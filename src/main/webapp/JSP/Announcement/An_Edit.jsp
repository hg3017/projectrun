<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/Announcement/IsLoggedIn.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<script type="text/javascript">
function validateForm(form) {  // 폼 내용 검증 
    if (form.title.value == "") {
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
    }
    if (form.content.value == "") {
        alert("내용을 입력하세요.");
        form.content.focus();
        return false;
    }
}
</script>
</head>
<body>
<jsp:include page= '/JSP/Common/Header.jsp' />
<h2>Edit</h2>
<form name="writeFrm" method="post" action="An_EditProcess.an"
      onsubmit="return validateForm(this);">
    <input type="hidden" name="num" value="${board.num }" /> 
    <c:if test="${not empty board}">
    <table border="1" width="90%">
        <tr>
            <td align="center">제목</td>
            <td colspan="2">
                <input type="text" name="title" style="width: 90%;" 
                       value="${board.title }"/> 
            </td>
        </tr>
        <tr>
            <td align="center">내용</td>
            <td colspan="2">
                <textarea name="content" style="width: 90%; height: 100px;">${board.content }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="location.href='List.an';">
                    목록 보기</button>
            </td>
        </tr>
    </table>
    </c:if>
</form>
<c:if test="${empty board}">
    <p>게시물 데이터를 찾을 수 없습니다.</p> <!-- board 값이 null인 경우 경고 -->
</c:if>
<jsp:include page= '/JSP/Common/Footer.jsp' />
</body>
</html>