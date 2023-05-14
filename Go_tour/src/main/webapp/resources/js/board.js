/**
 * 게시글 관련 함수
 */
 
// 게시글 등록
function fn_boardRegister(){
	//alert("확인");

	// 게시글 등록 화면에서 입력한 값을 가져온다
	let userID		= $("#userID").val();
	let board_subject = $("#board_subject").val();
	let board_content = $("#board_content").val();
	let problem_type1 = $("#problem_type1 option:selected").text();
	let problem_type2 = $("#problem_type2 option:selected").text();
	let region = $("#region option:selected").text();
	
	//alert( $("#problem_type2").val());
	
	if($("#problem_type1").val() == "option0"){
		alert("필수사항을 입력해주세요");
		$("#problem_type1").focus();
		return false;
	}
	
	if($("#problem_type2").val() == "선택"){
		alert("필수사항을 입력해주세요");
		$("#problem_type2").focus();
		return false;
	}
	
	if($("#region").val() == "option0"){
		alert("필수사항을 입력해주세요");
		$("#region").focus();
		return false;
	}
	
	if($("#board_subject").val() == ""){
		alert("제목을 입력해주세요.");
		$("#board_subject").focus();
		return false;
	}
	
	if($("#board_content").val() == ""){
		alert("내용을 입력해주세요.");
		$("#board_content").focus();
		return false;
	}
	
	
	
	$.ajax({
		type: "POST",
		url: "/board/boardRegister",
		data: {userID:userID, board_subject:board_subject, board_content:board_content, problem_type1:problem_type1, problem_type2:problem_type2, region:region},
		success: function(data){
			if(data == "Y"){
				alert("게시글이 등록되었습니다.");
				location.href = "/board/boardList?page=1";
				
				
			}
		},
		error: function(data){
			alert("게시글 등록에 실패하였습니다");
		}
	});

}// end - function fn_boardRegister()

// 게시글 등록 옵션
function categoryChange(e){
  let problem_type2_a = ["선택"];
  let problem_type2_b = ["선택", "해외여행", "국내여행"];
  let problem_type2_c = ["선택", "해외여행", "국내여행"];
  let problem_type2_d = ["선택", "해외여행", "국내여행"];
  let problem_type2_e = ["선택", "이벤트", "기타"];
  let target = document.getElementById("problem_type2");
  let d = [];

  if(e.value == "option0") d = problem_type2_a;
  else if(e.value == "option1") d = problem_type2_b;
  else if(e.value == "option2") d = problem_type2_c;
  else if(e.value == "option3") d = problem_type2_d;
  else if(e.value == "option4") d = problem_type2_e;

  target.options.length = 0;

  for (x in d) {
    let opt = document.createElement("option");
    opt.value = d[x];
    opt.innerHTML = d[x];
    target.appendChild(opt);
  }
}

// 검색 버튼을 눌렀을 경우( jquery)
$(document).ready(function() {
			
	var formObj = $("#formList");
	
	// 검색 버튼을 눌렀을 경우
	$("#searchBtn").click(function() {
		var typeStr		= $("#searchType").find(":selected").val();
		var keywordStr	= $("#searchKeyword").val();
		//alert(typeStr + ":" + keywordStr);
		
		// 서버로 전송하기 전에, name 속성에 값을 넣어준다.
		formObj.find("[name='searchType']").val(typeStr);
		formObj.find("[name='keyword']").val(keywordStr);
		formObj.find("[name='page']").val("1");
		formObj.submit();
	});
	
});



 