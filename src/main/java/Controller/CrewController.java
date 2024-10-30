package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CrewDAO;
import DTO.AnnouncementDTO;
import DTO.CommentDTO;
import DTO.CrewBoardDTO;
import DTO.CrewDTO;
import DTO.CrewMemberDTO;
import DTO.LocationDTO;
import Service.CommentService;
import Service.CommentServiceImpl;
import Service.CrewBoardServiceImpl;
import Service.CrewMemberService;
import Service.CrewMemberServiceImpl;
import Service.CrewService;
import Service.CrewServiceImpl;
import Service.LocationService;
import Service.LocationServiceImpl;
import Service.CrewBoardService;
import Service.CrewBoardServiceImpl;


// @WebServlet. 요청값이 .lo 로 끝나는 경우 해당 컨트롤러를 찾아 작동합니다. 
@WebServlet("*.crew")
public class CrewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CrewService service;
	CrewMemberService Memberservice;
	LocationService Locationservice;
	CommentService Commentservice;
	CrewBoardService CrewBoardService;
	
	// LoginController 생성자. 컨트롤러가 생성될 때 LoginServiceImpl 객체를 생성하여 service 변수에 할당합니다.
	public CrewController() {
		service = new CrewServiceImpl();
		Memberservice = new CrewMemberServiceImpl();
		Locationservice = new LocationServiceImpl();
		Commentservice = new CommentServiceImpl();
		CrewBoardService = new CrewBoardServiceImpl();
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
		
		String path = "CrewView";
		
		// 크루리스트 전체 목록을 가져옵니다. 
		if(action.equals("/CrewListProcess.crew")) {
			
			List<CrewDTO> CrewLists = service.selectCrewList();
			request.setAttribute("CrewLists", CrewLists);
						
			if(CrewLists != null){
				path = "CrewView";
			} 
		}
		// 선택한 크루의 정보를 가지고, 선택 크루 상세화면으로 이동합니다. 
		else if(action.equals("/CrewMainProcess.crew")) {
			
			String crewName = request.getParameter("crewName");
			CrewDTO CrewDetail = service.selectCrew(crewName);
			List<CrewMemberDTO> crewMainMemberLists = Memberservice.selectCrewMainMemberList(crewName);
			
			String searchField = request.getParameter("searchField");
			String searchWord = request.getParameter("searchWord");
			String limitParam = request.getParameter("limit");
			String pageNumParam = request.getParameter("pageNum");
			
			int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10;
			int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1;
			int offset = (pageNum - 1) * limit;
			
			Map<String, String> map = new HashMap<>();
			map.put("searchField", (searchField != null) ? searchField : "");
			map.put("searchWord", (searchWord != null) ? searchWord : "");
			map.put("limit", String.valueOf(limit));
			map.put("offset", String.valueOf(offset));
			
			
			List<CrewBoardDTO> boards = CrewBoardService.selectList(map);
			request.setAttribute("boards", boards);
			
			List<CommentDTO> CommentLists = Commentservice.commentView(crewName);
			
			String sessionId = (String) session.getAttribute("UserId");  
			String crewSessionId = Memberservice.selectCrewMemberStatus(crewName, sessionId);
			
			request.setAttribute("CrewDetail", CrewDetail);
			request.setAttribute("crewSessionId", crewSessionId);
			request.setAttribute("crewMainMemberLists", crewMainMemberLists);
			request.setAttribute("commentLists", CommentLists);
			
			if(CrewDetail != null){
				path= "CrewMain";
			} 
		
		} 
		// 크루 생성 화면으로 이동합니다. 
		else if(action.equals("/CrewRegist.crew")) {
			
			List<LocationDTO> locations = Locationservice.locationView();
			
			request.setAttribute("locations", locations);
			
			if(locations != null){
				path= "CrewRegist";
			} 
			
			
			
		} 
		// 입력한 크루를 등록합니다. 
		else if(action.equals("/CrewRegist.crew")) {
			CrewDTO dto = new CrewDTO();
			
			dto.setName(request.getParameter("name"));
			dto.setDescripton(request.getParameter("description"));
			dto.setLocation_id(request.getParameter("lo"));
			
			String sessionId = (String) session.getAttribute("UserId");  
			
			System.out.println("CrewRegist.crew- checkPoint2");
			System.out.println("dto getName : " + dto.getName()  );
			System.out.println("sessionId : " + sessionId  );
			
			int rs = service.registCrew(dto);
			int memberResult = service.registCrewMaster(dto.getName(), sessionId);
			
			
			
			if(rs == 1 && memberResult == 1){
				// 회원가입에 성공한 경우, 경로를 추출하고 추출한 경로를 통해 로그인 페이지로 이동합니다. 
				List<CrewDTO> CrewLists = service.selectCrewList();
				request.setAttribute("CrewLists", CrewLists);
				
				path= "CrewView";
			} else {	
				request.setAttribute("LoginErrMsg", "크루 등록 오류");
				path= "CrewView";
				
			}
			
			
		} 
		
		
		request.setAttribute("layout","Crew/" + path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}

}