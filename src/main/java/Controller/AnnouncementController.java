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

import DAO.AnnouncementDAO;
import DTO.AnnouncementDTO;
import Service.AnnouncementService;
import Service.AnnouncementServiceImpl;
import Utils.AnnouncementPage;

@WebServlet("*.an")
public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AnnouncementService service;

	public AnnouncementController() {
		service = new AnnouncementServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess");
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		
		String path = "An_List";
		
		if (action.equals("/An_List.an")) {
			// 1. 받을 값 확인
			String searchField = request.getParameter("searchField"); // 검색 필드 (예: 제목, 내용 등)
			String searchWord = request.getParameter("searchWord"); // 검색어
			String limitParam = request.getParameter("limit"); // 페이징 처리를 위한 limit
			//String offsetParam = request.getParameter("offset");
			String pageNumParam = request.getParameter("pageNum");
			
		    int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10; // 기본 페이지 크기
		    int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1; // 기본 페이지 번호
		    int offset = (pageNum - 1) * limit; // 오프셋 계산

			// 2. searchField, searchWord, limit, offset 값을 Map에 저장
//			Map<String, String> map = new HashMap<>();
//			map.put("searchField", searchField != null ? searchField : ""); // 필드가 없으면 빈 값
//			map.put("searchWord", searchWord != null ? searchWord : ""); // 검색어가 없으면 빈 값
//			map.put("limit", limit != null ? limit : "10"); // 기본 limit 설정
//			map.put("offset", offset != null ? offset : "0");
			
		    Map<String, String> map = new HashMap<>();
		    map.put("searchField", (searchField != null) ? searchField : "");
		    map.put("searchWord", (searchWord != null) ? searchWord : "");
		    map.put("limit", String.valueOf(limit));
		    map.put("offset", String.valueOf(offset));
		    
		    // 3. 총 게시물 수 가져오기
		    int totalCount = service.selectCount(map); // 총 게시물 수 계산
		    request.setAttribute("totalCount", totalCount);
		    
			// 4. service 요청
			List<AnnouncementDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);

		    // 5. 페이징 처리
		    int pageSize = 10; // 한 페이지에 보여줄 게시물 수
		    int blockPage = 5; // 한 번에 보여줄 페이지 블록 수
		    String pagingStr = AnnouncementPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/An_List.an");
		    request.setAttribute("pagingStr", pagingStr);

			// 4. 어떻게 어디로 이동 할것인가?
		    path = "An_List";
			
		} else if (action.equals("/An_Write.an")) {
			// 3. 어떻게 어디로 이동 할것인가?
			path = "An_Write";
			
		} else if (action.equals("/An_WriteProcess.an")) {
			// 파일 업로드 처리
			// 1. 받을 값 확인
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			HttpSession session = request.getSession();
		    String id = (String) session.getAttribute("UserId");
		    
			AnnouncementDTO dto = new AnnouncementDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setId(id);
			
			// 2. service 요청
			int rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공적으로 삽입
				//String path = "An_List.an";
				response.sendRedirect("/An_List.an");
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "게시물 작성에 실패하였습니다.");
				path = "An_Write"; // 다시 작성 페이지로 돌아감
			}
			
		} else if (action.equals("/An_View.an")) {
			String num = request.getParameter("num");  // 일련번호 받기 

			service.updateVisitCount(num);                 // 조회수 증가 
			AnnouncementDTO dto = service.pnPage(num);     // 게시물 가져오기 

			request.setAttribute("board", dto);
			path = "An_View";

		} else if (action.equals("/An_Edit.an")) {
			String num = request.getParameter("num");  // 일련번호 받기 
			//HttpSession session = request.getSession();
			//String sessionId = (String) session.getAttribute("UserId");
			
			AnnouncementDTO dto = service.pnPage(num);        // 게시물 가져오기 
			request.setAttribute("board", dto);
			
			// 3. 어떻게 어디로 이동 할것인가?
			path = "An_Edit";
			
		} else if (action.equals("/An_EditProcess.an")) {
			// 1. 받을 값 확인
			String num = request.getParameter("num");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			AnnouncementDTO dto = new AnnouncementDTO();
			dto.setNum(num);
			dto.setTitle(title);
			dto.setContent(content);
			
			// 2. service 요청
			int rs = service.updateEdit(dto);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공 시 상세 보기 페이지로 이동
				response.sendRedirect("/An_View.an?num=" + num);
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "수정하기에 실패하였습니다.");
				path = "An_Edit";
			}
			
		} else if (action.equals("/An_DeleteProcess.an")) {
			// 1. 받을 값 확인
			HttpSession session = request.getSession();
			String num = request.getParameter("num");

			AnnouncementDAO dao = new AnnouncementDAO();
			AnnouncementDTO dto = dao.pnPage(num);
			
			// 응답 인코딩 설정
		    response.setContentType("text/html; charset=UTF-8");
		    response.setCharacterEncoding("UTF-8");

			// 로그인된 사용자 ID 얻기
			String sessionId = session.getAttribute("UserId").toString();
			int delResult = 0;

			if (sessionId.equals(dto.getId())) { // 작성자가 본인인지 확인
				// 작성자가 본인이면...
				dto.setNum(num);

				delResult = service.deletePost(dto);

				// 3. 어떻게 어디로 이동 할것인가?
				if (delResult == 1) {
					// 성공 시 목록 페이지로 이동
//					session.setAttribute("message", "삭제되었습니다.");
					response.getWriter().write("<script>alert('삭제되었습니다.'); location.href = '/An_List.an'</script>");
					return;
				} else {
					// 실패 시 이전 페이지로 이동
					response.getWriter().write("<script>alert('삭제에 실패하였습니다.'); location.href = '/An_View.an?num=" + num + "'</script>");
					return;
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				response.getWriter().write("<script>alert('본인만 삭제할 수 있습니다.'); location.href = '/An_View.an?num=" + num + "'</script>");
				return;
			}
		}
		
		request.setAttribute("layout", path);
		request.getRequestDispatcher("/JSP/Announcement/layout.jsp").forward(request, response);
	}

}
