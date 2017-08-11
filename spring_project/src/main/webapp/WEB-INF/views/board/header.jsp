<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="UTF-8"/> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%request.setCharacterEncoding("UTF-8"); 
  String path=request.getContextPath();	
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
<style type="text/css">
	#menu{text-align:center; height:70px; border:1px solid black;}
</style>
</head>
<body>
	<div id="menu">
		<a href="${path }/list.do">게시판</a>
		<c:choose>
			<c:when test="${sessionScope.id == null }">
				<a href="${path }/member/login.do">로그인</a>
			</c:when>
			<c:otherwise>
				<br>${sessionScope.name }님이 로그인 중입니다.
				<a href="${path }/member/logout.do">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>