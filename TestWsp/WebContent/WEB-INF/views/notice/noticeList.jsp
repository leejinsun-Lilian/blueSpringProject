<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사할 목록</title>
<link rel="stylesheet" href="${contextPath}/resources/css/no_list.css" type="text/css">
</head>
<body>
	<!-- 해더 영역 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

 	<div class="wrapper">
		<h1>공지사항</h1>

		<!-- 공지사항 글 목록 --> <!-- 번갈아가면서 색깔주는거 나중에 추가하기 -->
		<div class="list-wrapper">
			<table class="table" id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				
				<tbody>
					
					<!-- 조회된 목록이 없을 때   -->
					<%-- 공지사항이 존재할 때와 존재하지 않을 때에 맞는 출력 형식을 지정해야 함. --%>
					<c:choose>
						
						<c:when test="${empty list}">
							<tr>
								<td colspan="5" align="center">존재하는 공지사항이 없습니다.</td>							
							</tr>
						</c:when>
					
						<c:otherwise> <%-- 조회된거 있을 때  --%>
							<c:forEach var="notice" items="${list}">
								<tr>   
									<td>${notice.noticeNo}</td>
									<td>${notice.noticeTitle}</td>
									<td>${notice.memberId}</td>
									<td>${notice.noticeViews}</td>
									<td>${notice.noticeCrtDt}</td>
								</tr>
							</c:forEach>
						
						</c:otherwise>
					
					</c:choose>
				</tbody>
			</table>
		</div>
		
		
		<!-- 관리자일 경우에만 글쓰기 버튼이 보이는거 -->
		<%-- <c:if test="${!empty loginMember && loginMember.memberGrade == '1' }"> --%>
			<div class="writer-bt">
				<a href="${contextPath}/notice/insertForm.do" class="btn btn-update">글쓰기</a>
			</div>
		<%-- </c:if> --%>
		
		
		<%---------------------- Pagination ----------------------%>
	 	<c:choose>
			
			<c:when test="${!empty param.sk && !empty param.sv }">     
				<c:url var="pageUrl" value="/search.do"/>
				
				
				<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}"/>
			</c:when>
			
			<c:otherwise>
				<c:url var="pageUrl" value="/notice/list.do"/>
			</c:otherwise>
			
		</c:choose> 
		
		
		<c:set var="firstPage" value="${pageUrl}?cp=1${searchStr}"/>
		<c:set var="lastPage" value="${pageUrl}?cp=${pInfo.maxPage}${searchStr}"/>
		
		<fmt:parseNumber  var="c1" value="${( pInfo.currentPage - 1) / 10 }" integerOnly="true" />    
		<fmt:parseNumber  var="prev" value="${ c1 * 10 }" integerOnly="true" />
		<c:set var="prevPage" value="${pageUrl}?cp=${prev}${searchStr}" />
		
		<fmt:parseNumber var="c2" value="${(pInfo.currentPage + 9) / 10 }" integerOnly="true"/>
		<fmt:parseNumber var="next" value="${ c2 * 10 + 1 }" integerOnly="true" />     
		<c:set var="nextPage" value="${pageUrl}?cp=${next}${searchStr}" />
			
		<!-- 페이지 번호 목록 -->
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