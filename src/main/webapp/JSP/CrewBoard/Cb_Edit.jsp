
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/JSP/CrewBoard/IsLoggedIn.jsp"%> 
    
    
<script type="text/javascript">
function validateForm(form) {
	 if (form.title.value == "") {
	        alert("제목을 입력하세요.");
	        form.title.focus();
	        return false;
	    }
	    if (form.content.value == "") {
	        alert("내용을 입력하세요.");
	        form.content.focus();
	        return false;
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
          <div class="board_write">
            <form name="editFrm" method="post" action="Cb_EditProcess.cb" enctype="multipart/form-data" onsubmit="return validateForm(this);">
            <input type="hidden" name="idx" value="${board.idx }" />
              <fieldset>
                <legend>게시물 수정하기</legend>
                <h3 class="tit">크루게시판 게시물 수정하기</h3>
                <p class="note"><i class="star"></i>표시는 필수 입력 사항입니다.</p>
                <c:if test="${not empty board }">
                <table>
                  <caption class="nohead">게시물 수정하기 테이블</caption>
                  <tr>
                    <th>제목<i class="star"></i></th>
                    <td><input type="text" name="title" placeholder="제목을 입력해주세요" title="제목을 입력해주세요" value="${board.title }"></td>
                  </tr>
                  <tr>
                    <th class="th_top">내용<i class="star"></i></th>
                    <td><textarea name="content" placeholder="게시물 내용을 작성해 주세요" title="게시물 내용을 작성해 주세요" rows="10">${board.content }</textarea></td>
                  </tr>
                  <tr>
                    <th>첨부파일</th>
                    <td class="td_flex">
                      <div class="file_wrap">
                        <input type="text" id="fileName" value="${not empty board.ofile ? board.ofile : '첨부파일 없음'}" readonly>
                        <label>
                          <input name="file" id="fileInput" type="file" class="blind">
                          파일선택
                        </label>
                      </div>
                      <p class="file_note">※ 등록 가능 확장자 : pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB</p>
                    </td>
                  </tr>
                </table>
                </c:if>
                <div class="btn_wrap">
                  <button type="submit" class="point_btn4" style="border:none">수정완료</button>
							<button type="button" class="point_btn5" 
								onclick="location.href='/Cb_List.cb';">취소</button>
                </div>
              </fieldset>
            </form>
          </div>
        </div>
      </section>
    </main>
    <c:if test="${empty board}">
	<p>게시물 데이터를 찾을 수 없습니다.</p>
	<!-- board 값이 null인 경우 경고 -->
</c:if>