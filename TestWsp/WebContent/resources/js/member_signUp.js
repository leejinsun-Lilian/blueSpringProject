// 입력 값들이 유효성 검사가 진행되었는지 확인하기 위한 객체 생성

var validateCheck = {
    "id" : false,
	"nickname" : false,
    "pwd1" : false,
    "pwd2" : false,
    "name" : false,
    "email" : false,
	"birthyy" : false,
	"birthdd" : false,
	"phone" : false,
	"email" : false,
	"emadilNum" : false
}

// 아이디 유효성 검사
// 첫 글자는 영어 소문자, 나머지 글자는 영어 대, 소문자 + 숫자, 총 5~20글자
$("#id").on("input", function(){
    var regExp = /^[a-z][a-zA-Z\d]{4,19}$/;

    var value = $("#id").val();
    if(!regExp.test(value)){
        $("#idMsg").text("아이디 형식이 유효하지 않습니다.").css("color", "red");
        validateCheck.id = false;
    } else{
        $.ajax({
            url : "idDupCheck.do",
            data : {"id" : value},
            type : "post",
            success : function(result){
                    if(result == 0){ // 중복되지 않은 경우
                    $("#idMsg").text("사용 가능한 아이디입니다.")
                    .css("color", "green");
                    validateCheck.id = true;
                }else{
                    $("#idMsg").text("이미 사용 중인 아이디입니다.")
                    .css("color", "red");
                    validateCheck.id = false;
                }
            },
            error : function(){
                console.log("아이디 중복 검사 실패");
            }
        });
    }

});

/*
이름
/^[가-힣]{2,}$/; // 한글 두 글자 이상
*/ 
$("#name").on("input", function(){
    var regExp = /^[가-힣]{2,}$/;

    var value = $("#name").val();
    if(!regExp.test(value)){
        $("#checkName").text("이름 형식이 유효하지 않습니다.")
            .css("color", "red");
            validateCheck.name = false;
    }else {
        $("#checkName").text("유효한 이름 형식입니다.")
            .css("color", "green");
            validateCheck.name = true;
    }
});


/*
이메일
/^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/; // 4글자 아무단어 @ 아무단어 . * 3
*/
$("#email").on("input", function(){
    var regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

    var value = $("#email").val();
    if(!regExp.test(value)){
        $("#checkEmail").text("이메일 형식이 유효하지 않습니다.")
            .css("color", "red");
            validateCheck.email = false;
    }else {
        $("#checkEmail").text("유효한 이메일 형식입니다.")
            .css("color", "green");
            validateCheck.email = true;
    }
});

// 비밀번호 유효성 검사
// 영어 대, 소문자 + 숫자, 총 6~12글자
// + 비밀번호, 비밀번호 확인의 일치 여부
// + 비밀번호를 입력하지 않거나 유효하지 않은 상태로
//   비밀번호 확인을 작성하는 경우

$("#pwd1, #pwd2").on("input", function(){
    // 비밀번호 유효성 검사
    var regExp = /^[a-zA-Z\d]{6,12}$/;

    var v1 = $("#pwd1").val();
    var v2 = $("#pwd2").val();

    if(!regExp.test(v1)){
        $("#checkPwd1").text("비밀번호 형식이 유효하지 않습니다.")
        .css("color", "red");
        validateCheck.pwd1 = false;
    } else{
        $("#checkPwd1").text("유효한 비밀번호 형식입니다.")
        .css("color", "green");
        validateCheck.pwd1 = true;
    }


    // 비밀번호가 유효하지 않은 상태에서 비밀번호 확인 작성 시
    if(!validateCheck.pwd1 && v2.length > 0){
        swal("유효한 비밀번호를 먼저 작성해주세요.");
        $("#pwd2").val(""); // 비밀번호 확인에 입력한 값 삭제
        $("#pwd1").focus();
    }else {
        // 비밀번호, 비밀번호 확인의 일치 여부
       if(v1.length == 0 || v2.length == 0){
			$("#checkPwd2").text("");
		}else if(v1 == v2){
            $("#checkPwd2").text("비밀번호 일치")
            .css("color", "green");
            validateCheck.pwd2 = true;
        }else{
            $("#checkPwd2").text("비밀번호 불일치")
            .css("color", "red");
            validateCheck.pwd2 = false;
        }
    }
});

// 전화번호 유효성 검사
$(".phone").on("input", function(){
    // 전화번호 input 태그에 4글자 초과 입력하지 못하게 하는 이벤트
	if ($(this).val().length > 4) {
        $(this).val( $(this).val().slice(0, 4));
        
        // this : 이벤트가 발생한 요소
        // $(this) 
	}

    var regExp1 = /^\d{3,4}$/;
    var regExp2 = /^\d{4}$/;

    var v1 = $("#phone2").val();
    var v2 = $("#phone3").val();

    if(!regExp1.test(v1) || !regExp2.test(v2)){
        $("#checkPhone").text("전화번호가 유효하지 않습니다.")
        .css("color", "red");
        validateCheck.phone2 = false;
    }else{
        $("#checkPhone").text("유효한 형식의 전화번호 입니다.")
        .css("color", "green");
        validateCheck.phone2 = true;
    }
});

function validate(){
	// 아이디 중복 검사 여부 확인
	// if($("#idDup").val() != "true") {
	// 	swal("아이디 중복 검사를 진행해주세요.");
	// 	$("#idDupCheck").focus();
	// 	return false; // 기본 이벤트 제거
		
	// }
	
    // 유효성 검사 여부 확인
    for(var key in validateCheck){
        if(!validateCheck[key]){
            var msg;
            switch(key){
                case "id" : msg="아이디가"; break;
                case "pwd1" :
                case "pwd2" : msg = "비밀번호가"; break;
                case "name" : msg="이름이"; break;
                case "phone2" : msg="전화번호가"; break;
                case "email" : msg="이메일이"; break;
            }

            swal(msg + " 유효하지 않습니다.");

            $("#" + key).focus();
            return false;
        }
    }

}

$(function(){
    $("#postcodify_search_button").postcodifyPopUp();

});

// 아이디 중복 체크창 오픈
$("#idDupCheck").on("click",function () {
	window.open("idDupForm.do", "idDupForm","width=450, height=250");
	 //				   팝업 주소			팝업창 name				설정
});



// 회원 정보 수정--------------------------------------
// 회원 정보 수정 유효성 검사
function memberUpdateValidate(){
  
    // 유효성 검사를 저장할 객체 생성
    var updateCheck = {"phone2":false,
                        "email":false}

    var regExp1 = /^\d{3,4}$/; // 숫자 3~4 글자
   var regExp2 = /^\d{4,4}$/; // 숫자 4 글자
   var regExp3 = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;


    // 전화번호 유효성 검사
    var p2 = $("#phone2").val();
    var p3 = $("#phone3").val();
    if(!regExp1.test(p2) || !regExp2.test(p3)){
        updateCheck.phone2 = false;
    }else{
        updateCheck.phone2 = true;
    }

    // 이메일 유효성 검사
    if(!regExp3.test( $("#email").val() )){
        updateCheck.email = false;
    }else{
        updateCheck.email = true;
    }


    // updateCheck 내부에 저장된 값 검사
    for(var key in updateCheck){

        // 업데이트에서 가져온 값이 false 라면
        if(!updateCheck[key]){
            swal("일부 값이 유효하지 않습니다.");
            return false;
        }
    }
}

// 비밀번호 수정 ------------------------------------------------------------------------------------
function pwdValidate(){

    var regExp = /^[a-zA-Z\d]{6,12}$/; // 영어 대,소문자 + 숫자, 총 6~12글자

    if(!regExp.test( $("#newPwd1").val() ) ){
        swal("비밀번호 형식이 유효하지 않습니다.");
        $("#newPwd1").focus();

        return false; 
    }

    // 새로운 비밀번호와 확인이 일치하지 않을 때
    if( $("#newPwd1").val() != $("#newPwd2").val() ){
        swal("새로운 비밀번호가 일치하지 않습니다.");
        
        $("#newPwd1").focus(); // 포커스 이동
        $("#newPwd1").val(""); // newPwd1에 값 지우기 
        $("#newPwd2").val(""); // newPwd2에 값 지우기 

        return false;
    }
}


// 회원 탈퇴 약관 동의 체크 확인 --------------------------------

function secessionValidate(){
	if(!$("#agree").prop("checked")){
		// #agree 체크박스가 체크되어 있지 않다면
		swal("약관에 동의해주세요.");
		return false;
	} else{
		return confirm("정말로 탈퇴하시겠습니까?");
	}
}