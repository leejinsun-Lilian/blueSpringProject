<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 인증하기 상세</title>
<link rel="stylesheet" href="resources/css/ch_cr_view.css" type="text/css">
</head>
<body>

	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">
		<h2>챌린지 인증</h2>
		<hr>

		
			<!-- 개설 정보 입력 -->
			<div class="input">

				<div class="one">
					<!-- 챌린지 이름 -->
					<label class="input-area">챌린지</label>
					<span class="input-area2">하루에 한번 물 마시기  2020.12.1 ~ 2020.12.31</span>
					<!--DB에서 회원이 참여하고 있는 챌린지들은 가져온다 -->
					<!-- 된다면 첼린지 제목 / 시작일 ~ 끝나는 날 -->
					<div class="lokup">
						<label class="input-area">조회수</label> 5
					</div>
				</div>

				
				<div class="one">
					<!-- 작성자 -->
					<label class="input-area">작성자</label> 
					<span class="input-area2">user01</span>
		
		
					<div class="cate">
						<label class="input-area">카테고리</label> 건강
					</div>
				</div>

				<!-- -------------------------------------------------- -->

				<div class="input-top-margin">
					<label class="input-area">작성일</label> 날짜 2021-01-14 1:05
				</div>
				
				
				
				<!-- 파일 가져오기 -->

				<!-- 파일 업로드 -->
				<div class="input-top-margin">
					<div class="form-line">
						<label>인증 사진 파일</label>
						<div class="ch-c-board-Img" id="titleImgArea">
							<img id="titleImg" width="350px" height="250px">
						</div>
					</div>
				</div>

				<!-- 참가 소감 작성 -->
				<div class="introduce">오늘의 참가 소감 작성</div>
				


			</div>

			<hr>

			<!-- 목록, 수정, 삭제  버튼 -->
			<div class="text-center">
				<button id="deleteBtn" class="btn">삭제</button>
				<a href="#" class="btn btn-update">수정</a>
				<a href="#" class="btn btn-update" onclick="location.href='challengeCrtfdList.jsp'">목록</a>
			</div>

		
	</div>








	<!-- 푸터 영역 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>


</body>
</html>