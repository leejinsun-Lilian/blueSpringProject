<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>푸른봄 - 전체 검색 결과</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	
	<style>
	.search_content {
		width: 70%;
		height: 100%;
		margin: auto;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}
	
	.search_title {
		margin: 3% 0 3% 0;
		color: rgb(40, 62, 105);
	}
	
	.admin_board {
		width: 100%;
		height: 100%;
	}
	
	.table td>a {
		text-decoration: none;
		color: black;
	}
	
	.page-item>a, .page-item>a:hover {
		color: black;
	}
	</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../common/header.jsp"></jsp:include>

        <div class="search_content">
            <div class="search_title">
                <h4>@@ 검색 결과</h4>
            </div>

            <div class="admin_board">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">내용</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td><a href="#">안녕하세요. 가입인사 합니다.</a></td>
                        <td>안녕하세요. 사이트 여러군데 찾아보다가 여기가 제일 분위기가
                            도란도란 한 것 같아서 가입했습니다. 정부정책도 최신글로 많이 올라오고
                            챌린지 게시판도 참여율이 높은 것 같아요. 저도 자주 들러서 글 올리겠습니다.
                            모두들 좋은하루 되세요.
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td><a href="#">제목2</a></td>
                        <td>내용2</td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td><a href="#">제목3</a></td>
                        <td>내용3</td>
                      </tr>
                    </tbody>
                  </table>

                
                  <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                      <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                          <span aria-hidden="true">&laquo;</span>
                        </a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                      <li class="page-item"><a class="page-link" href="#">2</a></li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                        </a>
                      </li>
                    </ul>
                  </nav>
                

            </div>
        </div>
		<div style="clear: both;"></div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>