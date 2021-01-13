<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 인증 등록 페이지</title>
<link rel="stylesheet" href="resources/css/ch_cr_insert.css" type="text/css">
</head>
<body>

	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">
		<h2>챌린지 인증하기</h2>
		<hr>
		
		<form action="#">
			<!-- 개설 정보 입력 -->
			<div class="input">
			
				<label class="input-area">챌린지 선택</label>
				<select name="cat" class="ch-c-cat">
					<option>DB에서 정보 챌린지 정보 가져올 거</option>
					<!--DB에서 회원이 참여하고 있는 챌린지들은 가져온다 -->
					<!-- 된다면 첼린지 제목 / 시작일 ~ 끝나는 날 -->
				</select>
				
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
			
			<!-- 완료, 목록 버튼 -->
			<div class="text-center">
				<button type="submit" class="btn">완료</button>
				<button type="button" class="btn" onclick="location.href='challengeCrtfdList.jsp'">목록</button>
			</div>
			
		</form>
	</div>








	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    

</body>
</html>