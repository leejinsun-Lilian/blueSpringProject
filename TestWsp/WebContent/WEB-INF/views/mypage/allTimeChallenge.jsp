<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 역대 챌린지 조회</title>

<link href="${contextPath}/resources/css/mypage/allTimeChallenge.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
.page-no-area{
   width: 100%;
   height: 60px;
   margin-top : 20px;
}

.page-no-area ul{  /* 중앙에 두는 방법 */
   width : 70%;
   height : 100%;
   margin : auto;
    text-align: center;
}
.page-no-area ul li{
    border : 1px solid gray;
   width : 7%;
   height : 100%;
    display: inline-block;
    margin-right: -6px;
    list-style-type: none;
    text-align: center;
}
.page-no-area li a{
   width : 100%;
   height : 100%;
    text-decoration: none;
    font-size: 30px;
    color: #3498db;
    line-height: 50px;
    display: block;
}
.page-no-area  a:hover{
   color : #283e69;
   background-color : #dee2e6; 
}
</style>
</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<jsp:include page="../common/mypageSideMenu.jsp"></jsp:include>
			<div class="content">
			<h3>역대 챌린지</h3>
				<div class="cBack">
					<table id="cTable">
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="3"> 참여한 챌린지가 없습니다. </td>
							</tr>
						</c:when>
				
				
				<c:otherwise> 
				<c:forEach var="challenge" items="${list}">
						<tr>
							<td>
								<div class="cThumbnail_area">
								<c:if test="${!empty fList}">
									<c:forEach var="thumbnail" items="${fList}">
										<c:if test="${challenge.chlngNo == thumbnail.parentChNo}">
											<img class="cThumbnail" src="${contextPath}/resources/uploadImages/challenge/${thumbnail.fileName}"></img>
										</c:if>
									</c:forEach>
								</c:if>
								
								<c:if test="${empty fList}">
									<img class="cThumbnail" src="${contextPath}/resources/uploadImages/challenge/${thumbnail.fileName}"></img>
								</c:if>
								
								
								
								</div>
								<div class="cTitle_area">
									<h4 class="title">${challenge.chlngTitle}</h4>
								</div>
								<div class="cPeriod_area">
									 <fmt:formatDate var="chlngStartDt" value="${challenge.chlngStartDt}" pattern="yyyy-MM-dd"/>
									 <fmt:formatDate var="chlngEndDt" value="${challenge.chlngEndDt}" pattern="yyyy-MM-dd"/>
									<span class="period">${chlngStartDt} - ${chlngEndDt}</span>
								</div>
								<div class="check_area">
									<img class="checkImg" src="${contextPath}/resources/img/challenge_check.png">
								</div>
							</td>
						</tr>
						</c:forEach>
						</c:otherwise>
							</c:choose>
					</table>
				</div>
				
				
		<div class="page-no-area">
			<ul>
			
				<c:if test="${pInfo.currentPage > 10}">
					<li><a href="${firstPage}">&lt;&lt;</a></li>
					<li><a href="${prevPage}">&lt;</a></li>
				</c:if>
				
				<c:forEach var="page" begin="${pInfo.startPage}" end="${pInfo.endPage}">
					<c:choose>
						<c:when test="${pInfo.currentPage == page }">     <!-- 만약 -->
							<li>
								<a class="page-link">${page}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<a class="page-link" href="${pageUrl}?cp=${page}${searchStr}">${page}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${next <= pInfo.maxPage}">
					<li><a href="${nextPage}">&gt;</a></li>
					<li><a href="${lastPage}">&gt;&gt;</a></li>
				</c:if>
				
			</ul>
        </div>
				
				
				
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>