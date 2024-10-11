<%-- <%@page import="DTO.AnnouncementDTO"%>
<%@page import="DAO.AnnouncementDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp"%> 

<%
String num = request.getParameter("num");  // 일련번호 받기
AnnouncementDAO dao = new AnnouncementDAO();
AnnouncementDTO dto = dao.selectView(num);

dao.close(); // DAO 자원 해제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE</title>
</head>
<body>
<form method="post" action="DeleteProcess.an">
    <input type="hidden" name="num" value="<%= dto.getNum() %>"/>
    <button type="submit">삭제</button>
    <button type="button" onclick="location.href='List.jsp';">목록 보기</button>
</form>
</body>
</html> --%>