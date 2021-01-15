<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>블랙리스트 조회 페이지</title>
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
	
	.admin_black_title{
	    margin: 3% 0 3% 0;
	    color:rgb(40, 62, 105);
	    
	}
	
	.admin_black_board{ 
	    width: 100%;
	    height: 100%;
	}
	
	.page_area{ margin-top: 2%; }
	
	.black_search{ text-align: center; }
	
	.page-item > a, .page-item > a:hover{ color: black; }
	
	#black_btn { 
	    background-color: #343a40;
	    color: snow;
	}
	
	#black_btn2 { 
	    background-color: #dc3545;
	    color: snow;
	}
	</style>
</head>
<body>
    <div class="wrapper">
    	<jsp:include page="../common/header.jsp"></jsp:include>
    	
    	<jsp:include page="../common/adminMenu.jsp"></jsp:include>

        <div class="admin_content">
            <div class="admin_black_title">
                <h4>블랙리스트 조회</h4>
            </div>
            <div class="admin_black_board">
                <table class="table table-sm">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col"><input type="checkbox"></th>
                        <th scope="col">회원번호</th>
                        <th scope="col">아이디</th>
                        <th scope="col">이름</th>
                        <th scope="col">생년월일</th>
                        <th scope="col">성별</th>
                        <th scope="col">전화번호</th>
                        <th scope="col">주소</th>
                        <th scope="col">가입일</th>
                        <th scope="col">탈퇴여부</th>
                        <th scope="col">블랙리스트여부</th>
                        <th scope="col">회원등급</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row">1</th>
                        <td>user02</td>
                        <td>유저이</td>
                        <td>2021.01.01</td>
                        <td>남</td>
                        <td>010-1234-5678</td>
                        <td>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</td>
                        <td>2021.01.10</td>
                        <td>N</td>
                        <td>Y</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row">2</th>
                        <td>user03</td>
                        <td>유저삼</td>
                        <td>2021.01.01</td>
                        <td>남</td>
                        <td>010-1234-5678</td>
                        <td>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</td>
                        <td>2021.01.10</td>
                        <td>N</td>
                        <td>Y</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row">3</th>
                        <td>user04</td>
                        <td>유저사</td>
                        <td>2021.01.01</td>
                        <td>남</td>
                        <td>010-1234-5678</td>
                        <td>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</td>
                        <td>2021.01.10</td>
                        <td>N</td>
                        <td>Y</td>
                        <td>2</td>
                      </tr>
                    </tbody>
                  </table>
            </div>

            <div class="page_area">
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


            <div class="black_search"><select id="black_search" name="black_search" required>
                <option selected>회원번호</option>
                <option>아이디</option>
                <option>이름</option>
                <option>탈퇴여부</option>
            </select>
            <input type="text"> <button type="button" id="black_btn">검색</button>
            <button type="button" id="black_btn2">삭제</button></div>

        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>