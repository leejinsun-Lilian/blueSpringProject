<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 회원가입</title>

<link href="${contextPath}/resources/css/signUp.css" rel="stylesheet" type="text/css">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<jsp:include page="../common/login_header.jsp"></jsp:include>
		
		
		<div id="container">
			<form id="signUp" method="post" action="#">
				<div id="content">
					<div id="signUp_form">
						<!-- 아이디 -->
						<div class="row_group">
							<span class="signUp_text">
								<label for="id" style="margin-bottom: 5px;">아이디</label>
							</span>
							<span class="sign_input input_id">
								<input type="text" id="id" name="id" class="signUp_int" maxlength="20" required>
							</span>
							<span class="error_area" id="idMsg">test</span>
						</div>
						
						<!-- 닉네임  -->
						<div class="row_group">
							<span class="signUp_text"> 
								<label for="nickName" style="margin-bottom: 5px;">닉네임</label>
							</span> 
							<span class="sign_input input_nickName"> 
							<input type="text" id="nickName" name="nickName" class="signUp_int" maxlength="20" required>
							</span> 
							<span class="error_area" id="nickNameMsg">test</span>
						</div>
						
						
						<!-- 비밀번호 -->
						<div class="row_group">
							<span class="signUp_text"> 
								<label for="pswd1" style="margin-bottom: 5px;">비밀번호</label>
							</span> 
							<span class="sign_input input_pswd1"> 
							<input type="text" id="pswd1" name="pswd1" class="signUp_int" maxlength="20" required>
							</span> 
							<span class="error_area" id="pswd1Msg">test</span>
						</div>

						<!-- 비밀번호  확인-->
						<div class="row_group">
							<span class="signUp_text"> 
								<label for="pswd2" style="margin-bottom: 5px;">비밀번호 확인</label>
							</span> 
							<span class="sign_input input_pswd2"> 
								<input type="text" id="pswd2" name="pswd2" class="signUp_int" maxlength="20" required>
							</span> 
							<span class="error_area" id="pswd2Msg">test</span>
						</div>
						
						<!-- 이름  -->
						<div class="row_group">
							<span class="signUp_text"> 
								<label for="name" style="margin-bottom: 5px;">이름</label>
							</span> 
							<span class="sign_input input_name"> 
							<input type="text" id="name" name="name" class="signUp_int" maxlength="40" required>
							</span> 
							<span class="error_area" id="nameMsg">test</span>
						</div>
						

						
						<!-- 주소  -->
						<!-- 오픈소스 도로명 주소 API -->
						<!-- https://www.poesis.org/postcodify/ -->
						<div class="row_group">
							<span class="signUp_text"> 
									<label for="address" style="margin-bottom: 5px;">주소</label>
							</span> 
												<div class="row mb-3 form-row">
							<div class="col-md-3" id="addr1_1">
								<label for="postcodify_search_button">우편번호</label>
							</div>
							<div class="col-md-3" id="addr1_2">
								<input type="text" name="post" class="form-control postcodify_postcode5" required>
							</div>
							<div class="col-md-3" id="addr1_3">
																				<!-- postcodify_search_button 복사 후 js 파일에 붙여넣기 -->
								<button type="button" class="btn btn-primary" id="postcodify_search_button"
									>검색</button>
							</div>
						</div>
	
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="address1">도로명 주소</label>
							</div>
							<div class="col-md-9">
								<input type="text" class="form-control postcodify_address" name="address1" id="address1" required>
							</div>
						</div>
	
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="address2">상세주소</label>
							</div>
							<div class="col-md-9">
								<input type="text" class="form-control postcodify_details" name="address2" id="address2" required>
							</div>
						</div>
						<span class="error_area" id="addressMsg">test</span>
					</div>	
					
					
					
					<!-- 생년월일  -->
					<div class="row_group">
						<span class="signUp_text"> 
							<label for="birthday" style="margin-bottom: 5px;">생년월일</label>
						</span>
						<div class="birthday_area">
							<div class="birthday_yy">
								<span class="sign_input">
									<input type="text" id="birth_yy" class="signUp_int" maxlength="4" required>
								</span>
							</div>
							
							<div class="birthday_mm">
								<span class="sign_input">
									<select id="birth_mm" class="sel" required>
										<option hidden="true">월</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select>
								</span>							
							</div>
							
							<div class="birthday_dd">
								<span class="sign_input">
									<input type="text" id="birth_mm" class="signUp_int" maxlength="2" required>
								</span>
							</div>
							
						</div>
							<span class="error_area" id="birthdayMsg">test</span>	
					</div>
					
					
					<!-- 성별 -->
					<div class="row_group">
						<span class="signUp_text"> 
							<label for="gender" style="margin-bottom: 5px;">성별</label>
						</span> 
						<span class="sign_input input_gender"> 
							<select id="gender" class="sel" required>
							<option hidden="true">성별</option>
							<option value="M">남자</option>
							<option value="F">여자</option>
							<option value="U">선택안함</option>
						</select>
						</span> 
						<span class="error_area" id="genderMsg">test</span>
					</div>
				
					<!-- 휴대전화  -->
					<div class="row_group">
						<span class="signUp_text"> 
							<label for="phone" style="margin-bottom: 5px;">휴대전화</label>
						</span> 
						<span class="sign_input input_phone"> 
						<input type="tel" id="phone" name="phone" class="signUp_int" maxlength="40" required placeholder='"-"를 포함해서 입력해주세요.'>
						</span> 
						<span class="error_area" id="phoneeMsg">test</span>
					</div>
					
					<!-- 이메일  -->
					<div class="row_group">
						<span class="signUp_text">
							<label for="email" stype="margin-bottom : 5px;">이메일</label>
						</span>
						<div id="emailForm">
							<div class="emailForm" id="fEmail">
								<span class="sign_input input_email">
									<input type="text" id="email_id" name="email_id" class="signUp_int" required>
								</span> 
							</div>
							
							<div class="emailForm" id="sEmail">
								<span id="email_at">@</span>
							</div>
							
							<div class="emailForm" id="tEmail">
								<span class="sign_input input_email" id="email_addr" name="email_addr" class="signUp_int">
									<select id="email_sel" class="sel" required>
									<option hidden="true">선택</option>
									<option value="naver.com">naver.com</option>
									<option value="gmail.com">gmail.com</option>
									<option value="daum.net">daum.net</option>
									<option value="nate.com">nate.com</option>
									<option value="self">직접 입력</option>
									</select>
								</span>
							</div>
						</div>
						<div id="cNumForm">
							<div class="cNumRow">
								<span id="cNum_area" class="sign_input input_email">
									<input type="text" id="cNum" name="cNum" class="sign_input input_email"
										maxlength="6" required>
								</span>
							</div>
							<div class="cNumRow">
								<span id="email_btn_area" class="sign_input input_email">
									<button type="button" id="email_btn" class="btn">인증번호 받기</button>
								</span>
							</div>
						</div>
						<span class="error_area" id="phoneeMsg">test</span>
					</div>
					
					
					<!-- 가입하기 버튼 -->
					<div class="btn_area">
						<button type="sumbit" id="signBtn" class="btn">가입하기</button>
					</div>
					
					
					
					</div>
				
				</div>
			
			</form>
		</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	
	
	
</body>
</html>