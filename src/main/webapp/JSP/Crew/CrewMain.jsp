
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CrewDTO"%>
<%@page import="DAO.CrewDAO"%>
<%@page import="DAO.CrewMemberDAO"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/main.css?v=<?php echo time(); ?>">
<link href="../../resources/css/CrewMain.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">

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
	String name = request.getParameter("name");  

	CrewDAO crewDao = new CrewDAO();  // Crew DAO 생성 
	CrewDTO crewDto = crewDao.selectCrew(name); // 크루 게시판 정보 불러오기 
	
	CrewMemberDAO crewMemberDao = new CrewMemberDAO();
	
	//id 세션을 가져옴.
    String sessionId = (String) session.getAttribute("userId");  
    // 가져온 id세션을 통해 내가 이 크루에 어떤 역할인지 확인.
   	String crewSessionId = crewMemberDao.selectCrewMemberStatus(name, sessionId );
   	crewMemberDao.close();
%>

	<jsp:include page= '../Common/Header.jsp' />
	  <section class="main_info">
	  <div class="inner">
	  <div class="crew_name">
	  
			<img src="/resources/images/free-icon-trail-running-3163782.jpg" alt="">
			<h2> 크루 이름 </h2>
			
			<% 
				if(crewSessionId == null || crewSessionId == "" || crewSessionId == "Refuse" || crewSessionId == "Wating" ) {
				%>
					<%
						if(sessionId == null || sessionId == "") {
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
				} else if (crewSessionId == "User" ) {
				%>
					<button type="button" onclick="crew_regist();">크루탈퇴신청</button>
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
				<img src="images/icon/arr2_r_on.png" alt="" class="on" title="">
	          </a>
	
	          <a href="#" class="picture_list">
				<img src="images/icon/arr2_r_on.png" alt="" class="on" title="">
	          </a>
	
	          <a href="#" class="picture_list">
				<img src="images/icon/arr2_r_on.png" alt="" class="on" title="">
	          </a>
	
	          <a href="#" class="picture_list">
				<img src="images/icon/arr2_r_on.png" alt="" class="on" title="">
	          </a>
      </div>	
	</div> <!-- Section left 마지막  -->
        <div class="section_right">
            
            <div class="board_more"> 
	            <h2 class="main_tit">
	              회원 목록
	            </h2>
            	<!-- <button  >더 보기</button> -->
            	<a href="/JSP/Crew/CrewMemberView.jsp?name=<%= name %>">  더 보기 </a>
            	
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

<jsp:include page= '../Common/Footer.jsp' />
</html>