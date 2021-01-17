<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	h1 {
		text-align: center;
	}

	#centerArea {
		margin-bottom: 100px;
		min-height: 800px;
	}

  #searchWrapper {
  	min-height: 400px;
  	
  }

	#selectArea {
		width: 15%;
		float: left;
	}

	#centerListArea {
		width: 25%;	
		float: left;
	}
    
    #sidoSelect {
    	margin-bottom: 20px;
    }
    
	#gugunSelectArea {
		overflow-x: hidden;
		overflow-y: scroll;
		width: 200px;
		height: 300px;
	}
	
	#centerSelectArea {
		overflow-x: hidden;
		overflow-y: scroll;
		width: 400px;
		height: 700px;
	}

    #mapArea {
    	margin: auto;
		width: 60%;
		height: 800px;
    }
    
    label {
    	display: block;
    	width: 100px;
    }
    
</style>
</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
    
    <h1>기관찾기</h1>
	
	<div id="centerArea">		    
			<!-- 기관 검색 -->
		<div id="searchArea">
			
				<div id ="selectArea">
					<h2>기관 검색</h2>
					시/도 : <select name="sidoSelect" id="sidoSelect"></select>
					
						<div id="gugunSelectArea">
							
						</div>   
						<br>
						<button id="search-btn">찾기</button> 
				</div>
				
				<!-- 기관 목록 -->
				<div id="centerListArea">
					<h2>기관 목록</h2>
					
					<div id="centerSelectArea">
							
					</div>  
				</div>		

	</div>
			
			<!-- 지도 -->
			<div id="mapArea">

			</div>

	</div>


     
        
    <jsp:include page="../common/footer.jsp"></jsp:include>

	<script>
		var sidoArea = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
			
		var gugun1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
		var gugun2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
		var gugun3 = ["대덕구","동구","서구","유성구","중구"];
		var gugun4 = ["광산구","남구","동구","북구","서구"];
		var gugun5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
		var gugun6 = ["남구","동구","북구","중구","울주군"];
		var gugun7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
		var gugun8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
		var gugun9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
		var gugun10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
		var gugun11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
		var gugun12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
		var gugun13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
		var gugun14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
		var gugun15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
		var gugun16 = ["서귀포시","제주시","남제주군","북제주군"];
		

		// 찾기 버튼 클릭 시
		$("#search-btn").on("click", function() {
			var sido = $("#sidoSelect option:selected").val();
			var gugun = new Array();

			$("input:checkbox[name='gugunSelect']:checked").each(function(){
				gugun.push($(this).val());
			}) 		
			
			console.log(sido);
			console.log(gugun);
			
			$.ajaxSettings.traditional = true;
			
			$.ajax({
				url : "${contextPath}/center/selectCenterList.do", 
				data : {"sido" : sido, 
								"gugun" : gugun}, 
				type : "get",
				success : function(cList) {
					
					$("#centerSelectArea").html("");
					$("#centerSelectArea").html(cList);
					
				}, error : function(request, status, error) {
			  	   alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			 	}	
			});
			
		});
		

		// 지도 관련
		function initMap(){
            // 최초에 어느 위도와 경도를 표시할 것인가.
            const myLatLng = {
                lat: 37.603662, // 이 부분을 받아오면 될듯
                lng: 127.063035 // 이 부분을 받아오면 될듯
            }
            const map = new google.maps.Map(
                document.getElementById('mapArea'),
                {
                    center: myLatLng,
                    scrollwheel: true,
                    zoom: 18
                }
            );
            const marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                title: 'GitHub'
            });
        }



		// 초기 select 설정
		$(function(){  	  
			$("#sidoSelect").each(function() {
					for(var i = 0; i < sidoArea.length; ++i) {
						$(this).append("<option value='"+sidoArea[i]+"'>"+sidoArea[i]+"</option>");
					}		
				});	  	 
		
		});
		
			// 시 도 체크시
		$("#sidoSelect").on("change", function(){
//			console.log($("#sidoSelect option:selected").val());
			$("#gugunSelectArea").empty();
			
			var sidoIndex = $("#sidoSelect option").index($("#sidoSelect option:selected"));
			
//			console.log(sidoIndex);

			// 서울
			if(sidoIndex == 1) {
				for(var j = 0; j < gugun1.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun1[j] + ">" + gugun1[j] +"</label>");	  			
					}    		
			}
			
			// 인천
			if(sidoIndex == 2) {
				for(var j = 0; j < gugun2.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun2[j] + ">" + gugun2[j] +"</label>");	  			
					}    		
			}
			
			// 대전
			if(sidoIndex == 3) {
				for(var j = 0; j < gugun3.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun3[j] + ">" + gugun3[j] +"</label>");	  			
					}    		
			}
			
			// 광주
			if(sidoIndex == 4) {
				for(var j = 0; j < gugun4.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun4[j] + ">" + gugun4[j] +"</label>");	  			
					}    		
			}
			
			// 대구
			if(sidoIndex == 5) {
				for(var j = 0; j < gugun5.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun5[j] + ">" + gugun5[j] +"</label>");	  			
					}    		
			}
			
			// 울산
			if(sidoIndex == 6) {
				for(var j = 0; j < gugun6.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun6[j] + ">" + gugun6[j] +"</label>");	  			
					}    		
			}
			
			
			// 부산
			if(sidoIndex == 7) {
				for(var j = 0; j < gugun7.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun7[j] + ">" + gugun7[j] +"</label>");	  			
					}    		
			}
			
			
			// 경기도
			if(sidoIndex == 8) {
				for(var j = 0; j < gugun8.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun8[j] + ">" + gugun8[j] +"</label>");	  			
					}    		
			}
			
			
			// 강원도
			if(sidoIndex == 9) {
				for(var j = 0; j < gugun9.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun9[j] + ">" + gugun9[j] +"</label>");	  			
					}    		
			}
			
			
			// 충청북도
			if(sidoIndex == 10) {
				for(var j = 0; j < gugun10.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun10[j] + ">" + gugun10[j] +"</label>");	  			
					}    		
			}
			
			
			// 충청남도
			if(sidoIndex == 11) {
				for(var j = 0; j < gugun11.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	  */ 				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun11[j] + ">" + gugun11[j] +"</label>");	  			
					}    		
			}
			
			
			// 전라북도
			if(sidoIndex == 12) {
				for(var j = 0; j < gugun12.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun12[j] + ">" + gugun12[j] +"</label>");	  			
					}    		
			}
			
			
			// 전라남도
			if(sidoIndex == 13) {
				for(var j = 0; j < gugun13.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun13[j] + ">" + gugun13[j] +"</label>");	  			
					}    		
			}
			
			
			// 경상북도
			if(sidoIndex == 14) {
				for(var j = 0; j < gugun14.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun14[j] + ">" + gugun14[j] +"</label>");	  			
					}    		
			}
			
			
			// 경상남도
			if(sidoIndex == 15) {
				for(var j = 0; j < gugun15.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				} */	  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun15[j] + ">" + gugun15[j] +"</label>");	  			
					}    		
			}
			
			
			// 제주도
			if(sidoIndex == 16) {
				for(var j = 0; j < gugun16.length; ++j) {
	/* 	 				if(j % 2 == 0) {
							$("#gugunSelectArea").append("<br>");
				}	 */  				
				$("#gugunSelectArea").append("<label><input type='checkbox' name='gugunSelect' class='gugunSelect' value=" + gugun16[j] + ">" + gugun16[j] +"</label>");	  			
					}    		
			}
			
 			
	
		});
    
    // 시 도 체크시 
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTQIlxBn5AfKGvsfJiormAE1esN3fcCkg&callback=initMap" async defer></script>
</body>
</html>