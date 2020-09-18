<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<title>/member/profInsert.jsp</title>

<script>
$(function(){
	if("${errorcode}"=="2"){
		alert("${errormsg}");		
	}
})
</script>


</head>

<body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" name="frm" method="post" id="frm" 
					action="${pageContext.request.contextPath}/profInsert.do">
				<fieldset>
					<br>
					<h3>교사 회원가입</h3>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">ID</label>
						<div class="col-md-5">
							<input id="Name" name="teacher_id" type="text" placeholder="username"
								class="form-control input-md" required="required">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="passwordinput">Password</label>
						<div class="col-md-5">
							<input id="passwordinput" name="teacher_password" type="password"
								placeholder="" class="form-control input-md" required="required">
							<span class="help-block">max 16 characters</span>
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="confirm_password">Confirm
							Password</label>
						<div class="col-md-5">
							<input id="confirm_password" 
								type="password" placeholder="Re-type password"
								class="form-control input-md" required="required">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">Name</label>
						<div class="col-md-5">
							<input id="Name" name="teacher_name" type="text" placeholder="username"
								class="form-control input-md" required="required">
						</div>
					</div>



					<div class="form-group">
					<label class="col-md-4 control-label" for="address">프로필 사진</label>
						<div>
							<label for="filename">Select a file:</label> 
							<input type="file" id="filename" name="teacher_picture">
						</div>
					</div>


					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">이력</label>
						<div class="col-md-4">
							<textarea class="form-control" id="address" name="teacher_record">default text</textarea>
						</div>
					</div>
					
					
					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">보유자격증</label>
						<div class="col-md-4">
							<textarea class="form-control" id="address" name="teacher_certificate">default text</textarea>
						</div>
					</div>
					

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="submit"></label>
						<div class="col-md-4">
							<button id="submit" name="submit" class="btn btn-success">Submit</button>
							<a href="${pageContext.request.contextPath}/member/login.jsp"><input value="취소" class="btn"></a>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>