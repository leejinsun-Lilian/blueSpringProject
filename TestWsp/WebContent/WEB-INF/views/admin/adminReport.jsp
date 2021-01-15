<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신고목록 조회 페이지</title>
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
	
	.report_title{
	    margin: 3% 0 3% 0;
	    color:rgb(40, 62, 105);
	}
	
	.report_board{ 
	    width: 100%;
	    height: 100%;
	}
	
	.table th > a{ 
    text-decoration: none;
    color: black;
    }
	
	.page_area{ margin-top: 2%; }
	
	.report_search{ text-align: center; }
	
	.page-item > a, .page-item > a:hover{ color: black; }
	
	#report_btn { 
	    background-color: #343a40;
	    color: snow;
	}
	
	#report_btn2 { 
	    background-color: rgb(40, 62, 105);
	    color: snow;
	}
	
	#report_btn3 { 
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
            <div class="report_title">
                <h4>신고목록 조회</h4>
            </div>
            <div class="report_board">
                <table class="table table-sm">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col"><input type="checkbox"></th>
                        <th scope="col">신고접수번호</th>
                        <th scope="col">신고유형</th>
                        <th scope="col">글번호</th>
                        <th scope="col">신고한회원</th>
                        <th scope="col">신고카테고리번호</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">1</a></th>
                        <td>1</td>
                        <td>21</td>
                        <td>324</td>
                        <td>1</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">2</a></th>
                        <td>1</td>
                        <td>18</td>
                        <td>222</td>
                        <td>2</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">3</a></th>
                        <td>2</td>
                        <td>38</td>
                        <td>345</td>
                        <td>3</td>
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


            <div class="report_search"><select id="report_search" name="report_search" required>
                <option selected>신고접수번호</option>
                <option>신고유형</option>
                <option>글번호 </option>
            </select>
            <input type="text"> <button type="button" id="report_btn">검색</button>
            <button type="button" id="report_btn2">등록</button>
            <button type="button" id="report_btn3">삭제</button></div>

        </div>
    
    <div style="clear: both;"></div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    </div>
</body>
</html>