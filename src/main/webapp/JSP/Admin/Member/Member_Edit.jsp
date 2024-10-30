<%@page import="DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//결과 확인 및 저장(웹 페이지에 출력)
MemberDTO member = (MemberDTO)request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit.jsp</title>
</head>
<body>
<!-- Menu -->
<%-- <jsp:include page="../common/Menu.jsp" /> --%>
<!-- Contents -->
<h1>Edit</h1>
<form name="editFrm" method="post" action="Member_EditProcess.adme">
<input type="hidden" name="id" value="<%=member.getId() %>">
	<table border="1" width="80%">
		<tr>
			<td>IDX</td>
			<td>
				<%=member.getIdx() %>
			</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>
				<%=member.getId() %>
			</td>
		</tr>
		<tr>
			<td>PASS</td>
			<td>
				<input type="text" name="pass" style="width: 90%;" value="<%=member.getPass() %>" />
			</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>
				<input type="text" name="name" style="width: 90%;" value="<%=member.getName() %>" />
			</td>
		</tr>
		<tr>
			<td>GRADE</td>
			<td>
				<input type="text" name="grade" style="width: 90%;" value="<%=member.getGrade() %>" />
			</td>
		</tr>
		<tr>
			<td>NICKNAME</td>
			<td>
				<input type="text" name="nickname" style="width: 90%;" value="<%=member.getNickname() %>" />
			</td>
		</tr>
		<tr>
			<td>LOCATION</td>
			<td>
				<input type="text" name="location" style="width: 90%;" value="<%=member.getLocation() %>" />
			</td>
		</tr>
		<tr>
			<td>PHONE_NUMBER</td>
			<td>
				<input type="text" name="phone_number" style="width: 90%;" value="<%=member.getPhone_number() %>" />
			</td>
		</tr>
		<tr>
			<td>DESCRIPTION</td>
			<td>
				<input type="text" name="description" style="width: 90%;" value="<%=member.getDescription() %>" />
			</td>
		</tr>
		<tr>
			<td>REGIDATE</td>
			<td>
				<%=member.getRegidate() %>
			</td>
		</tr>
		<tr>
			<td>EDITDATE</td>
			<td>
				<%=member.getEditdate() %>
			</td>
		</tr>
		<tr>
			<td>MEMBER_IMAGE_IDX</td>
			<td>
				<input type="text" name="member_image_idx" style="width: 90%;" value="<%=member.getMember_image_idx() %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">작성 완료</button>
				<button type="reset">다시 입력</button>
				<button type="button" onclick="location.href='/Member_List.adme';">목록 보기</button>
			</td>
		</tr>
	</table>
	
</form>

</body>
</html>