package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CrewDAO;
import DTO.AnnouncementDTO;
import DTO.CrewDTO;
import Service.CrewMemberService;
import Service.CrewMemberServiceImpl;
import Service.CrewService;
import Service.CrewServiceImpl;



// @WebServlet. 요청값이 .lo 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.crew")
public class CrewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CrewService service;
	CrewMemberService Memberservice;
	
	// LoginController 생성자. 컨트롤러가 생성될 때 LoginServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public CrewController() {
		service = new CrewServiceImpl();
		Memberservice = new CrewMemberServiceImpl();
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
		
		// Servelt 의 경로값이 /CrewListProcess.crew 인 경우 작동합니다. 
		if(action.equals("/CrewListProcess.crew")) {
			
			List<CrewDTO> CrewLists = service.selectCrewList();
			request.setAttribute("CrewLists", CrewLists);
						
			if(CrewLists != null){
				request.getRequestDispatcher("/JSP/Main/Crew_view.jsp").forward(request, response);
			} 
			// dto 값이 null 인 경우 작동합니다. 
			else{
				request.getRequestDispatcher("/JSP/Main/Main.jsp").forward(request, response);
			}
		}
		// Servelt 의 경로값이 /LoginForm.lo 인 경우 작동합니다. 해당 위치는 아직 추가 작업이 필요합니다.
		else if(action.equals("/CrewMainProcess.crew")) {
			
			String crewName = request.getParameter("crewName");
			
			CrewDTO CrewDetail = service.selectCrew(crewName);
			
			String sessionId = (String) session.getAttribute("UserId");  
			String crewSessionId = Memberservice.selectCrewMemberStatus(crewName, sessionId);
			
			request.setAttribute("CrewDetail", CrewDetail);
			request.setAttribute("crewSessionId", crewSessionId);
						
			System.out.println("CrewController: crewName " + crewName);
			System.out.println("CrewController: sessionId " + sessionId);
			System.out.println("CrewController: crewSessionId " + crewSessionId);
			
			if(CrewDetail != null){
				request.getRequestDispatcher("/JSP/Crew/CrewMain.jsp").forward(request, response);
			} 
			// dto 값이 null 인 경우 작동합니다. 
			else{
				request.getRequestDispatcher("/JSP/Main/Main.jsp").forward(request, response);
			}

		}
		
	}

}