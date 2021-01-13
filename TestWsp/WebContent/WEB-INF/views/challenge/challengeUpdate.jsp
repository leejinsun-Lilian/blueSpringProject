<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   <!-- 날짜 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 덥데이트 페이지</title>
<link rel="stylesheet" href="resources/css/ch_update.css" type="text/css">
</head>

<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="wrapper">
		
		<h2>챌린지 개설하기</h2>
		<hr>
		
		
		<form action="#">
			<!-- 개설 정보 입력 -->
			<div class="input">
				<label class="input-area">제목</label>
				<input type="text" class="title-input" value=""> <br><br>
				
				<label class="input-area">시작일</label>
				<input type="date" class="date str-date" value=""> 
				
				<label class="input-area">종료일</label>
				<input type="date" class="date end-date" value=""> 
				
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
				
				<!-- 이미지 업로드 부분 업데이트 -->
			
				<div class="rule-area">
					<label class="input-area">인증방법</label>
					<input type="text" class="rule-input"  value="">
				</div>
				
				<br>
				<div>소개하기</div>
				<textarea class="form-control" id="boardContent" name="boardContent" rows="15" style="resize: none;">
				<%-- ${} --%>
				</textarea>
			</div>
			
			<hr>
			
			<!-- 수정, 이전으로 버튼 -->
			<div class="text-center">
				<button type="submit" class="btn">수정</button>
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