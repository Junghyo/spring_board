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
		$("#writeBtn").click(function(){
			var session = "${sessionScope.name}";
			if(session == null || session == ""){
				alert("로그인 하세요");
			}else{
				$(location).attr("href","${path}/insert.do");
			}
		});
	});
	function list(page){
		$(location).attr("href", "${path}/list.do?curPage="+page+"&option=${map.option}"+"&keyword=${map.keyword}");
	}
</script>
<style type="text/css">
	h2{text-align:center;}
</style>
</head>
<body>
	<c:import url="header.jsp"/>
	<h2>게시글 목록</h2>
	<form method="post" action="${path }/list.do">
		<select name="option">
			<option value="all" <c:out value="${map.option=='all'?'selected':'' }"/>>제목+이름+내용</option>
			<option value="title" <c:out value="${map.option=='title'?'selected':'' }"/>>제목</option>
			<option value="writer" <c:out value="${map.option=='writer'?'selected':'' }"/>>작성자</option>
			<option value="content" <c:out value="${map.option=='content'?'selected':'' }"/>>내용</option>
		</select>
		<input name="keyword" value="${map.keyword }">
		<input type="submit" value="조회">
		<input type="button" id="writeBtn" value="글쓰기"/>
	</form>
	${map.count }개의 게시물이 있습니다.
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${map.list }">
			<tr>
				<td>${board.no }</td>
				<td>
					<a href="${path }/read.do?no=${board.no}&curPage=${map.boardPage.curPage}&option=${map.option}&keyword=${map.keyword}">${board.title }</a>
					<c:if test="${board.recnt > 0 }">
						<span style="color:red;">(${board.recnt })</span>
					</c:if>
				</td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${board.readCnt }</td>
			</tr>
		</c:forEach>
		<c:if test="${map.list.size()==0 }">
			<tr>
				<td colspan="5">작성된 글이 없습니다!!</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="5">
				<c:if test="${map.boardPage.curPage > 1 }">
					<a href="javascript:list('1')">[처음]</a>				
				</c:if>
				<c:if test="${map.boardPage.curBlock > 1 }">
					<a href="javacript:list('${map.boardPage.prePage }')">[이전]</a>
				</c:if>
				<c:forEach var="num" begin="${map.boardPage.blockStart }" end="${map.boardPage.blockEnd }">
					<c:choose>
						<c:when test="${num == map.boardPage.curPage }">
							<span style="color:red;">${num }</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:list('${num }')">${num }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${map.boardPage.curBlock <= map.boardPage.totBlock }">
					<a href="javascript:list('${map.boardPage.nextPage }')">[다음]</a>
				</c:if>
				<c:if test="${map.boardPage.curPage <= map.boardPage.totPage }">
					<a href="javascript:list('${map.boardPage.totPage }')">[끝]</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>