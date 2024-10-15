<%@page import="Utils.FreeBoardPage"%>
<%@page import="DTO.FreeBoardDTO"%>
<%@page import="DAO.FreeBoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
FreeBoardDAO dao = new FreeBoardDAO();

//사용자가 입력한 검색 조건을 Map에 저장
Map<String, String> fb = new HashMap<String, String>(); 
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
 fb.put("searchField", searchField);
 fb.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(fb);  // 게시물 수 확인



//paging
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int)Math.ceil((double)totalCount/pageSize);

int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if(pageTemp != null && !pageTemp.equals(""))
	pageNum =Integer.parseInt(pageTemp);

int limit = pageSize;
int offset = (pageNum - 1) * pageSize; // 1 ~ 10 , 11 ~ 20
fb.put("limit", String.valueOf(pageSize));
fb.put("offset", String.valueOf(offset)); 


List<FreeBoardDTO> fbLists = dao.selectList(fb);  // 게시물 목록 받기
dao.close();  // DB 연결 닫기
%>
<%
String message = (String) session.getAttribute("message");
if (message != null) {
    out.println("<script>alert('" + message + "');</script>");
    session.removeAttribute("message");  // 메시지를 한 번 출력 후 삭제
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script>
alter(${pageContext.request.contextPath});
</script>
  <script src="/resources/js/jquery-3.7.1.min.js"></script>
  <script src="/resources/js/jquery-ui.min.js"></script>
  <script src="/resources/js/swiper-bundle.min.js"></script>
  <script src="/resources/js/aos.js"></script>
  <script src="/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

  <!-- css 파일 연결 -->
  <link href="/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/sub.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
<style>
</style>
</head>
<body>
    <jsp:include page= '/JSP/Common/Header.jsp' />
    <h1 style="font-size:24px">자유게시판</h1>
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
if (fbLists.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
<%
}
else {
    // 게시물이 있을 때 
        int virtualNum = totalCount - (pageNum - 1) * pageSize; //
        for (FreeBoardDTO dto : fbLists) {
%>
		<tr align="center">
			<td><%= virtualNum %></td>
			<!--게시물 번호-->
			<td align="left">
				<!--제목(+ 하이퍼링크)--> <a href="/JSP/FreeBoard/fb_View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle() %></a>
			</td>
			<td align="center"><%= dto.getId() %></td>
			<!--작성자 아이디-->
			<td align="center"><%= dto.getVisitcount() %></td>
			<!--조회수-->
			<td align="center"><%= dto.getPostdate() %></td>
			<!--작성일-->
		</tr>
		<%
        	virtualNum--;
        }}%>
	</table>
	<table width="50%" style="border-collapse: collapse">
		<tr align="right">
 			<td align="center"><%=FreeBoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getRequestURI()) %></td>
			<td>
				<button type="button" onclick="location.href='/JSP/FreeBoard/Fb_Write.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>
	   
	<jsp:include page= '/JSP/Common/Footer.jsp' />   
	   
</body>
</html>