<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
			<link href="${contextPath}/resources/css/board/boardList.css" rel="stylesheet" type="text/css">
			<script src="${contextPath}/resources/js/board.js"></script>
</head>
<body>

	<!-- 상단 메뉴 -->
	<jsp:include page="../common/topMenu.jsp" flush="false"/>
	
	<div class="container">
	<h2>문의내역</h2>
		<div>
		<h3>확인사항</h3>
		</div>
		<div>
		<ul>
			<li style="font-size:13px;">고객님께서 여행가자를 이용하시면서 불편하셨던 점을 올려주세요</li>
			<li style="font-size:13px;">고객만족을 위해 보다 좋은 서비스를 제공하도록 항상 노력하는 여행가자가 되겠습니다.</li>
		</ul>
		</div>
		
		<!-- 검색창 -->
		<div id="searchArea">
			<div>
				<select id="searchType" class="form-control" >
					<option value="s" <c:if test="${searchType == 's' }">selected</c:if>>제목</option>
					<option value="c" <c:if test="${searchType == 'c' }">selected</c:if>>내용</option>
					<option value="u" <c:if test="${searchType == 'u' }">selected</c:if>>글쓴이</option>
				</select>
			</div>
			<div>
				<input type="text" id="searchKeyword" value="${keyword}"/>
				<button id="searchBtn" class="glyphicon glyphicon-search"></button>
			</div>
		</div>
		
		<!-- 테이블 -->
		<div>
			<table id="boardTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>가</td>
						<td>d</td>
						<td>d</td>
						<td>d</td>
						<td>d</td>
						<td>d</td>
					</tr>
				</tbody>
			</table>
			<!-- 페이징 처리 -->
			<div id="bottomMaker">
				<div id="pageMaker" align="center">
					<ul class="btn-group pagination">
						<c:if test="${pageMaker.prev }">
							<li>
								<a href='<c:url value="/board/boardList?page=${pageMaker.startPage-1}&searchType=${searchType}&keyword=${keyword}"/>'><span class="glyphicon glyphicon-chevron-left"></span></a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="pageNum">
							<li>
								<a href='<c:url value="/board/boardList?page=${pageNum}&searchType=${searchType}&keyword=${keyword}"/>'><i>${pageNum}</i></a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li>
								<a href='<c:url value="/board/boardList?page=${pageMaker.endPage+1}&searchType=${searchType}&keyword=${keyword}"/>'><span class="glyphicon glyphicon-chevron-right"></span></a>
							</li>
						</c:if>					
					</ul>
				</div>
				<div id="boardRegisterForm">
					<button type="button" id="boardRegisterFormbtn" onclick="location.href='/board/boardRegisterForm'">
					<span class="glyphicon glyphicon-pencil" style="font-weight:bold">&nbsp;문의하기</span>
					</button>
				</div>  
			</div>
		</div>	
	</div>
	
	<form id="formList" action="/board/boardList?page=1" method="get">
		<input type="hidden" name="searchType" value="${searchType}"/>
		<input type="hidden" name="keyword" value="${keyword}"/>
	</form>
	
</body>
</html>