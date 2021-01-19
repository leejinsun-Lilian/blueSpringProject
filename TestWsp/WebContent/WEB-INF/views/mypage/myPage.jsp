<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸른봄: 마이페이지</title>

<link href="${contextPath}/resources/css/mypage/myPage.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<style>
.myInfoTable td > span {
	margin-left : 30px;
}

</style>
</head>

<body>
	
		<c:choose>
			<c:when test="${loginMember.memberGender == 'M'.charAt(0)}">
				<c:set var="gender" value="남자"/>
			</c:when>
			<c:otherwise>
				<c:if test="${loginMember.memberGender == 'F'.charAt(0)}">
					<c:set var="gender" value="여자"/>
				</c:if>
				<c:if test="${loginMember.memberGender == 'U'.charAt(0)}">
					<c:set var="gender" value="선택 안함"/>
				</c:if>
			</c:otherwise>
		</c:choose>


	<div class="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">

			<jsp:include page="../common/mypageSideMenu.jsp"></jsp:include>
			<div class="content">
				<div class="myInfo_area area">
					<h3>내 정보</h3>
					<div class="myInfo_back back">
						<table class="myInfoTable t_left">
							<tr>
								<th class="title">아이디</th>
								<td><span>${loginMember.memberId}</span></td>
							</tr>
							<tr>
								<th class="title">닉네임</th>
								<td><span>${loginMember.memberNickname}</span></td>
							</tr>
							<tr>
								<th class="title">이름</th>
								<td><span>${loginMember.memberNm}</span></td>
							</tr>
							<tr>
								<th class="title last">성별</th>
								<td><span>${gender}</span></td>
							</tr>
						</table>



						<table class="myInfoTable t_right">
							<tr>
								<th class="title">주소</th>
								<td><span>${loginMember.memberAddr}</span></td>
							</tr>
							<tr>
								<th class="title">이메일</th>
								<td><span>${loginMember.memberEmail}</span></td>
							</tr>
							<tr>
								<th class="title">생년월일</th>
								<td><span>${loginMember.memberBirth}</span></td>
							</tr>
							<tr>
								<th class="title last">휴대전화</th>
								<td><span>${loginMember.memberPhone}</span></td>
								<td>
										<button type="button" class="btn"
											onclick="location.href = '${contextPath}/mypage/myInfoChangePw.do'">정보
											수정</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- // myInfo 끝 -->


				<!-- 챌린지 -->
				<div class="chanllenge_in_progress_area area">
					<h3>참여중인 챌린지</h3>
					<div class="back">
						<table id="chanllenge_table">
							<tr>
								<td rowspan="2">
									<!-- 챌린지 썸네일  -->
									<div id="cThumbnail_area">
										<img id="cThumbnail"
											src="${contextPath}/resources/img/test.jpeg" id="C">
									</div>
								</td>

								<!-- 챌린지 제목  -->
								<td class="cTitle_td">
									<h4 id="cTitle">매일 2L 이상 물 마시기</h4>
								</td>
								<!-- 인증게시글 -->
								<td rowspan="4" id="cboard">
									<h5>인증게시글</h5>
									<table id="certification_board">
										<tr>
											<th scope="row" class="boardNo">1</th>
											<td colspan="3"><a href="#">오늘의 인증샷</a>
										</tr>
										<tr>
											<th scope="row" class="boardNo">2</th>
											<td colspan="3"><a href="#">오늘은 3L를 마셨어요.</a>
										</tr>
									</table>
								</td>
							</tr>

							<!-- 챌린지 달성률  -->
							<tr>
								<td class="progress">
									<h5>달성률</h5>
									<div class="progress_area">
										<div class="progress2 progress-moved">
											<div class="progress-bar2"></div>
										</div>
									</div>
								</td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>


			<div class="list_wrapper">
				<!-- 내가 쓴 게시글 조회 -->
				<div class="myBoardlistAll area">
					<h3>내가 쓴 게시글</h3>
					<div class="list_area">
						<table id="board_list">
							<tr>
								<th>1</th>
								<td>왜그래 무슨일 있었어?</td>
							<tr>
							<tr>
								<th>2</th>
								<td>너의 얼굴이 말이 아냐 말해봐</td>
							<tr>
							<tr>
								<th>3</th>
								<td>지금 뭐하자는거야? 참는데도 한계가 있어 알겠니dssdfsfdfsdsfdsfdsfdsfd</td>
							<tr>
						</table>
					</div>
				</div>
				
				
				
				<!-- 내가 쓴 댓글 조회 -->
				<div class="myReplylistAll area">
					<h3>내가 쓴 댓글</h3>
					<div class="list_area">
						<table id="Reply_list">
							<tr>
								<th>1</th>
								<td>왜그래 무슨일 있었어?</td>
							<tr>
							<tr>
								<th>2</th>
								<td>너의 얼굴이 말이 아냐 말해봐</td>
							<tr>
							<tr>
								<th>3</th>
								<td>지금 뭐하자는거야? 참는데도 한계가 있어 알겠니dssdfsfdfsdsfdsfdsfdsfd</td>
							<tr>
						</table>
					</div>
				</div>
				
				
				<!-- 역대 챌린지 조회 -->
				<div class="allTimeChallenges_area area">
				<h3>역대 챌린지 조회</h3>
									<div class="list_area">
						<table id="allTimeChallenges_list">
							<tr>
								<th>1</th>
								<td>왜그래 무슨일 있었어?</td>
							<tr>
							<tr>
								<th>2</th>
								<td>너의 얼굴이 말이 아냐 말해봐</td>
							<tr>
							<tr>
								<th>3</th>
								<td>지금 뭐하자는거야? 참는데도 한계가 있어 알겠니dssdfsfdfsdsfdsfdsfdsfd</td>
							<tr>
						</table>
					</div>
				</div>
			</div>

			</div>

		</div>

		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>


</body>
</html>