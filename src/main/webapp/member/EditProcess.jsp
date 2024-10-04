<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// EditProcess -> View.jsp

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");

MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setPass(pass);
dto.setName(name);

MemberDAO dao = new MemberDAO(application);
/* int rs = dao.updateEdit(id, pass, name);  */
int rs = dao.updateEdit(dto);

// 작업 후 이동
response.sendRedirect("View.jsp?id="+id);
%>



