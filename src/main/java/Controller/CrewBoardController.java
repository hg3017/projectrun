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
import Service.CrewService;
import Utils.CrewBoardPage;


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
		
		String path = "Cb_List";
		
		System.out.println(action);
		if(action.equals("/Cb_List.cb")) {
			String searchField = request.getParameter("searchField");
			String searchWord = request.getParameter("searchWord");
			String limitParam = request.getParameter("limit");
			String pageNumParam = request.getParameter("pageNum");
			
			int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10;
			int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1;
			int offset = (pageNum - 1) * limit;
			
			Map<String, String> map = new HashMap<>();
			map.put("searchField", (searchField != null) ? searchField : "");
			map.put("searchWord", (searchWord != null) ? searchWord : "");
			map.put("limit", String.valueOf(limit));
			map.put("offset", String.valueOf(offset));
			
			int totalCount = service.selectCount(map);
			request.setAttribute("totalCount", totalCount);
			
			List<CrewBoardDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);
			
			int pageSize = 10;
			int blockPage = 5;
			
			String pagingStr = CrewBoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/Cb_List.cb");
			request.setAttribute("pagingStr", pagingStr);	

			path = "Cb_List";
		}else if(action.equals("/Cb_View.cb")) {
			String idx = request.getParameter("idx");
			
			service.updateVisitCount(idx);
			CrewBoardDTO dto = service.pnPage(idx);
			
			request.setAttribute("board", dto);
			
			path = "Cb_View";
		}else if(action.equals("/Cs_Write.cb")) {
			path = "Cb_Write";
		}else if(action.equals("/Cb_WriteProcess.cb")) {
			String title= request.getParameter("title");
			String content = request.getParameter("content");
			
			HttpSession session = request.getSession();
		    String member_id = (String) session.getAttribute("UserId");
		    
		    CrewBoardDTO dto = new CrewBoardDTO();
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
		}
		
		request.setAttribute("layout","CrewBoard/" + path);
	    request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}
	
}
