
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CrewDTO"%>
<%@page import="DAO.CrewDAO"%>
<%@page import="DAO.CrewMemberDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resource/css/main.css?v=<?php echo time(); ?>">
<link href="/resources/css/CrewMain.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">

<title>Insert title here</title>
<script type="text/javascript">
	function crew_regist() {
		alert("asdasd");
	}
	
	function goLogin() {
		location.href="/JSP/Login/Login.jsp"
	}
</script>
</head>



<body>

<% 
	//id 세션을 가져옴.
    String sessionId = (String) session.getAttribute("UserId");  
    // 가져온 id세션을 통해 내가 이 크루에 어떤 역할인지 확인.
    
    
   	String crewSessionId = (String)request.getAttribute("crewSessionId");  
   	CrewDTO dto = (CrewDTO)request.getAttribute("CrewDetail"); 
   	
   	System.out.println(crewSessionId + " CrewMain.JSP crewSessionId 의 값 ");
   
%>

	<jsp:include page= '/JSP/Common/Header.jsp' />
	  <section class="main_info">
	  <div class="inner">
	  <div class="crew_name">
	  
			<img src="/resources/images/logo.png" alt="">
			<h2> 크루 이름 </h2>
			
			<% 
				if(crewSessionId.equals(null) || crewSessionId.equals("") ) {
				%>
					<%
						if(sessionId.equals(null) || sessionId.equals("")) {
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
					<p> 승인 대기중입니다.  </p>
				<% 
				} else if (crewSessionId.equals("Master")) { 
				%>
					<button type="button" onclick="crew_regist();">크루 해체 신청 </button>
				<% 
				}
			%>			
			<p> 크루 간단설명 </p>
			
          <h1> 크루 긴 설명 </h1>
          <p> 
            크루 긴 상세설명 
            설명중설명중설명중설명중설명중설명중설명중설명중설명중설명중 
            설명중설명중설명중설명중설명중설명중설명중설명중설명중설명중
            설명중설명중설명중설명중설명중설명중설명중설명중설명중설명중
            설명중설명중설명중설명중설명중설명중설명중설명중설명중설명중
            설명중설명중설명중설명중설명중설명중설명중설명중설명중설명중
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
            	<a href="/JSP/Crew/CrewMemberView.jsp?name=<%= dto.getName() %>">  더 보기 </a>
            	
            </div>
            <ul class="notice">
              <li>
                <a href="#">
                  <div class="list_detail">
                    <p> 사진 </p>
                    <p> 이름 </p>
                    <p> 소개 </p>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="list_detail">
                    <p> 사진 </p>
                    <p> 이름 </p>
                    <p> 소개 </p>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="list_detail">
                    <p> 사진 </p>
                    <p> 이름 </p>
                    <p> 소개 </p>
                  </div>
                </a>
              </li>
            </ul> <!-- 회원 목록 -->
			
      </div>    
      </div>
    </section>
        
		
		</div>  <!-- inner 마지막  -->
</body>

<jsp:include page= '/JSP/Common/Footer.jsp' />
</html>