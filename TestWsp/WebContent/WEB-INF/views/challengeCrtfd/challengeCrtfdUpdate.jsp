<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 인증 수정 페이지</title>
<link rel="stylesheet" href="resources/css/ch_cr_update.css" type="text/css">
</head>
<body>
	<!-- 첨부파일과 소감작성만 수정가능 -->
	
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">
		<h2>챌린지 인증 수정하기</h2>
		<hr>
		
		<form action="#">
			<!-- 개설 정보 입력 -->
			<div class="input">
			
				<div class="input-top-margin">
					<label class="input-area">챌린지</label>
					하루에 한번 물 마시기  2020.12.1 ~ 2020.12.31
				</div>	
				
				<div class="input-top-margin">
					<label  class="input-area">작성자 </label>
					작성자 이름
				</div>
				
				<div class="input-top-margin">
					<label class="input-area">작성일</label>
					날짜 2021-01-14 1:05 
				</div>
			
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
				<div class="input-top-margin">오늘의 참가 소감 작성</div>
				<textarea class="form-control" id="boardContent" name="boardContent" rows="20" style="resize: none;"></textarea>
				
			</div>
			
			<hr>
			
			<!-- 수정, 이전으로 버튼 -->
			<div class="text-center">
				<button type="submit" class="btn">수정</button>
				<button type="button" class="btn" onclick="location.href='challengeCrtfdList.jsp'">목록</button>
			</div>
			
		</form>
	</div>








	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    

</body>
</html>