<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

  
    <main id="container" class="crew_page">
     <div id="wrap">
    <section class="main_report">
      <div class="inner">
        <div class="head_wrap">
          <h2 class="main_tit">러닝크루</h2>
          <a class="crew_btn" href="/CrewRegistHref.crew">크루등록하기</a>
        </div>
        <p class="tit">전국 각지에 흩어진 러닝크루들을 소개합니다.</p>
        <div class="filter_container">
          <ul class="social_tab">
            <li class="active">
              <a href="#" data-tab="all">전체</a>
            </li>
            <li >
              <a href="#" data-tab="capital">수도권</a>
            </li>
            <li>
              <a href="#" data-tab="Chungcheong">충청권</a>
            </li>
            <li>
              <a href="#" data-tab="Gangwon">강원권</a>
            </li>
            <li>
              <a href="#" data-tab="Jeolla">전라권</a>
            </li>
            <li>
              <a href="#" data-tab="Gyeongsang">경상권</a>
            </li>
          </ul>
          <div class="report_wrap">
            <ul class="all_view">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
	              <li class="featured_card">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                <!-- <a href="/CrewMainProcess.crew"> -->
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
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </section>
    </div>
    </main>
   
  