<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 상세 조회 페이지</title>
<link rel="stylesheet" href="${contextPath}/resources/css/challenge/ch_view.css" type="text/css">
</head>

<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">

		<h2>챌린지</h2>
		<hr>


		<!-- 개설 정보 입력 -->
		<div class="input">
			<label class="input-area">제목 </label> 
			<span class="input-area2">${challenge.chlngTitle}</span>
			<div class="writer">
				<label class="input-area">작성자 </label>${challenge.memNickname}
			</div>

			<br>
			<br> 
			<label class="input-area">기간</label> 
			<span class="input-area2">
				<fmt:formatDate var="startDate" value="${challenge.chlngStartDt}" pattern="yyyy-MM-dd"  />
				${startDate}
				&nbsp;&nbsp;~&nbsp;&nbsp;
				<fmt:formatDate var="endDate" value="${challenge.chlngEndDt}" pattern="yyyy-MM-dd"  />
				${endDate}
			</span>


			<div class="health">
				<label class="input-area">카테고리</label>${challenge.chlngCateNm}
			</div>

			<br>
			<br>
			
 			<!-- 이미지 출력 -->
			<c:if test="${!empty fList}">
				<!-- 이미지가 없으면 그 슬라이드 공간을 차지하지 않음 -->
				
					<div>
						<c:forEach var="file" items="${fList}" varStatus="vs">
							<div class="imgFile" align="center">
								<img class="d-block w-100 chImg" id="${file.fileNo}" 
											src="${contextPath}/resources/uploadImages/challenge/${file.fileName}">
							</div>
						</c:forEach>
					</div>
				
			</c:if> 




			<div class="rule-area">
				 ${challenge.chlngContent}
			</div>

			<br>

			<!-- <div class="introduce">내용들어갈 부분</div> -->
			
		</div>

		<hr>
		
		<!-- 로그인한 회원이 글 작성자면 버튼 보이게 -->

		<!-- 목록, 수정, 삭제  버튼 -->    <!-- !~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!멤버아이디     !!!!버튼  -->
		<div class="text-center">
			<c:if test="${!empty loginMember && (challenge.memberId == loginMember.memberId) }">
				<button id="deleteBtn" class="btn">삭제</button>
				
				<c:if test="${!empty param.sv && !empty param.sk && !empty param.cn && !empty param.sort}">
					<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}&cn=${param.cn}&sort=${param.sort}" />
				</c:if>
				
				<a href="updateForm.do?cp=${param.cp}&no=${param.no}${searchStr}&cn=${param.cn}$sort=${param.sort}" class="btn btn-update">수정</a>
			</c:if>
			
			
			<!-- 목록 버튼 -->
			<c:choose>
				<c:when test="${!empty param.sk && !empty param.sv }">
					<c:url var="goToList" value="../challengeSearch.do">
						<c:param name="cp">${param.cp}</c:param>
						<c:param name="sk">${param.sk}</c:param>
						<c:param name="sv">${param.sv}</c:param>
						<%-- <c:param name="cn">${param.cn}</c:param>
						<c:param name="sort">${param.sort}</c:param> --%>
					</c:url>
				</c:when>
				
				<%-- <c:otherwise test="${!empty param.cn && !empty param.sort}" > 
					<c:url var="goToList" value="../challengeCategorySearch.do">
				
						<c:param name="cn">${param.cn}</c:param>
					</c:url>
				
				</c:otherwise> --%>
				
				
				<c:otherwise>
					<c:url var="goToList" value="list.do">  <!-- 상대경로 방식 -->
						<c:param name="cp">${param.cp}</c:param>
					</c:url>
				</c:otherwise>
				
				
			</c:choose>
			
			<c:if test="${!empty param.cn}">
				<c:set var="goToList" value="${goToList}&cn=${param.cn}" />
			</c:if>
			
			<c:if test="${!empty param.sort}">
				<c:set var="goToList" value="${goToList}&sort=${param.sort}" />
			</c:if>
			
			<a href="${goToList}" class="btn btn-update">목록</a>
		</div>


	</div>

	<!-- 푸터 영역 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>



	<script>
	$("#deleteBtn").on("click", function(){                     // window.confirm 윈도우에서 제공하는 내장객체
		
		if(window.confirm("정말 삭제 하시겠습니까?")){
			location.href = "delete.do?no=${challenge.chlngNo}";
		}
		
	});
	
	var chlngeWriter = '${challenge.memberId}';
	var memberId = '${loginMember.memberId}';
	var chlngNo = ${challenge.chlngNo};
	var memberNo = ${loginMember.memberNo}; 
	var likeCount = ${challenge.likeCount};
	
	var i;
	
	// 좋아요
	$(document).on("click","#like-btn",function(){
				//console.log(chlngeWriter);
				//console.log(memberId);
				if(chlngeWriter != memberId) {
					$.ajax({   			
		    			url : "${contextPath}/challenge/list.do",
		    			data : {"chlngNo" : chlngNo,
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
				}   		
  		});
    
    	
    </script>
</body>
</html>