<%@page import="DAO.CrewBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/CrewBoard/IsLoggedIn.jsp"%>

<%
String num = request.getParameter("num");

CrewBoardDAO dao = new CrewBoardDAO();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title </title>
</head>
<body>
 <jsp:include page="/JSP/Common/Header.jsp" />
    
    <main id="container" class="sub_container list_page">
      <section class="sub_visual">
        <div class="inner">
          <div class="sub_wrap">
            <h3>게시판 <span></span> 크루</h3>
          </div>
        </div>
      </section>
      <section class="contents">
        <div class="inner">
          <div class="board_view">
            <div class="view_top">
              <a href="/JSP/Main/List_boardcrew_modify.jsp" class="modify_btn">글 수정하기</a>
            </div>
            <div class="view_tit">
              <h3>러닝 시 필요물품</h3>
              <span class="date">2024.09.30</span>
            </div>
            <div class="view_con">
              게시물 내용
            </div>
            <dl class="view_paging">
              <dt>이전글</dt>
              <dd><a href="#"></a></dd>
            </dl>
            <dl class="view_paging">
              <dt>다음글</dt>
              <dd><a href="#">?</a></dd>
            </dl>
            <div class="btn_wrap">
              <a class="point_btn3" href="/JSP/Main/List_boardcrew.jsp">목록</a>
            </div>
          </div>
        </div>
      </section>
    </main>
    <jsp:include page= '/JSP/Common/Footer.jsp' />
</body>
</html>