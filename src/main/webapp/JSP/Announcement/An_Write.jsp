<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="IsLoggedIn.jsp"%> <!--로그인 확인-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<script type="text/javascript">
function validateForm(form) {  
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
<jsp:include page= '../Common/Header.jsp' />

<h1>글쓰기 - Write</h1>
<form name="writeFrm" method="post" action="An_WriteProcess.an" onsubmit="return validateForm(this);">
	<table border="1" style="width:100%; border-collapse: collapse">
		<tr align="center">
			<td>제목</td>
			<td>
				<input type="text" name="title" style="width: 100%; height: 20px;" />
			</td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td>
				<textarea name="content" style="width: 100%; height: 100px;"></textarea>
			</td>
		</tr>
		<tr>
            <td colspan="2" align="right">
            <input type="hidden" name="id" value="${userId}">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="location.href='An_List.an';">
                    목록 보기</button>
            </td>
        </tr>
	</table>
</form>
<jsp:include page= '../Common/Footer.jsp' /> 
</body>
</html>