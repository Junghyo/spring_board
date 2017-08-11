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
		listReply("1");
		
		$("#listBtn").click(function(){
			$(location).attr("href","${path}/list.do");
		});
		$("#uptBtn").click(function(){
			$(location).attr("href","${path}/update.do?no=${article.no}");
		});
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				$("form").attr("action","${path}/delete.do");
				$("form").submit();
			}
		});
		$("#replyBtn").click(function(){
			var replytext = $("#replytext").val();
			var no = "${article.no}";
			var secret = "n";
			if($("#secret").is(":checked")){
				secret = "y";
			}
			var param = "replytext="+replytext+"&no="+no+"&secret="+secret;
			$.ajax({
				type: "post",
				url: "${path}/reply/insert.do",
				data: param,
				success: function(){
					alert("댓글이 등록되었습니다.");
					listReply("1");
				}
			});
		});
	});
	
 	function listReply(num){
		$.ajax({
			type: "get",
			url: "${path}/reply/list.do?no=${article.no}&curPage="+num,
			success: function(result){
				$("#listReply").html(result);
			}
		});
	} 
	
	function listReply2(){
		$.ajax({
			type: "get",
			url: "${path}/reply/listJson.do?no=${article.no}",
			success: function(result){
				console.log(result);
				var output = "<table>";
				for(var i in result){
					output+= "<tr>";
					output+= "<td>"+result[i].name;
					output+= "("+changeDate(result[i].regdate)+")<br>";
					output+= result[i].replytext+"</td>";
					output+= "</tr>";
				}
				output+= "</table>";
				$("#listReply").html(output);			
			}
		});
	}
	
	function changeDate(date){
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		return strDate;
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<c:import url="header.jsp"/>
	<h2>게시글보기</h2>
	<form method="post">
		<div>
			작성일자 : <fmt:formatDate value="${article.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</div>
		<div>
			조회수 : ${article.readCnt }<br>
			이름 : ${article.writer }
		</div>
		<div>
			제목 : ${article.title }
		</div>
		<div>
			내용
			<textarea rows="4" cols="80" readonly="readonly">${article.content }</textarea>
		</div>
		<div style="width:650px; text-align:center;">
			<input type="hidden" name="no" value="${article.no }"/>
			<c:if test="${sessionScope.name == article.writer }">
				<input type="button" id="uptBtn" value="수정"/>
				<input type="button" id="delBtn" value="삭제"/>
			</c:if>
			<input type="button" id="listBtn" value="목록"/>
		</div>
	</form>
	<div>
		<br>
		<c:if test="${sessionScope.id!=null}">
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해주세요."></textarea>
			<br>
			<input type="checkbox" id="secret"/>비밀댓글
			<input type="button" id="replyBtn" value="댓글 작성"/>
		</c:if>
	</div>
	<div id="listReply"></div>
</body>
</html>