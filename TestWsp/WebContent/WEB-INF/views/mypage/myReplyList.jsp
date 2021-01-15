<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 작성한 댓글 조회</title>

<link href="${contextPath}/resources/css/boardList.css" rel="stylesheet" type="text/css">
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
			<jsp:include page="../common/sideMenu.jsp"></jsp:include>
			<div class="content">
				<h3>작성한 댓글 조회</h3>
				<div class="list-wrapper">
					<table class="table" id="list-table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>

						<tbody>

							<!-- 조회된 목록이 없을 때   -->
							<!-- <tr>
                  <td colspan="5">존재하는 인증글이 없습니다</td>
               </tr> -->
							<tr>
								<td>112</td>
								<td>제목 출력</td>
								<td>작성자 출력</td>
								<td>날짜 출력</td>
							</tr>
							<tr>
								<td>113</td>
								<td>제목 출력</td>
								<td>작성자 출력</td>
								<td>날짜 출력</td>
							</tr>
							<tr>
								<td>114</td>
								<td>제목 출력</td>
								<td>작성자 출력</td>
								<td>날짜 출력</td>
							</tr>
							<tr>
								<td>115</td>
								<td>제목 출력</td>
								<td>작성자 출력</td>
								<td>날짜 출력</td>
							</tr>
							<tr>
								<td>116</td>
								<td>제목 출력</td>
								<td>작성자 출력</td>
								<td>날짜 출력</td>
							</tr>

						</tbody>
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