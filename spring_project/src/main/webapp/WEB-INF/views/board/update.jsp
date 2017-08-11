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
/*             var writer = $("#writer").val(); */
            if(title == ""){
                alert("제목을 입력하세요");
                $("#title").focus();
                return;
            }
            if(content == ""){
                alert("내용을 입력하세요");
                $("#content").focus();
                return;
            }
/*             if(writer == ""){
                alert("이름을 입력하세요");
                $("#writer").focus();
                return;
            } */
            $("form").attr("action","${path}/updateProc.do");
            $("form").submit();
        });
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<c:import url="header.jsp"/>
	<h2>게시글 수정</h2>
	<form method="post">
	    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
	        작성일자 : <fmt:formatDate value="${upt.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
	                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
	    </div>
	    <div>
	        조회수 : ${upt.readCnt}
	    </div>
	    <div>
	        제목
	        <input name="title" id="title" size="80" value="${upt.title}" placeholder="제목을 입력해주세요">
	    </div>
	    <div>
	        내용
	        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">${upt.content}</textarea>
	    </div>
<%-- 	    <div>
	        이름
	        <input name="writer" id="writer" value="${upt.writer}" placeholder="이름을 입력해주세요">
	    </div> --%>
	    <div style="width:650px; text-align: center;">
	        <!-- 게시물번호를 hidden으로 처리 -->
	        <input type="hidden" name="no" value="${upt.no}">
	        <button type="button" id="saveBtn">완료</button>
	        <button type="reset">다시작성</button>
	    </div>
	</form>
</body>
</html>