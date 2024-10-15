<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 매뉴</title>
</head>
<body>
<h1>관리자 매뉴</h1>
<table border="1" width="80%">
	<tr>
		<td align="center"><a href="<%=request.getContextPath() %>/JSP/Admin/Member/List.adme">러닝크루 회원목록</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/JSP/Admin/Member/List.adme">러닝크루 회원목록</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/JSP/Admin/Member/List.adme">러닝크루 회원목록</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/JSP/Admin/Member/test01.adme">컨트롤러 테스트 페이지</a></td>
	</tr>
</table>
	request page context 확인 : <%=request.getContextPath() %> <br>
</body>
</html>