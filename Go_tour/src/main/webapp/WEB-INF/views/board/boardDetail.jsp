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
<title>게시글 상세</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
			<link href="${contextPath}/resources/css/board/boardDetail.css" rel="stylesheet" type="text/css">
			<script src="${contextPath}/resources/js/board.js"></script>
</head>
<body>
	<!-- 상단 메뉴 -->
	<jsp:include page="../common/topMenu.jsp" flush="false"/>
	
	<div class="container">
		<h2>문의내역</h2>
		<h4>${boardDTO.problem_type1} > ${boardDTO.problem_type2} &nbsp;&nbsp;&nbsp;&nbsp;${boardDTO.region}</h4>
		<div>
			<table>
				<tr>
					<td id="board_subject">${boardDTO.board_subject}</td>
				</tr>
				<tr>
				    <td id="board_regDate" style="white-space: nowrap;">
				       	<fmt:formatDate value="${boardDTO.board_regDate}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;&nbsp;
				       	<c:choose>
				        <c:when test="${boardDTO.process_status == 'N' }">
				            <span id="process_status1">접수</span>
				        </c:when>
				        <c:otherwise>
				            <span id="process_status2"><span class="check-icon">&#10003;</span>답변완료</span>
				        </c:otherwise>
				        </c:choose>
				    </td>
				</tr>
				<tr>
					<td>${boardDTO.board_content}</td>
				</tr>
			</table>
		</div>
		
		
	
	</div>

</body>
</html>