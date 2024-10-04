<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");

MemberDAO dao = new MemberDAO(application);
MemberDTO dto = dao.selectView(id);

if(dto != null) {
	if(pw.equals(dto.getPass())){
		session.setAttribute("UserId", id);
		session.setAttribute("UserName", dto.getName());
		response.sendRedirect("LoginForm.jsp");
		
	}else{
		request.setAttribute("LoginErrMsg", "로그인 오류");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
}else{
	request.setAttribute("LoginErrMsg", "로그인 오류");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}





%>