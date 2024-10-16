<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/FreeBoard/IsLoggedIn.jsp"%> <!--로그인 확인-->
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
<jsp:include page= '/JSP/Common/Header.jsp' />

<h1>글쓰기 - Write</h1>
<form name="writeFrm" method="post" action="WriteProcess.free" onsubmit="return validateForm(this);">
	<table border="1" width="50%" style="border-collapse: collapse">
		<tr align="center">
			<td>제목</td>
			<td>
				<input type="text" name="title" style="width: 99%; height: 20px;" />
			</td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td>
				<textarea name="content" style="width: 99%; height: 200px;"></textarea>
			</td>
		</tr>
        <tr>
            <td colspan="2" align="right">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="location.href='/JSP/FreeBoard/Fb_List.jsp';">
                    목록 보기</button>
            </td>
        </tr>
	</table>
</form>
<jsp:include page= '/JSP/Common/Footer.jsp' /> 
</body>
</html>