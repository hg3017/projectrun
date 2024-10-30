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

import DAO.FreeBoardDAO;
import DTO.FreeBoardDTO;
import Service.FreeBoardService;
import Service.FreeBoardServiceImpl;
import Utils.FileUtils;
import Utils.FreeBoardPage;


@WebServlet("*.free")
public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FreeBoardService service;

	public FreeBoardController() {
		service = new FreeBoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		
		String path = "Fb_List";
		
		if (action.equals("/Fb_List.free")) {
			
			// 1. 받을 값 확인
			String searchField = request.getParameter("searchField"); // 검색 필드 (예: 제목, 내용 등)
			String searchWord = request.getParameter("searchWord"); // 검색어
			String limitParam = request.getParameter("limit"); // 페이징 처리를 위한 limit
			//String offsetParam = request.getParameter("offset");
			String pageNumParam = request.getParameter("pageNum");
			
		    int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10; // 기본 페이지 크기
		    int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1; // 기본 페이지 번호
		    int offset = (pageNum - 1) * limit; // 오프셋 계산
			
		    Map<String, String> map = new HashMap<>();
		    map.put("searchField", (searchField != null) ? searchField : "");
		    map.put("searchWord", (searchWord != null) ? searchWord : "");
		    map.put("limit", String.valueOf(limit));
		    map.put("offset", String.valueOf(offset));
		    
		    // 3. 총 게시물 수 가져오기
		    int totalCount = service.selectCount(map); // 총 게시물 수 계산
		    
			// 4. service 요청
			List<FreeBoardDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);

		    // 5. 페이징 처리
		    int pageSize = 10; // 한 페이지에 보여줄 게시물 수
		    int blockPage = 5; // 한 번에 보여줄 페이지 블록 수
		    String pagingStr = FreeBoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/Fb_List.free", map.get("searchField"), map.get("searchWord"));
		    request.setAttribute("pagingStr", pagingStr);

			// 4. 어떻게 어디로 이동 할것인가?
			path = "Fb_List";
			
		} else if (action.equals("/Fb_Write.free")) {

			// 3. 어떻게 어디로 이동 할것인가?
			path = "Fb_Write";
			
		} else if (action.equals("/Fb_WriteProcess.free")) {
			FreeBoardDTO dto = new FreeBoardDTO();
			
			Map<String, String> rData = FileUtils.fileUpload(request, "file");
			dto.setOfile(rData.get("ofile"));
			dto.setSfile(rData.get("sfile"));
			
			// 파일 업로드 처리
			// 1. 받을 값 확인
			String title = rData.get("title");
			String content = rData.get("content");
			//String idx = request.getParameter("idx");
			
			HttpSession session = request.getSession();
		    String member_id = (String) session.getAttribute("UserId");
		    
			dto.setTitle(title);
			dto.setContent(content);
			dto.setMember_id(member_id);
			
			// 2. service 요청
			int rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공적으로 삽입
				response.sendRedirect("/Fb_List.free");
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "게시물 작성에 실패하였습니다.");
				path = "Fb_Write"; // 다시 작성 페이지로 돌아감
			}
			
		} else if (action.equals("/Fb_View.free")) {
			
			String idx = request.getParameter("idx");  // 일련번호 받기 

			service.updateVisitCount(idx);                 // 조회수 증가 
			FreeBoardDTO dto = service.pnPage(idx);     // 게시물 가져오기 

			request.setAttribute("board", dto);
		
			path = "Fb_View";

		} else if (action.equals("/Fb_Edit.free")) {
			String idx = request.getParameter("idx");  // 일련번호 받기 
			
			FreeBoardDTO dto = service.pnPage(idx);        // 게시물 가져오기 
			request.setAttribute("board", dto);
			
			// 3. 어떻게 어디로 이동 할것인가?
			path = "Fb_Edit";
			
		} else if (action.equals("/Fb_EditProcess.free")) {
			FreeBoardDTO dto = new FreeBoardDTO();
			
			String saveDirectory = request.getServletContext().getRealPath("/JSP/Upload");
			
			Map<String, String> rData = FileUtils.fileUpload(request, "file");
			dto.setOfile(rData.get("ofile"));
			dto.setSfile(rData.get("sfile"));
			
			// 1. 받을 값 확인
			String idx = rData.get("idx");
			String title = rData.get("title");
			String content = rData.get("content");
			String fileName = rData.get("ofile");
			String newFileName = rData.get("sfile");

			dto.setIdx(idx);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
			
			// 2. service 요청
			int rs = service.updateEdit(dto, saveDirectory);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공 시 상세 보기 페이지로 이동
				response.sendRedirect("/Fb_View.free?idx=" + idx);
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "수정하기에 실패하였습니다.");
				path = "Fb_Edit"; // 다시 작성 페이지로 돌아감
			}
		} else if (action.equals("/Fb_DeleteProcess.free")) {
			// 1. 받을 값 확인
			HttpSession session = request.getSession();
			String idx = request.getParameter("idx");

			FreeBoardDAO dao = new FreeBoardDAO();
			FreeBoardDTO dto = dao.pnPage(idx);

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
					response.getWriter().write("<script>alert('삭제되었습니다.'); location.href = '/Fb_List.free'</script>");
					return;
				} else {
					// 실패 시 이전 페이지로 이동
					response.getWriter().write("<script>alert('삭제에 실패하였습니다.'); location.href = '/Fb_View.free?idx=" + idx + "'</script>");
					return;
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				response.getWriter().write("<script>alert('본인만 삭제할 수 있습니다.'); location.href = '/Fb_View.free?idx=" + idx + "'</script>");
				return;
			}
			
		} else if (action.equals("/FileDown.an")) {
			FileUtils.fileDownload(request, response);
			return;
		
		}
		
		request.setAttribute("layout", "FreeBoard/" + path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}

}
