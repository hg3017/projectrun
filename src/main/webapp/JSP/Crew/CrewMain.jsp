
<%@page import="java.util.List"%>
<%@page import="DTO.CrewMemberDTO"%>
<%@page import="DTO.CommentDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CrewDTO"%>
<%@page import="DAO.CrewDAO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/CrewMain.css" rel="stylesheet" type="text/css">

<% 
	//id 세션을 가져옴.
    String sessionId = (String) session.getAttribute("UserId");  
    // 가져온 id세션을 통해 내가 이 크루에 어떤 역할인지 확인.
        
   	String crewSessionId = (String)request.getAttribute("crewSessionId");  
   	CrewDTO dto = (CrewDTO)request.getAttribute("CrewDetail"); 
   	List<CrewMemberDTO> crewMainMemberLists =  (List<CrewMemberDTO>)request.getAttribute("crewMainMemberLists"); 
   	
   	System.out.println("crewSessionId : " + crewSessionId );
   	
	/* 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 */
   	/* List<CommentDTO> commentLists = (List<CommentDTO>)request.getAttribute("CommentLists");
   	System.out.println("CrewMain-commentList");
	System.out.println(commentLists); */
	
	/* for( CommentDTO aaa : commentLists ) {
		out.println(aaa + "<br>"); 
	} */
	
   	/* 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 */
   	int count = 0;

%>

<script type="text/javascript">
	function goLogin() {
		location.href="/JSP/Login/Login.jsp"
	}
</script>

<main id="container" class="crew_page">

	  <section class="main_info">
	  <div class="inner">
		  <div class="crew_name">
		 	<div class="crew_login">
				<% 
					if( session.getAttribute("UserId") != null) {
					%>
						<%
							if( crewSessionId == null || crewSessionId.equals("")) {
						%>
							<button onclick="location.href='/insert.crewMember?crewName=<%= dto.getName() %>'">크루<br>가입 신청</button>
						<% 	
							} else if (crewSessionId.equals("User")) {
								%>
								<button onclick="location.href='/delete.crewMember?<%=dto.getName() %>'">크루탈퇴</button>
							<% 
							} else if (crewSessionId.equals("Refuse") ) {
							%>
								<p> 가입이 거절되었습니다. </p>
							<% 
							} else if (crewSessionId.equals("Waiting") ) {
							%>
								<p> 승인 대기중입니다. </p>
							<% 
							} else if (crewSessionId.equals("Master")) {
							%>
								<!--<button type="button" onclick="crew_regist();">크루<br>해체 신청 </button>-->
							<% 
							} 
					}  else  {
						%>
						<button onclick="location.href='/LoginPage.lo'">로그인</button>
					<%
						}
				%>
				</div>			
				 <h2 class="crew_tit" style="margin-top: 30px;"> 크루 소개 </h2>
				<div class="main_tit">
					<h2 class="crew_h2"> <%=dto.getName() %> </h2>
					<!-- <img src="/resources/images/logo.png" alt=""> -->
				</div>
				<a class="crew_img"> 크루 썸네일  </a>
	          <p class="crew_cont"> 
	            <%=dto.getDescripton() %>
	          </p> 
	        </div>
	        
	        <div class="exter"> 
		  
		  	<div class="section_left">
		  	
		  	  <div class="board_more"> 
		            <h2 class="main_tit">
		              크루 활동
		            </h2>
		            
	            	<button onclick="location.href='href=/Cb_List.cb?crewName=<%= dto.getName() %>'">더 보기</button>
	            </div>
		  		
			  <div class="crew_picture">
	
	 			<table>
			           <thead>
				        <tr class="crew_head">
				            <th> 제목 </th>
				            <th> 작성자 </th>
				            <th> 크루명 </th>
				            <th> 작성일 </th>
				        </tr>
				      </thead>
				
                
				<c:forEach var="board" items="${boards }" varStatus="status">
						<c:if test="${board.crew_name eq CrewDetail.name }"> 
						<% 
			                count++; // count 증가
			                if (count > 3) { // count가 3 이상이면 반복 종료
			                    break;
			                }
			            %>
						
						   	<tr class="crew_bo" align="center" onclick="location.href='Cb_View.cb?idx=${board.idx}'" style="cursor: pointer;">
		                		<td>${board.title }</td> <!-- 제목 --></td>
		                		<td>${board.member_id }</td>
		                		<td>${board.crew_name }</td>
		                		<td>${board.regidate }</td>
	                		</tr>
	                		
                		</c:if>
				</c:forEach>
	
	
		        </table>
	      	</div>	
		</div> <!-- Section left 마지막  -->
	        <div class="section_right">
	            
	            <div class="board_more"> 
		            <h2 class="main_tit">
		              회원 목록
		            </h2>
	            	<button  onclick="location.href='/CrewMemberList.crewMember?crewName=<%= dto.getName() %>'"  >더 보기</button>
	            	
	            	<%-- <a href="/CrewMemberList.crewMember?crewName=<%= dto.getName() %>">  더 보기 </a> --%>
	            	
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
      </div>
      
        
      			
      		
    </section>
</main>
    <!-- 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 --> 
    <%-- <jsp:include page="/JSP/Crew/Comment.jsp" /> --%>
	<!-- 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트 --> 

