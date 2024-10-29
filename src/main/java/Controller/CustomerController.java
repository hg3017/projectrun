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

import org.apache.tomcat.util.http.fileupload.FileUtils;

import DAO.AnnouncementDAO;
import DAO.CustomerboardDAO;
import DTO.AnnouncementDTO;
import DTO.CustomerboardDTO;
import DTO.FreeBoardDTO;
import Service.CustomerboardService;
import Service.CustomerboardServiceImpl;
import Utils.CustomerboardPage;

@WebServlet("*.co")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerboardService service;

	public CustomerController() {
		service = new CustomerboardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String action = uri.substring(lastSlash);

		String path = "Cs_List";

		if(action.equals("/Cs_List.co")) {
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

			int totalCount =  service.selectCount(map);
			request.setAttribute("totalCount", totalCount);

			List<CustomerboardDTO> boards = service.selectList(map);
			request.setAttribute("boards", boards);

			int pageSize = 10;
			int blockPage = 5;
			String pagingStr = CustomerboardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/Cs_List.co");
			request.setAttribute("pagingStr", pagingStr);

			path = "Cs_List";
			
		} else if(action.equals("/Cs_Write.co")) {

			path = "Cs_Write";
			
		} else if(action.equals("/Cs_WriteProcess.co")) {
			String category = request.getParameter("category");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
//			System.out.println("ableview 출력 : "+request.getParameter("ableview"));

			HttpSession session = request.getSession();
			String member_id = (String) session.getAttribute("UserId");
			
			CustomerboardDTO dto = new CustomerboardDTO();
			dto.setCategory(category);
			dto.setTitle(title);
			dto.setMember_id(member_id);
			dto.setContent(content);

			int rs = service.insertWrite(dto);

			if(rs == 1) {
				response.sendRedirect("/Cs_List.co");
				return;
				
			} else {
				request.setAttribute("errorMessage", "게시물 작성에 실패하였습니다");
				path = "Cs_Write";
			}

		} else if(action.equals("/Cs_View.co")) {
			String idx = request.getParameter("idx");

			service.updateVisitCount(idx);
			CustomerboardDTO dto = service.ViewPage(idx);

			request.setAttribute("board", dto);
			path = "Cs_View";

		} else if(action.equals("/Cs_Edit.co")) {
			String idx = request.getParameter("idx");
			
			CustomerboardDTO dto = service.ViewPage(idx);
			request.setAttribute("board", dto);
			
			path = "Cs_Edit";
		} else if(action.equals("/Cs_EditProcess.co")) {
			String category = request.getParameter("category");
			String idx = request.getParameter("idx");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			CustomerboardDTO dto = new CustomerboardDTO();
			dto.setCategory(category);
			dto.setIdx(idx);
			dto.setTitle(title);
			dto.setContent(content);
			
			int rs = service.updateEdit(dto);
			
			if(rs == 1) {
				response.sendRedirect("Cs_View.co?idx=" + idx);
				return;
			} else {
				request.setAttribute("errorMessage", "수정하기가 실패하였습니다.");
				path = "Cs_Edit";
			}
			
		} else if (action.equals("/Cs_DeleteProcess.co")) {
			HttpSession session = request.getSession();
			String idx = request.getParameter("idx");

			CustomerboardDAO dao = new CustomerboardDAO();
			CustomerboardDTO dto = dao.viewPage(idx);
			

			String member_id = session.getAttribute("UserId").toString();
			int delResult = 0;

			if (member_id.equals(dto.getMember_id())) {
				dto.setIdx(idx);

				delResult = service.deletePost(dto);

				if (delResult == 1) {
					// 성공 시 목록 페이지로 이동
					response.getWriter().write("<script>alert('삭제되었습니다.'); location.href = '/Cs_List.co'</script>");
					return;
				} else {
					// 실패 시 이전 페이지로 이동
					response.getWriter().write("<script>alert('삭제에 실패하였습니다.'); location.href = '/Cs_View.co?idx=" + idx + "'</script>");
					return;
				}
			} else {
				// 작성자가 본인이 아닐 때 처리
				response.getWriter().write("<script>alert('본인만 삭제할 수 있습니다.'); location.href = '/Cs_View.co?idx=" + idx + "'</script>");
				return;
			}
			
		}
		request.setAttribute("layout", "Customerboard/" + path);
		request.getRequestDispatcher("/JSP/layout.jsp").forward(request, response);
	}
}
