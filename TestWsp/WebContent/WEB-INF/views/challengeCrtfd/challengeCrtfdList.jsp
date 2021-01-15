<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 인증 메인 페이지</title>
<link rel="stylesheet" href="resources/css/ch_cr_list.css" type="text/css">
</head>
<body>

	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div class="wrapper">
        
        <div class="ch">
            <div id="ch-a" class="ch-float">
                <h1>챌린져스 인증 게시판</h1>
            </div>
            <div id="ch-s" class="ch-float">
                <ul>  
                    <li><a href="challengeCrtfdInsert.jsp">챌린지 <strong>인증</strong>하러가기 -></a></li>
                </ul>
            </div>
        </div>

        <!-- 카테고리 선택 -->
        <br><br>
        <hr>  <!-- 차후 이미지로 교체 예정  -->
        <div class="cat-area">
            <div class="cat">
                <a id="cat-mg" class="cat-float" href="#">전체</a>
                <a id="cat-mg" class="cat-float" href="#">건강</a>
                <a id="cat-mg" class="cat-float" href="#">관계</a> 
                <a id="cat-mg" class="cat-float" href="#">생활</a> 
                <a id="cat-mg" class="cat-float" href="#">역량</a> 
            </div> 
            <div class="cat-2">
                <a id="cat-mg" class="cat-float" href="#">자산</a> 
                <a id="cat-mg" class="cat-float" href="#">취미</a>
                <a id="cat-mg" class="cat-float" href="#">공부</a>
                <a id="cat-mg" class="cat-float" href="#">돈 관리</a>
                <a id="cat-mg" class="cat-float" href="#">그 외</a>
            </div>
        </div>
            <hr>
        <br>

		<!-- 정렬 -->
		<div class="sort">
			<form action="#" >
				<select name="sk" class="form-control">
					<option value="new">최신순</option>
					<option value="like">조회순</option>
				</select>
			</form>
		</div>

		<!-- 인증 글 목록 --> <!-- 번갈아가면서 색깔주는거 나중에 추가하기 -->
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