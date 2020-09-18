<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>/member/memInsert.jsp</title>


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
					action="${pageContext.request.contextPath}/memInsert.do">
				<fieldset>
					<br>
					<h3>회원가입</h3>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">ID</label>
						<div class="col-md-5">
							<input id="member_id" name="member_id" type="text" placeholder="username"
								class="form-control input-md" required="required">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="passwordinput">Password</label>
						<div class="col-md-5">
							<input id="member_pw" name="member_pw" type="password"
								placeholder="" class="form-control input-md" required="required">
							<span class="help-block">max 16 characters</span>
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="confirm_password">Confirm
							Password</label>
						<div class="col-md-5">
							<input id="confirm_password" name="confirm_password"
								type="password" placeholder="Re-type password"
								class="form-control input-md" required="required">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">Name</label>
						<div class="col-md-5">
							<input id="Name" name="member_name" type="text" placeholder="username"
								class="form-control input-md" required="required">
						</div>
					</div>

					<!-- Textarea 
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">Address</label>
						<div class="col-md-4">
							<textarea class="form-control" id="address" name="address">default text</textarea>
						</div>
					</div> -->
					
					
					<!-- age -->
					
					
					<!-- <div class="row">					
						<div class="col">
							<label class="col-md-4 control-label">생년월일</label>
						</div>
						<div class="col">
							<input type="text" class="form-control input-sm" placeholder="년(4자)">
						</div>
						<div class="col">
							<select id="member_job" name="member_job" class="form-control">
								<option value="1">1월</option>
								<option value="2">2월</option>
								<option value="3">3월</option>
								<option value="4">4월</option>
							</select>
						</div>
						<div class="col">
							<input type="text" class="form-control input-sm" placeholder="일">
						</div>
					</div> -->

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">생년월일</label>
						<div class="col-md-5">
							<div class="form-row">
								<div class="col-md-4">
									<input type="text" class="form-control input-sm" placeholder="년(4자)" name="member_age1">
								</div>
								<div class="col-md-4">
									<select id="member_job" name="member_age2" class="form-control">
										<option value="01">1월</option>
										<option value="02">2월</option>
										<option value="03">3월</option>
										<option value="04">4월</option>
										<option value="05">5월</option>
									</select>
								</div>
								<div class="col-md-4">
									<input type="text" class="form-control input-sm" placeholder="일" name="member_age3">
								</div>
							</div>
						</div>
					</div>



					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="mobilenumber">Phone Number</label>
						<div class="col-md-5">
							<input id="phone_number" name="phone_number" type="text"
								placeholder="Phone Number" class="form-control input-md"
								required="required">

						</div>
					</div>

					<!-- Select Basic job -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="member_job">Job</label>
						<div class="col-md-5">
							<select id="member_job" name="member_job" class="form-control">
								<option value="학생">학생</option>
								<option value="취준생">취준생</option>
								<option value="직장인">직장인</option>
							</select>
						</div>
					</div>


					<!-- Select Basic job -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="is_major">전공</label>
						<div class="col-md-5">
							<select id="is_major" name="is_major" class="form-control">
								<option value="학생">컴공</option>
								<option value="취준생">예체능</option>
							</select>
						</div>
					</div>


					<!-- Multiple Radios (inline) --> 
					<div class="form-group">
						<label class="col-md-4 control-label" for="study_term">공부기간</label>
						<div class="col-md-5">
							<label class="radio-inline" for="gender-0"> 
								<input type="radio" name="study_term" id="gender-0" value="1일" checked="checked"> 1일-1개월
							</label> 
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="study_term" id="gender-1" value="2개월-6개월">2개월-6개월
							</label>
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="study_term" id="gender-1" value="6개월-1년">6개월-1년
							</label>
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="study_term" id="gender-1" value="1년이상">1년 이상
							</label>
						</div>
					</div>

					<!-- Multiple Radios (inline) --> 
					<div class="form-group">
						<label class="col-md-4 control-label" for="tested_num">시험횟수</label>
						<div class="col-md-5">
							<label class="radio-inline" for="gender-0"> 
								<input type="radio" name="tested_num" id="gender-0" value="0" checked="checked"> 0회
							</label> 
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="tested_num" id="gender-1" value="1">1회
							</label>
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="tested_num" id="gender-1" value="2">2회
							</label>
							<label class="radio-inline" for="gender-1">
								<input type="radio" name="tested_num" id="gender-1" value="3">3회 이상
							</label>
						</div>
					</div>


					<!-- Text input
					<div class="form-group">
						<label class="col-md-4 control-label" for="emailId">Email
							Id</label>
						<div class="col-md-6">
							<input id="emailId" name="emailId" type="text"
								placeholder="user@domain.com" class="form-control input-md"
								required="">

						</div>
					</div> -->

					<!-- Select Multiple -->
					<!-- <div class="form-group">
						<label class="col-md-4 control-label" for="languages">Languages
							Known</label>
						<div class="col-md-5">
							<select id="languages" name="languages" class="form-control"
								multiple="multiple">
								<option value="English">English</option>
								<option value="Hindi">Hindi</option>
								<option value="Malayalam">Malayalam</option>
								<option value="Others">Others</option>
							</select>
						</div>
					</div> -->

					<!-- Prepended checkbox -->
					<!-- <div class="form-group">
						<label class="col-md-4 control-label" for="check_critiria">Check
							the box</label>
						<div class="col-md-6">
							<div class="input-group">
								<span class="input-group-addon"> <input type="checkbox">
								</span> <input id="check_critiria" name="check_critiria"
									class="form-control" type="text"
									placeholder="I accept the criteria" required="">
							</div>

						</div>
					</div>   -->

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