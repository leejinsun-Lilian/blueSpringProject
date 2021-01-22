<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 인증 게시글 조회</title>

<link href="${contextPath}/resources/css/mypage/boardList.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
/* ****************************************************************** */

/* 페이지 번호 목록 */
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
				<h3>인증 게시글 조회</h3>
				<div class="list-wrapper">
					<table class="table" id="list-table">
							<tr>
								<th>번호</th>
								<th>카테고리</th>
								<th>제목</th>
								<th>조회수</th>
								<th>작성일</th>
							</tr>

				<c:choose>
                    <c:when test="${empty bList}"> 
                        <tr>
                            <td colspan="4" class="none">존재하는 게시글이 없습니다.</td>
                        </tr>
                    </c:when>
						  
                    <c:otherwise>                      
                        <c:forEach var="board" items="${bList}">
                            <tr>
                                <td>${board.chlngBoardNo}</td>
                                <td>${board.chlngCateNm}</td>
                                <td>${board.chlngBoardTitle}</td>
                                <td>
                                    <fmt:formatDate var="createDate" value="${board.chlngBoardCrtDt}" pattern="yyyy-MM-dd"/>
                                    <fmt:formatDate var="today" value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd"/>
                                    
                                    <c:choose>
                                        <c:when test = "${createDate != today}">
                                            ${createDate}
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:formatDate value="${board.chlngBoardCrtDt}" pattern="HH:mm"/>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${board.chlngBoardViews}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
					</table>
				</div>
				        <!-- 페이지 번호 목록 -->
 
 
 		<c:set var="firstPage" value="${pageUrl}?cp=1${searchStr}"/>
		<c:set var="lastPage" value="${pageUrl}?cp=${pInfo.maxPage}${searchStr}"/>
		
		<fmt:parseNumber  var="c1" value="${( pInfo.currentPage - 1) / 10 }" integerOnly="true" />    
		<fmt:parseNumber  var="prev" value="${ c1 * 10 }" integerOnly="true" />
		<c:set var="prevPage" value="${pageUrl}?cp=${prev}${searchStr}" />
		
		<fmt:parseNumber var="c2" value="${(pInfo.currentPage + 9) / 10 }" integerOnly="true"/>
		<fmt:parseNumber var="next" value="${ c2 * 10 + 1 }" integerOnly="true" />     
		<c:set var="nextPage" value="${pageUrl}?cp=${next}${searchStr}" />
			

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
	<!-- 인증 글 목록 -->
	<!-- 번갈아가면서 색깔주는거 나중에 추가하기 -->
    <script>
			// 게시글 상세보기 기능 (jquery를 통해 작업)		
			$("#board td").on("click", function() {
				// 게시글 번호 얻어오기
				var boardNo = $(this).parent().children().eq(0).text();

				var url = "${contextPath}/challengeCrtfd/list.do?cp=${pInfo.currentPage}&no=" + boardNo + "${searchStr}";
				// var url = "${contextPath}/board/view.do?cp=${pInfo.currentPage}&no=" + boardNo + "${searchStr}";
				location.href = url;
			});
			
			$("#board td").hover(function() {
                   $(this).parent().css("backgroundColor", "lightgray");
               }, function(){
                   $(this).parent().css("backgroundColor", "white");
               });
			
    </script>

</body>
</html>