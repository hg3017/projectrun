<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>링크 테스트 페이지</title>
</head>
<body>
<h1>링크 테스트 페이지</h1>
<table border="1" width="80%">
	<tr>
		<td align="center"><a href="/JSP/Admin_Sample/List.do">러닝크루 회원목록</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Write.do">러닝크루 회원추가</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Edit.do">러닝크루 회원수정</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/View.do">러닝크루 회원보기</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Test01.jsp">테스트 페이지</a></td>
	</tr>
		<tr>
		<td align="center"><a href="/JSP/Admin_Sample/Controller_Test01.do">컨트롤러 테스트1</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Controller_Test02.do">컨트롤러 테스트2</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/Controller_Test03.do">컨트롤러 테스트3</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/not_exist.do">존재하지 않는 JSP 파일로 이동</a></td>
		<td align="center"><a href="/JSP/Admin_Sample/not_exist.do">존재하지 않는 JSP 파일로 이동</a></td>
	</tr>
</table>
	request page context 확인 : <%=request.getContextPath() %> <br>
</body>
</html>