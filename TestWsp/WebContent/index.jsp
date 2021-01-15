<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>푸른봄에 오신 것을 환영합니다.</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="resources/css/main.css" type="text/css">
    
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="WEB-INF/views/common/header.jsp"></jsp:include>

		<div class="title">
			<a href="${contextPath}/admin/adminMain.do"><img id="mainImg" src="resources/img/mainImg.png"></a>
			<form action="${contextPath}/main/mainSearchPage.do" method="get" name="search_input">
				<input type="text" id="search_input" class="input" placeholder="관심있는 내용을 검색해 보세요!">
			</form>
		</div>
		<div class="content">
			<div class="board">
				<div class="board_item">
					<div class="board_title">정부정책</div>
					<div class="board_content">
						<table class="table table-sm table-borderless">
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
						      <td colspan="3"><a href="#">코로나블루 토닥토닥...광명시 ‘마음카페’ 개소</a></td>
						    </tr>
						    <tr>
						      <th scope="row">2</th>
						      <td colspan="3"><a href="#">정부, 3971억 규모 근로장려금 지급</a></td>
						    </tr>
						    <tr>
						      <th scope="row">3</th>
						      <td colspan="3"><a href="#">서울시 상담 센터 블루터치 사이트 안내</a><td>
						    </tr>
						    <tr>
						      <th scope="row">4</th>
						      <td colspan="3"><a href="#">서울시, '코로나 블루' 검진·상담비용 8만원 지원</a><td>
						    </tr>		
						    <tr>
						      <th scope="row">5</th>
						      <td colspan="3"><a href="#">코로나19 확진자 대상 비대면 정신 상담 서비스 운영</a><td>
						    </tr>	
						    <tr>
						      <th scope="row">6</th>
						      <td colspan="3"><a href="#">"코로나 우울 극복해요" 앱·전화상담으로 '마음건강' 회복 지원</a><td>
						    </tr>	
						    <tr>
						      <th scope="row">7</th>
						      <td colspan="3"><a href="#">세종시 울적한 마음 카카오톡 상담 위로</a><td>
						    </tr>			    
						  </tbody>
						</table>
					</div>
					<div class="board_more">
						<a href="${contextPath}/notice/list.do">더보기</a>
					</div>
				</div>
				<div class="board_item">
					<div class="board_title">자유게시판</div>
					<div class="board_content">
						<table class="table table-sm table-borderless">
						  <tbody>
						    <tr>
						      <th scope="row">[자유]</th>
						      <td colspan="3"><a href="#">저희반에 인간자바가 잇어요,,,</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[정보]</th>
						      <td colspan="3"><a href="#">동네 상담 센터에 상담 다녀온 후기</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[고민]</th>
						      <td colspan="3"><a href="#">코로나에 걸릴까봐 너무 무서워요 ㅠㅠ</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">요즘 할게 없어서 이것 저것 한 것 올려봅니다</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[자유]</th>
						      <td colspan="3"><a href="#">작년부터 코딩 배우는 중입니다.</a><td>
						    </tr>
							<tr>
						      <th scope="row">[일상]</th>
						      <td colspan="3"><a href="#">수세미 뜨개질 해서 친구들 선물해줬어요!</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[자유]</th>
						      <td colspan="3"><a href="#">새해 기념 음악방송 합니다. 들어오세요.</a><td>
						    </tr>						    					    
						  </tbody>
						</table>
					</div>
					<div class="board_more">
						<a href="${contextPath}/board/list.do">더보기</a>
					</div>
				</div>
				<div class="board_item">
					<div class="board_title">챌린지목록</div>
					<div class="board_content">
						<table class="table table-sm table-borderless">
						  <tbody>
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">미니멀 리스트 도전하기 (하루에 1개씩 물건 버리기)</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[역량]</th>
						      <td colspan="3"><a href="#">일주일에 정해진 책 1권 읽기</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">원격 방송으로 주말에 함께 노래 듣기</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[건강]</th>
						      <td colspan="3"><a href="#">매일 30분씩 런데이/산책 하기</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[돈관리]</th>
						      <td colspan="3"><a href="#">하루에 10000원 이하로 지출 하기</a><td>
						    </tr>	
						    <tr>
						      <th scope="row">[공부]</th>
						      <td colspan="3"><a href="#">매일 2시간 공부 하기 (공부 주제: 자유)</a><td>
						    </tr>	
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">뜨개질 만들기 (이번주: 곱창밴드)</a><td>
						    </tr>	
						    			    
						  </tbody>
						</table>
					</div>
					<div class="board_more">
						<a href="${contextPath}/challenge/list.do">더보기</a>
					</div>
				</div>
				<div class="board_item">
					<div class="board_title">인증게시판</div>
					<div class="board_content">
						<table class="table table-sm table-borderless">
						  <tbody>
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">미니멀 리스트 도전 (문제집 버렸어요.)</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[건강]</th>
						      <td colspan="3"><a href="#">01/12 조깅 30분 (런데이어플) 사진 인증합니다.</a></td>
						    </tr>
						    <tr>
						      <th scope="row">[역량]</th>
						      <td colspan="3"><a href="#">01/12 '시선으로부터' 완독 후기</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[취미]</th>
						      <td colspan="3"><a href="#">미니멀 리스트 도전 (옷 버리기)</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[건강]</th>
						      <td colspan="3"><a href="#">01/12 산책 30분 인증합니다.</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[공부]</th>
						      <td colspan="3"><a href="#">하루에 공부 2시간 (영어 공부 인증)</a><td>
						    </tr>
						    <tr>
						      <th scope="row">[돈관리]</th>
						      <td colspan="3"><a href="#">하루 지출 10000원 이하 하기 인증합니다.</a><td>
						    </tr>					    
						  </tbody>
						</table>
					</div>
					<div class="board_more">
						<a href="${contextPath}/challengeCrtfd/list.do">더보기</a>
					</div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
		<jsp:include page="WEB-INF/views/common/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>