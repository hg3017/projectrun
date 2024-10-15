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
import DAO.CrewMemberDAO;
import DAO.LoginDAO;
import DTO.AnnouncementDTO;
import DTO.CrewDTO;
import DTO.CrewMemberDTO;
import DTO.LoginDTO;
import Service.CrewMemberService;
import Service.CrewMemberServiceImpl;



// @WebServlet. 요청값이 .lo 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.crewMember")
public class CrewMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CrewMemberService service;

	// LoginController 생성자. 컨트롤러가 생성될 때 LoginServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public CrewMemberController() {
		service = new CrewMemberServiceImpl();
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
		if(action.equals("/CrewListProcess.crewMember")) {
			// 1. 받을 값 확인
			
			
			// 2. service 요청
			CrewDAO dao = new CrewDAO();
			// LoginDTO 의 형태를 가진 객체를 dto 의 이름으로 생성하고 그 안에 dao.selectView(id) 에서 리턴받은 값을 입력합니다.
			
			List<CrewDTO> dto = dao.selectCrewList();
			// dto 값이 null 이 아닌경우(리턴이 있는 경우) 작동합니다. 
			if(dto != null){
				
				
				
			} 
			// dto 값이 null 인 경우 작동합니다. 
			else{
				request.setAttribute("LoginErrMsg", "로그인 오류");
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
			}
			
			
		}
		else if(action.equals("/accept.crewMember")) {
			String name = request.getParameter("name");
			String crew_name = request.getParameter("crew_name");
			
			
			CrewMemberDAO dao = new CrewMemberDAO();
			int rs = dao.acceptCrewMember(crew_name, name);

			if(rs == 1) {
				System.out.println("CrewMemberController.doProcess.accept - checkpoint2");

				response.sendRedirect("/JSP/Crew/CrewMemberView.jsp");
			} else {
				request.setAttribute("AcceptErrMsg", "가입 승인 오류");
				request.getRequestDispatcher("/JSP/Crew/CrewMemberView.jsp").forward(request, response);
			}
			
		}
		else if(action.equals("/refuse.crewMember")) {
			String name = request.getParameter("name");
			String crew_name = request.getParameter("crew_name");
			
			CrewMemberDAO dao = new CrewMemberDAO();
			int rs = dao.refuseCrewMember(crew_name, name);
			
			System.out.println("CrewMemberController.doProcess.refuse - checkpoint1");
			
			if(rs == 1) {
				System.out.println("CrewMemberController.doProcess.refuse - checkpoint2");
				response.sendRedirect("/JSP/Crew/CrewMemberView.jsp");
			} else {
				request.setAttribute("RefuseErrMsg", "가입 거절 오류");
				request.getRequestDispatcher("/JSP/Crew/CrewMemberView.jsp").forward(request, response);
			}
		}
		
	}

}