/**
 * 게시글 관련 함수
 */
 

function fn_boardRegister(){
	//alert("확인");

	// 게시글 등록 화면에서 입력한 값을 가져온다
	let userID		= $("#userID").val();
	let board_subject = $("#board_subject").val();
	let board_content = $("#board_content").val();
	
	alert( "userID = " + userID+"board_subject = "+board_subject+"board_content = "+board_content);
	
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
		data: {userID:userID, board_subject:board_subject, board_content:board_content},
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
 