<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body {
        background-color: lightgray;
    }

    h1 {
        text-align: center;
    }

    #board-report-area {
        text-align: center;
    }

    #report-form > label{
        display: inline-block;
        width: 19%;
        text-align: center;
    }

    #report-content {
        width: 80%;
        height: 200px;
        margin: auto;
    }

    #btn-area {
        display: flex;
        justify-content: space-around;
    }
    
    .hidden-form {
    		display: none;
    }


</style>

</head>
<body>

    <div id="board-report-area">
        <h1>게시글 신고</h1>
    
        <form action="${contextPath}/boardReport.do" method="get" id="report-form">
            <label><input type="radio" name="reportCategory" value="10">욕설</label>
            <label><input type="radio" name="reportCategory" value="20">광고</label>
            <label><input type="radio" name="reportCategory" value="30">비방</label>
            <label><input type="radio" name="reportCategory" value="40">허위</label>
            <label><input type="radio" name="reportCategory" value="50">기타</label>
            <br>
            <br>
	
						<input type="text" class="hidden-form" name="brdNo" value="${boradNo}"/>
						<input type="text" class="hidden-form" name="memNo" value="${memberId}"/>
						<input type="text" class="hidden-form" name="target" value="${target}"/>

            <textarea name="reportContent" id="report-content"></textarea>
        
            <br>
            <br>

            <div id="btn-area">
                <button>취소</button>
                <input type="submit" value="신고하기"> 
            </div>
            
        </form>
    </div>

<script>
	
</script>

</body>
</html>