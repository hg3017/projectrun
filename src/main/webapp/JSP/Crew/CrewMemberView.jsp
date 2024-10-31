<%@page import="DTO.CrewMemberDTO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/CrewMember.css" rel="stylesheet" type="text/css">



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
<main id="container" class="cview" style=" padding:250px 0 400px;backgorund:#fff;border-radius:0;box-shadow:none;">
<div class="inner" style="max-width: 800px;margin: 0 auto;	">
	<section class="m_info" style="height: 150px;">
		<div class="inner">
		<div class="n_info">
			<table class="notice">
				<thead>
				<tr>
					<th  style="color:#fff;"> 사진 </th>
					<th  style="color:#fff;"> 이름 </th>
					<th  style="color:#fff;"> 소개 </th>
					 <c:if test = "${ crewSessionId eq 'Master'}" >
					 <th  style="color:#fff;" > 상태  </th>
					 <th colspan='1'  style="color:#fff;"> 처리 </th>
					 </c:if>
				</tr>
				</thead>
				<tbody>
				
				<c:forEach var="crewMember" items="${crewMemberLists }" >
					<tr style="height:70px;">
						<td> 사진 ${crewMember.member_image } </td>
		                <td> 이름 ${crewMember.member_id } </td>
		                <td> 소개 ${crewMember.description } </td>
		                
		                
		                <c:if test = "${ crewSessionId eq 'Master'}" >
		                <td> 상태 ${crewMember.status} </td>
					                 
	                 		<c:if test="${crewMember.status eq 'Waiting'}">
	                 			<td>
	 							<input type="button" value="승인" class="btn" onclick="sendAccept('${crewMember.member_id}','${crewMember.crew_name}');"> 
				                <input type="button" value="거부" class="btn" onclick="sendRefuse('${crewMember.member_id}', '${crewMember.crew_name}');">
				                </td>
							</c:if>
							
							<c:if test="${crewMember.status eq 'User'}">
								<td> <input type="button" value="추방" class="btn" onclick="senDelete('${crewMember.member_id}','${crewMember.crew_name}');">  </td>		
							</c:if>
						
						</c:if>
					</tr>
				</c:forEach>

             </tbody>
            </table>
            </div>
            </div>
            </section>
            </div>
</main>
