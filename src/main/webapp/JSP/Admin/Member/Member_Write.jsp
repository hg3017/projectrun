<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Write.jsp</title>
</head>
<body>
<%@page import="DTO.MemberDTO"%>
<!-- Menu  -->
<jsp:include page= '/JSP/Admin/Member/Member_Menu.jsp' />
<!-- Contents -->
<h1>Write</h1>
<form name="writeFrm" method="post" action="WriteProcess.do">
    <table border="1" width="80%">
        <tr>
            <td>ID</td>
            <td>
                <input type="text" name="id" style="width: 90%;" />
            </td>
        </tr>
        <tr>
            <td>PASS</td>
            <td>
                <input type="text" name="pass" style="width: 90%;" />
            </td>
        </tr>
        <tr>
            <td>NAME</td>
            <td>
                <input type="text" name="name" style="width: 90%;" />
            </td>
        </tr>        
        <tr>
            <td>GRADE</td>
            <td>
                <input type="text" name="grade" style="width: 90%;" />
            </td>
        </tr>        
        <tr>
            <td>NICKNAME</td>
            <td>
                <input type="text" name="nickname" style="width: 90%;" />
            </td>
        </tr>        
        <tr>
            <td>PHONE_NUMBER</td>
            <td>
                <input type="text" name="phone_number" style="width: 90%;" />
            </td>
        </tr>        
        <tr>
            <td>LOCATION</td>
            <td>
                <input type="text" name="location" style="width: 90%;" />
            </td>
        </tr>        
        <tr>
            <td colspan="2" align="center">
                <button type="submit">작성 완료</button>
                <button type="reset">다시 입력</button>
                <button type="button" onclick="location.href='/JSP/Admin/Member/Member_list.jsp';">
                    목록 보기</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>