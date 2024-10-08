<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    
</head>
<body>
	<h1> 로그인 페이지 </h1>
	
	<!-- 로그인 오류 메시지를 출력합니다. 오류가 없는 경우 빈 문자열을 출력합니다. -->
	<span style="color:red; font-size: 1.2em;">
		<%=request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
	</span>

	<!-- 입력한 값을 LoginProcess.lo 에  , post 방식을 통해 전달합니다.  -->
	<form action="LoginProcess.lo" method = "post" name = "LoginFrm" onsubmit="return validateForm(this)">
		ID : <input type = "text" name="user_id"> <br>
		Pw : <input type = "text" name="user_pw"> <br>
		<input type="submit" value="로그인">	
	</form>
	
	<a href='../Register/Register.jsp' > 회원가입 </a>   
	                  		
</body>
</html>