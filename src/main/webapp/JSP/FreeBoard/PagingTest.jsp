<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int pageSize = 10;
int blockPage = 10;
int pageNum = 11;

if(request.getParameter("pageNum") != null) {
	pageNum = Integer.parseInt(request.getParameter("pageNum"));
}

int totalpage = 55;
int pageTemp = ((pageNum -1)/blockPage) * blockPage + 1; // 1, 11, 21

%>
<%if(pageTemp != 1) {%>
<a href="PagingTest.jsp?pageNum=1">[First]</a>
<a href="PagingTest.jsp?pageNum=<%=pageTemp-1%>">[Prev]</a>
<%} %>
<%
int blockCount = 1;
while(blockCount <= blockPage && pageTemp <= totalpage){
%>
	<%if(pageNum == pageTemp) {%>
		[<%=pageTemp %>]
	<%}else{ %>
		<a href="PagingTest.jsp?pageNum=<%=pageTemp %>">[<%=pageTemp %>]</a>
	<%} %>
<%
	pageTemp++;
	blockCount++;
}%>
<%if(pageTemp <= totalpage) {%>
<a href="PagingTest.jsp?pageNum=<%=pageTemp+1%>">[Next]</a>
<a href="PagingTest.jsp?pageNum=<%=totalpage%>">[End]</a>
<%} %>