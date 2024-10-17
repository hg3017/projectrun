<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="러닝크루">
  <meta property="og:type" content="website">
  <meta  property="og:title" content="러닝">
  <meta property="og:url" content="https://dot386@dot386.dothome.co.kr/html/test/index.html">
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
  <link href="/resources/css/view.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/crew_write.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
   <link href="/resources/css/detail.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
</head>
<body>
  <div id="wrap">
    <jsp:include page= '/JSP/Common/Header.jsp' />
    <main id="container">
      <section class="main_visual">
      <h2 class="blind">메인슬라이더</h2>
      </section>
      <section class="main_crew">
        <div class="inner">
          <div class="head_wrap">
            <h2 class="main_tit">러닝크루</h2>
            <a class="crew_btn" href="/JSP/Main/Crew_write.jsp">크루등록하기</a>
          </div>
          <p class="tit">전국 각지에 흩어진 러닝크루들을 소개합니다.</p>
          <div class="swiper_wrap">
            <div class="swiper">
              <div class="swiper-wrapper">
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew1.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew2.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew2.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew2.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew2.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
                <div class="swiper-slide">
                  <a href="/JSP/Main/Crew_view.jsp">
                    <div class="img_wrap">
                      <img src="/resources/images/main_crew1.jpg" alt="">
                    </div>
                    <div class="txt_wrap">
                      <h3>서울/경기</h3>
                      <p>Sub3</p>
                      <span>목요일<br>PM 7:30</span>
                    </div>
                  </a>
                </div>
              </div>
              <div class="swiper-pagination"></div>
              <div class="swiper-button-prev arrow_btn"></div>
              <div class="swiper-button-next arrow_btn"></div>
            </div>
          </div>
        </div>
      </section>
      <section class="main_info">
        <div class="inner">
          <div class="board">
            <div class="board_list">
              <h2>Q&A</h2>
            </div>
            <ul class="list">
              <li>
                <a href="/JSP/Main/List_cs_view.jsp">
                  <p>모임 시간 외에 뒤풀이나 번개가 있나요?</p>
                  <span class="date">2024.09.30</span>
                </a>
              </li>
              <li>
                <a href="/JSP/Main/List_cs_view.jsp">
                  <p>러닝은 처음인데 참여해도 괜찮나요?</p>
                  <span class="date">2024.09.30</span>
                </a>
              </li>
              <li>
                <a href="/JSP/Main/List_cs_view.jsp">
                  <p>모집기간은 언제인가요? 마감된 모임은 신청할 수 없나요?</p>
                  <span class="date">2024.09.30</span>
                </a>
              </li>
            </ul>
            <a href="/JSP/Main/List_cs.jsp" class="more_btn">더보기</a>
            <!-- 고객센터로 이동 -->
          </div>
        </div>
      </section>
    <jsp:include page= '/JSP/Common/Footer.jsp' />
  </div>
</body>
</html>