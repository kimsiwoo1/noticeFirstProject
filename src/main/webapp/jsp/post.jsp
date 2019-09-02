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

</script>
<style>
	label{
		width : 100px;
		height : 30px;
		display : inline-block;
		vertical-align: top;
	}
</style>
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
						게시물<br>
					</h1>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
						<form action="${cp }/postModify" method="post" enctype="multipart/form-data">
							<input type="hidden" id="no" name="no" value="${boardNo }">
							<input type="hidden" id="userId" name="userId" value="<%=userId%>">
							<label for="postNm">제목</label>
							<input type="hidden" id="postNm" name="postNm" value="${post.postNm }">
							${post.postNm }
							<br>
							<label for="postContents">글내용</label>
							<input type="hidden" id="postContents" name="postContents" value="${post.postContents }">
							${post.postContents }
							<br>
							<button>수정</button>
							<input type="button" id="delete" name="delete" value="삭제"/>
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
