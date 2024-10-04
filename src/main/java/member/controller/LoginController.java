package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet("*.lo")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;

	public LoginController() {
		service = new MemberServiceImpl();
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
		HttpSession session = request.getSession();
		if(action.equals("/LoginProcess.lo")) {
			// 1. 받을 값 확인
			String id = request.getParameter("user_id");
			String pw = request.getParameter("user_pw");
			System.out.println(id);
			System.out.println(pw);
			// 2. service 요청
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.selectView(id);

			if(dto != null) {
				if(pw.equals(dto.getPass())){
					session.setAttribute("UserId", id);
					session.setAttribute("UserName", dto.getName());
					response.sendRedirect("LoginForm.jsp");
					
				}else{
					request.setAttribute("LoginErrMsg", "로그인 오류");
					request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("LoginErrMsg", "로그인 오류");
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
			}

			// 3. 어떻게 어디로 이동 할것인가?
		}else if(action.equals("/LoginForm.lo")) {
			response.sendRedirect("LoginForm.jsp");
		}else if(action.equals("/Logout.lo")) {
			session.invalidate();
			response.sendRedirect("LoginForm.jsp");
		}
	}

}
