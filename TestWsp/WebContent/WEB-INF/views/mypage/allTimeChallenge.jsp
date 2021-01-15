<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 역대 챌린지 조회</title>

<link href="${contextPath}/resources/css/mypage/allTimeChallenge.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
.side
</style>
</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<jsp:include page="../common/sideMenu.jsp"></jsp:include>
			<div class="content">
			<h3>역대 챌린지</h3>
				<div class="cBack">
					<table id="cTable">
						<tr>
							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog.JPG"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>


							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog2.jpg"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>
							
							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog2.jpg"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>
						</tr>
						
						
						
						<tr>
							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog.JPG"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>


							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog2.jpg"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>
							
							<td>
								<div class="cThumbnail_area">
									<img class="cThumbnail" src="${contextPath}/resources/img/dog2.jpg"></img>
								</div>
								<div class="cTitle_area">
									<h4 class="title">강아지 사진 찍기</h4>
								</div>
								<div class="cPeriod_area">
									<span class="period">2021/01/02 - 2021/03/02</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>
						</tr>
						
					</table>
				</div>
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>