<%@page import="member.dao.MemberDAO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DeleteProcess -> List.jsp

String id = request.getParameter("id");

MemberDAO dao = new MemberDAO(application);
int rs = dao.deletePcs(id);

// 작업 후 이동
response.sendRedirect("List.jsp");
%>


