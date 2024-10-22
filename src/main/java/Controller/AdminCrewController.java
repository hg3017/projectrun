package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AdminCrewDTO;
import Service.AdminCrewService;
import Service.AdminCrewServiceImpl;


// *.do 로 들어오는 모든 요청 처리
@WebServlet("*.adcr")
public class AdminCrewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminCrewService service;

	public AdminCrewController() {
		service = new AdminCrewServiceImpl();
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
		// System.out.println(uri);
		int lastSlash = uri.lastIndexOf("/");
		//	System.out.println(lastSlash);
		String action = uri.substring(lastSlash);
		// System.out.println(action);
		
		// DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = dateFormat.format(new Date());
		
		// List.do로 들어온 요청 처리
		if(action.equals("/Crew_List.adcr")) {
		// 만일 요청 값이 List.do라면 중괄호 안의 코드 실행
			System.out.println("List.adme 접속 성공");
			// System.out.println("Member List");
			// 1. 받을 값을 확인

			// 2. 어떤 service 요청
			List<AdminCrewDTO> crews = service.selectList();
			// service 객체의 selectList() 메서드 호출해서 결과값을
			// List형 객체 crews에 대입
			request.setAttribute("crews", crews);
			// System.out.println(request.getAttribute("members"));

			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			String path = "/JSP/Admin/Crew/Crew_List.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			// List.jsp 파일로 forward 방식으로 이동
			
		}else if(action.equals("/Crew_Index.adcr")) {
			// System.out.println(action);
			System.out.println("write : "+ request.getParameter("name"));
			// 받을 값 없음, service 요청할 거 없음
			// 3. 어떻게 어디로 이동할 것인가?
			// System.out.println("Write.do" + request.getParameter("id"));
			String path = "/JSP/Admin/Crew/Crew_Index.jsp";
			response.sendRedirect(path);
			
		}else if(action.equals("/Crew_Write.adcr")) {
			// System.out.println(action);
			System.out.println("write : "+ request.getParameter("name"));
			// 받을 값 없음, service 요청할 거 없음
			// 3. 어떻게 어디로 이동할 것인가?
			// System.out.println("Write.do" + request.getParameter("id"));
			String path = "/JSP/Admin/Crew/Crew_Write.jsp";
			response.sendRedirect(path);
			
		}else if(action.equals("/Crew_WriteProcess.adcr")) {
			// request.setCharacterEncoding("UTF-8");
			// System.out.println("Crew List");
			// 1. 받을 값을 확인
			// int idx = Integer.parseInt(request.getParameter("idx"));
			// String -> int 형변환 : int numInt = Integer.parseInt(str);
			// int형 변수 idx를 선언하고 request 객체의 idx 속성의 값을 저장한다.
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 pass 속성의 값을 저장한다.
			String location_id = request.getParameter("location_id");
			String description = request.getParameter("description");
			String regidate = request.getParameter("regidate");
			// String regidate = dateFormat.format(new Date());
			
			AdminCrewDTO dto = new AdminCrewDTO(name, location_id, description, regidate);
			// 2. 어떤 service 요청
			int rs = service.insertWrite(dto);
			// service 객체의 메서드 insertWrite(dto) 호출

			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			String path = "/JSP/Admin/Crew/Crew_List.adcr";
			response.sendRedirect(path);
			// sendRedirect 방식으로 List.do 파일로 이동(가상 경로)
		}else if(action.equals("/Crew_View.adcr")) {
			System.out.println("Crew_View.adcr 실행 성공");
			int idx = Integer.parseInt(request.getParameter("idx"));
			AdminCrewDTO crew = service.selectView(idx);
			request.setAttribute("crew", crew);
			
			String path = "/JSP/Admin/Crew/Crew_View.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			// request에 담긴 값이 다음페이지와 그 다음 페이지에서도 계속 유지된다.
			// 원래 A.jsp -> Servlet -> B.jsp 까지는 파라미터 정보가 유지되나, 그 다음 단계에서는 소멸된다.
			dispatcher.forward(request, response);
		}else if(action.equals("/Crew_Edit.adcr")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			AdminCrewDTO crew = service.selectView(idx);
			request.setAttribute("crew", crew);
			
			String path = "/JSP/Admin/Crew/Crew_Edit.adcr";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			// RequestDispatcher 객체 생성, request.getRequestDispatcher(path) 메서드의 반환값을 할당받는다.
			dispatcher.forward(request, response);
			// forward 방식으로 request 객체를 전송하면서 파일로 이동
		}else if(action.equals("/Crew_EditProcess.adcr")) {
			// 1. 받을 값을 확인
			int idx = Integer.parseInt(request.getParameter("idx"));
			// String형 변수 id를 선언하고 request 객체의 id 속성의 값을 저장한다.
			// String -> int 형변환 : int numInt = Integer.parseInt(str)
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 name 속성의 값을 저장한다.
			// System.out.print(id + "," + pass + "," + name);
			String location_id = request.getParameter("location_id");
			String description = request.getParameter("description");
			String regidate = request.getParameter("regidate");
			
			AdminCrewDTO dto = new AdminCrewDTO(idx, name, location_id, description, regidate);
			
			// int rs = service.updateEdit(dto);
			
			// 작업 후 페이지 이동
			String path = "/JSP/Admin/Crew/Crew_View.adcr?idx="+idx;
			response.sendRedirect(path);
		}else if(action.equals("/Crew_DeleteProcess.adcr")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			
			int rs = service.delete(idx);
			String path = "/JSP/Admin/Crew/Crew_List.adcr";
			response.sendRedirect(path);
		}else if(action.equals("/Crew_Test01.adcr")) {
			String path = "/JSP/Admin/Crew/Crew_Test01.jsp";
			response.sendRedirect(path);
		}
	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}