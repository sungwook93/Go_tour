<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="${contextPath}/resources/css/topMenu.css" rel="stylesheet" type="text/css">


<!-- html 주석 다는법 -->


</head>
<body>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="container-fluid" id="logo">
		  <a id="logo2" href="/main.do"><img src = "../resources/images/airplane.png" style = "width: 50px; height:50px; margin-bottom:10px;"/>&nbsp;여행가자</a>
		</div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
		 	<ul class="nav navbar-nav">
		 		<li class="dropdown">
		 			<a class="dropdown-toggle"  data-toggle="dropdown" href="#">해외 여행<span class="caret"></span></a>
		 		</li>
		 		<li class="dropdown">
		 			<a class="dropdown-toggle" data-toggle="dropdown" href="#">국내 여행<span class="caret"></span></a>
		 		</li>
		 		<li class="dropdown">
		 			<a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판<span class="caret"></span></a>
		 			<ul class="dropdown-menu">
		 				<li><a href="/board/boardList?page=1">문의내역</a></li>
		 			</ul>
		 		</li>
		 	</ul>
		 	<ul class="nav navbar-nav navbar-right">
		 		<li><a href="#">장바구니</a></li>
		 		<li><a href="#">예약확인</a></li>
		 		<c:choose>
		 			<c:when test="${isLogOn == true && member != null}">
		 				<li><a href="/member/myPage">마이페이지</a></li>
		 				<li id="logout"><a href="/member/logout.do">로그아웃</a></li>
		 			</c:when>
		 			<c:otherwise>
			 			<li><a href="/member/loginForm.do">로그인</a></li>
			 			<li><a href="/member/memberForm.do">회원 가입</a></li>
		 			</c:otherwise>
		 		</c:choose>
		 	</ul>
		</div>
	</div>
</nav>


</body>
</html>