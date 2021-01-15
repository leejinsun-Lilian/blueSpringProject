<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 조회</title>
<link rel="stylesheet" href="resources/css/no_view.css" type="text/css">
</head>
<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	
	<div class="wrapper">
		<h2>공지사항</h2>
		<hr>
		
		<div class="input">
			
			<div class="one">
				<div class="writer">작성자
					<span>user01</span>
				</div>
				
				<div class="writer-dt">작성일
					<span>2021-01-15 19:53</span>
				</div>
				
				<div class="lokup">조회수
					<span>5</span>
				</div>
			</div>
			
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
 			
 			<!-- 내용 부분 -->
			<div class="introduce">내용들어갈 부분</div>
				
		</div>

		<hr>

		<!-- 목록, 수정, 삭제  버튼 -->
		<div class="text-center">
			<button id="deleteBtn" class="btn">삭제</button>
			<a href="#" class="btn btn-update">수정</a>
			<a href="#" class="btn btn-update" onclick="location.href='noticeList.jsp'">목록</a>
		</div>

		
	</div>
	
	
	


	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    

</body>
</html>