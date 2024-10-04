<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("UserId") == null){
	response.sendRedirect("LoginForm.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member.jsp</title>
</head>
<body>
회원만 들어올 수 있는 페이지 입니다.
</body>
</html>