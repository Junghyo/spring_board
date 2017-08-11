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
<link rel="stylesheet" href="/resources/css/a00_com.css">
<script src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#loginBtn").click(function(){
			var id = $("#id").val();
			var pwd = $("#pwd").val();
			if(id == ""){
				alert("아이디를 입력하세요");
				$("#id").focus();
				return;
			}
			if(pwd == ""){
				alert("비밀번호를 입력하세요.");
				$("#pwd").focus();
				return;
			}
			$("form").attr("action", "${path}/member/loginCheck.do");
			$("form").submit();
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<c:import url="../board/header.jsp"/>
	<h2>로그인</h2>
	<form method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input name="id" id="id"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password" id="pwd"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="loginBtn" value="로그인">
					<c:if test="${msg=='failure' }">
						<div style="color:red;">
							아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${msg=='logout' }">
						<div style="color:red;">
							로그아웃되었습니다.
						</div>
					</c:if>
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>