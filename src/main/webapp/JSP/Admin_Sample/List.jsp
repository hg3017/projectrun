<%@page import="DTO.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 결과 확인(웹 페이지에 출력)
List<MemberDTO> members = (List<MemberDTO>)request.getAttribute("members");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>List.jsp</title>
<script>
	function delete_confirm(member_id) {
		const rs = confirm("삭제하시겠습니까?");
		console.log(rs);
		if(rs){
			location.href="DeleteProcess.do?id="+member_id;
		}else{
			alert('삭제가 취소 되었습니다.');
		}
	}
</script>
</head>
<body>
<!-- Menu  -->
<jsp:include page= './Menu.jsp' />
<!-- Contents -->
<h1>List </h1>
<table border="1" width="80%">
	<tr>
		<th width="11%">ID</th>
		<th width="11%">PASS</th>
		<th width="11%">NAME</th>
		<th width="11%">GRADE</th>
		<th width="11%">NICKNAME</th>
		<th width="11%">LOCATION</th>
		<th width="12%">PHONE_NUMBER</th>
		<th width="11%">REGIDATE</th>
		<th width="11%">EDITDATE</th>
	</tr>
<%for(MemberDTO member: members) {%>	
	<tr align="center">
		<td><a href="/JSP/Admin_Sample/View.do?id=<%=member.getId()%>"><%=member.getId() %></a></td>
		<td><%=member.getPass() %></td>
		<td><%=member.getName() %></td>
		<td><%=member.getGrade() %></td>
		<td><%=member.getNickname() %></td>
		<td><%=member.getLocation() %></td>
		<td><%=member.getPhone_number() %></td>
		<td><%=member.getRegidate() %></td>				 	
		<td><%=member.getEditdate() %></td>				 	
<%} %>
	<tr><td colspan="4"><a href="Write.jsp">[회원 가입]</a></td></tr>
</table>

</body>
</html>