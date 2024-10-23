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

import DAO.CrewBoardDAO;
import DTO.CrewBoardDTO;
import Service.CrewBoardService;
import Service.CrewBoardServiceImpl;
import Service.CrewService;


@WebServlet("*.crewb")
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
		if(action.equals("/Cb_List.crewb")) {
			Map<String, String> param = new HashMap<String, String>();
			String searchField = request.getParameter("searchField");
			String searchWord = request.getParameter("searchWord");
			String limitParam = request.getParameter("limit");
			String pageNumParam = request.getParameter("pageNum");
			
			int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10;
			int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1;
			
			
			if(searchWord != null) {
				param.put("searchField",searchField);
				param.put("searchWord",searchWord);
			}
			CrewBoardDAO dao = new CrewBoardDAO();
			List<CrewBoardDTO> boardLists = dao.selectList(param);
			
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		request.setAttribute("layout", path);
	    request.getRequestDispatcher("/JSP/Customerboard/layout.jsp").forward(request, response);
	}
	
}
