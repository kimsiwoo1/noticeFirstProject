<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-Main</title>

<%@ include file="/commonjsp/basicLib.jsp"%>
<script>
	$(function() {
		$('#btnCreate').on('click', function() {
			$('#frm').submit();
		})
		
		$('.blog-post').on('click', '#btnModify', function() {
			$('#frm2').submit();
		})
	})
</script>
</head>

<body>
	<%
		HttpSession httpSession = request.getSession();
		User userVo = (User) httpSession.getAttribute("S_USER");
		String userId = "";
		userId = userVo == null ? "" : userVo.getUserId();
	%>
	<!-- header -->
	<%@include file="/commonjsp/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@include file="/commonjsp/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">
						게시판 생성<br>
					</h1>
					<p class="lead blog-description">생성 및 관리</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<form id="frm" action="${cp }/noticeCreat" method="post">
								게시판 이름 <input type="text" id="boardNm" name="boardNm" /> 
								<input type="hidden" id="userId" name="userId" value="<%=userId%>" />
								<select id="boardSelect" name="boardSelect">
									<option value="1">사용</option>
									<option value="0">미사용</option>
								</select> <input type="button" id="btnCreate" value="생성" /><br><br>
							</form>
							
							<form id="frm2" action="${cp }/noticeModify">
								<c:forEach items="${list }" var="board">
									게시판 이름 <input type="text" id="boardNm" name="boardNm" value="${board.boardNm }"/>
									<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo }" />
									<select id="boardSelect" name="boardSelect">									
									   <c:choose>
									      <c:when test="${board.use =='0' }">
										    <option value="1">사용</option>
											<option value="0" selected>미사용</option>
									      </c:when>
									      <c:when test="${board.use =='1' }">
										    <option value="1" selected>사용</option>
											<option value="0">미사용</option>
									      </c:when>
									   </c:choose>
									</select> 
									<input type="button" id="btnModify" value="수정" /><br><br>
								</c:forEach>
							</form>
							
						</div>
					</div>
				</div>
				<!-- /.blog-main -->
			</div>
		</div>
	</div>
</body>
</html>
