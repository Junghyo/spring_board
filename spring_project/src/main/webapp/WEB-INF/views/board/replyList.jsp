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

	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<table>
		<c:forEach var="reply" items="${listR }">
			<tr>
				<td>
					${reply.name }(<fmt:formatDate value="${reply.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>)
					<br>
					${reply.replytext }
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${replyPage.curPage >1 }">
					<a href="javascript:listReply('1')">[처음]</a>
				</c:if>
				<c:if test="${replyPage.curBlock >1 }">
					<a href="javascript:listReply('${replyPage.prePage }')">[이전]</a>
				</c:if>
				<c:forEach var="num" begin="${replyPage.blockStart }" end="${replyPage.blockEnd }">
					<c:choose>
						<c:when test="${num == replyPage.curPage }">
							<span style="color:red;">${num }</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:listReply('${num }')">${num }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${replyPage.curBlock <= replyPage.totBlock }">
					<a href="javascript:listReply('${replyPage.nextPage }')">[다음]</a>
				</c:if>
				<c:if test="${replyPage.curPage <= replyPage.totPage }">
					<a href="javascript:listReply('${replyPage.totPage}')">[끝]</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>