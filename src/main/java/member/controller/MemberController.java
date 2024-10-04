package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.MemberDTO;
import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;

	public MemberController() {
		service = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess");
//		String uri = request.getRequestURI();
//		int lastSlash = uri.lastIndexOf("/");
//		String action = uri.substring(lastSlash);
//		System.out.println(action);
//		if(action.equals("/List.do")) {
//			// 1. 받을 값 확인
//
//			// 2. service 요청
//			List<MemberDTO> members = service.selectList();
//			request.setAttribute("members", members);
//
//			// 3. 어떻게 어디로 이동 할것인?
//			String path = "List.jsp";
//			request.getRequestDispatcher(path).forward(request, response);
//		}else if(action.equals("/Write.do")) {
//
//			// 3. 어떻게 어디로 이동 할것인?
//			String path = "Write.jsp";
//			response.sendRedirect(path);
//		}else if(action.equals("/WriteProcess.do")) {
//
//			// 1. 받을 값 확인
//			String id = request.getParameter("id");
//			String pass = request.getParameter("pass");
//			String name = request.getParameter("name");
//			System.out.print(id + "," + pass + "," + name);
//			
//			MemberDTO dto = new MemberDTO(id, pass, name, null);
//			
//			// 2. service 요청
//			int rs = service.insertWrite(dto);
//
//			// 3. 어떻게 어디로 이동 할것인?
//			String path = "List.do";
//			response.sendRedirect(path);
//		}else if(action.equals("/View.do")) {
//			// 1. 받을 값 확인
//			String id = request.getParameter("id");
//			// 2. service 요청
//			MemberDTO member = service.selectView(id);
//			request.setAttribute("member", member);
//
//			// 3. 어떻게 어디로 이동 할것인?
//			String path = "View.jsp";
//			request.getRequestDispatcher(path).forward(request, response);
//			
//		}else if(action.equals("/Edit.do")) {
//			// 1. 받을 값 확인
//			String id = request.getParameter("id");
//			
//			// 2. service 요청
//			MemberDTO member = service.selectView(id);
//			request.setAttribute("member", member);
//			
//			// 3. 어떻게 어디로 이동 할것인가?
//			String path = "Edit.jsp";
//			request.getRequestDispatcher(path).forward(request, response);
//		}else if(action.equals("/EditProcess.do")) {
//			// 1. 받을 값 확인
//			String id = request.getParameter("id");
//			String pass = request.getParameter("pass");
//			String name = request.getParameter("name");
//			
//			MemberDTO dto = new MemberDTO(id, pass, name);
//			
//			// 2. service 요청
//			int rs = service.updateEdit(dto);
//			
//			// 3. 어떻게 어디로 이동 할것인가?
//			String path = "View.do?id="+id;
//			response.sendRedirect(path);
//		}
	}

}
