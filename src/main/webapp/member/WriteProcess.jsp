<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// WriteProcess -> list.jsp

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
out.print(id + "," + pass + "," + name);
MemberDTO dto = new MemberDTO(id, pass, name, null);

JDBCConnect jdbc = new JDBCConnect();

MemberDAO dao = new MemberDAO(application);
//int rs = dao.insertWrite(id, pass, name);
int rs = dao.insertWrite(dto);

// 작업 후 이동
response.sendRedirect("List.jsp");
%>



