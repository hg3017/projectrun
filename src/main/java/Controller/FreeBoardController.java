package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.FreeBoardDTO;
import Service.FreeBoardService;
import Service.FreeBoardServiceImpl;

@WebServlet("*.free")
public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FreeBoardService service;

	public FreeBoardController() {
		service = new FreeBoardServiceImpl();
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
		if(action.equals("/List.free")) {
			// 1. 받을 값 확인

			// 2. service 요청
			List<FreeBoardDTO> boards = service.selectList();
			request.setAttribute("boards", boards);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "List.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}else if(action.equals("/Write.free")) {

			// 3. 어떻게 어디로 이동 할것인?
			String path = "Write.jsp";
			response.sendRedirect(path);
		}else if(action.equals("/WriteProcess.free")) {

			// 1. 받을 값 확인
			int num = Integer.getInteger("num");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String id = request.getParameter("id");
			String postdate = request.getParameter("postdate");
			int visitcount = Integer.getInteger("visitcount");
			System.out.print(num + "," + title + "," + content + "," + id + "," + postdate + "," + visitcount );
			
			FreeBoardDTO dto = new FreeBoardDTO();
			
			// 2. service 요청
			int rs = service.insertWrite(dto);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "List.free";
			response.sendRedirect(path);
		}else if(action.equals("/View.free")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			// 2. service 요청
			FreeBoardDTO board = service.selectView(id);
			request.setAttribute("board", board);

			// 3. 어떻게 어디로 이동 할것인?
			String path = "View.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}else if(action.equals("/Edit.free")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			
			// 2. service 요청
			FreeBoardDTO board = service.selectView(id);
			request.setAttribute("board", board);
			
			// 3. 어떻게 어디로 이동 할것인가?
			String path = "Edit.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}else if(action.equals("/EditProcess.free")) {
			// 1. 받을 값 확인
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			
			FreeBoardDTO dto = new FreeBoardDTO();
			
			// 2. service 요청
			int rs = service.updateEdit(dto);
			
			// 3. 어떻게 어디로 이동 할것인가?
			String path = "View.do?id="+id;
			response.sendRedirect(path);
		}
	}

}
