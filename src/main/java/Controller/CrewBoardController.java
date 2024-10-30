package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CrewBoardDAO;
import DTO.CrewBoardDTO;
import Service.CrewBoardService;
import Service.CrewBoardServiceImpl;
import Utils.CrewBoardPage;
import Utils.FileUtils;


@WebServlet("*.cb")
public class CrewBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CrewBoardService service;
	
	public CrewBoardController() {
		service = new CrewBoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess");
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = "Cb_List";
		
		System.out.println(action);
		if(action.equals("/Cb_List.cb")) {
			String searchField = request.getParameter("searchField");
			String searchWord = request.getParameter("searchWord");
			String limitParam = request.getParameter("limit");
			String pageNumParam = request.getParameter("pageNum");
			
			// 테스트 
			String crewName = request.getParameter("crewName");
			request.setAttribute("crewName", crewName);
			// 테스트 
			
			int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10;
			int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1;
			int offset = (pageNum - 1) * limit;
			
			Map<String, String> map = new HashMap<>();
			map.put("searchField", (searchField != null) ? searchField : "");
			map.put("searchWord", (searchWord != null) ? searchWord : "");
			map.put("limit", String.valueOf(limit));
			map.put("offset", String.valueOf(offset));
			
			int totalCount = service.selectCount(map);
			
			List<CrewBoardDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);
			
			int pageSize = 10;
			int blockPage = 5;
			
			String pagingStr = CrewBoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/Cb_List.cb", map.get("searchField"), map.get("searchWord"));
			request.setAttribute("pagingStr", pagingStr);	

			path = "Cb_List";
		}else if(action.equals("/Cb_View.cb")) {
			String idx = request.getParameter("idx");
			
			service.updateVisitCount(idx);
			CrewBoardDTO dto = service.pnPage(idx);
			
			request.setAttribute("board", dto);
			
			path = "Cb_View";
		}else if(action.equals("/Cb_Write.cb")) {
			HttpSession session = request.getSession();
		    String member_id = (String) session.getAttribute("UserId");
		    
			request.setAttribute("crewNames", service.selectCrewNames(member_id));
			path = "Cb_Write";
			
		}else if(action.equals("/Cb_WriteProcess.cb")) {
		CrewBoardDTO dto = new CrewBoardDTO();
			

			Map<String, String> rData = FileUtils.fileUpload(request, "file");
			dto.setOfile(rData.get("ofile"));
			dto.setSfile(rData.get("sfile"));


			String crew_name = rData.get("crew_name");
			String title= rData.get("title");
			String content = rData.get("content");
			
			
			HttpSession session = request.getSession();
		    String member_id = (String) session.getAttribute("UserId");
		    
		    dto.setCrew_name(crew_name);
		    dto.setTitle(title);
		    dto.setContent(content);
		    dto.setMember_id(member_id);
		    
		    int rs = service.insertWrite(dto);
		    
		    if (rs == 1) {
				// 성공적으로 삽입
				response.sendRedirect("/Cb_List.cb");
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "게시물 작성에 실패하였습니다.");
				path = "Cb_Write"; // 다시 작성 페이지로 돌아감
			}
		}else if(action.equals("/Cb_View.cb")) {
			String idx = request.getParameter("idx");
			
			service.updateVisitCount(idx);
			CrewBoardDTO dto = service.pnPage(idx);
			
			request.setAttribute("board", dto);
			
			path = "Cb_View";
			
		}else if (action.equals("/Cb_Edit.cb")) {
			String idx = request.getParameter("idx");
			
			CrewBoardDTO dto = service.pnPage(idx);
			request.setAttribute("board", dto);
			
			path = "Cb_Edit";
			
		}else if (action.equals("/Cb_EditProcess.cb")) {
			CrewBoardDTO dto = new CrewBoardDTO();
			
			Map<String, String> rDate = FileUtils.fileUpload(request, "file");
			dto.setOfile(rDate.get("ofile"));
			dto.setSfile(rDate.get("sfile"));
			
			String idx = rDate.get("idx");
			String title = rDate.get("title");
			String content = rDate.get("content");
			String fileName = rDate.get("ofile");
			String newFileName = rDate.get("sfile");
			
			dto.setIdx(idx);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
			int rs = service.updateEdit(dto);
			
			if (rs == 1) {
				// 성공 시 상세 보기 페이지로 이동
				response.sendRedirect("/Cb_View.cb?idx=" + idx);
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "수정하기에 실패하였습니다.");
				path = "Cb_Edit";
			}
		} else if (action.equals("/Cb_DeleteProcess.cb")) {
			// 1. 받을 값 확인
			HttpSession session = request.getSession();
			String idx = request.getParameter("idx");

			CrewBoardDAO dao = new CrewBoardDAO();
			CrewBoardDTO dto = dao.pnPage(idx);
			

			// 로그인된 사용자 ID 얻기
			String member_id = session.getAttribute("UserId").toString();
			int delResult = 0;

			if (member_id.equals(dto.getMember_id())) { // 작성자가 본인인지 확인
				// 작성자가 본인이면...
				dto.setIdx(idx);

				delResult = service.deletePost(dto);

				// 3. 어떻게 어디로 이동 할것인가?
				if (delResult == 1) {
					// 성공 시 목록 페이지로 이동
//					session.setAttribute("message", "삭제되었습니다.");
					response.getWriter().write("<script>alert('삭제되었습니다.'); location.href = '/Cb_List.cb'</script>");
					return;
				} else {
					// 실패 시 이전 페이지로 이동
					response.getWriter().write("<script>alert('삭제에 실패하였습니다.'); location.href = '/Cb_View.cb?idx=" + idx + "'</script>");
					return;
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				response.getWriter().write("<script>alert('본인만 삭제할 수 있습니다.'); location.href = '/Cb_View.cb?idx=" + idx + "'</script>");
				return;
			}
			
		} else if (action.equals("/FileDown.cb")) {
			FileUtils.fileDownload(request, response);
			return;
		}
		
		request.setAttribute("layout","CrewBoard/" + path);
	    request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}
	
}