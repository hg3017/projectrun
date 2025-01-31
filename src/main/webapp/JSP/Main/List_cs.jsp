<%@page import="DTO.BoardCommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <!-- <meta name="viewport" content="width=1004"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="러닝크루">
  <meta property="og:type" content="website">
  <meta  property="og:title" content="러닝">
  <meta property="og:url" content="https://dot386@dot386.dothome.co.kr/html/test/index.html">
  <meta property="og:image" content="/pub/images/og_image.jpg">
  <meta property="og:description" content="러닝크루">
  <title>러닝메이트</title>
  <link rel="icon" href="/resources/images/common/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/resources/images/common/free-icon-running-7126743.png">

	<!-- js 파일 연결 -->
  <!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
  <script src="/resources/js/jquery-3.7.1.min.js"></script>
  <script src="/resources/js/jquery-ui.min.js"></script>
  <script src="/resources/js/swiper-bundle.min.js"></script>
  <script src="/resources/js/aos.js"></script>
  <script src="/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

  <!-- css 파일 연결 -->
  <link href="/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/aos.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/list.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
</head>
<body>
  <div id="wrap">
    <jsp:include page="/JSP/Common/Header.jsp" />
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
          <div class="m_wrap">
            <p><a href="/JSP/Main/Main.jsp">HOME</a><span></span>고객센터</p>
          </div>
          <div class="board_list">
            <div class="list_wrap">
              <div class="board_search_wrap">
                <form>
                  <fieldset>
                    <legend>게시물 검색</legend>
                    <div class="board_search">
                      <div class="select_wrap">
                        <select>
                          <option>제목</option>
                          <option>내용</option>
                        </select>
                      </div>
                      <div class="input_wrap">
                        <input type="search" title="검색어를 입력해주세요">
                        <button type="submit" class="search_btn">
                          <span class="blind">게시물 검색</span>
                        </button>
                      </div>
                    </div>
                  </fieldset>
                </form>
              </div>
            </div>
            <table>
                <tr>
                  <th class="col1">번호</th>
                  <th class="td_left">제목</th>
                  <th class="col3">작성일자</th>
                </tr>
               
            </table>
            <div class="board_pagination">
              <a href="#" class="prev_paging">
                <span class="blind">첫페이지</span>
              </a>
              <span class="num active">1</span>
              <a href="#" class="next_paging">
                <span class="blind">마지막페이지</span>
              </a>
            </div>
          </div>
        </div>
      </section>
      <section class="ban_box">
        <div class="inner">
          <ul class="etc">
            <li>
              <a href="/JSP/Main/List_cs_write.jsp" class="etc_left"><p>1:1 상담하기</p></a>
            </li>
            <li>
              <a href="#" class="etc_right"><p>전화 문의하기<span></span>TEL : 02-1234-5678</p></a>
            </li>
          </ul>
        </div>
      </section>
    </main>
    <jsp:include page= '/JSP/Common/Footer.jsp' />
  </div>
</body>
</html>