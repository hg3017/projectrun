
<%@page import="java.util.List"%>
<%@page import="DTO.CrewMemberDTO"%>
<%@page import="DTO.CommentDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CrewDTO"%>
<%@page import="DAO.CrewDAO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<% 
	//id 세션을 가져옴.
    String sessionId = (String) session.getAttribute("UserId");  
    // 가져온 id세션을 통해 내가 이 크루에 어떤 역할인지 확인.
    
   	String crewSessionId = (String)request.getAttribute("crewSessionId");  
   	CrewDTO dto = (CrewDTO)request.getAttribute("CrewDetail"); 
   	List<CrewMemberDTO> crewMainMemberLists =  (List<CrewMemberDTO>)request.getAttribute("crewMainMemberLists"); 
   	
	/* 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 */
   	/* List<CommentDTO> commentLists = (List<CommentDTO>)request.getAttribute("CommentLists");
   	System.out.println("CrewMain-commentList");
	System.out.println(commentLists); */
	
	/* for( CommentDTO aaa : commentLists ) {
		out.println(aaa + "<br>"); 
	} */
	
   	/* 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 */
   	
%>

<script type="text/javascript">
	function goLogin() {
		location.href="/JSP/Login/Login.jsp"
	}
</script>

<main id="container">

	  <section class="main_info">
	  <div class="inner">
		  <div class="crew_name">
		  		<div id="main_tit">
				
					<h2> <%=dto.getName() %> </h2>
					<!-- <img src="/resources/images/logo.png" alt=""> -->
					<a> 크루 썸네일  </a>
				</div>
				<% 
					if(crewSessionId == null || crewSessionId.equals("") ) {
					%>
						<%
							if( crewSessionId == null || crewSessionId.equals("")) {
						%>
							<button type="button" onclick="goLogin();">크루가입신청</button>
						<% 	
							} else {
						%>
							<button type="button" onclick="crew_regist();">크루가입신청</button>
						<%
							}
						%>
					<% 
					} else if (crewSessionId.equals("User")) {
					%>
						<button type="button" onclick="crew_regist();">크루탈퇴신청</button>
					<% 
					} else if (crewSessionId.equals("Refuse") ) { 
					%>
						<p> 가입이 거절되었습니다. </p>
					<% 
					} else if (crewSessionId.equals("Wating") ) { 
					%>
						<p> 승인 대기중입니다. </p>
					<% 
					} else if (crewSessionId.equals("Master")) { 
					%>
						<button type="button" onclick="crew_regist();">크루 해체 신청 </button>
					<% 
					}
				%>			
				
	          <h2> 크루 소개 </h2>
	          <p> 
	            <%=dto.getDescripton() %>
	          </p> 
	        </div>
		  
		  	<div class="section_left">
		  	
		  	  <div class="board_more"> 
		            <h2 class="main_tit">
		              크루 활동
		            </h2>
	            	<button >더 보기</button>
	            </div>
		  		
			  <div class="crew_picture">
	
		          <a href="#" class="picture_list">
					<img src="" alt="" class="on" title="">
		          </a>
		
		          <a href="#" class="picture_list">
					<img src="" alt="" class="on" title="">
		          </a>
		
		          <a href="#" class="picture_list">
					<img src="" alt="" class="on" title="">
		          </a>
		
		          <a href="#" class="picture_list">
					<img src="" alt="" class="on" title="">
		          </a>
	      </div>	
		</div> <!-- Section left 마지막  -->
	        <div class="section_right">
	            
	            <div class="board_more"> 
		            <h2 class="main_tit">
		              회원 목록
		            </h2>
	            	<!-- <button  >더 보기</button> -->
	            	<a href="/CrewMemberList.crewMember?crewName=<%= dto.getName() %>">  더 보기 </a>
	            	
	            </div>
	            
	            <table class="notice">
				    <thead>
				        <tr>
				            <th> 사진 </th>
				            <th> 이름 </th>
				            <th> 소개 </th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach var="crewMainMember" items="${crewMainMemberLists}">
				            <tr>
				                <td>사진: ${crewMainMember.member_image}</td>
				                <td>이름: ${crewMainMember.member_id}</td>	
				                <td>소개: ${crewMainMember.description}</td>
				            </tr>
				        </c:forEach>  
				        
				    </tbody>
				</table>
	      </div> 
	         
      </div>
      
        
      			
      		
    </section>
    <!-- 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 --> 
    <%-- <jsp:include page="/JSP/Crew/Comment.jsp" /> --%>
	<!-- 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 --> 
</main>
