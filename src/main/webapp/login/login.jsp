<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="${cp }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${cp }/css/signin.css"
	rel="stylesheet">

<script src="${cp }/js/jquery-3.4.1.min.js"></script>

<script src="${cp }/js/js.cookie.js"></script>
<script>
	$(document).ready(function() {
		$("#signinBtn").on("click", function() {
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
	<div class="container">
		<form id="frm" class="form-signin"
			action="${cp}/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			
			<label for="userId" class="sr-only">ID</label>
			<%
				String userId = request.getParameter("userId");
				userId = userId == null ? "" : userId;
			%>
			<input type="text"	id="userId" name="userId" class="form-control"
			placeholder="ID" required autofocus="autofocus"/>
			
			<label for="pass" class="sr-only">PASSWORD</label>
			<input type="password"	id="pass" name="pass" class="form-control"
			placeholder="PASSWORD" required>
			
			<button id="signinBtn" class="btn btn-lg btn-primary btn-block"
				type="button">SIGN IN</button>
		
		</form>

	</div>
	<!-- /container -->
</body>
</html>