<%@page import="member.dto.MemberDTO"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
//out.print(id);
%>
<%
JDBCConnect jdbc = new JDBCConnect();

String sql = "select id, pass, name, regidate from member where id = ?";
jdbc.psmt = jdbc.con.prepareStatement(sql);
jdbc.psmt.setString(1, id);
jdbc.rs = jdbc.psmt.executeQuery();

MemberDTO member = null;
if (jdbc.rs.next()) {
	String pass = jdbc.rs.getString("pass");
	String name = jdbc.rs.getString("name");
	String regidate = jdbc.rs.getString("regidate");
	member = new MemberDTO(id, pass, name, regidate);
}

jdbc.close();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit.jsp</title>
</head>
<body>
<!-- Menu -->
<jsp:include page="/common/Menu2.jsp" />

<!-- Contents -->
<h1>Edit</h1>
<form name="writeFrm" method="post" action="EditProcess.jsp">
<input type="hidden" name="id" value="<%=member.getId() %>">
	<table border="1" width="80%">
		<tr><td>ID</td><td><%=member.getId() %></td></tr>
		<tr><td>PASS</td><td><input type="text" name="pass" value="<%=member.getPass() %>" style="width:90%"></td></tr>
		<tr><td>NAME</td><td><input type="text" name="name" value="<%=member.getName() %>" style="width:90%"></td></tr>
		<tr><td colspan="2"><input type="submit" value="작성완료"></td></tr>
	</table>
</form>
</body>
</html>