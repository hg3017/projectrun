<%@page import="member.dao.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// db conn	
MemberDAO dao = new MemberDAO(application);
List<MemberDTO> members = dao.selectList();
dao.close();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List.jsp</title>
</head>
<body>
<!-- Menu -->
<jsp:include page="/common/Menu2.jsp" />

<!-- Contents -->
<h1>회원목록</h1>
<table border="1" width="80%">
	<tr>
		<th width="25%">ID</th>
		<th width="25%">PASS</th>
		<th width="25%">NAME</th>
		<th width="25%">LOCATION</th>
	</tr>
<%for(MemberDTO member : members) {%>	
	<tr>
		<td><a href="View.jsp?id=<%=member.getId()%>"><%=member.getId() %></a></td>
		<td><%=member.getPass() %></td>
		<td><%=member.getName() %></td>
		<td><%=member.getLocation() %></td>
	</tr>
<%} %>	
	<tr><td colspan="4"><a href="Write.jsp">회원가입</a></td></tr>
</table>
</body>
</html>