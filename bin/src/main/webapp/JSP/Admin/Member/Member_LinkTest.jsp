<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member_LinkTest</title>
</head>
<body>
<h1>관리자 멤버 링크 테스트 페이지</h1>
<h2>현재 controller를 이용해서 제어되고 있다.</h2>
<table border="1" width="80%">
	<tr>
		<td align="center" width="16%"><a href="/JSP/Admin/Member/Member_Index.adme">멤버 시작페이지</a>
		<td align="center" width="16%"><a href="/JSP/Admin/Member/Member_List.adme">멤버 목록</a>
		<td align="center" width="16%"><a href="/JSP/Admin/Member/Member_View.adme">멤버 정보</a>
		<td align="center" width="16%"><a href="/JSP/Admin/Member/Member_Write.adme">멤버 추가</a>
		<td align="center" width="16%"><a href="/JSP/Admin/Member/Member_Edit.adme">멤버 수정</a>
	</tr>
	<tr>
		<td align="center"><a href="/JSP/Admin/Member/Member_Test01.jsp">컨트롤러 작동 테스트 페이지</a>
		<td align="center"><a href="/JSP/Admin/Member/Member_Test02.jsp">JSP 파일 바로 접속</a>
	</tr>
</table>
	<p>
	멤버 정보는 오류나는게 정상이다.
	특정 멤버의 정보를 보는 건데
	특정 멤버가 누군지 알려주는 값이 Member_View.jsp 페이지에 전달되지 않았기 때문이다.
	</p>
	<p>
	멤버 수정은 오류나는게 정상이다.
	이유는 멤버 정보가 오류나는 이유와 같다.
	</p>
</body>
</html>