<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사할 목록</title>
<link rel="stylesheet" href="${contextPath}/resources/css/no_list.css" type="text/css">
</head>
<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

 	<div class="wrapper">
		<h1>공지사항</h1>

		<!-- 공지사항 글 목록 --> <!-- 번갈아가면서 색깔주는거 나중에 추가하기 -->
		<div class="list-wrapper">
			<table class="table" id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				
				<tbody>
					
					<!-- 조회된 목록이 없을 때   -->
					<!-- <tr>
						<td colspan="5">존재하는 인증글이 없습니다</td>
					</tr> -->
					<tr>   
						<td>112</td>
						<td>제목 출력</td>
						<td>작성자 출력</td>
						<td>5</td>
						<td>날짜 출력</td>
					</tr>
					
				</tbody>
			</table>
		</div>
		
		
		<!-- 관리자일 경우에만 글쓰기 버튼이 보이는거 -->
		<div class="writer-bt">
			<a href="${contextPath}/notice/insert.do" class="btn btn-update">글쓰기</a>
		</div>
		
		
		 <!-- 페이지 번호 목록 -->
        <div class="page-no-area">
			<ul>
				<li><a href="#">&lt;&lt;</a></li>
				<li><a href="#">&lt;</a></li>
			
				<li>
					<a href="#">1</a>
				</li>
			
				<li><a href="#">&gt;</a></li>
				<li><a href="#">&gt;&gt;</a></li>
			</ul>
        </div>
        
        <!-- 검색 -->
        <div class="search">
        	<form class="search-form">
        		<select name="sk" class="s-form-control1">
        			<option>제목</option>
        			<option>작성자</option>
        			<option>내용</option>
        			<option>내용+제목</option>
        		</select>
        		<input type="text" name="sv" class="s-form-control2">
        		<button class="s-form-control3">검색</button> 
        	</form>
        </div>
		
		
		


	</div>

	
	<!-- 푸터 영역 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    

</body>
</html>