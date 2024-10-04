<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm.jsp</title>
<script>
function validateForm(form){
	if(!form.user_id.value){
		alert("ID 필수");
		form.user_id.focus();
		return false;
	}
	if(!form.user_pw.value){
		alert("PW 필수");
		form.user_pw.focus();
		return false;
	}
}
</script>
</head>
<body>
<jsp:include page="/common/Menu2.jsp" /> 
<h1>로그인 페이지</h1>
<span style="color:red; font-size: 1.2em;">
	<%=request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
</span>
<%if(session.getAttribute("UserId") == null) {%>
<form action="LoginProcess.jsp" method="post" name="loginFrm" onsubmit="return validateForm(this)">
	ID : <input type="text" name="user_id"> <br>
	PW : <input type="password" name="user_pw"> <br>
	<input type="submit" value="로그인">
</form>
<%}else{ 
	if ("admin".equals(session.getAttribute("UserId"))) {

%>
	<%=session.getAttribute("UserId") %>
	관리자 로그인하셨습니다.
	<br>
<%
	} else {
%>
	<%=session.getAttribute("UserName") %> 회원님, 로그인하셨습니다. <br>
	<a href="Member.jsp">[Member]</a>
	<a href="Logout.jsp">[로그아웃]</a>
	<%
	}
}
%>
</body>
</html>