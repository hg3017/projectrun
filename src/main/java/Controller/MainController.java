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

import DAO.AnnouncementDAO;
import DAO.CustomerboardDAO;
import DTO.AnnouncementDTO;
import DTO.CustomerboardDTO;
import DTO.FreeBoardDTO;
import Service.CustomerboardService;
import Service.CustomerboardServiceImpl;
import Utils.AnnouncementPage;
import Utils.CustomerboardPage;
import Utils.MainPage;

@WebServlet("*.mn")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerboardService service;

	public MainController() {
		service = new CustomerboardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess");
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		System.out.println(action);
		
		if(action.equals("/Index.mn")) {
			
			
			// 2. 데이터 설정
			
			String test01 = "데이터 전송이 성공적으로 완료됬습니다.";
			
			request.setAttribute("test01", test01);
			
			
			
			
			
			// 3. 이동
			String path = "/JSP/HomePage.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
	}
}
