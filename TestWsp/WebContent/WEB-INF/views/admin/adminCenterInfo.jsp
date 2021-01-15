<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	.page-item > a, .page-item > a:hover{ color: black; }
	
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
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">1</a></th>
                        <td>센터</td>
                        <td>서울특별시</td>
                        <td>강남구</td>
                        <td>강남구정신건강복지센터</td>
                        <td>02-2226-0344</td>
                        <td><a href="https://www.gangnam.go.kr/office/smilegn/main.do" target="_blank"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                          </svg></a></td>
                        <td>강남구 일원로9길 38, 3층(일원동)</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">2</a></th>
                        <td>정신병원</td>
                        <td>경기도</td>
                        <td>남양주시</td>
                        <td>연세정신건강의학과의원</td>
                        <td>0507-1409-2906</td>
                        <td><a href="#" target="_blank"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                          </svg></a></td>
                        <td>남양주시 별내중앙로 24 이레타워 6층</td>
                      </tr>
                      <tr>
                        <th><input type="checkbox"></th>
                        <th scope="row"><a href="#">3</a></th>
                        <td>센터</td>
                        <td>서울특별시</td>
                        <td>서대문구</td>
                        <td>서대문구정신건강복지센터</td>
                        <td>02-330-1801</td>
                        <td><a href="http://www.sdm.go.kr/health/contents/dementia/improve" target="_blank"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                        </svg></a></td>
                        <td>서대문구 연희로 242 보건소 별관 우리들4층 (연희동)</td>
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


            <div class="center_search"><select id="center_search" name="center_search" required>
                <option selected>번호</option>
                <option>분류</option>
                <option>지역(시/도)</option>
                <option>지역(구/군)</option>
                <option>기관명</option>
            </select>
            <input type="text"> <button type="button" id="senter_btn">검색</button><br></div>
            
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