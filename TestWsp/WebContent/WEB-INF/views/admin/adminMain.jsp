<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인 페이지</title>
	<style>
    .admin_content{ 
        width: 70%;
        height: 100%;
        margin: auto;
    }

    .admin_title{
        font-size: 25px;
        color:rgb(40, 62, 105);
        text-align: center;
    }
	</style>
</head>
<body>
    <div class="admin_wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		  <div class="admin_content">
				<jsp:include page="../common/adminMenu.jsp"></jsp:include>
             <div class="admin_title">
                <h1>관리자 페이지</h1>
             </div>
				<!-- 안녕하세요 -->

        </div>
		
		<div style="clear: both;"></div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>