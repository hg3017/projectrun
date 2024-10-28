package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AdminCrewDTO;
import DTO.MemberDTO;
import Service.AdminCrewService;
import Service.AdminCrewServiceImpl;


// *.adcr 로 들어오는 모든 요청 처리
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
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		String path="Crew";
		boolean forward_ok = true;
		
		// Crew_List.adcr로 들어온 요청 처리
		if(action.equals("/Crew_List.adcr")) {
			System.out.println("Crew_List.adcr 접속 성공");

			List<AdminCrewDTO> crews = service.selectList();
			request.setAttribute("crews", crews);
			System.out.println("crews set 성공");
			// 3. 어떻게 어디로 이동할 것인가?
			path = "Crew_List";
			
		}else if(action.equals("/Crew_Write.adcr")) {
			// System.out.println(action);
			System.out.println("write : "+ request.getParameter("name"));
			// 받을 값 없음, service 요청할 거 없음
			// 3. 어떻게 어디로 이동할 것인가?
			// System.out.println("Write.do" + request.getParameter("id"));
			path = "Crew_Write";
			
			
		}else if(action.equals("/Crew_WriteProcess.adcr")) {
			// request.setCharacterEncoding("UTF-8");
			// System.out.println("Member List");
			// 1. 받을 값을 확인
			// int idx = Integer.parseInt(request.getParameter("idx"));
			// String -> int 형변환 : int numInt = Integer.parseInt(str);
			String name = request.getParameter("name");
			String location_id = request.getParameter("location_id");
			String description = request.getParameter("description");
			// String regidate = request.getParameter("regidate");
			
			AdminCrewDTO dto = new AdminCrewDTO(name, location_id, description);			
			// 2. 어떤 service를 요청할 것인가?
			int rs = service.insertWrite(dto);
			// 3. 어떻게 어디로 이동할 것인가?
			// 어느 파일로 send redirect, forward 두가지 방식 중에 어떤걸로 이동할 것인가?
			forward_ok = false;
			path = "/JSP/Admin/Crew/Crew_List.adcr";
			response.sendRedirect(path);
			// sendRedirect 방식으로 List.do 파일로 이동(가상 경로)
		}else if(action.equals("/Crew_View.adcr")) {
			System.out.println("Crew_View.adcr 실행 성공");
			int idx = Integer.parseInt(request.getParameter("idx"));
			// request.getParameter() 메서드는 String 데이터형태로 데이터를 가져오므로
			// Integer.parseInt() 메서드를 통해서 int형으로 강제 형변환 해주어야 한다.
			// String -> int 형변환 : int numInt = Integer.parseInt(str)
			AdminCrewDTO crew = service.selectView(idx);
			request.setAttribute("crew", crew);
			path = "Crew_View";
			
		}else if(action.equals("/Crew_Edit.adcr")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			
			AdminCrewDTO crew = service.selectView(idx);
			
			request.setAttribute("crew", crew);
			
			path = "Crew_Edit";

		}else if(action.equals("/Crew_EditProcess.adcr")) {
			System.out.println("Crew_EditProcess.adcr 진입성공");
			System.out.println(request.getParameter("idx"));			// 1. 받을 값을 확인
			int idx = Integer.parseInt(request.getParameter("idx"));
			// request.getParameter() 메서드는 String 데이터형태로 데이터를 가져오므로
			// Integer.parseInt() 메서드를 통해서 int형으로 강제 형변환 해주어야 한다.
			// String -> int 형변환 : int numInt = Integer.parseInt(str)
			System.out.println("idx 값 확인 : "+idx);
			String name = request.getParameter("name");
			// String형 변수 name를 선언하고 request 객체의 name 속성의 값을 저장한다.
			String location_id = request.getParameter("location_id");
			String description  = request.getParameter("description");
			AdminCrewDTO dto = new AdminCrewDTO(idx,name,location_id,description);			
			
			int rs = service.updateEdit(dto);
			forward_ok = false;
			// 작업 후 페이지 이동
			path = "/JSP/Admin/Crew/Crew_View.adcr?idx="+idx;
			response.sendRedirect(path);
		}else if(action.equals("/Crew_DeleteProcess.adcr")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			int rs = service.delete(idx);
			forward_ok = false;
			path = "/JSP/Admin/Crew/Crew_List.adcr";
			response.sendRedirect(path);
		}
		
		
		if(forward_ok) {
		System.out.println("/JSP/Admin/Layout.jsp 조건문 진입");
		request.setAttribute("layout", "Crew/" + path);		
		// request 객체의 layout 속성에 "Crew/"+path값 저장
		request.getRequestDispatcher("/JSP/Admin/Layout.jsp").forward(request, response);
		// forward 방식으로 request 객체에 저장된 값을 전달해서 이동
		}
		
	}
	/* 서비스나 dao는 순수 자바 파일이다. */
}