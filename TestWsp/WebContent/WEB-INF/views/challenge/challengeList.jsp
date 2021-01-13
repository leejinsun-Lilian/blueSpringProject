<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 메인 페이지</title>
<link rel="stylesheet" href="resources/css/ch_list.css" type="text/css">
</head>

<body>
    <!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div class="wrapper">
        
        <div class="ch">
            <div id="ch-a" class="ch-float">
                <h1>챌린져스</h1>
                <h4>: 작은 습관으로 하루를 바꿔보세요.</h4>
            </div>
            <div id="ch-s" class="ch-float">
                <ul>
                    <li><a href="challengeInsert.jsp">챌린지 <strong>개설</strong>하러 가기 -></a></li>
                    <li><a href="challengeCrtfdList.jsp">챌린지 <strong>인증 게시판</strong> 가기 -></a></li>
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
					<option value="like">좋아요순</option>
				</select>
			</form>
		</div>



		<!-- 챌린지 목록들의 전체 영역 -->
        <div class="ch-sb-aarea">

	        <!-- 1챌린지 선택 --> <!-- 데이터가 있는만큼 보여지기 위해서 데이터가 있는만큼 반복 -->
	        <div class="ch-sb-area">
	            <div class="ch-img">
	                <a href="#"><img src="resources/img/ch_main_like.png" ></a>      <!-- 해당 챌린지 상세페이지로  -->
	            </div>
	
	            <div class="ch-sb">
	
	                <div class="ch-title">예를들어<!-- db에서 제목 가져옴 --></div>
	                <div class="ch-dt"><!-- db에서 시작일 종료일 가져옴 --></div>
	
	                <div class="ch-sh-like">
	                    <div id="like-img" class="ch-s-float" >
	                        <img src="resources/img/ch_main_like.png"  >
	                    </div>
	                    <div id="like" class="ch-s-float">
	                        5<!-- db에서 좋아요 수 가져옴 -->
	                    </div>
	                </div>
	
	            </div>
	        </div>

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