<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신고 접수 상세 페이지</title>
    
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
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

        <div class="admin_content">
            <div class="reportPage_view">
                <div class="reportPage_board">
                <table class="table table-sm">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">신고접수번호</th>
                        <th scope="col">글번호</th>
                        <th scope="col">신고한회원</th>
                        <th scope="col">신고카테고리번호</th>
                        <th scope="col">접수내용</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                    <c:when test="${empty report}">
                        <tr>
                            <td colspan="5">존재하는 정보가 없습니다.</td>
                        </tr>
                    </c:when>
    
                    <c:otherwise>                      
                        <c:forEach var="report" items="${report}">
                            <tr>
                                <th>${report.reportNo}</th>
                                <td>${report.boardNo}</td>
                                <td>${report.memberId}</td>
                                <td>${report.reportCategoryNo}</td>                               
	               				<td>${report.reportContext}</td>
	          				</tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                    </tbody>
                  </table>
            </div>

                </div>
            </div>
    
    <div style="clear: both;"></div>
    </div>
</body>
</html>