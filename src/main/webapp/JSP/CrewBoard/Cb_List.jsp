<%@page import="DTO.CrewBoardDTO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CrewBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
 
 <%
 CrewBoardDAO dao = new CrewBoardDAO();
 
 Map<String, String> param = new HashMap<String, String>(); 
 String searchField = request.getParameter("searchField");
 String searchWord = request.getParameter("searchWord");
 if (searchWord != null) {
     param.put("searchField", searchField);
     param.put("searchWord", searchWord);
 }

 int totalCount = dao.selectCount(param);  // 게시물 수 확인
/*  int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
 int blockPage = Integer.parseInt(application.getInitParameter("POSTS_PER_BLOCK"));
 int totalPage = (int)Math.ceil((double)totalCount/pageSize); */

 int pageNum = 1;
 String pageTemp = request.getParameter("pageNum");
 if(pageTemp != null && !pageTemp.equals(""))
 	pageNum = Integer.parseInt(pageTemp);

/*  int limit1 = pageSize;
 int offset = (pageNum -1) * pageSize + 1;
 param.put("limit",pageSize+""); */
/*  param.put("offset",offset+""); */
 
 List<CrewBoardDTO> boardLists = dao.selectList(param);
 dao.close();
 %>
 
<!DOCTYPE html>
<html>
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
  <link href="/resources/css/view.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/crew_write.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
   <link href="/resources/css/detail.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
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
          <div class="m_wrap">
            <p><a href="/JSP/Main/Main.jsp">HOME</a><span></span>크루게시판</p>
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
              <div class="btn_wrap">
                <a class="write_btn" href="/JSP/Main/List_boardcrew_write.jsp">글쓰기</a>
              </div>
            </div>
            <table>
              <caption class="nohead">공지사항 테이블</caption>
                <tr>
                  <th>No</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>크루명</th>
                  <th>조회수</th>
                  <th>작성일</th>
                </tr>
                <%
if (boardLists.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
        <tr>
            <td colspan="5" align="center">
                등록된 게시물이 없습니다.
            </td>
        </tr>
<%
}
else {
    // 게시물이 있을 때 
    int virtualNum = 0;  // 화면상에서의 게시물 번호
    for (CrewBoardDTO dto : boardLists)
    {
        virtualNum = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소
%>
        <tr align="center">
            <td><%= virtualNum %></td>  <!--게시물 번호-->
            <td align="left">  <!--제목(+ 하이퍼링크)-->
                <%-- <a href="View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle() %></a>  --%>
            </td>
            <td align="center"><%= dto.getMember_id() %></td>          <!--작성자 아이디-->
            <td align="center"><%= dto.getVisitcount() %></td>  <!--조회수-->
            <td align="center"><%= dto.getPostdate() %></td>    <!--작성일-->
        </tr>
<%
    }
}
%>
                
                
                <%-- <c:if test="${empty boards }">
                	<tr>
                		<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
                	</tr>
                </c:if>
                
                <c:forEach var="board" items="${boards }" varStatus="status">
                	<tr align="center">
                		<td>${boards.size() - status.index}</td>
                		<td>
                			<a href="#"></a>
                		</td>
                		<td>${board.id }</td>
                		<td>${board.visitcount }</td>
                		<td>${board.postdate }</td>
                	</tr>
                </c:forEach> --%>
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
    </main>
    <jsp:include page= '/JSP/Common/Footer.jsp' />
</body>
</html>