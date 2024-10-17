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
		<td align="center"><a href="/JSP/Admin_Sample/List.do">러닝크루 회원목록</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Write.do">러닝크루 회원추가</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Edit.do">러닝크루 회원수정</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/View.do">러닝크루 회원보기</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Test01.jsp">테스트 페이지</a></td>
	</tr>
</table>
<%-- 	request page context 확인 : <%=request.getContextPath() %> <br> --%>
</body>
</html>