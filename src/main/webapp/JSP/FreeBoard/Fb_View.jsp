<%@page import="DTO.FreeBoardDTO"%>
<%@page import="DAO.FreeBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/FreeBoard/IsLoggedIn.jsp"%>
<%
String num = request.getParameter("num");  // 일련번호 받기 

FreeBoardDAO dao = new FreeBoardDAO();  // DAO 생성 
dao.updateVisitCount(num);                 // 조회수 증가 
FreeBoardDTO dto = dao.selectView(num);        // 게시물 가져오기 
dao.close();                               // DB 연결 해제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "DeleteProcess.free";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}
</script>
</head>
<body>
<jsp:include page= '/JSP/Common/Header.jsp' />
<h2>View</h2>
<form name="writeFrm">
    <input type="hidden" name="num" value="<%= num %>" />  <!-- 공통 링크 -->

    <table border="1" width="90%" style="border-collapse: collapse">
        <tr>
            <td align="center">작성자</td>
            <td><%= dto.getName() %></td>
            <td align="center">작성일</td>
            <td><%= dto.getPostdate() %></td>
        </tr>
        <tr>
            <td align="center">제목</td>
            <td colspan="3"><%= dto.getTitle() %></td>
        </tr>
        <tr>
            <td align="center">내용</td>
            <td colspan="3" height="100px">
                 <%= dto.getContent() != null ? dto.getContent().replace("\r\n", "<br/>") : "내용없음"%></td>
                 <%-- <%= dto.getContent()%></td> --%>
        </tr>
        <tr>
            <td colspan="4" align="right">
            <%
            if (session.getAttribute("UserId") != null
                && session.getAttribute("UserId").toString().equals(dto.getId())) {
            %>
                <button type="button"
                        onclick="location.href='/JSP/FreeBoard/Fb_Edit.jsp?num=<%= dto.getNum() %>';">
                    수정하기</button>
                <button type="button" onclick="deletePost();">삭제하기</button> 
            <%
            }
            %>
                <button type="button" onclick="location.href='/JSP/FreeBoard/Fb_List.jsp';">
                    목록 보기
                </button>
            </td>
        </tr>
    </table>
</form>
<jsp:include page= '/JSP/Common/Footer.jsp' />
</body>
</html>
