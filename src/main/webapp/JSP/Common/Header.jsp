<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
	<div class="inner">
    	<h1 class="logo">
            <a href="<%=request.getContextPath() %>/JSP/Main/Main.jsp">
              <img src="<%=request.getContextPath() %>/resources/images/free-icon-trail-running-3163782.png" alt="러닝메이트">
              <!-- <img src="ProjectRun/src/main/webapp/resources/images/free-icon-trail-running-3163782.png" alt="러닝메이트">  -->
              <span class="blind">러닝메이트</span>
            </a>
       	</h1>
        <nav class="gnb_wrap">
           <ul class="gnb">
             <li><a href="<%=request.getContextPath() %>/JSP/Main/Crew_view.jsp">지역크루</a></li>
             <li><a href="<%=request.getContextPath() %>/JSP/Main/List_boardcrew.jsp">크루게시판</a></li>
             <li><a href="<%=request.getContextPath() %>/JSP/Main/List_board.jsp">자유게시판</a></li>
             <li><a href="<%=request.getContextPath() %>/List">공지사항</a></li>
             <li><a href="<%=request.getContextPath() %>/JSP/Main/List_cs.jsp">고객센터</a></li>
           </ul>
         </nav>
         <div class="btn_wrap">
           <a class="login_btn" href="<%=request.getContextPath() %>/JSP/Login/Login.jsp">로그인</a>  
           <button type="button" class="sitemap_btn">
           	<span class="blind">사이트맵 열기</span>
          	<i></i>
            <i></i>
            <i></i>
           </button>
        </div>
      </div>
      <aside class="menu_wrap">
        <div class="menu_inner">
          <h2><span class="blind">러닝크루</span></h2>
          <ul class="menu">
           <li><a href="<%=request.getContextPath() %>/JSP/Main/Crew_view.jsp">지역크루</a></li>
           <li><a href="<%=request.getContextPath() %>/JSP/Main/List_boardcrew.jsp">크루게시판</a></li>
           <li><a href="<%=request.getContextPath() %>/JSP/Main/List_board.jsp">자유게시판</a></li>
           <li><a href="<%=request.getContextPath() %>/List">공지사항</a></li>
           <li><a href="<%=request.getContextPath() %>/JSP/Main/List_cs.jsp">고객센터</a></li>
         </ul>
       </div>
    </aside>
</header>