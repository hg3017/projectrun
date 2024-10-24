<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main id="container" class="sub_container list_page">
      <section class="sub_visual">
        <div class="inner">
          <div class="sub_wrap">
            <h3>Q&A</h3>
          </div>
        </div>
      </section>
      <section class="contents">
        <div class="inner">
          <div class="board_write">
            <form name="writeFrm" method="post" action="Cs_WriteProcess.co" enctype="multipart/form-data" onsubmit="return validateForm(this);">
              <fieldset>
                <legend>게시물 작성하기</legend>
                <h3 class="tit">Q&A 게시물 작성하기</h3>
                <p class="note"><i class="star"></i>표시는 필수 입력 사항입니다.</p>
                
                <table>
                  <caption class="nohead">게시물 작성하기 테이블</caption>
                  <tr>
                    <th>제목 <i class="star"></i></th>
                    <td><input type="text" placeholder="제목을 입력해주세요" title="제목을 입력해주세요"></td>
                  </tr>
                  <tr>
                    <th class="th_top">내용 <i class="star"></i></th>
                    <td><textarea placeholder="게시물 내용을 작성해 주세요" title="게시물 내용을 작성해 주세요" rows="10"></textarea></td>
                  </tr>
                </table>
                <div class="btn_wrap">
                  	<a class="point_btn4" href="/Cs_View.co?idx=${board.idx }">작성완료</a>
                  	<a class="point_btn5" href="/Cs_List.co">취소</a>
                </div>
              </fieldset>
            </form>
          </div>
        </div>
      </section>
    </main>