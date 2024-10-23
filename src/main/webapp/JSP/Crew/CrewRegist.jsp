<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
     <main id="container">
      <section class="main_write">
        <div class="inner">
          <div class="head_wrap">
            <h2 class="main_tit">크루 등록</h2>
            <p class="tit">크루 정보를 입력해주세요.</p>
          </div>
          <form action="/CrewRegist.crew" method = "post" name = "RegisterFrm" onsubmit="return validateForm(this)">
          <div class="input_wrap">
          
            <div class="inner">
            
            
              <div class="wr1">
                <p>크루명</p>
                <input type="text" name="name">
              </div>
              <div class="wr2">
                <p>크루 소개</p>
                <input type="text" name="description">
              </div>
              <div class="wr3">
                <p>활동지역</p>
                
                
                
                
                
                
                	<select id = "lo" name = "lo" size = "1" >
                		<c:forEach var="location" items="${locations }" varStatus="status">
                			<option value=${location.id}>${location.name} </option>	
                		</c:forEach>
                	</select>
                
              </div>
              
            </div>
          </div>
          <div class="btn_wrap2">
            <a href="/JSP/Main/Crew_view.jsp">목록</a>
            <button type="submit">작성 완료</button>
          </div>
          </form>
        </div>
        
      </section>
    </main>
    