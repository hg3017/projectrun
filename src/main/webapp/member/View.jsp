<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

MemberDTO member = null;
MemberDAO dao = new MemberDAO(application);
member = dao.selectView(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View.jsp</title>
</head>
<body>
	<!-- Menu -->
	<jsp:include page="/common/Menu2.jsp" />

	<!-- Contents -->
	<h1>View</h1>
 	<table border="1" width="80%">
		<tr>
			<td>ID</td>
			<td><%=member.getId() %></td>
		</tr>
		<tr>
			<td>PASS</td>
			<td><%=member.getPass() %></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><%=member.getName() %></td>
		</tr>
		<tr>
			<td>LOCATION</td>
			<td><%=member.getLocation()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="Edit.jsp?id=<%=member.getId()%>">[회원정보수정]</a>
				<a href="DeleteProcess.jsp?id=<%=member.getId()%>">[회원정보삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>