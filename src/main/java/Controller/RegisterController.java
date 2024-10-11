package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import DAO.RegisterDAO;

import DTO.LoginDTO;
import DTO.RegisterDTO;

import Service.LoginService;
import Service.LoginServiceImpl;
import Service.RegisterService;
import Service.RegisterServiceImpl;

//@WebServlet. 요청값이 .regi 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.regi")
public class RegisterController extends HttpServlet {

	RegisterService service;

	// RegisterController 생성자. 컨트롤러가 생성될 때 RegisterServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public RegisterController() {
		service = new RegisterServiceImpl();
	}

	// Get 방식으로 데이터를 받은 경우 작동합니다.
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
		
		if(action.equals("/RegisterProcess.regi")) {
			// 1. 받을 값 확인
			// 전달받은 값들을 dto 객체에 입력합니다.
			RegisterDTO dto = new RegisterDTO();
			dto.setId(request.getParameter("id"));
			dto.setPass(request.getParameter("pass"));
			dto.setName(request.getParameter("name"));
			dto.setGrade(Integer.parseInt(request.getParameter("grade")));
			dto.setNickname(request.getParameter("nickname"));
			dto.setLocation(Integer.parseInt(request.getParameter("location")));
			dto.setPhone_number(Integer.parseInt(request.getParameter("phone_number")));
			
			// 2. service 요청
			// DAO 의 insertMember 를 dto 인자를 사용하여 수행 후 결과값을 rs 에 저장합니다.
			RegisterDAO dao = new RegisterDAO();
			int rs = dao.insertMember(dto);
						
			
			// insertMember 의 리턴값이 있는 경우 수행합니다. 
			if(rs == 1){
				// 회원가입에 성공한 경우, 경로를 추출하고 추출한 경로를 통해 로그인 페이지로 이동합니다. 
				String ContextPath = request.getContextPath();				
				response.sendRedirect(ContextPath + "/JSP/Login/Login.jsp");
			} else {
				
				request.setAttribute("LoginErrMsg", "로그인 오류");
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
			}
		
		}
		// Servelt 의 경로값이 /Logout.lo 인 경우 작동합니다. 해당 위치는 아직 추가 작업이 필요합니다.
		else if(action.equals("/Logout.lo")) {
			session.invalidate();			
			response.sendRedirect("LoginForm.jsp");
		}
		
	}
}
