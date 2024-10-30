<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
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
                <form method="get">
                  <fieldset>
                    <legend>게시물 검색</legend>
                    <div class="board_search">
                      <div class="select_wrap">
                        <select name="searchField">
                         <option value="title" ${param.searchField eq 'title' ? 'selected' : ''}>제목</option>
						 <option value="content" ${param.searchField eq 'content' ? 'selected' : ''}>내용</option>
                        </select>
                      </div>
                      <div class="input_wrap">
                        <input type="search" placeholder="검색어를 입력해주세요"
						 name="searchWord" value="${param.searchWord }" />
                        <button type="submit" class="search_btn"></button>
                      </div>
                    </div>
                  </fieldset>
                </form>
              </div>
              <div class="btn_wrap">
                <c:if test="${not empty UserId }">
					<a href="/Cb_Write.cb" class="write_btn">글쓰기</a>
				</c:if>
              </div>
            </div>
            <table>
              <caption class="nohead">공지사항 테이블</caption>
              
                <tr>
                  <!-- <th>No</th> -->
                  <th>제목</th>
                  <th>작성자</th>
                  <th>크루명</th>
                  <th>작성일</th>
                  <th>조회수</th>
                </tr>
                <c:if test="${empty boards }">
                	<tr>
			           <td colspan="6" align="center">
			               등록된 게시물이 없습니다.
			           </td>
			       </tr>
                </c:if>
                <c:forEach var="board" items="${boards }" varStatus="status">
                	
                	<c:choose> 
	                	<c:when test="${empty crewName or crewName eq '' }" >
	                		<tr align="center">
		                		<%-- <td>${boards.size() - status.index}</td> --%>
		                		<td><a href="Cb_View.cb?idx=${board.idx }">${board.title }</a></td> <!-- 제목 --></td>
		                		<td>${board.member_id }</td>
		                		<td>${board.crew_name }</td>
		                		<td>${board.regidate }</td>
		                		<td>${board.visitcount }</td>
		                	</tr>
	                	
	                	</c:when>
	                	
	                	<c:when test="${board.crew_name eq crewName}"> 
	                		<tr align="center">
		                		<%-- <td>${boards.size() - status.index}</td> --%>
		                		<td><a href="Cb_View.cb?idx=${board.idx }">${board.title }</a></td> <!-- 제목 --></td>
		                		<td>${board.member_id }</td>
		                		<td>${board.crew_name }</td>
		                		<td>${board.regidate }</td>
		                		<td>${board.visitcount }</td>
	                		</tr>
                		</c:when>
                		
                		
                	</c:choose>
                	<%-- <c:choose> 
                		<c:when test="${crewName eq null } or ${crewName eq '' } ">
                			
                		</c:when>
                		
                		<c:when test="${board.crew_name eq crewName}"> 
	                		<tr align="center">
		                		<td>${boards.size() - status.index}</td>
		                		<td><a href="Cb_View.cb?idx=${board.idx }">${board.title }</a></td> <!-- 제목 --></td>
		                		<td>${board.member_id }</td>
		                		<td>${board.crew_name }</td>
		                		<td>${board.regidate }</td>
		                		<td>${board.visitcount }</td>
	                		</tr>
                		</c:when>
                	</c:choose> --%>
                	
                	
                </c:forEach>
            </table>
            <div class="board_pagination">
           		${pagingStr}
            </div>
          </div>
        </div>
      </section>
    </main>