<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
			<link href="${contextPath}/resources/css/board/boardRegisterForm.css" rel="stylesheet" type="text/css">
			<script src="${contextPath}/resources/js/board.js"></script>
</head>
<body>

	<!-- 상단 메뉴 -->
	<jsp:include page="../common/topMenu.jsp" flush="false"/>
	
	<div class="container">
		<h2>문의하기</h2>
		<form>			
			<div>
			<input type="hidden" id="userID" name="userID" value="${member.userID}"/>
				<label for="board_subject">제목</label>
				<div>
					<input type="text" class="form-control" id="board_subject" name="board_subject" maxlength="80" placeholder="&nbsp;&nbsp;제목을 입력하세요"/>
				</div>			
			</div>
			<div>
				<label for="board_content">내용</label>
				<div>
					<textarea class="form-control" id="board_content" name="board_content" maxlength="1000" placeholder="&nbsp;&nbsp;내용을 입력하세요"></textarea>
				</div>
			</div>
				<div id="registerFormBtn">
					<input type="button" id="cancle" onclick="location.href='/board/boardList?page=1'"  value="취소">
					<input type="button" id="register" onclick="fn_boardRegister();"  value="등록">
				</div>
		</form>
	</div>

</body>
</html>