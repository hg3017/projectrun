package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
		System.out.println(action);
		if (action.equals("/List.an")) {
			// 1. 받을 값 확인
			String searchField = request.getParameter("searchField"); // 검색 필드 (예: 제목, 내용 등)
			String searchWord = request.getParameter("searchWord"); // 검색어
			String limit = request.getParameter("limit"); // 페이징 처리를 위한 limit
			String offset = request.getParameter("offset");

			// 2. searchField, searchWord, limit, offset 값을 Map에 저장
			Map<String, String> map = new HashMap<>();
			map.put("searchField", searchField != null ? searchField : ""); // 필드가 없으면 빈 값
			map.put("searchWord", searchWord != null ? searchWord : ""); // 검색어가 없으면 빈 값
			map.put("limit", limit != null ? limit : "10"); // 기본 limit 설정
			map.put("offset", offset != null ? offset : "0");

			// 3. service 요청
			List<AnnouncementDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);

			// 4. 어떻게 어디로 이동 할것인가?
			String path = "List.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else if (action.equals("/Write.an")) {

			// 3. 어떻게 어디로 이동 할것인가?
			String path = "Write.jsp";
			response.sendRedirect(path);
		} else if (action.equals("/WriteProcess.an")) {

			// 1. 받을 값 확인
			// int num = Integer.parseInt(request.getParameter("num"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// String id = request.getParameter("id");
			// String postdate = request.getParameter("postdate");
			// int visitcount = Integer.parseInt(request.getParameter("visitcount"));
			// System.out.print(title + "," + content + "," + id);
			HttpSession session = request.getSession();
			// String id = session.getAttribute("UserId") != null ?
			// session.getAttribute("UserId").toString() : null; // 세션에서 ID 가져오기

			AnnouncementDTO dto = new AnnouncementDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setId(session.getAttribute("UserId").toString());

			// 2. service 요청
			int rs = 0;
			rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공적으로 삽입
				String path = "List.an";
				response.sendRedirect(path);
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "게시물 작성에 실패하였습니다.");
				String path = "Write.jsp"; // 다시 작성 페이지로 돌아감
				request.getRequestDispatcher(path).forward(request, response);
			}
		} else if (action.equals("/View.an")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			// 2. service 요청
			AnnouncementDTO board = service.selectView(id);
			request.setAttribute("board", board);

			// 3. 어떻게 어디로 이동 할것인가?
			String path = "View.jsp";
			request.getRequestDispatcher(path).forward(request, response);

		} else if (action.equals("/Edit.an")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");

			// 2. service 요청
			AnnouncementDTO board = service.selectView(id);
			request.setAttribute("board", board);

			// 3. 어떻게 어디로 이동 할것인가?
			String path = "Edit.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else if (action.equals("/EditProcess.an")) {
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
				String path = "View.an?num=" + num;
				response.sendRedirect(path);
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "수정하기에 실패하였습니다.");
				String path = "Edit.jsp"; // 다시 작성 페이지로 돌아감
				request.getRequestDispatcher(path).forward(request, response);
			}
		} else if (action.equals("/DeleteProcess.an")) {
			// 1. 받을 값 확인
			HttpSession session = request.getSession();
			String num = request.getParameter("num");

			AnnouncementDAO dao = new AnnouncementDAO();
			AnnouncementDTO dto = dao.selectView(num);

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
					session.setAttribute("message", "삭제되었습니다.");
					String path = "List.an";
					response.sendRedirect(path);
				} else {
					// 실패 시 이전 페이지로 이동
					request.setAttribute("errorMessage", "삭제에 실패하였습니다.");
					String path = "View.jsp?num=" + num; // 다시 작성 페이지로 돌아감
					request.getRequestDispatcher(path).forward(request, response);
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				request.setAttribute("errorMessage", "본인만 삭제할 수 있습니다.");
				String path = "View.jsp?num=" + num; // 상세 페이지로 돌아감
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

}
