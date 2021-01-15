<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${contextPath}/resources/css/board/boardWrite.css">

</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
    
    <h1>자유게시판</h1>

    <div id="write-wrapper">
        <h2>글작성</h2>

        <form action="${contextPath}/board/write.do" method="post" 
				  		enctype="multipart/form-data" role="form" onsubmit="return boardValidate();">
            <div id="title-wrapper">
                <label>글 제목</label> 
                <input id="b-title" name="b-title" type="text"> <br>
            </div>
  
            <div id="category-wrapper">
                <label>카테고리</label>
                <input type="radio" name="b-category" id="info" value="10"> <label class="radio-check">정보</label>
                <input type="radio" name="b-category" id="life" value="20"> <label class="radio-check">일상</label>
                <input type="radio" name="b-category" id="hobby" value="30"> <label class="radio-check">취미</label>
                <input type="radio" name="b-category" id="worry" value="40"> <label class="radio-check">고민</label>
                <input type="radio" name="b-category" id="employ" value="50"> <label class="radio-check">취업</label>
                <input type="radio" name="b-category" id="free" value="60"> <label class="radio-check">자유</label> <br>
            </div>

            <div id="file-wrapper">
                <label>첨부하기</label> <br>
            </div>

            <div id="content-wrapper">
                <label>내용</label> <br>    
                <textarea name="b-content" id="b-content" cols="3000" rows="1000"></textarea> <br>
            </div>

            <button type="submit" id="add-btn">등 록</button>
            <button type="button" id="back-board-main" onclick="location.href='${header.referer}'">목록으로</button>
        </form>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    <script>
	    (function printToday(){
				// 오늘 날짜 출력 
		 		var today = new Date();
				var month = (today.getMonth()+1);
				var date = today.getDate();
		
		  	var str = today.getFullYear() + "-"
		        		+ (month < 10 ? "0"+month : month) + "-"
		        		+ (date < 10 ? "0"+date : date);
				$("#today").html(str);
			})();

			// 유효성 검사 
			function boardValidate() {
				if ($("#boardTitle").val().trim().length == 0) {
					alert("제목을 입력해 주세요.");
					$("#boardTitle").focus();
					return false;
				}
		
				if ($("#boardContent").val().trim().length == 0) {
					alert("내용을 입력해 주세요.");
					$("#boardContent").focus();
					return false;
				}
			}
    </script>

</body>
</html>