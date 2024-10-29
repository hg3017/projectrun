<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/Login.css" rel="stylesheet" type="text/css">


<main id="main_info">
	<section class="main_report" >
	<div id="inner">
		<h2 class="login-title">로그인</h2>
		
		<!-- 로그인 오류 메시지를 출력합니다. 오류가 없는 경우 빈 문자열을 출력합니다. -->
		<span style="color:red; font-size: 1.2em;">
			<%=request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
		</span>
	
		<!-- 입력한 값을 LoginProcess.lo 에  , post 방식을 통해 전달합니다.  -->
		<form action="LoginProcess.lo" method = "post" name = "LoginFrm" onsubmit="return validateForm(this)">
			<label for="user_id">ID</label>  <input type="text" name="user_id" id="user_id" class="input-field"> 
			<label for="user_pw">Pw</label>  <input type="password" name="user_pw" id="user_pw" class="input-field">
			
			<input type="submit" value="로그인" class="submit-btn">
		</form>
		
		<div class="links">
		<!-- 	<a href='/JSP/Register/Register.jsp' > 회원가입 </a> -->
			<a href="/JSP/Register/Register.regi"> 회원가입 </a> 
			<a href="/JSP/Register/Register.jsp"> 회원가입JSP </a> 
			<a href="/JSP/Admin/Member/Member_List.adme">회원 목록</a>
		</div>
	</div>	
	</section>
</main>
		