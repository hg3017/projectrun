<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write.jsp</title>
</head>
<body>
<!-- Menu -->
<jsp:include page="/common/Menu2.jsp" />

<!-- Contents -->
<h1>Write</h1>
<form name="writeFrm" method="post" action="WriteProcess.jsp">
	<table border="1" width="80%">
		<tr><td>ID</td><td><input type="text" name="id" style="width:90%"></td></tr>
		<tr><td>PASS</td><td><input type="text" name="pass" style="width:90%"></td></tr>
		<tr><td>NAME</td><td><input type="text" name="name" style="width:90%"></td></tr>
		<tr><td colspan="2"><input type="submit" value="작성완료"></td></tr>
	</table>
</form>
</body>
</html>