<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 조회 페이지</title>
<link rel="stylesheet" href="resources/css/ch_view.css" type="text/css">
</head>

<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">

		<h2>챌린지</h2>
		<hr>


		<!-- 개설 정보 입력 -->
		<div class="input">
			<label class="input-area">제목 </label> <span class="input-area2">제목
				들어갈 부분</span>
			<div class="writer">
				<label class="input-area">작성자 </label> 작성자이름
			</div>

			<br>
			<br> 
			<label class="input-area">시작일</label> 
			<span class="input-area2">2020-12-01 ~ 2020-12-31</span>


			<div class="health">
				<label class="input-area">카테고리</label> 건강
			</div>

			<br>
			<br>

<%-- 		<!-- 이미지 출력 -->
			<c:if test="${!empty fList}">
				<!-- 이미지가 없으면 그 슬라이드 공간을 차지하지 않음 -->
				<div class="carousel slide boardImgArea" id="board-image">
					<!-- 이미지 선택 버튼 -->
					<ol class="carousel-indicators">
						<c:forEach var="file" items="${fList}" varStatus="vs">
							<li data-slide-to="${vs.index}" data-target="#board-image"
								<c:if test="${vs.first}"> class="active" </c:if>></li>
						</c:forEach>
					</ol>

					<!-- 출력되는 이미지 -->
					<div class="carousel-inner active">
						<c:forEach var="file" items="${fList}" varStatus="vs">

							<div class="carousel-item <c:if test="${vs.first}">active</c:if>">
								<img class="d-block w-100 boardImg" id="${file.fileNo}"
									src="${contextPath}/resources/uploadImages/${file.fileName}">
							</div>

						</c:forEach>

					</div>

					<!-- 좌우 화살표 -->
					<a class="carousel-control-prev" href="#board-image"
						data-slide="prev"><span class="carousel-control-prev-icon"></span>
						<span class="sr-only">Previous</span></a> <a
						class="carousel-control-next" href="#board-image"
						data-slide="next"><span class="carousel-control-next-icon"></span>
						<span class="sr-only">Next</span></a>
				</div>
			</c:if>
 --%>





			<div class="rule-area">
				<label class="input-area">인증방법</label> 매일 아침 8시에 일어나서 세면대에서 손과 함께 찍은
				사진을 올려주세요.
			</div>

			<br>

			<div class="introduce">내용들어갈 부분</div>
		</div>

		<hr>

		<!-- 목록, 수정, 삭제  버튼 -->
		<div class="text-center">
			<button id="deleteBtn" class="btn">삭제</button>
			<a href="#" class="btn btn-update">수정</a>
			<a href="#" class="btn btn-update" onclick="location.href='challengeList.jsp'">목록</a>
		</div>


	</div>

	<!-- 푸터 영역 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>



	<script>
    	// 유효성 검사
    
    	
    </script>
</body>
</html>