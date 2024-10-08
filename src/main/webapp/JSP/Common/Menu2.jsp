<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <table border="1" width="80%">
	<tr>
		<td align="center"><a href="<%=request.getContextPath() %>/member/List.jsp">회원목록</a></td>
	</tr>
</table> --%>
<%-- <table border="1" width="80%">	
	<tr>
        <td align="center">             
            <a href="../announcement/List.jsp">공지사항</a>         
        </td>
    </tr>    
    <tr>
    	<td align="center" colspan="2">
    		<!-- 로그인 여부에 따른 메뉴 변화 -->
        <% if (session.getAttribute("UserId") == null) { %>
            <a href="<%=request.getContextPath() %>/Session/LoginForm.lo">로그인</a>
        <% } else { %>
            <a href="<%=request.getContextPath() %>/Session/Logout.lo">로그아웃</a>
        <% } %>
    	</td>
    </tr>    
</table> --%>