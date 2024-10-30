<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/view.css" rel="stylesheet" type="text/css">   
<script src="/resources/js/CrewView.js"></script>

    
<% 
	String sessionId = (String) session.getAttribute("UserId");  
%>
    <main id="container" class="crew_page">
     <div id="wrap">
    <section class="main_report">
      <div class="inner">
        <div class="head_wrap">
          <h2 class="main_tit">러닝크루</h2>
          
          <%      
          	if(sessionId != null  ) {
        %>
          	<a class="crew_btn" href="/CrewRegistHref.crew">크루등록하기</a>
        <%
          	}
        %>
          
        </div>
        <p class="tit">전국 각지에 흩어진 러닝크루들을 소개합니다.</p>
        <div class="filter_container">
          <ul class="social_tab">
            <li class="active">
              <a data-tab="all" onclick="changeTab(event)">전체</a>
            </li>
            <li >
              <a data-tab="capital" onclick="changeTab(event)">수도권</a>
            </li>
            <li>
              <a data-tab="Chungcheong" onclick="changeTab(event)">충청권</a>
            </li>
            <li>
              <a data-tab="Gangwon" onclick="changeTab(event)">강원권</a>
            </li>
            <li>
              <a data-tab="Jeolla" onclick="changeTab(event)">전라권</a>
            </li>
            <li>
              <a data-tab="Gyeongsang" onclick="changeTab(event)">경상권</a>
            </li>
          </ul>
          <div class="report_wrap">
          
          	<ul class="all_view" data-content="all">
		        <c:forEach var="crew" items="${CrewLists}">
		            <li class="featured_card" data-content="all">
		                <a href="/CrewMainProcess.crew?crewName=${crew.name}">
		                    <div class="img_wrap">
		                        <img src="/resources/images/main_crew1.jpg" alt="">
		                    </div>
		                    <div class="txt_wrap">
		                        <h3>${crew.name}</h3>
		                        <p>${crew.location_id}</p>
		                        <span>${crew.regidate}</span>
		                    </div>
		                </a>
		            </li>
		        </c:forEach>
		    </ul>
              
            <ul class="all_view" data-content="capital" style="display: none;">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
                 <c:if test="${crewList.location_id == '서울시' or crewList.location_id == '경기도' or crewList.location_id == '인천' or crewList.location_id == '경기북도' }">
              
	              <li class="featured_card" data-content="capital">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
	             </c:if>
              </c:forEach>
            </ul>
            
            <ul class="all_view" data-content="Chungcheong" style="display: none;">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
                 <c:if test="${crewList.location_id == '충청남도' or crewList.location_id == '충청북도' or crewList.location_id == '대전' or crewList.location_id == '세종' }">
              
	              <li class="featured_card" data-content="Chungcheong">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
	             </c:if>
              </c:forEach>
            </ul>
            
            <ul class="all_view" data-content="Gangwon" style="display: none;">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
                 <c:if test="${crewList.location_id == '강원도' }">
              
	              <li class="featured_card" data-content="Gangwon">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
	             </c:if>
              </c:forEach>
            </ul>
            
            <ul class="all_view" data-content="Jeolla" style="display: none;">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
                 <c:if test="${crewList.location_id == '전라남도' or crewList.location_id == '전라북도' or crewList.location_id == '광주'}">
              
	              <li class="featured_card" data-content="Jeolla">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
	             </c:if>
              </c:forEach>
            </ul>
            
            <ul class="all_view" data-content="Gyeongsang" style="display: none;">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
                 <c:if test="${crewList.location_id == '경상남도' or crewList.location_id == '경상북도' or crewList.location_id == '부산' or crewList.location_id == '울산' or crewList.location_id == '대구'}">
              
	              <li class="featured_card" data-content="Gyeongsang">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
	             </c:if>
              </c:forEach>
            </ul>
            
            
          </div>
        </div>
      </div>
    </section>
    </div>
    </main>
   
  