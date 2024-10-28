package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import DTO.LoginDTO;
import Service.LoginService;
import Service.LoginServiceImpl;



// @WebServlet. 요청값이 .lo 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.lo")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginService service;

	// LoginController 생성자. 컨트롤러가 생성될 때 LoginServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public LoginController() {
		service = new LoginServiceImpl();
	}

	// GET 방식으로 데이터를 받은 경우 작동합니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	// Post 방식으로 데이터를 받은 경우 작동합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달받은 Servlet URI 값 이 어느 위치에 존재하는지 경로를 찾습니다. 
		// URI :  ( Uniform Resource Identifier ) - 통합 자원 식별자 
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		HttpSession session = request.getSession();
		
		String path = "Login";
		
		// Servelt 의 경로값이 /LoginProcess.lo 인 경우 작동합니다. 
		if(action.equals("/LoginProcess.lo")) {
			// 1. 받을 값 확인
			String id = request.getParameter("user_id");
			String pw = request.getParameter("user_pw");
			
			System.out.println(id);
			
			
			// 2. service 요청
			// LoginDTO 의 형태를 가진 객체를 dto 의 이름으로 생성하고 그 안에 dao.selectView(id) 에서 리턴받은 값을 입력합니다.
			LoginDTO dto = service.selectView(id);
				
			System.out.println(dto);
			
			// dto 값이 null 이 아닌경우(리턴이 있는 경우) 작동합니다. 
			if(dto != null){
				
				// 전달받은 id, pw 값이 일치하는 경우 작동합니다. 
				if(pw.equals(dto.getPass())){
					session.setAttribute("UserId", id);	
					path = "Main/Main";
				}else{
					request.setAttribute("LoginErrMsg", "로그인 오류");
					path = "/Login/Login";
//					request.getRequestDispatcher("/JSP/Login/Login.jsp").forward(request, response);
				}
			} 
			// dto 값이 null 인 경우 작동합니다. 
			else{
				request.setAttribute("LoginErrMsg", "로그인 오류");
				path = "/Login/Login";
			}
		}
		else if(action.equals("/LoginPage.lo")) {
			path = "/Login/Login";
		}
		// Servelt 의 경로값이 /Logout.lo 인 경우 작동합니다. 해당 위치는 아직 추가 작업이 필요합니다.
		else if(action.equals("/Logout.lo")) {
			session.invalidate();
			path = "/Login/Login";
			
		} 
		else if(action.equals("/AdminPage.lo")) {		
						
			path = "Admin_Index";
			
			response.sendRedirect("/JSP/Admin/Admin_Index.jsp");
			
			// request.setAttribute("layout","Admin/" + path);
			// request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
		}
		
		request.setAttribute("layout", path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
		
	}

}