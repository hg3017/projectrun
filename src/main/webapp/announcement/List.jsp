<%@page import="utils.AnnouncementPage"%>
<%@page import="announcement.dto.AnnouncementDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="announcement.dao.AnnouncementDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
AnnouncementDAO dao = new AnnouncementDAO(application);

//사용자가 입력한 검색 조건을 Map에 저장
Map<String, String> ann = new HashMap<String, String>(); 
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
 ann.put("searchField", searchField);
 ann.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(ann);  // 게시물 수 확인

//paging
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int)Math.ceil((double)totalCount/pageSize);

int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if(pageTemp != null && !pageTemp.equals(""))
	pageNum =Integer.parseInt(pageTemp);

int limit = pageSize;
int offset = (pageNum - 1) * pageSize + 1; // 1 ~ 10 , 11 ~ 20
ann.put("limit", String.valueOf(pageSize));
ann.put("offset", String.valueOf(offset));

List<AnnouncementDTO> amtLists = dao.selectList(ann);  // 게시물 목록 받기
dao.close();  // DB 연결 닫기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/swiper-bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

  <!-- css 파일 연결 -->
  <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/sub.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
<style>
</style>
</head>
<body>
    <header id="header">
      <div class="inner">
          <h1 class="logo">
            <a href="index.html">
              <img src="../resources/images/free-icon-trail-running-3163782.png" alt="러닝메이트">
              <span class="blind">러닝메이트</span>
            </a>
          </h1>
          <nav class="gnb_wrap">
            <ul class="gnb">
              <li>
                <a href="#">회사소개</a>
                <ul class="depth2">
                  <li><a href="/company/ceo"></a></li>
                  <li><a href="/company/philosophy"></a></li>
                  <li><a href="/company/business"></a></li>
                  <li><a href="/company/history"></a></li>
                </ul>
              </li>
              <li>
                <a href="#">지역크루</a>
                <ul class="depth2">
                  <li><a href="/company/ceo"></a></li>
                  <li><a href="/company/philosophy"></a></li>
                  <li><a href="/company/business"></a></li>
                  <li><a href="/company/history"></a></li>
                  <li><a href="/product/list?type=9"></a></li>
                  <li><a href="/product/list?type=9"></a></li>
                  <li><a href="/product/list?type=5"></a></li>
                  <li><a href="/product/list?type=11"></a></li>
                  <li><a href="/product/list?type=7"></a></li>
                </ul>
              </li>
              <li>
                <a href="#">게시판</a>
                <ul class="depth2">
                  <li><a href="/esg/esg"></a></li>
                  <li><a href="/esg/eco"></a></li>
                  <li><a href="/esg/value"></a></li>
                  <li><a href="/esg/global"></a></li>
                  <li><a href="/esg/ethics"></a></li>
                  <li><a href="/esg/contribution"></a></li>
                  <li><a href="/esg/reports"></a></li>
                </ul>
              </li>
              <li>
                <a href="/running/announcement/List.jsp">고객센터</a>
                <ul class="depth2">
                  <li><a href="/center/service"></a></li>
                  <li><a href="/center/supply?prod_cat_idx=1"></a></li>
                  <li><a href="/center/cyber"></a></li>
                  <li><a href="/center/safe"></a></li>
                  <li><a href="/support/privacy"></a></li>
                </ul>
              </li>
            </ul>
          </nav>
          <div class="btn_wrap">
            <a class="login_btn" href="login.html">로그인</a>  
            <button type="button" class="sitemap_btn">
              <span class="blind">사이트맵 열기</span>
              <i></i>
              <i></i>
              <i></i>
            </button>
          </div>
      </div>
      <aside class="menu_wrap">
        <div class="menu_inner">
          <h2><span class="blind">러닝크루</span></h2>
          <ul class="menu">
            <li>
              <a href="#">회사소개</a>
              <ul class="depth2">
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="#">지역크루</a>
              <ul class="depth2">
                <li><a href="/products/sampleCheck.do"></a></li>
                <li><a href="/products/sampleCheck.do"></a></li>
                <li><a href="/products/sampleCheck.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="#">게시판</a>
              <ul class="depth2">
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="/running/announcement/List.jsp">고객센터</a>
              <ul class="depth2">
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
              </ul>
            </li>
          </ul>
        </div>
      </aside>
    </header>

	<!-- 검색 -->
	<form method="get">
		<table width="50%" style="border-collapse: collapse">
			<tr>
				<td align="right"><select name="searchField">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색" /></td>
			</tr>
		</table>
	</form>
	<!-- 공지사항 목록 -->
	<table border="1" width="50%" style="border-collapse: collapse">
		<!-- 각각의 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<%
if (amtLists.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
<%
}
else {
    // 게시물이 있을 때 
/*     int virtualNum = 0; // 화면상에서의 게시물 번호
    for (AnnouncementDTO dto : amtLists) {
    	virtualNum = totalCount--;   // 전체 게시물 수에서 시작해 1씩 감소 */
    	int virtualNum = totalCount - (pageNum - 1) * pageSize; // 페이지에 맞춰 가상번호 계산
    	for (AnnouncementDTO dto : amtLists) {
    	    virtualNum--;   // 가상번호는 1씩 감소
%>
		<tr align="center">
			<td><%= virtualNum %></td>
			<!--게시물 번호-->
			<td align="left">
				<!--제목(+ 하이퍼링크)--> <a href="View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle() %></a>
			</td>
			<td align="center"><%= dto.getId() %></td>
			<!--작성자 아이디-->
			<td align="center"><%= dto.getVisitcount() %></td>
			<!--조회수-->
			<td align="center"><%= dto.getPostdate() %></td>
			<!--작성일-->
		</tr>
		<%}
    }%>
	</table>
	<table width="50%" style="border-collapse: collapse">
		<tr align="right">
			<td align="center"><%=AnnouncementPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getRequestURI()) %></td>
			<td>
				<button type="button" onclick="location.href='Write.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>
	    <footer id="footer">
      <div class="inner">
        <div class="footer_top">
          <h2><img src="../resources/images/free-icon-trail-running-3163782.png" alt="러닝크루"></h2>
          <div class="menu">
            <p><a href="#">개인정보처리방침</a></p>
            <p><a href="#">문의하기</a></p>
          </div>
        </div>
        <div class="footer_bottom">
          <h2>
            <span class="blind">러닝크루</span>
          </h2>
          <div class="txt_wrap">
            <p class="address">서울특별시 종로구 삼일대로17길 51<span></span>사업자번호 : 123-45-67890<span></span>대표자 : 김경문</p>
            <p class="copyright">COPYRIGHT © <strong>2024 LX Glas Corp.</strong> All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
</body>
</html>