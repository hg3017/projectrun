<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Register.jsp</title>
</head>
<body>

<h1>Write</h1>

<!-- 입력한 값을 RegisterProcess.regi 에  , post 방식을 통해 전달합니다.  -->
<form action="RegisterProcess.regi" method = "post" name = "RegisterFrm" onsubmit="return validateForm(this)">
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
                <button type="button" onclick="location.href='List.jsp';">
                    목록 보기</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>