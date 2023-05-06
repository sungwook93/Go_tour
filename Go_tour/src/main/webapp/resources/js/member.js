/**
 * 
 */
// memberForm관련 jquery
$(document).ready(function(){
	//alert("확인");
	
	//나이 달력사용하기
	 $("#age").datepicker();
	
	$.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년',
	        yearRange: 'c-100:c', //연도 범위
	        changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
	   
	        changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.        
    });
               
	//중복검사후 아이디를 바꿔서 들어가는것을 막기위해 변하면 속성값을 바꿔준다.
	$('#userID').change(function(){
	 	$('#idCheck').attr("value","N");
	});
	
	
});




 
 //다음(카카오) API 호출 함수 - memberForm의 주소 입력
 function daumZipCode() {
 	// alert("확인");
				
	new daum.Postcode({
		//alert("확인");			
		oncomplete: function(data) {
			//alert("확인");
			// 팝업창에서 검색한 결과에서 항목을 클릭하였을 경우에 실행할 코드를 이곳에 작성한다.
						
			// 각 주소의 노출 규칙에 따라서 주소를 조합해야 한다.
			// 내려오는 변수가 값이 없을 경우에는 공백('')값을 가지므로 이름을 참고하여 분기한다.
						
			var fullAddr = '';	// 최종 주소값을 저장할 변수
			var subAddr = '';	// 조합형 주소값을 저장할 변수
						
			// 사용자가 선택한 주소의 타입에 따라서 해당 주소 값을 가져온다.
			if(data.userSelectedType == 'R') {	// 도로명 주소를 선택한 경우	
			
				fullAddr		= data.roadAddress;
						
			}else {	// 지번 주소를 선택한 경우
			
				fullAddr		= data.jibunAddress;
				
			}	
						
			// 사용자가 선택한 주소가 도로명 타입일 때 조합한다.
			if(data.userSelectedType == 'R'){
				// 법정도명이 있을 경우에 추가한다.
				if(data.bname != ''){
					subAddr += data.bname;
				}
				// 건물명이 있을 경우에 추가한다.
				if(data.buildingName != ''){
					subAddr += (subAddr != '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 조합형 주소의 유무에 따라서 양쪽에 괄호를 추가하여 최종 주소를 만든다.
				fullAddr += (subAddr != '' ? '(' + subAddr +' )' : ' ');
			}
						
			// 우편번호와 주소정보를 화면의 해당 필드에 출력시킨다.
			document.getElementById('postnum').value	= data.zonecode;	// 5자리의 새 우편번호
			document.getElementById('address1').value	= fullAddr;
						
			// 커서를 상세주소 입력란으로 이동시킨다.
			document.getElementById('address2').focus();
		}
					
	}).open({
		//open에 이름을 부여하여 우편번호 팝업창이 여러개 뜨는 것을 방지하기 위해서 popupName을 사용한다.
		popupName:	'postcodePopup'
	});		
}


// 이이디 중복 검사 ajax
function fn_idCheck(){
	//alert("확인");
	
	$.ajax({
		url: "/member/idCheck",
		type: "post",
		dataType: "json",
		data: {"userID" : $("#userID").val()},
		success: function(data){
			if(data == 1){ // 데이터가 있는 경우이므로 이미 아이디가 있다.
				
				$("#idCheck").attr("value","N"); //아이디가 존재하므로 속성에 N변경
				alert("이미 사용중인 아이디 입니다.");
			}else if(data == 0){ // 입력한 아이디가 DB에 존재하지 않는 경우
			
				//버튼 id = "idCheck"의 속성인 value 값을 "N"에서 "Y"로 변경
				$("#idCheck").attr("value","Y");
				alert("사용 가능한 아이디입니다.");
			}
		}
	});
}


//가입하기 버튼 누를때 유효성 검사하기
function addmember(){
	//alert("확인");
	let userID =  document.getElementById("userID");
	let idCheck = document.getElementById("idCheck");
	let pwd =  document.getElementById("pwd");
	let repwd =  document.getElementById("repwd");
	let name =  document.getElementById("name");
	let postnum =  document.getElementById("postnum");
	let address1 =  document.getElementById("address1");
	let address2 =  document.getElementById("address2");
	let age =  document.getElementById("age");
	let email =  document.getElementById("email");
	let phone =  document.getElementById("phone");
	
	
	if(userID.value == ""){
		alert("아이디를 입력해주세요");
		userID.focus();
		return false;
	}
	if(userID.value.length < 4){
		alert("아이디를 4자리 이상을 입력하셔야 합니다.");
		userID.focus();
		return false;
	}
	
	if(idCheck.value == "N"){
		alert("아이디 중복검사가 필요합니다. 중복확인을 해주세요");
		idCheck.focus();
		return false;
	}
	
	if(pwd.value == ""){
		alert("비밀번호를 입력해주세요");
		pwd.focus();
		return false;
	}
	if(pwd.value.length < 4){
		alert("비밀번호를 4자리 이상을 입력하셔야 합니다.");
		pwd.focus();
		return false;
	}
	if(pwd.value != repwd.value){
		alert("비밀번호 재확인이 다릅니다.");
		pwd.focus();
		return false;
	}
	if(name.value == ""){
		alert("이름을 입력해주세요");
		name.focus();
		return false;
	}
	if(postnum.value == ""){
		alert("우편번호을 입력해주세요");
		postnum.focus();
		return false;
	}
	if(address1.value == ""){
		alert("주소을 입력해주세요");
		address1.focus();
		return false;
	}
	if(address2.value == ""){
		alert("상세주소을 입력해주세요");
		address2.focus();
		return false;
	}
	if(email.value == ""){
		alert("이메일을 입력해주세요");
		email.focus();
		return false;
	}
	if(phone.value == ""){
		alert("핸드폰 번호를 입력해주세요");
		phone.focus();
		return false;
	}
		
	
}

//비밀번호  확인 함수
 function passConfirm() {
 
 	let pwd = document.getElementById('pwd');					//비밀번호 
	let repwd = document.getElementById('repwd');				//비밀번호 확인 값
	let confrimMsg = document.getElementById('confirmMsg');		//확인 메세지
	let correctColor = "#0000FF";	//맞았을 때 출력되는 색깔.
	let wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
					
	if(pwd.value == repwd.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
		confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
		confirmMsg.innerHTML ="비밀번호가 일치합니다";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호가 일치하지 않습니다.";
	}

 }
 
 
 // 로그인 화면에서 로그인 버튼 눌렀을때
 function fn_login(){
 	//alert("확인");
 	
 	let userID = $("#userID").val();
 	let pwd = $("#pwd").val();
 	
 	//alert("userID = " + userID + "pwd = " + pwd);
 	
 	$.ajax({
 		type:"POST",
 		url: "/member/login.do",
 		data: {userID:userID, pwd:pwd},
 		success: function(data){
 			
			if(data == 1){ //아이디값이 없음
				alert("아이디를 입력하세요.");

			} else if (data == 2) { //비밀번호가 다름
				alert("비밀번호가 다릅니다.");

			} else if (data == 3){	//db에 없는 아이디일때
				alert("존재하지 않는 아이디입니다.");
			} else{
				location.href="/main.do";
			}
		 		
 		}
 	
 	});
 	
 		
 }//end - 로그인 처리
 
