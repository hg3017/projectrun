<%@page import="DTO.CrewMemberDTO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

</script>


<body>

<%
	String name = request.getParameter("name");  

	CrewMemberDAO crewMemberDao = new CrewMemberDAO();
	
	List<CrewMemberDTO> crewMemberLists = crewMemberDao.selectCrewMemberList(name);
		
	//id 세션을 가져옴.
	String sessionId = (String) session.getAttribute("userId");  
    // 가져온 id세션을 통해 내가 이 크루에 어떤 역할인지 확인.
   	String crewSessionId = crewMemberDao.selectCrewMemberStatus(name, sessionId );
    
    
%>
        
<script>
function sendAccept(memberId) {
    // 페이지 이동을 통해 서버에 데이터를 전달 (GET 요청)
    window.location.href = "/accept.crewMember?name=" + memberId + "&crew_name=<%= name %>";
}

function sendRefuse(memberId) {
    // 페이지 이동을 통해 서버에 데이터를 전달 (GET 요청)
    window.location.href = "/refuse.crewMember?name=" + memberId + "&crew_name=<%= name %>";
}
</script>

<jsp:include page= '../Common/Header.jsp' />
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
				<%
					for (CrewMemberDTO dto : crewMemberLists) {
				%>
				
              <tr>
              
              <%
              	if(dto.getStatus().equals("Waiting")) {
				
					%>
					<td><input type="checkbox" name="chkRow" id=""></td>
			  <%
				} else {
			   %>
					<td> </td>
			  <%
				}
              %>
              	<% 
              		/* if (!dto.getStatus().equals("Waiting") && !crewSessionId.equals("Master")) { */
                %>
                
              	<td> 사진 <%= dto.getMember_image() %> </td>
                <td> <%= dto.getMember_id() %> </td>
                <td> 소개 <%= dto.getDescription() %> </td>
                <td> 상태 <%= dto.getStatus() %> </td>
                <% 
                	if( dto.getStatus().equals("Waiting") && crewSessionId.equals("Master") ) { 
                %>
                <td> <input type="button" value="승인" class="btn" onclick="sendAccept('<%= dto.getMember_id() %>');">  </td>
                <td> <input type="button" value="거부" class="btn" onclick="sendRefuse('<%= dto.getMember_id() %>');"> </td>
                
                <%
                	}
                
                /* } */
                 %>
              </tr>
              
             <%
				}
             %>
             </tbody>
            </table>
            
            
            

</body>

<jsp:include page= '../Common/Footer.jsp' />

</html>