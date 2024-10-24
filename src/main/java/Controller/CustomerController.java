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

import org.apache.tomcat.util.http.fileupload.FileUtils;

import DTO.CustomerboardDTO;
import Service.CustomerboardService;
import Service.CustomerboardServiceImpl;
import Utils.CustomerboardPage;

@WebServlet("*.co")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerboardService service;
	
	public CustomerController() {
		service = new CustomerboardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		
		String path = "Cs_List";
		
		if(action.equals("/Cs_List.co")) {
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
			
			int totalCount =  service.selectCount(map);
			request.setAttribute("totalCount", totalCount);
			
			List<CustomerboardDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);
			
			int pageSize = 10;
			int blockPage = 5;
			String pagingStr = CustomerboardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/Cs_List.co");
			request.setAttribute("pagingStr", pagingStr);
			
			path = "Cs_List";
		} else if(action.equals("/Cs_View.co")) {
			String idx = request.getParameter("idx");
			
			service.updateVisitCount(idx);
			CustomerboardDTO dto = service.ViewPage(idx);
			
			request.setAttribute("board", dto);
			path = "Cs_View";
			
		} else if(action.equals("/Cs_Write.co")) {
			path = "Cs_Write";
		} else if(action.equals("/Cs_WriteProcess.co")) {
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			String content = request.getParameter("content");
			int ableview = Integer.parseInt(request.getParameter("ableview"));
			
			HttpSession session = request.getSession();
			String member_id = (String) session.getAttribute("UserId");
			
			CustomerboardDTO dto = new CustomerboardDTO();
			dto.setTitle(title);
			dto.setCategory(category);
			dto.setAbleview(ableview);
			dto.setContent(content);
			
			int rs = service.insertWrite(dto);
			
			if(rs == 1) {
				response.sendRedirect("Cs_List.co");
				return;
			} else {
				request.setAttribute("errorMessage", "게시물 작성에 실패하였씁니다");
				path = "Cs_Write";
			}
		}
		request.setAttribute("layout", path);
		request.getRequestDispatcher("/JSP/Customerboard/Cs_Layout.jsp").forward(request, response);
	}
	
	
	
}
