<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<link href="/resources/css/list.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>
    <jsp:include page='/JSP/Common/Header.jsp' />
    
    <main id="container" class="sub_container list_page">
      <section class="sub_visual">
        <div class="inner">
          <div class="sub_wrap">
            <h3>공지사항</h3>
          </div>
        </div>
      </section>
      <section class="contents">
        <div class="inner">
          <div class="m_wrap">
            <p><a href="/Main.jsp">HOME</a><span></span>공지사항</p>
          </div>
          <div class="board_list">
            <div class="list_wrap">
            </div>
          </div>
        </div>
      </section>
    </main>
    
    <div>
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
		<c:if test="${empty boards}">
			<tr>
				<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
			</tr> 
		</c:if>
		
			<c:forEach var="board" items="${boards }" varStatus="status">
			<tr align="center">
				<td>${boards.size() - status.index}</td>
				<!--게시물 번호-->
				<td align="left">
					<!--제목(+ 하이퍼링크)--> <a href="An_View.an?num=${board.num }">${board.title }</a>
				</td>
				<td align="center">${board.id }</td>
				<!--작성자 아이디-->
				<td align="center">${board.visitcount }</td>
				<!--조회수-->
				<td align="center">${board.postdate }</td>
				<!--작성일--> 
			</tr>
			</c:forEach>
		</table>
		<table width="50%" style="border-collapse: collapse">
			<tr align="center">
		        <td>${pagingStr}</td>  <!-- 페이징 링크 표시 -->
		    </tr>
			<tr align="right">
				<td>
				<c:if test="${UserId eq 'hong01' }">
					<button type="button" onclick="location.href='An_Write.an';">글쓰기</button>
				</c:if>
				</td>
			</tr>
		</table>
    </div>
    
	   
	<jsp:include page= '/JSP/Common/Footer.jsp' />   
	   
</body>
</html>