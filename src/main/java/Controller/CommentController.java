package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;

import DAO.LoginDAO;
import DTO.CommentDTO;
import DTO.LoginDTO;
import DTO.RegisterDTO;
import Service.CommentService;
import Service.CommentServiceImpl;
import Service.LoginService;
import Service.LoginServiceImpl;



// @WebServlet. 요청값이 .lo 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CommentService service;

	// LoginController 생성자. 컨트롤러가 생성될 때 LoginServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public CommentController() {
		service = new CommentServiceImpl();
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
		
		// Servelt 의 경로값이 /LoginProcess.lo 인 경우 작동합니다. 
		if(action.equals("/commentProcess.comment")) {
			// 1. 받을 값 확인
			String member_id = request.getParameter("member_id");
			String content = request.getParameter("content");
			String crew_name = request.getParameter("crew_name");
			
			CommentDTO dto = new CommentDTO();
			dto.setMember_id(request.getParameter("member_id"));
			dto.setContent(request.getParameter("content"));
			dto.setCrew_name(request.getParameter("crew_name"));
			
			
			// 2. service 요청
			int result = 0;
			result = service.insertComment(dto);
						
			// dto 값이 null 이 아닌경우(리턴이 있는 경우) 작동합니다. 
			if(result == 1){
				
				response.setContentType("text/html; charset=UTF-8");
			    response.getWriter().println("<script type='text/javascript'>");
			    response.getWriter().println("alert('댓글 작성이 완료되었습니다.');");
			    response.getWriter().println("window.location.href = '/CrewMainProcess.crew?crewName=" + crew_name + "';");
			    response.getWriter().println("</script>");
				
			} 
			
		}
		
	}

}