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


// *.do 로 들어오는 모든 요청 처리
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;

	public MemberController() {
		service = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("멤버 컨트롤러 작동 성공");
		System.out.println("doProcess");
		String uri = request.getRequestURI();
		// System.out.println(uri);
		int lastSlash = uri.lastIndexOf("/");
		//	System.out.println(lastSlash);
		String action = uri.substring(lastSlash);
		// System.out.println(action);

		// List.do로 들어온 요청 처리
		if(action.equals("/List.do")) {
			// 만일 요청 값이 List.do라면 중괄호 안의 코드 실행
			System.out.println("List.do 접속 성공");
			// System.out.println("Member List");
			// 1. 받을 값을 확인

			// 2. 어떤 service 요청
			List<MemberDTO> members = service.selectList();
			request.setAttribute("members", members);
			// System.out.println(request.getAttribute("members"));

			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			String path = "/JSP/Admin_Sample/List.jsp";
			System.out.println(path);
			request.getRequestDispatcher(path).forward(request, response);
			// List.jsp 파일로 forward 방식으로 이동

		}else if(action.equals("/Write.do")) {
			// System.out.println(action);
			System.out.println("write : "+ request.getParameter("name"));
			// 받을 값 없음, service 요청할 거 없음
			// 3. 어떻게 어디로 이동할 것인가?
			// System.out.println("Write.do" + request.getParameter("id"));
			String path = "/JSP/Admin_Sample/Write.jsp";
			response.sendRedirect(path);

		}else if(action.equals("/WriteProcess.do")) {
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
			String phone_number =request.getParameter("phone_number");
			// int phone_number = Integer.parseInt(request.getParameter("phone_number"));
			// String -> int 형변환 : int numInt = Integer.parseInt(str);

			MemberDTO dto = new MemberDTO(id,pass,name,grade,nickname,location,phone_number);
			// 2. 어떤 service 요청
			int rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			String path = "/JSP/Admin_Sample/List.do";
			response.sendRedirect(path);
			// sendRedirect 방식으로 List.do 파일로 이동(가상 경로)
		}else if(action.equals("/View.do")) {
			System.out.println("View.do 실행 성공");
			String id = request.getParameter("id");
			System.out.println("View로 가는 id 값 : "+id);
			MemberDTO member = service.selectView(id);
			System.out.println("member 값 : " + member);
			request.setAttribute("member", member);
			System.out.println("member 값2 : " + request.getAttribute("member"));

			String path = "/JSP/Admin_Sample/View.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			// request에 담긴 값이 다음페이지와 그 다음 페이지에서도 계속 유지된다.
			// 원래 A.jsp -> Servlet -> B.jsp 까지는 파라미터 정보가 유지되나, 그 다음 단계에서는 소멸된다.
			dispatcher.forward(request, response);
		}else if(action.equals("/Edit.do")) {
			String id = request.getParameter("id");

			MemberDTO member = service.selectView(id);

			request.setAttribute("member", member);

			String path = "/JSP/Admin_Sample/Edit.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			// RequestDispatcher 객체 생성, request.getRequestDispatcher(path) 메서드의 반환값을 할당받는다.
			dispatcher.forward(request, response);
			// forward 방식으로 request 객체를 전송하면서 파일로 이동
		}else if(action.equals("/EditProcess.do")) {
			// 1. 받을 값을 확인
			String id = request.getParameter("id");
			// String형 변수 id를 선언하고 request 객체의 id 속성의 값을 저장한다.
			String pass = request.getParameter("pass");
			// String형 변수 pass를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			// System.out.print(id + "," + pass + "," + name);
			String nickname = request.getParameter("nickname");
			String location = request.getParameter("location");
			String phone_number = request.getParameter("phone_number");
			// String -> int 형변환 : int numInt = Integer.parseInt(str)
			MemberDTO dto = new MemberDTO(id, pass, name, nickname, location, phone_number);

			int rs = service.updateEdit(dto);

			// 작업 후 페이지 이동
			String path = "/JSP/Admin_Sample/View.do?id="+id;
			response.sendRedirect(path);
		}else if(action.equals("/DeleteProcess.do")) {
			String id = request.getParameter("id");

			int rs = service.delete(id);

			String path = "List.do";
			response.sendRedirect(path);
		}else if(action.equals("/Test02.do")) {
			System.out.println("컨트롤러 Test02.do 실행 성공");
			String path = "/JSP/Admin_Sample/Test02.jsp";
			response.sendRedirect(path);
		}else if(action.equals("/Controller_Test01.do")) {
			// Cotroller_Test02.do
			System.out.println("컨트롤러 Controller_Test01.do 실행 성공");
			String path = "/JSP/Admin_Sample/Controller_Test01.jsp";
			response.sendRedirect(path);
			
		}else if(action.equals("/Controller_Test02.do")) {
			System.out.println("컨트롤러 Controller_Test02 실행 성공");
			String path = "/JSP/Admin_Sample/Controller_Test02.jsp";
			response.sendRedirect(path);
			
		}else if(action.equals("/Controller_Test03.do")) {
			System.out.println("컨트롤러 Controller_Test03 실행 성공");
			String path = "/JSP/Admin_Sample/Controller_Test03.jsp";
			response.sendRedirect(path);
		}

	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}