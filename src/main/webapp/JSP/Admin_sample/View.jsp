<%@page import="DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//결과 확인 및 저장(웹 페이지에 출력)
MemberDTO member = (MemberDTO)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View.jsp</title>
</head>
<body>
<!-- Menu -->
<jsp:include page= './Menu.jsp' />
<!-- Contents -->
<h1>View</h1>
<% out.println("member 객체 : "+ member); %>
<form name="writeFrm" method="post" action="WriteProcess.do">
	<table border="1" width="80%">
		<tr>
			<td width="10%">ID</td>
			<td align="center">
				<%=member.getId() %>
			</td>
		</tr>
		<tr>
			<td width="10%">PASS</td>
			<td align="center">
				<%=member.getPass() %>
			</td>
		</tr>
		<tr>
			<td width="10%">NAME</td>
			<td align="center">
				<%=member.getName() %>
			</td>
		</tr>
		<tr>
			<td width="10%">GRADE</td>
			<td align="center">
				<%=member.getGrade() %>
			</td>
		</tr>
		<tr>
			<td width="10%">NICKNAME</td>
			<td align="center">
				<%=member.getNickname() %>
			</td>
		</tr>
		<tr>
			<td width="10%">LOCATION</td>
			<td align="center">
				<%=member.getLocation() %>
			</td>
		</tr>
		<tr>
			<td width="10%">PHONE_NUMBER</td>
			<td align="center">
				<%=member.getPhone_number() %>
			</td>
		</tr>
		<tr>
			<td width="10%">REGIDATE</td>
			<td align="center">
				<%=member.getRegidate() %>
			</td>
		</tr>
		<tr>
			<td width="10%">EDITDATE</td>
			<td align="center">
				<%=member.getEditdate() %>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="/JSP/Admin_Sample/List.do">[List]</a>
				<a href="/JSP/Admin_Sample/Edit.do?id=<%=member.getId()%>">[Edit]</a>
				<a href="/JSP/Admin_Sample/DeleteProcess.do?id=<%=member.getId()%>">[Delete]</a>
			</td>
		</tr>
	</table>
	<%=member.getId()%>
</form>

</body>
</html>