<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main id="container" class="sub_container list_page">
	<section class="sub_visual">
        <div class="inner">
          <div class="sub_wrap"><h3>Q&A</h3></div>
        </div>
      </section>
      <section class="contents">
        <div class="inner">
          <div class="board_view">
            <div class="view_top">
              <a href="/JSP/Main/List_cs_modify.jsp" class="modify_btn">글 수정하기</a>
            </div>
            <div class="view_tit">
              <h3>${board.title }</h3>
              <span class="date">${board.regidate }</span>
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
              <dd><a href="#">러닝은 처음인데 참여해도 괜찮나요?</a></dd>
            </dl>
            <div class="btn_wrap">
              <a class="point_btn3" href="/JSP/Main/List_cs.jsp">목록</a>
            </div>
          </div>
        </div>
	</section>
</main>