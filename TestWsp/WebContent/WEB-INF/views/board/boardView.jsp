<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${contextPath}/resources/css/board/boardView.css">

</head>
<body>
    <c:set var="contextPath" scope="application" value="${pageContext.servletContext.contextPath}"></c:set>
    
    <!-- 추후 session의 member로 변경 필요 -->
    <c:set var="member" value="22"/>
    
    <jsp:include page="../common/header.jsp"></jsp:include>

    <h1>자유게시판</h1>  

    <div id="board-view">

        <div id="titleReport">
            <h2 id="board-title">${board.boardTitle}</h2>
             <!-- 로그인이 되어있고 글 작성자가 아닌 경우 -->       
            <button type="button" id="boardReportBtn">신고하기</button>
        </div>

        
        
        <div id="board-info">
            <div id="board-box1">
                <span>${board.memberId}</span> 
            </div>
            <div id="board-box2">
                <span>
                	작성일 : <fmt:formatDate value="${board.boardCreateDate}" pattern="yyyy년 MM월 dd일HH:mm:ss"/>
                	<br>
                	수정일 : <fmt:formatDate value="${board.boardModifyDate}" pattern="yyyy년 MM월 dd일HH:mm:ss"/>
                </span> 
                 
                <span>조회수 : ${board.readCount}</span> 
            </div>
        </div>

        <div id="board-content">
            <h3>${board.categoryName}</h3>
            ${board.boardContent}               
        </div>
        <br>
        <br>
        
        
        <!-- 로그인 한 상태고 자신의 글이 아닐 시에만  -->
        <div id="like-area">					
						<c:if test="${likeInfo.boardNo == board.boardNo && likeInfo.memberNo == member}">
								<i id="like-btn" class="fas fa-heart">&nbsp;${board.likeCount}</i>
						</c:if>
						
						<c:if test="${likeInfo.boardNo != board.boardNo || likeInfo.memberNo != member}">
								<i id="like-btn" class="far fa-heart">&nbsp;${board.likeCount}</i>
						</c:if>
						
        </div>
        
        
        
				<jsp:include page="comment.jsp"></jsp:include>
    
    <button type="button" id="back-board-main" onclick="location.href='list.do?cp=${param.cp}'">목록으로</button>	
		<%-- 로그인된 회원과 해당 글 작성자가 같은 경우--%>
<%-- 		<c:if test="${!empty loginMember && (board.memberId == loginMember.memberId)}"> --%>
			<button id="deleteBtn">삭제</button> 
			
			<%-- 게시글 수정 후 상세조회 페이지로 돌아오기 위한 url 조합 --%>
			<%-- 검색된 내용 들어온 상세 조회 페이지인 경우 --%>
<%-- 			<c:if test="${!empty param.sk && !empty param.sv}">		 --%>		
				<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}" />
<%-- 			</c:if>	 --%>
			<button type="button" id="updateBtn" onclick="location.href = 'updateBoardForm.do?cp=${param.cp}&no=${param.no}${searchStr}'">수정</button>
<%-- 		</c:if>  --%>     
      			
    </div>
    	
  

		<jsp:include page="../common/footer.jsp"></jsp:include>

    <script>
			$("#deleteBtn").on("click", function(){
				if(window.confirm("게시글을 삭제 하시겠습니까?")) {
					location.href = "deleteBoard.do?no=${board.boardNo}";
				}
				
			});
			
			
  		$("#boardReportBtn").on("click", function() {
				if(window.confirm("보고 있는 게시글을 신고하시겠습니까?")) {
					/* $(board.memberId); */
					var memberId = 3;
					var boardNo = ${board.boardNo};
					
					var url = "${contextPath}/boardReportForm.do?brdNo=" + boardNo + "&memNo=" + memberId;
					var title = "신고하기";
					var option = "width = 700, height = 400, top = 300, left = 600, location = no";
					
					window.open(url, title, option);
				}
			});  
  		
  		
  		
			var boardNo = ${board.boardNo};
			var memberNo = ${member}; // memberNo로 변경 필요
			var likeCount = ${board.likeCount};
			
			var i;
  		
			$(document).on("click","#like-btn",function(){
  		//$("#like-btn").on("click", function() {			
    		$.ajax({   			
    			url : "${contextPath}/board/boardLike.do",
    			data : {"boardNo" : boardNo,
    							"memberNo" : memberNo,
    							"likeCount" : likeCount}, 
					success : function(likeFlag) {
						
						$("#like-area").html("");
						
						if(likeFlag == 1) {		
								i = $("<i>").addClass("fas fa-heart").attr("id", "like-btn");
								likeCount = likeCount + 1;
								$("#like-area").append(i).append("&nbsp;").append(likeCount);
								
						} else if(likeFlag == 0) {
								i = $("<i>").addClass("far fa-heart").attr("id", "like-btn");
								if(likeCount > 0) {
									likeCount = likeCount - 1;
								}							
								$("#like-area").append(i).append("&nbsp;").append(likeCount);
						}
						
						
					}, 
      		error : function(request, status, error) {
       	      alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
       		}    										
    		});   		
  		});
  				
	 </script>


</body>
</html>