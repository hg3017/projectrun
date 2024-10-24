<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CommentDTO"%>
<%@page import="java.util.List"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  
<% 
	String sessionId = (String)session.getAttribute("UserId");  
%>
        
            
            
            <table class="notice">
		    <thead>
		        <tr>
		            <th>이름</th>
		            <th>댓글 내용</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="comment" items="${commentLists}">
		            <tr>
		                <td>${comment.member_id}</td>
		                <td>${comment.content}</td>
		            </tr>
		        </c:forEach>
		    </tbody>
		    
		    
		    <%
		   		if( sessionId != null ) {
		    %>
		    
		    <form action="/commentProcess.comment" method = "post" name = "CommentFrm" onsubmit="return validateForm(this)">
		    	<input type="hidden" name="crew_name" value="${CrewDetail.name }">
		    	<input type="hidden" name="member_id" value=<%= sessionId %>>
		    	
				코멘트 : <input type = "text" name="content"> <br>
				
				<input type="submit" value="코멘트 등록">	
			</form>
		    
		    <%
		   		}
		    %>
		    
		</table>
			
      


    

