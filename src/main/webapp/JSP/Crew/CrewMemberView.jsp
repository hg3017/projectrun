<%@page import="DTO.CrewMemberDTO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
   	String crewSessionId = (String)request.getAttribute("crewSessionId");  
   	List<CrewMemberDTO> crewMemberLists = (List<CrewMemberDTO>)request.getAttribute("crewMemberLists"); 	
%>
        
<script>
function sendAccept(memberId, crewName) {
    // 페이지 이동을 통해 서버에 데이터를 전달 (GET 요청)
    window.location.href = "/accept.crewMember?name=" + memberId + "&crew_name=" + crewName;
}

function sendRefuse(memberId, crewName) {
    // 페이지 이동을 통해 서버에 데이터를 전달 (GET 요청)
    window.location.href = "/refuse.crewMember?name=" + memberId + "&crew_name=" + crewName;
}

function sendDelete(memberId, crewName) {
    // 페이지 이동을 통해 서버에 데이터를 전달 (GET 요청)
    window.location.href = "/delete.crewMember?name=" + memberId + "&crew_name=" + crewName;
}

</script>
<main id="container">
	<section class="main_info">
			<table class="notice">
				<thead>
				<tr>
					<th><input type="checkbox" name="" id="chkRowAll" > </th>
					<th> 사진 </th>
					<th> 이름 </th>
					<th> 소개 </th>
				</tr>
				</thead>
				<tbody>
				
				<c:forEach var="crewMember" items="${crewMemberLists }" >
					<tr>
						<td> 사진 ${crewMember.member_image } </td>
		                <td> 이름 ${crewMember.member_id } </td>
		                <td> 소개 ${crewMember.description } </td>
		                <td> 상태 ${crewMember.status} </td>
					                 
                 		<c:if test="${crewMember.status eq 'Waiting' && crewSessionId eq 'Master'}">
 							<td> <input type="button" value="승인" class="btn" onclick="sendAccept('${crewMember.member_id}','${crewMember.crew_name}');">  </td>
			                <td> <input type="button" value="거부" class="btn" onclick="sendRefuse('${crewMember.member_id}', '${crewMember.crew_name}');"> </td>
						</c:if>
						
						<c:if test="${crewMember.status eq 'User' && crewSessionId eq 'Master'}">
							<td> <input type="button" value="추방" class="btn" onclick="senDelete('${crewMember.member_id}','${crewMember.crew_name}');">  </td>		
						</c:if>
					</tr>
				</c:forEach>

             </tbody>
            </table>
            </section>
</main>
