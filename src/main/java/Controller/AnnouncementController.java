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
import Utils.FileUtils;

@WebServlet("*.an")
public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//공지사항 관련 비즈니스 로직을 수행하기 위해
	AnnouncementService service; 
	//인터페이스를 구현한 객체를 초기화
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
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    //URI 처리: 요청 URI에서 마지막 경로를 추출하여 action 변수에 저장
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);
		//기본경로
		String path = "An_List";
		
		if (action.equals("/An_List.an")) {
			// 1. 받을 값 확인
			String searchField = request.getParameter("searchField"); // 검색 필드 (예: 제목, 내용 등)
			String searchWord = request.getParameter("searchWord"); // 검색어
			String limitParam = request.getParameter("limit"); // 페이징 처리를 위한 limit
			String pageNumParam = request.getParameter("pageNum");// 페이지 번호
			
		    int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 10; // 기본 페이지 크기
		    int pageNum = (pageNumParam != null) ? Integer.parseInt(pageNumParam) : 1; // 기본 페이지 번호
		    int offset = (pageNum - 1) * limit; // 오프셋 계산

		    Map<String, String> map = new HashMap<>();
		    map.put("searchField", (searchField != null) ? searchField : "");
		    map.put("searchWord", (searchWord != null) ? searchWord : "");
		    map.put("limit", String.valueOf(limit));
		    map.put("offset", String.valueOf(offset));
		    
		    // 3. 총 게시물 수 가져오기
		    int totalCount = service.selectCount(map); // 총 게시물 수 계산
		    
			// 4. service 요청
			List<AnnouncementDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);

		    // 5. 페이징 처리
		    int pageSize = 10; // 한 페이지에 보여줄 게시물 수
		    int blockPage = 5; // 한 번에 보여줄 페이지 블록 수
		    //pagingStr 메서드를 호출할 때 searchField와 searchWord 값을 전달하여 링크에 포함
		    String pagingStr = AnnouncementPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/An_List.an", map.get("searchField"), map.get("searchWord"));
		    request.setAttribute("pagingStr", pagingStr);

			// 4. 어떻게 어디로 이동 할것인가?
		    path = "An_List";
			
		} else if (action.equals("/An_Write.an")) {
			// 3. 어떻게 어디로 이동 할것인가?
			path = "An_Write";
			
		} else if (action.equals("/An_WriteProcess.an")) {
			AnnouncementDTO dto = new AnnouncementDTO();
			
			Map<String, String> rData = FileUtils.fileUpload(request, "file");
			dto.setOfile(rData.get("ofile"));
			dto.setSfile(rData.get("sfile"));
			
			// 파일 업로드 처리
			// 1. 받을 값 확인
			String title = rData.get("title");
			String content = rData.get("content");
			//String idx = request.getParameter("idx");
			
			HttpSession session = request.getSession();
		    String member_id = (String) session.getAttribute("UserId");
		    
			dto.setTitle(title);
			dto.setContent(content);
			dto.setMember_id(member_id);
			
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
				path = "An_Write";
			}
			
		} else if (action.equals("/An_View.an")) {
			
			String idx = request.getParameter("idx");  // 일련번호 받기 

			service.updateVisitCount(idx);                 // 조회수 증가 
			AnnouncementDTO dto = service.pnPage(idx);     // 게시물 가져오기 

			request.setAttribute("board", dto);
			path = "An_View";

		} else if (action.equals("/An_Edit.an")) {
			String idx = request.getParameter("idx");  // 일련번호 받기 
			
			AnnouncementDTO dto = service.pnPage(idx);        // 게시물 가져오기 
			request.setAttribute("board", dto);

			// 3. 어떻게 어디로 이동 할것인가?
			path = "An_Edit";
			
		} else if (action.equals("/An_EditProcess.an")) {
			AnnouncementDTO dto = new AnnouncementDTO();
			
			String saveDirectory = request.getServletContext().getRealPath("/JSP/Upload");
			
			Map<String, String> rData = FileUtils.fileUpload(request, "file");
			dto.setOfile(rData.get("ofile"));
			dto.setSfile(rData.get("sfile"));
			
			// 1. 받을 값 확인
			String idx = rData.get("idx");
			String title = rData.get("title");
			String content = rData.get("content");
			String fileName = rData.get("ofile");
			String newFileName = rData.get("sfile");

			dto.setIdx(idx);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
			// 2. service 요청
			int rs = service.updateEdit(dto, saveDirectory);

			// 3. 어떻게 어디로 이동 할것인가?
			if (rs == 1) {
				// 성공 시 상세 보기 페이지로 이동
				response.sendRedirect("/An_View.an?idx=" + idx);
				return;
			} else {
				// 삽입 실패
				request.setAttribute("errorMessage", "수정하기에 실패하였습니다.");
				path = "An_Edit";
			}
			
		} else if (action.equals("/An_DeleteProcess.an")) {
			// 1. 받을 값 확인
			HttpSession session = request.getSession();
			String idx = request.getParameter("idx");

			AnnouncementDAO dao = new AnnouncementDAO();
			AnnouncementDTO dto = dao.pnPage(idx);
			

			// 로그인된 사용자 ID 얻기
			String member_id = session.getAttribute("UserId").toString();
			int delResult = 0;

			if (member_id.equals(dto.getMember_id())) { // 작성자가 본인인지 확인
				// 작성자가 본인이면...
				//dto.setIdx(idx);

				delResult = service.deletePost(idx);

				// 3. 어떻게 어디로 이동 할것인가?
				if (delResult == 1) {
					FileUtils.fileDelete(request, dto.getSfile());
					// 성공 시 목록 페이지로 이동
//					session.setAttribute("message", "삭제되었습니다.");
					response.getWriter().write("<script>alert('삭제되었습니다.'); location.href = '/An_List.an'</script>");
					return;
				} else {
					// 실패 시 이전 페이지로 이동
					response.getWriter().write("<script>alert('삭제에 실패하였습니다.'); location.href = '/An_View.an?idx=" + idx + "'</script>");
					return;
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				response.getWriter().write("<script>alert('본인만 삭제할 수 있습니다.'); location.href = '/An_View.an?idx=" + idx + "'</script>");
				return;
			}
			
		} else if (action.equals("/FileDown.an")) {
			FileUtils.fileDownload(request, response);
			return;
		}
		
		request.setAttribute("layout", "Announcement/" + path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}

}
