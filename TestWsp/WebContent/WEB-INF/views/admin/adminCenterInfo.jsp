<%@page import="com.boss.blueSpring.center.model.vo.Center"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기관목록 조회 페이지</title>
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
    <style>
	.admin_content{ 
	    width: 70%;
	    height: 100%;
	    margin: auto;
	
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	
	 }
	
	.center_title{
	    margin: 3% 0 3% 0;
	    color:rgb(40, 62, 105);
	    
	}
	
	.center_board{ 
	    width: 100%;
	    height: 100%;
	}
	
	.table th > a, .table td > a{ 
	    text-decoration: none;
	    color: black;
	}
	
	.page_area{ margin-top: 2%; }
	
	.center_search{ text-align: center; }
	
	.pagination > li > a, .pagination > li > a:hover{ color: black; }
	
	#center_btn { 
	    background-color: #343a40;
	    color: snow;
	}
	
	#center_btn2 { 
	    background-color: rgb(40, 62, 105);
	    color: snow;
	}
	
	#center_btn3 { 
	    background-color: rgb(152, 173, 216);
	    color: snow;
	}
	
	#center_btn4 { 
	    background-color: #dc3545;
	    color: snow;
	}
	
	.center_page_btn {
	    width: 22%;
	    height: 100%;
	    margin-top: 1%;
	    margin-left: 41%;
	}
	</style>
</head>
<body>
    <div class="wrapper">
    	<jsp:include page="../common/header.jsp"></jsp:include>
    	
    	<jsp:include page="../common/adminMenu.jsp"></jsp:include>

        <div class="admin_content">
            <div class="center_title">
                <h4>기관목록 조회</h4>
            </div>
            <div class="center_board">
                <table class="table table-sm">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col"><input type="checkbox"></th>
                        <th scope="col">번호</th>
                        <th scope="col">분류</th>
                        <th scope="col">지역(시/도)</th>
                        <th scope="col">지역(구/군)</th>
                        <th scope="col">기관명</th>
                        <th scope="col">전화번호</th>
                        <th scope="col">홈페이지</th>
                        <th scope="col">상세주소</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                    <c:when test="${empty cList}">
                        <tr>
                            <td colspan="9">존재하는 게시글이 없습니다.</td>
                        </tr>
                    </c:when>
    
                    <c:otherwise>                      
                        <c:forEach var="center" items="${cList}">
                            <tr>
                            	<td><input type="checkbox"></td>
                                <th scope="row">${center.centerNo}</th>
                                <td>${center.centerCla}</td>
                                <td>${center.centerArea1}</td>
                                <td>${center.centerArea2}</td>
								<td>${center.centerName}</td>
								<td>${center.centerTel}</td>
		                        <td><a href="${center.centerUrl}" target="_blank"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
		                            <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
		                            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
		                          </svg></a></td>
		                        <td>${center.centerAddr}</td>
                     	 	</tr>
                     	 </c:forEach>
                    </c:otherwise>
                </c:choose>
                    </tbody>
                  </table>
            </div>


            <%---------------------- Pagination ----------------------%>
			<%-- 페이징 처리 주소를 쉽게 사용할 수 있도록 미리 변수에 저장 --%>
			<c:choose>
				<%-- 검색 내용이 파라미터에 존재할 때 == 검색을 통해 만들어진 페이지인가? --%>
				<c:when test="${!empty param.sk && !empty param.sv }">
					<c:url var="pageUrl" value="/search.do"/>
					
					<%-- 쿼리스트링으로 사용할 내용을 변수에 저장 --%>
					<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}" />
				</c:when>
				
				<%-- 검색을 하지 않았을 경우 --%>
				<c:otherwise>
					<c:url var="pageUrl" value="/admin/adminCenterInfo.do"/>		
				</c:otherwise>
			</c:choose>

			<!-- 화살표에 들어갈 주소를 변수로 생성 -->
			 
			<c:set var="firstPage" value="${pageUrl}?cp=1${searchStr}"/>
			<c:set var="lastPage" value="${pageUrl}?cp=${cpInfo.maxPage}${searchStr}"/>
			 
			 <fmt:parseNumber var="c1" value="${(cpInfo.currentPage - 1) / 10 }" integerOnly="true" />
			 <fmt:parseNumber var="prev" value="${ c1 * 10 }" integerOnly="true" />
			 <c:set var="prevPage" value="${pageUrl}?cp=${prev}${searchStr}" />
			 
			 <fmt:parseNumber var="c2" value="${(cpInfo.currentPage + 9) / 10 }" integerOnly="true" />
			 <fmt:parseNumber var="next" value="${ c2 * 10 + 1 }" integerOnly="true" />
			 <c:set var="nextPage" value="${pageUrl}?cp=${next}${searchStr}" />



			<div class="page_area">
				<ul class="pagination justify-content-center">

					<%-- 현재 페이지가 10페이지 초과인 경우 --%>
					<c:if test="${cpInfo.currentPage > 10}">
						<li>
							<!-- 첫 페이지로 이동(<<) --> <a class="page-link" href="${firstPage}">&lt;&lt;</a>
						</li>

						<li>
							<!-- 이전 페이지로 이동 (<) --> <a class="page-link" href="${prevPage}">&lt;</a>
						</li>
					</c:if>

					<!-- 페이지 목록 -->
					<c:forEach var="page" begin="${cpInfo.startPage}"
						end="${cpInfo.endPage}">
						<c:choose>
							<c:when test="${cpInfo.currentPage == page }">
								<li><a class="page-link">${page}</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="page-link"
									href="${pageUrl}?cp=${page}${searchStr}">${page}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<%-- 다음 페이지가 마지막 페이지 이하인 경우 --%>
					<c:if test="${next <= cpInfo.maxPage}">
						<li>
							<!-- 다음 페이지로 이동 (>) --> <a class="page-link" href="${nextPage}">&gt;</a>
						</li>
						<li>
							<!-- 마지막 페이지로 이동(>>) --> <a class="page-link" href="${lastPage}">&gt;&gt;</a>
						</li>

					</c:if>

				</ul>
			</div>


            <div class="center_search">
            <form action="${contextPath}/adminSearch/center.do" method="GET">
	            <select id="center_search" name="sk" required>
	                <option selected value="centerNo">번호</option>
	                <option value="centerCla">분류</option>
	                <option value="centerArea1">지역(시/도)</option>
	                <option value="centerArea2">지역(구/군)</option>
	                <option value="centerNm">기관명</option>
	            </select>
            <input type="text" name="sv">
            <button type="button" id="senter_btn">검색</button><br></div>
            </form>
            
            <div class="center_page_btn">
            <button type="button" id="center_btn2">등록</button>
            <button type="button" id="center_btn3">수정</button>
            <button type="button" id="center_btn4">삭제</button></div>
			
        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>