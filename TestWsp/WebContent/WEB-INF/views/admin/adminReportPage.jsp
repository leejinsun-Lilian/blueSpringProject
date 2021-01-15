<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신고 접수 상세 페이지</title>
    <style>
    .admin_content { 
        width: 70%; 
        height: 100%;
        margin: auto;
    }
    .reportPage_category { 
        width: 100%;
        height: 10%;
        font-weight: bold;
    }
    .reportPage_title{
        border-top: 2px solid gray;
        border-bottom : 2px solid gray;
        width: 100%;
        height: 30%;
    }
    .reportPage_content{
        width: 100%;
        height: 60%;
    }
	</style>
</head>
<body>
    <div class="wrapper">
    	<jsp:include page="../common/header.jsp"></jsp:include>

        <div class="admin_content">
            <div class="reportPage_view">
                <div class="reportPage_category">
                    <p>[욕설]</p>
                </div>
                <div class="reportPage_title">
                    <p>신고접수 번호 : 3</p>
                    <p>글번호 : 38</p>
                    <p>신고한 회원 : 345</p>
                    <p>신고카테고리 번호 : 3</p>
                </div>
                <div class="reportPage_content">
                        <p>접수 이유:
			                        글번호 - 001 번을 보시면
			                        제 챌린지 글과 자유게시판에 꾸준히 댓글로 욕을 했습니다.
			                        욕설로 신고하오니 빠른 처리 바랍니다.
			                        감사합니다.</p>
                </div>
            </div>
        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>