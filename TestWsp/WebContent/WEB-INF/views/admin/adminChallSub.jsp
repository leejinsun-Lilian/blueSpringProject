<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>챌린지 인증게시판 관리 페이지</title>
    
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

    .adminChallSub_title{
    margin: 3% 0 3% 0;
    color:rgb(40, 62, 105);

    }

    .adminChallSub_board{ 
    width: 100%;
    height: 100%;
    }

    .page_area{ margin-top: 2%; }

    .adminChallSub_search{ text-align: center; }

    .page-item > a, .page-item > a:hover{ color: black; }

    #adminChallSub_btn { 
    background-color: #343a40;
    color: snow;
    }

    #adminChallSub_btn2 { 
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
            <div class="adminChallSub_title">
                <h4>챌린지 인증게시판 관리</h4>
            </div>
            <div class="adminChallSub_board">
                <table class="table table-sm">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col"><input type="checkbox"></th>
                        <th scope="col">챌린지번호</th>
                        <th scope="col">인증글번호</th>
                        <th scope="col">작성자</th>
                        <th scope="col">삭제여부</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row">123</th>
                        <td>3</td>
                        <td>user03</td>
                        <td>N</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row">240</th>
                        <td>5</td>
                        <td>user04</td>
                        <td>N</td>
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


            <div class="adminChallSub_search"><select id="adminChallSub_search" name="adminChallSub_search" required>
                <option selected>챌린지번호</option>
                <option>인증글번호</option>
                <option>작성자</option>
                <option>삭제여부</option>
            </select>
            <input type="text"> <button type="button" id="adminChallSub_btn">검색</button>
            <button type="button" id="adminChallSub_btn2">삭제</button></div>

        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>