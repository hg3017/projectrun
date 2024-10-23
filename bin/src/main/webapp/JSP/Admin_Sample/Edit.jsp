<%@page import="DTO .MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 결과 확인 및 저장(웹 페이지에 출력)
MemberDTO member = (MemberDTO)request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit.jsp</title>

</head>
<body>
<!-- Menu -->
<jsp:include page= './Menu.jsp' />
<%-- <jsp:include page= '../Common/Header.jsp' /> --%>
<!-- Contents -->
<h1>Edit</h1>
<form name="editFrm" method="post" action="EditProcess.do">
<input type="hidden" name="id" value="<%=member.getId() %>">
<!-- id값 숨겨서 전달 -->
	<table border="1" width="80%">
		<tr>
			<td>ID</td>
			<td>
				<%=member.getId() %>
			</td>
		</tr>
		<tr>
			<td>PASS</td>
			<td>
				<input type="text" name="pass" style="width: 90%;" value="<%=member.getPass() %>" />
			</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>
				<input type="text" name="name" style="width: 90%;" value="<%=member.getName() %>" />
			</td>
		</tr>
		<tr>
			<td>GRADE</td>
			<td>
				<%=member.getGrade() %>
			</td>
		</tr>
		<tr>
			<td>NICKNAME</td>
			<td>
				<input type="text" name="nickname" style="width: 90%;" value="<%=member.getNickname() %>" />
			</td>
		</tr>
		<tr>
			<td>LOCATION</td>
			<td>
				<input type="text" name="location" style="width: 90%;" value="<%=member.getLocation() %>" />
			</td>
		</tr>
		<tr>
			<td>PHONE_NUMBER</td>
			<td>
				<input type="text" name="phone_number" style="width: 90%;" value="<%=member.getPhone_number() %>" />
			</td>
		</tr>
		<tr>
			<td>REGIDATE</td>
			<td>
				<%=member.getRegidate() %>
			</td>
		</tr>
		<tr>
			<td>EDITDATE</td>
			<td>
				<%=member.getEditdate() %>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit">작성 완료</button>
				<button type="reset">다시 입력</button>
				<button type="button" onclick="location.href='/JSP/Admin_Sample/List.jsp';">목록 보기</button>
				<button type="button" onclick="location.href='/JSP/FreeBoard/Fb_List.jsp';">자유게시판 보기</button>
	</table>
	
</form>

</body>
</html>