<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="result"		 value="${param.result}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
	<link href="${contextPath}/resources/css/member/loginForm.css" rel="stylesheet" type="text/css">
	<script src="${contextPath}/resources/js/member.js"></script>
</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>


<div class="container">
	<form class="form-horizontal" method="post"  action="${contextPath}/member/login.do">
		<p>로그인</p>
		<div class="login">
			<label for="id">&nbsp;&nbsp;&nbsp;아이디&nbsp;&nbsp;</label>
			<input type="text" id="userID" name="userID" placeholder="아이디를 입력해주세요"/>
		</div>
		<div class="login">
			<label for="pwd">비밀번호&nbsp;</label>
			<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요"/>
		</div>
		<div>
			<input type="button" id="loginbutton" onclick="fn_login();" value="Login">
			<input type="button" id="button" onclick="location.href='/member/memberForm.do'" value="회원가입">
		</div>
	</form>
</div>

</body>
</html>