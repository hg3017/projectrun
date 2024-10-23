<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty UserId }">
<script>
alert("로그인 후 이용해주십시오");
location.href="/JSP/Login/Login.jsp";
</script>
</c:if>