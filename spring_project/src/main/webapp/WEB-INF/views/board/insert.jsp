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
		$("#saveBtn").click(function(){
			var title = $("#title").val();
			var content = $("#content").val();
			var writer = $("#writer").val();
			if(title==""){
				alert("제목을 입력하세요");
				$(this).focus();
				return;
			}
			if(content==""){
				alert("내용을 입력하세요");
				$(this).focus();
				return;
			}
/* 			if(writer==""){
				alert("이름을 입력하세요");
				$(this).focus();
				return;
			} */
			$("form").submit();
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<c:import url="header.jsp"/>
	<h2>게시글 작성</h2>
	<form method="post" action="${path }/insertProc.do">
		<div>
			제목
			<input name="title" id="title" size="80" placeholder="제목을 입력해주세요.">
		</div>
		<div>
			내용
			<textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요."></textarea>
		</div>
<!-- 		<div>
			이름
			<input name="writer" id="writer" placeholder="이름을 입력해주세요.">
		</div> -->
		<div style="width:650px; text-align: center;">
			<input type="button" id="saveBtn" value="확인"/>
			<input type="reset" value="다시작성"/>
		</div>
	</form>
</body>
</html>