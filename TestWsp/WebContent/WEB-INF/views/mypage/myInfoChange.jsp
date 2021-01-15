<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 회원 정보 수정</title>

<link href="${contextPath}/resources/css/mypage/myInfoChange.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<jsp:include page="../common/mypageSideMenu.jsp"></jsp:include>
			<div class="content">
			<form action="#" method="post" id="changeForm">
				<div class="changeWrap">
					<h3>내 정보 수정</h3>
					<hr>
					<div class="group">
						<div class="text_area">
							<span>아이디</span>
						</div>
						<div class="input_area readonly_area">
							<input type="text" id="changeId" name="changeId" readonly> 
						</div>
					</div>
					<hr>
					
					<div class="group">
						<div class="text_area">
							<label for="changeNickName"><span>닉네임</span></label>
						</div>
						<div class="input_area">
							<input type="text" id="changeNickName" name="changeNickName"> 
						</div>
						<div class="error_area">
							<span id="error_nickName">test</span>
						</div>
					</div>
					<hr>
					
					<div class="group">
						<div class="text_area">
							<span>비밀번호</span>
						</div>
						<div class="input_area" style="border:0;">
							<button type="button" class="pwChangeBtn" id="pwBtn" 
								onclick="location.href='${contextPath}/mypage/changePw.do'">
								비밀번호 변경
							</button>
						</div>
					</div>
					<hr>

						<div class="group">
							<div class="text_area" style="float: left;">
								<span>주소</span>
							</div>
							<div class="address_wrap">
								<div class="row mb-3 form-row">
									<div class="col-md-3">
										<label for="postcodify_search_button">우편번호</label>
									</div>
									<div class="col-md-3" style="float: left;">
										<input type="text" name="post"
											class="form-control postcodify_postcode5">
									</div>
									<div class="col-md-3">
										<!-- postcodify_search_button 복사 후 js 파일에 붙여넣기 -->
										<button type="button" class="btn btn-primary"
											id="postcodify_search_button">검색</button>
									</div>
								</div>


								<div class="row mb-3 form-row">
									<div class="col-md-3">
										<label for="address1">도로명 주소</label>
									</div>
									<div class="col-md-9">
										<input type="text" class="form-control postcodify_address"
											name="address1" id="address1">
									</div>
								</div>

								<div class="row mb-3 form-row">
									<div class="col-md-3">
										<label for="address2">상세주소</label>
									</div>
									<div class="col-md-9">
										<input type="text" class="form-control postcodify_details"
											name="address2" id="address2">
									</div>
								</div>
							</div>
						</div>
						<hr>

						<div class="group">
							<div class="text_area">
								<span>이름</span>
							</div>
							<div class="input_area readonly_area">
								<input type="text" id="changeName" name="changeName" readonly>
							</div>
						</div>
						<hr>


						<div class="group">
							<div class="text_area">
								<span>이메일</span>
							</div>
							<div class="input_area readonly_area">
								<input type="text" id="changeEmail" name="changeEmail" readonly>
							</div>
						</div>
						<hr>

						<div class="group">
							<div class="text_area">
								<span>생년월일</span>
							</div>
							<div class="input_area readonly_area">
								<input type="text" id="changeBirth" name="changeBirth" readonly>
							</div>
						</div>
						<hr>

						<div class="group">
							<div class="text_area">
								<span>성별</span>
							</div>
							<div class="input_area readonly_area">
								<input type="text" id="changeGender" name="changeGender" readonly>
							</div>
						</div>
						<hr>

						<div class="group">
							<div class="text_area">
								<span>휴대전화</span>
							</div>
							<div class="input_area">
								<input type="text" id="changeTel" name="changeTel" placeholder='"-"포함 번호를 입력하세요.'>
							</div>
						</div>
						<hr>
					</div>
					<button type="submit" class="btn submitBtn">완료</button>
					
			</form>
			
			</div>

		</div>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>