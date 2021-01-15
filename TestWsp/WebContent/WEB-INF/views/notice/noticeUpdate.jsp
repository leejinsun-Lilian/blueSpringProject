<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사할 글 작성</title>
<link rel="stylesheet" href="resources/css/no_insert.css" type="text/css">
</head>
<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	
	<div class="wrapper">
		
		<h2>공지사항 작성</h2>
		<hr>
		
		<!-- 조금 안으로 들여쓰기 위해서  -->
		<div class="input">
			
			<!-- 제목 -->		
			<label class="input-area">제목</label>
			<input type="text" class="title-input" value="">
											<!-- value=""   에   el로 저장되어있던 값을 가져온다 --> 
												
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
			<!-- 파일 업로드 부분 -->
		
			<div>내용</div>
			<textarea class="form-control" id="boardContent" name="boardContent" rows="15" style="resize: none;">
			<%-- ${} --%>
			</textarea>


		</div>
	
		<hr>
		
		<!-- 수정, 이전으로 버튼 -->
		<div class="text-center">
			<button type="submit" class="btn">수정</button>
			<button type="button" class="btn" onclick="location.href='noticeList.jsp'">목록</button>
		</div>

	</div>



 	

	
	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    

</body>
</html>