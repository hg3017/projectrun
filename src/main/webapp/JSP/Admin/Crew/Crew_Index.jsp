<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String UserId = (String)session.getAttribute("UserId");
String admin="admin";
if(!UserId.equals(admin)){
	String path = "/";
	request.getRequestDispatcher(path).forward(request, response);
}
%>
<!DOCTYPE html>
<jsp:include page= '/JSP/Admin/Crew/Crew_Main.jsp' />