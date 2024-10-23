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
			request.setAttribute("paginStr", pagingStr);
			
			path = "Cs_List";
		} 
		request.setAttribute("layout", path);
		request.getRequestDispatcher("/JSP/Customerboard/layout.jsp").forward(request, response);
	}
	
	
	
}
