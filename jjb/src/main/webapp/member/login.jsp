<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style>
body {
    padding-top: 90px;
}
.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
}
.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align:center;
}
.panel-login>.panel-heading a{
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login>.panel-heading a.active{
	color: #029f5b;
	font-size: 18px;
}
.panel-login>.panel-heading hr{
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
}
.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login input:hover,
.panel-login input:focus {
	outline:none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}
.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}
.btn-login:hover,
.btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}
.forgot-password {
	text-decoration: underline;
	color: #888;
}
.forgot-password:hover,
.forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}
.btn-register:hover,
.btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function() {
	
    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
		$("#userRegister").delay(100).fadeIn(100);
 		$("#login2-form").fadeOut(100);
		$('#login2-form-link').removeClass('active');
 		$("#user2Register").fadeOut(100);
		$('#user2Register-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#login2-form-link').click(function(e) {
		$("#login2-form").delay(100).fadeIn(100);
		$("#user2Register").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
 		$("#userRegister").fadeOut(100);
		$('#userRegister-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});




$(function(){
	if("${errorcode}" > 0 && "${errorcode}" < 5 ){
		alert("${errormsg}");		
	}
});


</script>
</head>
<body>
<%--=request.getAttribute("errormsg") --%>
	<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">일반회원</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="login2-form-link">강사회원</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="${pageContext.request.contextPath}/login.do" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="member_id" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required="required">
									</div>
									<div class="form-group">
										<input type="password" name="member_pw" id="password" tabindex="2" class="form-control" placeholder="Password" required="required">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Admin</label>
									</div>
									
									<!-- 로그인 버튼 -->
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
								</form>
									<!-- 가입버튼 -->
									<form id="userRegister" action="${pageContext.request.contextPath}/member/memInsert.jsp">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Register">
											</div>
										</div>
									</div>
									</form>
									

								
								
								<form id="login2-form" action="${pageContext.request.contextPath}/teacherlogin.do" method="post" role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="teacher_id" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required="required">
									</div>
									<div class="form-group">
										<input type="password" name="teacher_password" id="password" tabindex="2" class="form-control" placeholder="Password" required="required">
									</div>
									
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Admin</label>
									</div>
									
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
								</form>
									
									<form id="user2Register" action="${pageContext.request.contextPath}/member/profInsert.jsp" style="display: none;">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Register">
											</div>
										</div>
									</div>
									</form>
									

								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="https://phpoll.com/recover" tabindex="5"
													class="forgot-password">Forgot Password?</a>
											</div>
										</div>
									</div>
								</div>

									<form id="user2Register" action="${pageContext.request.contextPath}/main.jsp" style="display: block;">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="취소">
											</div>
										</div>
									</div>
									</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>