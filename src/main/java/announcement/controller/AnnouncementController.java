package announcement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import announcement.dto.AnnouncementDTO;
import announcement.service.AnnouncementService;
import announcement.service.AnnouncementServiceImpl;

@WebServlet("*.an")
public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AnnouncementService service;

	public AnnouncementController() {
		service = new AnnouncementServiceImpl();
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
		System.out.println(action);
		if(action.equals("/List.an")) {
			// 1. 받을 값 확인

			// 2. service 요청
			List<AnnouncementDTO> boards = service.selectList();
			request.setAttribute("board", boards);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "List.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}else if(action.equals("/Write.an")) {

			// 3. 어떻게 어디로 이동 할것인?
			String path = "Write.jsp";
			response.sendRedirect(path);
		}else if(action.equals("/WriteProcess.an")) {

			// 1. 받을 값 확인
			int num = Integer.getInteger("num");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String id = request.getParameter("id");
			String postdate = request.getParameter("postdate");
			int visitcount = Integer.getInteger("visitcount");
			System.out.print(num + "," + title + "," + content + "," + id + "," + postdate + "," + visitcount );
			
			AnnouncementDTO dto = new AnnouncementDTO();
			
			// 2. service 요청
			int rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "List.an";
			response.sendRedirect(path);
		}else if(action.equals("/View.an")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			// 2. service 요청
			AnnouncementDTO board = service.selectView(id);
			request.setAttribute("board", board);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "View.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}else if(action.equals("/Edit.an")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			
			// 2. service 요청
			AnnouncementDTO board = service.selectView(id);
			request.setAttribute("board", board);
			
			// 3. 어떻게 어디로 이동 할것인가?
			String path = "Edit.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}else if(action.equals("/EditProcess.an")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			
			AnnouncementDTO dto = new AnnouncementDTO();
			
			// 2. service 요청
			int rs = service.updateEdit(dto);
			
			// 3. 어떻게 어디로 이동 할것인가?
			String path = "View.do?id="+id;
			response.sendRedirect(path);
		}
	}

}
