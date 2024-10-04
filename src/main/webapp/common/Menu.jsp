<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="80%">
	<tr>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMember/List.jsp">회원목록</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMember2/List.jsp">회원목록2</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMemberDAO/List.jsp">회원목록(DAO)</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMemberServlet/List.jsp">회원목록(Servlet)</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMemberMVC/List.do">회원목록(MVC)</a></td>
		<td align="center"><a href="<%=request.getContextPath() %>/05JDBCMemberJSTL/List.do">회원목록(JSTL)</a></td>
	</tr>
</table>
<table border="1" width="80%">	
	<tr>
        <td align="center">        
            <a href="../08Board/List.jsp">게시판(페이징X)</a>
        </td>
        <td align="center">             
            <a href="../09PagingBoard/List.jsp">게시판(페이징O)</a>         
        </td>
        <td align="center">             
            <a href="../09PagingBoardServlet/List.jsp">게시판(페이징O - Servlet)</a>         
        </td>     
    </tr>    
    <tr>
    	<td align="center" colspan="2">
    		<!-- 로그인 여부에 따른 메뉴 변화 -->
        <% if (session.getAttribute("UserId") == null) { %>
            <a href="<%=request.getContextPath() %>/06Session/LoginForm.lo">로그인</a>
        <% } else { %>
            <a href="<%=request.getContextPath() %>/06Session/Logout.lo">로그아웃</a>
        <% } %>
    	</td>
    </tr>    
</table>