package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.LocationDTO;
import DTO.MemberDTO;
import DTO.LocationDTO;
import DAO.LocationDAO;
import Service.LocationService;
import Service.LocationServiceImpl;
import Service.MemberService;
import Service.MemberServiceImpl;
import Utils.MemberPage;


// *.regi 로 들어오는 모든 요청 처리
@WebServlet("*.regi")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;
	LocationService Locationservice;

	
	public RegisterController() {
		service = new MemberServiceImpl();
		Locationservice = new LocationServiceImpl();
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
		String path ="/Register/Register";

		// Register.regi로 들어온 요청 처리
		if(action.equals("/Register.regi")) {
			// 만일 요청 값이 Register.regi라면 중괄호 안의 코드 실행
			System.out.println("Register.regi 접속 성공");
			path = "/Register/Register";
			System.out.println("Register 경로 출력 : "+path);
			
			List<LocationDTO> locations = Locationservice.locationView();
			
			request.setAttribute("locations", locations);

		}else if(action.equals("/RegisterProcess.regi")) {
			System.out.println("RegisterProcess.regi 접속 성공");
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

			// forward_ok = false;
			// 3. 어떻게 어디로 이동할 것인가?
			path = "/Main/Main";
		}else if(action.equals("/Register_Test01.regi")) {
			System.out.println("action 값 확인 : "+action);
			path = "Register_Test01.jsp";
			response.sendRedirect(path);
		}

		// request.setAttribute("layout", path);
		request.setAttribute("layout", path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);

	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}