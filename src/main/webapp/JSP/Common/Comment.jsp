<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.CommentDTO"%>
<%@page import="java.util.List"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	
<% 
	String sessionId = (String)session.getAttribute("UserId");  
	String boardType = request.getParameter("boardType");
	String boardIdx = request.getParameter("boardIdx");	
%>	
	
<script type="text/JavaScript">
<%-- 
function loadComments() {
    
	 var boardType = "<%= boardType %>";
	 var boardIdx = "<%= boardIdx %>";
	
    /*
    	alert(boardType);
    	alert(boardIdx);
     */
    $.ajax({
        type: "POST",
        url: "/commentList.comment",
        data: {
            boardType: boardType,
            boardIdx: boardIdx
        },
        dataType: "json",
        success: function(response) {
        	alert("요청이 성공적으로 처리되었습니다!");
            
        },
        error: function(xhr, status, error) {
            alert("댓글을 불러오는데 실패했습니다.");
        }
    });
}

jQuery(document).ready(function() {
	loadComments();
	
}); --%>

</script>

	  


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
		    
		</table>
