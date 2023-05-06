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
	<link href="${contextPath}/resources/css/member/myPage.css" rel="stylesheet" type="text/css">
	<script src="${contextPath}/resources/js/member.js"></script>
</head>
<body>
<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<div class="container">
	<div class="main-header row">
		<div class="col-sm-7">
			<h1>....님 안녕하세요.</h1>
			<h2>항상 찾아주셔서 감사합니다.</h2> 
			<h2>즐거운 여행되세요.</h2>
		</div>
		<div class="col-sm-5" id="head">
			<span><img src="../resources/images/plane.png" style="withd:200px; height:200px;" /></span>
		</div>
	</div>
	<div>
		<h2>예약 내역</h2>
		<div>
		</div>
		<div class="jumbotron" id="reservation">
			<table id="reservation_table">
				<thead>
					<tr>
						<th>...</th>
						<th>...</th>
						<th>...</th>
						<th>...</th>
						<th>...</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>ㅇㄴㅁㄻ</td>
						<td>ㅇㅁㄴㄹ</td>
						<td>ㅁㄴㅇㄹ</td>
						<td>ㅇㄴㅁㄹ</td>
						<td>ㅁㄴㅇㄹ</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


</body>
</html>