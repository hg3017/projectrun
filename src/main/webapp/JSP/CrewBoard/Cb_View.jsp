<%@page import="DAO.CrewBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/CrewBoard/IsLoggedIn.jsp"%>

<script>
	function deletePost() {
		var confirmed = confirm("정말로 삭제하겠습니까?");
		if(confirmed) {
			var form = document.writeFrm;
			form.method = "post";
			form.action = "/An_DeleteProcess.an";
		}
		
	}
</script>
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
              <h3>${board.title }</h3>
              <span class="date">${board.regidate }</span>
            </div>
            <div class="view_con">
              <c:if test="${empty board.content }">내용없음</c:if>
              <c:if test="${not empty board.content }">${board.content }</c:if>
            </div>
            <dl class="view_paging">
              <dt>이전글</dt>
              <dd>
				<c:if test="${not empty board.prevNum  }">
					<a href="Cb_View.cb?idx=${board.prevNum }">${board.prevTitle }</a>
				</c:if>
				<c:if test="${empty board.prevNum }"></c:if>
			 </dd>
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