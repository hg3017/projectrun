package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.MemberDTO;
import Service.MemberService;
import Service.MemberServiceImpl;


// *.regi 로 들어오는 모든 요청 처리
@WebServlet("*.regi")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;

	public RegisterController() {
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
		String path ="Register";
		
		// Register.regi로 들어온 요청 처리
		if(action.equals("/Register.regi")) {
			// 만일 요청 값이 Register.regi라면 중괄호 안의 코드 실행
			System.out.println("Register.regi 접속 성공");
			path = "Register";
			System.out.println("Register 경로 출력 : "+path);
			// request.getRequestDispatcher(path).forward(request, response);
			// Register.jsp 파일로 forward 방식으로 이동
			// response.sendRedirect(path);
		}else if(action.equals("/RegisterProcess.regi")) {
			// request.setCharacterEncoding("UTF-8");
			// System.out.println("Member List");
			// 1. 받을 값을 확인
			String id = request.getParameter("id");
			// String형 변수 id를 선언하고 request 객체의 id 속성의 값을 저장한다.
			String pass = request.getParameter("pass");
			// String형 변수 pass를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			// System.out.print(id + "," + pass + "," + name);
			int grade = Integer.parseInt(request.getParameter("grade"));
			String nickname = request.getParameter("nickname");
			String location = request.getParameter("location");
			String phone_number = request.getParameter("phone_number");
			String description = request.getParameter("description");
			// String -> int 형변환 : int numInt = Integer.parseInt(str);
			MemberDTO dto = new MemberDTO(id, pass, name, grade, nickname, location, phone_number, description);			
			int rs = service.insertWrite(dto);
			path = "Register";
		}else if(action.equals("/Register_Test01.regi")) {
			System.out.println("action 값 확인 : "+action);
			path = "Register_Test01.jsp";
			response.sendRedirect(path);
		}
		
		request.setAttribute("layout","Register/" + path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
		
		
	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}