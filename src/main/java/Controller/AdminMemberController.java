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


// *.adme 로 들어오는 모든 요청 처리
@WebServlet("*.adme")
public class AdminMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;

	public AdminMemberController() {
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
		String path="Admin";
		boolean forward_ok = true;
		// Member_List로 들어온 요청 처리
		if(action.equals("/Member_List.adme")) {
		// 만일 요청 값이 Member_List라면 중괄호 안의 코드 실행
			System.out.println("List.adme 접속 성공");
			// System.out.println("Member List");
			// 1. 받을 값을 확인

			// 2. 어떤 service 요청
			List<MemberDTO> members = service.selectList();
			request.setAttribute("members", members);
			// System.out.println(request.getAttribute("members"));
			System.out.println("members set 성공");
			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			path = "Member_List";
			// path = "/JSP/Admin/Member/Member_List.jsp";
			
		}else if(action.equals("/Member_Write.adme")) {
			System.out.println("write : "+ request.getParameter("name"));
			path = "Member_Write";
			// path = "/JSP/Admin/Member/Member_Write.jsp";
			
		}else if(action.equals("/Member_WriteProcess.adme")) {
			// 1. 받을 값을 확인
			String id = request.getParameter("id");
			// String형 변수 id를 선언하고 request 객체의 id 속성의 값을 저장한다.
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			int grade = Integer.parseInt(request.getParameter("grade"));
			String nickname = request.getParameter("nickname");
			String location = request.getParameter("location");
			String phone_number = request.getParameter("phone_number");
			String description = request.getParameter("description");
			// String -> int 형변환 : int numInt = Integer.parseInt(str);
			
			MemberDTO dto = new MemberDTO(id, pass, name, grade, nickname, location, phone_number, description);			
			// 2. 어떤 service 요청
			int rs = service.insertWrite(dto);

			forward_ok = false;
			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			path = "/JSP/Admin/Member/Member_List.adme";
			response.sendRedirect(path);
			// sendRedirect 방식으로 List.do 파일로 이동(가상 경로)
		}else if(action.equals("/Member_View.adme")) {
			System.out.println("Member_View.adme 실행 성공");
			String id = request.getParameter("id");
			MemberDTO member = service.selectView(id);
			System.out.println("member 값 : " + member);
			request.setAttribute("member", member);
			System.out.println("member 값2 : " + request.getAttribute("member"));
			
			path = "Member_View";
			// path = "/JSP/Admin/Member/Member_View.jsp";
		}else if(action.equals("/Member_Edit.adme")) {
			String id = request.getParameter("id");
			
			MemberDTO member = service.selectView(id);
			
			request.setAttribute("member", member);
			
			path = "Member_Edit";
			// path = "/JSP/Admin/Member/Member_Edit.jsp";
		}else if(action.equals("/Member_EditProcess.adme")) {
			System.out.println("Member_EditProcess.adme 진입성공");
			// 1. 받을 값을 확인
			String id = request.getParameter("id");
			// String형 변수 id를 선언하고 request 객체의 id 속성의 값을 저장한다.
			String pass = request.getParameter("pass");
			// String형 변수 pass를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			// System.out.print(id + "," + pass + "," + name);
			int grade = Integer.parseInt(request.getParameter("grade"));
			// String -> int 형변환 : int numInt = Integer.parseInt(str)
			String nickname = request.getParameter("nickname");
			String location = request.getParameter("location");
			String phone_number = request.getParameter("phone_number");
			String description = request.getParameter("description");
			MemberDTO dto = new MemberDTO(id, pass, name, grade, nickname, location, phone_number, description);			
			
			int rs = service.updateEdit(dto);
			
			forward_ok = false;
			// 작업 후 페이지 이동
			path = "/JSP/Admin/Member/Member_View.adme?id="+id;
			response.sendRedirect(path);
		}else if(action.equals("/Member_DeleteProcess.adme")) {
			String id = request.getParameter("id");
			
			int rs = service.delete(id);
			
			forward_ok = false;
			path = "/JSP/Admin/Member/Member_List.adme";
			response.sendRedirect(path);
		}
		
		if(forward_ok) {
		System.out.println("/JSP/Admin/Layout.jsp 조건 진입");
		request.setAttribute("layout", "Member/" + path);		
		// request.setAttribute("layout", "Member/" + path);		
		//layout 속성에 "Member/"+path값 저장
		request.getRequestDispatcher("/JSP/Admin/Layout.jsp").forward(request, response);
		// forward 방식으로 request 객체에 저장된 값을 전달해서 이동
		}
		
	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}