<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 등록 페이지</title>
<link rel="stylesheet" href="${contextPath}/resources/css/challenge/ch_insert.css" type="text/css">
</head>

<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">
		
		<h2>챌린지 개설하기</h2>
		<hr>
		
		
		<form action="${contextPath}/challenge">
			<!-- 개설 정보 입력 -->
			<div class="input">
				<label class="input-area">제목</label>
				<input type="text" class="title-input" placeholder="챌린지 제목을 입력해주세요."> <br><br>
				
				<label class="input-area">시작일</label>
				<input type="date" class="date str-date"> 
				
				<label class="input-area">종료일</label>
				<input type="date" class="date end-date"> 
				
				<label class="input-area">카테고리</label>
				<select name="cat" class="ch-cat">
	        			<option>건강</option>
	        			<option>관계</option>
	        			<option>생활</option>
	        			<option>역량</option>
	        			<option>자산</option>
	        			<option>취미</option>
	        			<option>공부</option>
	        			<option>돈 관리</option>
	        			<option>그 외</option>
	        	</select>
				
				<br><br>
				
				<!-- 이미지 파일 업로드 -->
				<div class="form-line">
					<label class="title-img">대표 이미지 </label>
					<div class="ch-board-Img" id="titleImgArea">
						<img id="titleImg" width="200" height="200">
					</div>
				</div>
				
				<div class="form-line-sb">
					<label class="t-img">업로드<br>이미지</label>
					<div class="ch-board-Img" id="contentImgArea1">
						<img id="contentImg1" width="150" height="150">
					</div>
	
					<div class="ch-board-Img" id="contentImgArea2">
						<img id="contentImg2" width="150" height="150">
					</div>
				</div>
				
				<div id="fileArea">
					<input type="file" id="img0" name="img0" onchange="LoadImg(this,0)">     
					<input type="file" id="img1" name="img1" onchange="LoadImg(this,1)"> 
					<input type="file" id="img2" name="img2" onchange="LoadImg(this,2)">
				</div>
				
			
				<div class="rule-area">
					<label class="input-area">인증방법</label>
					<input type="text" class="rule-input" placeholder="ex) 매일 아침 8시에 일어나서 세면대에서 손과 함께 찍은 사진을 올려주세요.">
				</div>
				
				<br>
				<div>소개하기</div>
				<textarea class="form-control" id="boardContent" name="boardContent" rows="15" style="resize: none;"></textarea>
			</div>
			
			<hr>
			
			<!-- 완료, 목록 버튼 -->
			<div class="text-center">
				<button type="submit" class="btn">완료</button>
				<button type="button" class="btn" onclick="location.href='challengeList.jsp'">목록</button>
			</div>
		
		</form>
	</div>

	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    
    
    
    <script>
    	// 유효성 검사
    
    	
    </script>
</body>
</html>