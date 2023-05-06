<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath }"/>
<c:set var = "result" value = "${param.result }"/>
<% request.setCharacterEncoding("UTF-8"); %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
	
	 <!-- 달력쓰기위해 추가 -->
	 <!-- 제이쿼리 ui css -->
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	 <!-- 제이쿼리 style css -->
	 <link rel="stylesheet" href="/resources/demos/style.css">
	 <!-- 제이쿼리 js -->
	 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 <!-- 제이쿼리 ui js -->
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 <!-- 다음 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<link href="${contextPath}/resources/css/member/memberForm.css" rel="stylesheet" type="text/css">
	<script src="${contextPath}/resources/js/member.js"></script>
</head>
<body>	

<!-- 상단화면 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

	<div class="member">
		<form class="form" method="post" id="loginForm" name="loginForm" action="${contextPath }/member/addMember.do">
		<div class="field">
			<b>아이디</b>
			<input type="text" id="userID" name="userID">
			<button type="button" id="idCheck" onclick="fn_idCheck();" value="N" >아이디 중복 검사</button>
			<strong style = "color: red;">&nbsp;&nbsp;ID 중복 여부를 확인해주세요.</strong>
		</div>
		
		<div class="field">
			<b>비밀번호</b>
			<input class="pwd" id="pwd" name="pwd" type="password">
		</div>
		<div class="field">
			<b>비밀번호 재확인</b>
			<input class="userpw-confirm" id="repwd" name="repwd" type="password" onkeyup="passConfirm()">
			<strong><span id ="confirmMsg"></span></strong>
		</div>
		
		<div class="field">
			<b>이름</b>
			<input type="text" id="name" name="name">
		</div>
		<div class="field">
			<b>우편번호</b>
			<input type="text" id="postnum" name="postnum" placeholder="우편번호 검색을 눌러주세요" readonly/>
			<input type = "button" class = "form-control postBtn" onclick = "daumZipCode()" value = "우편번호 검색"/>
		</div>
		<div class="field">
			<b>주소</b>
			<input type="text" id="address1" name="address1" readonly/>
		</div>
		<div class="field">
			<b>상세주소</b>
			<input type="text" id="address2" name="address2">
		</div>
		<div class="field">
			<b>나이</b>
			<input type="text"  id="age" name="age" readonly>
		</div>
		<div class="field">
			<b>이메일</b>
			<input type="email" id="email" name="email" placeholder="이메일을 입력하세요."> 
		</div>
		<div class="field">
			<b>핸드폰 번호</b>
			<input type="text" id="phone" name="phone">
		</div>
		<div class="field gender">
            <b>성별</b>
            <div>
                <label><input type="radio" name="gender" value="male" checked>남자</label>
                <label><input type="radio" name="gender" value="female">여자</label>
            </div>
        </div>
		
		<input type="submit" form="loginForm" value="가입하기" onclick = "return addmember()">	
		</form>
	</div>
	


	
</body>
</html>