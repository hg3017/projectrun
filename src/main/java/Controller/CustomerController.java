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

	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(requset, response);
	}

	protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(requset, response);
	}
	
	protected void doProcess(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess");
		String uri = requset.getRequestURI();
		int lastShash = uri.lastIndexOf("/");
		String action = uri.substring(lastShash);
		System.out.println(action);
		
		if(action.equals("Cs_list.co")) {
			String searchField = requset.getParameter("searchField");
			String searchWord = requset.getParameter("searchWord");
			String limitParam = requset.getParameter("limit");
			String pageNumParam = requset.getParameter("pageNum");
			
			int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10;
			int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1;
			int offset = (pageNum - 1) * limit;
			
			Map<String, String> map = new HashMap<>();
			map.put("searchField", (searchField != null) ? searchField : "");
			map.put("searchWord", (searchWord != null) ? searchWord : "");
			map.put("limit", String.valueOf(limit));
			map.put("offset", String.valueOf(offset));
			
			int totalCount =  service.selectCount(map);
			requset.setAttribute("totalCount", totalCount);
			
			List<CustomerboardDTO> board = service.selectList(map);
			requset.setAttribute("board", board);
			
			int pageSize = 10;
			int blockPage = 5;
			String pagingStr = CustomerboardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, requset.getContextPath() + "/Cs_list.co");
			requset.setAttribute("paginStr", pagingStr);
			
			String path = "Cs_list";
		} 
	}
	
	
	
	
}
