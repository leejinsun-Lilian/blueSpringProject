<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 작성한 댓글 조회</title>

<link href="${contextPath}/resources/css/mypage/boardList.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>

		<div class="container">
			<jsp:include page="../common/mypageSideMenu.jsp"></jsp:include>
			<div class="content">
				<h3>작성한 댓글 조회</h3>
				<div class="list-wrapper">
					<table class="table" id="list-table">
							<tr>
								<th>게시글 번호</th>
								<th>내용</th>
								<th>작성일</th>
							</tr>
				
					<c:choose>
						<c:when test= "${empty cList}">
							<td colspan="4">작성한 댓글이 없습니다.</td> 
						</c:when>
					
					
					<c:otherwise>
 						<c:forEach var="comment" items="${cList}">
								<tr>
									<td>${comment.parentBoardNo}</td>
									<td>${comment.comContent}</td>
									<td>${comment.comCreateDate}</td>
								</tr>
							</c:forEach> 
						</c:otherwise>
						</c:choose>
					</table>
				</div>

			</div>
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<!-- 인증 글 목록 -->
	<!-- 번갈아가면서 색깔주는거 나중에 추가하기 -->


</body>
</html>