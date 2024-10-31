<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CommentDTO"%>
<%@page import="java.util.List"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/resources/css/Comment.css" rel="stylesheet" type="text/css">

	
<% 
	String sessionId = (String)session.getAttribute("UserId");  
	String boardType = request.getParameter("boardType");
	String boardIdx = request.getParameter("boardIdx");	
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
		    
		</table>
		
		<%
		   		if( sessionId != null ) {
		    %>
		    
		    <form action="/commentInsert.comment" method = "post" name = "CommentFrm" onsubmit="return validateForm(this)">
		    	<input type="hidden" name="boardIdx" value=<%= boardIdx %>>
		    	<input type="hidden" name="member_id" value=<%= sessionId %>>
		    	<input type="hidden" name="boardType" value=<%= boardType %>>
		    	
				코멘트 : <input type = "text" name="content"> <br>
				
				<input type="submit" value="코멘트 등록">	
			</form>
		    
		    <%
		   		}
		    %>
