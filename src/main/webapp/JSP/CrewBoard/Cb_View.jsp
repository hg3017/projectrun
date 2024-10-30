<%@page import="DAO.CrewBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JSP/CrewBoard/IsLoggedIn.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function deletePost() {
		var confirmed = confirm("정말로 삭제하겠습니까?");
		if(confirmed) {
			var form = document.writeFrm;
			form.method = "post";
			form.action = "/Cb_DeleteProcess.cb";
			form.submit();
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
         	<form name="writeFrm" method="post">
   				<input type="hidden" name="idx" value="${board.idx}" />
			</form>
            <div class="view_top">
             	<c:if test="${UserId eq board.member_id }">
             		<button type="button" onclick="location.href='Cb_Edit.cb?idx=${board.idx}';">수정하기</button>
             		<button type="button" onclick="deletePost()">삭제하기</button>
             	</c:if>
            </div>
            <div class="view_tit">
         
              <h3>${board.title }</h3>
              <span class="date">${board.regidate }</span>
            </div>
            <div class="view_con">
              <c:if test="${not empty board.content }">${board.content }</c:if>
              <c:if test="${empty board.content }">내용없음</c:if>
            </div>
            <div class="view_file" align="right">
				<h3>첨부파일</h3>
				<c:if test="${not empty board.ofile}">
					<a href="/FileDown.cb?sFile=${board.sfile}&oFile=${board.ofile}">${board.ofile}</a>
				</c:if>
				<c:if test="${empty board.ofile}">
					<span>첨부파일 없음</span>
				</c:if>
				</div>
            <dl class="view_paging">
              <dt>이전글</dt>
              <dd>
				<c:if test="${not empty board.prevnum  }"><a href="Cb_View.cb?idx=${board.prevnum }">${board.prevtitle }</a></c:if>
				<c:if test="${empty board.prevnum }"><span>이전 글이 없습니다.</span></c:if>
			 </dd>
            </dl>
            <dl class="view_paging">
              <dt>다음글</dt>
              <dd>
            	<c:if test="${not empty board.nextnum}"><a href="Cb_View.cb?idx=${board.nextnum}">${board.nexttitle}</a></c:if>
              	<c:if test="${empty board.nextnum }"><span>다음글은 없습니다</span></c:if>              
              </dd>
            </dl>
            <div class="btn_wrap">
              <button type="button" class="point_btn3" onclick="location.href='/Cb_List.cb';">목록</button>
            </div>
          </div>
        </div>
      </section>
    </main>