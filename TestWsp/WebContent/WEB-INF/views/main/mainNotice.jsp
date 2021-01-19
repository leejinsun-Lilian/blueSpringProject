<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</head>
<body>

		<div class="content">
			<div class="board">
				<div class="board_item">
					<div class="board_title">정부정책</div>
					<div class="board_content">
						<table class="table table-sm table-borderless">
						  <tbody>
					<c:choose>
                    <c:when test="${empty nList}">
                        <tr>
                            <td colspan="3">존재하는 게시글이 없습니다.</td>
                        </tr>
                    </c:when>
    
                    <c:otherwise>                      
                        <c:forEach var="board" items="${nList}">
						  
						    <tr>
						      <th scope="row">${notice.noticeNo}</th>
						      <td colspan="3"><a href="#"></a>${notice.noticeTitle}</td>
						    </tr>
						 </c:forEach>
                    </c:otherwise>
                </c:choose>		    
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

</body>
</html>