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
int grade = Integer.getInteger("grade");
String nickname = request.getParameter("nickname");
String location = request.getParameter("location");
int phone_number  = Integer.getInteger("phone_number");
out.print(id + "," + pass + "," + name);
MemberDTO dto = new MemberDTO(id, pass, name, grade, nickname, location, phone_number);

JDBCConnect jdbc = new JDBCConnect();

MemberDAO dao = new MemberDAO(application);
//int rs = dao.insertWrite(id, pass, name);
int rs = dao.insertWrite(dto);

// 작업 후 이동
response.sendRedirect("List.jsp");
%>



