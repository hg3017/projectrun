<%@page import="DTO.CustomerboardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="DAO.CustomerboardDAO"%>
<%@page import="DTO.BoardCommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//DAO를 생성해 DB에 연결
CustomerboardDAO dao = new CustomerboardDAO();

//사용자가 입력한 검색 조건을 Map에 저장
Map<String, String> param = new HashMap<String, String>(); 
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
 param.put("searchField", searchField);
 param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param);
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int)Math.ceil((double)totalCount/pageSize);

int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if(pageTemp != null && !pageTemp.equals(""))
pageNum = Integer.parseInt(pageTemp);

int limit1 = pageSize;
int offset = (pageNum -1) * pageSize + 1;
param.put("limit",pageSize+"");
param.put("offset",offset+"");

List<CustomerboardDTO> boardList = dao.selectList(param);
dao.close();
%>
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
            		<th width="10%">NO</th>
            		<th width="10%">분류</th>
            		<th width="10%">공개여부</th>
            		<th width="50%">제목</th>
            		<th width="15%">작성자</th>
            		<th width="15%">작성일</th>
     		   </tr>
<%
if (boardList.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
        <tr>
        	<td colspan="10" align="center">등록된 게시물이 없습니다</td>
        </tr>
<%
}
else {
    // 게시물이 있을 때 
    int virtualNum = 0;  // 화면상에서의 게시물 번호
    for (CustomerboardDTO dto : boardList)
    {
        virtualNum = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소
%>
        <tr align="center">
            <td><%= virtualNum %></td>  <!--게시물 번호-->
            <td><%= dto.getAbleview() %></td>
            <td><%= dto.getCategory() %></td>
            <td align="left">  <!--제목(+ 하이퍼링크)-->
                <a href="View.jsp?num=<%= dto.getIdx() %>"><%= dto.getTitle() %></a>
            </td>
            <td align="center"><%= dto.getMember_id() %></td>          <!--작성자 아이디-->
            <td align="center"><%= dto.getRegidate() %></td>    <!--작성일-->
        </tr>
<%
    }
}
%>
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