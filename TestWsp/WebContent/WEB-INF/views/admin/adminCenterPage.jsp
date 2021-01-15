<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기관 상세 페이지</title>
    <style>
    .admin_content { 
        width: 70%; 
        height: 100%;
        margin: auto;
    }
    .centerPage_category { 
        width: 100%;
        height: 10%;
        font-weight: bold;
    }
    .centerPage_title{
        border-top: 2px solid gray;
        border-bottom : 2px solid gray;
        width: 100%;
        height: 30%;
    }
    .centerPage_content{
        width: 100%;
        height: 60%;
    }
	</style>
</head>
<body>
    <div class="wrapper">
    	<jsp:include page="../common/header.jsp"></jsp:include>

        <div class="admin_content">
            <div class="centerPage_view">
                <div class="centerPage_category">
                    <p>상담센터</p>
                </div>
                <div class="centerPage_title">
                    <p>강남구정신건강복지센터</p>
                </div>
                <div class="centerPage_content">
                    <p></p>
                    지역(시/도) : 서울특별시<br>
                    지역(구/군) : 강남구<br>
                    전화번호 : 02-2226-0344<br>
                    홈페이지 : #<br>
                    상세주소: 서울특별시 강남구 일원로9길 38, 3층(일원동)<br>
                </div>
            </div>
        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>