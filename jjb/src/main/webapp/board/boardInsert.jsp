<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script>
	function inputCheck() {

		if (frm.title.value == "") {
			window.alert("제목 입력하세요");
			frm.title.focus();
			return false;
		}
		if (frm.id.value == "") {
			window.alert("작성자를 입력하세요");
			frm.contents.focus();
			return false;
		}
		if (frm.contexts.value == "") {
			window.alert("내용을 입력하세요");
			frm.title.focus();
			return false;
		}
	
		return true;
	}
</script> 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<title>boardInsert.jsp</title>
<style>
body {
	padding-top: 170px;
	padding-bottom: 30px;
}
</style>


</head>
<body>
	
		<div class="container" role="main">
			<h1 align="right">자유게시판</h1>
			<form id="frm" name="frm" id="frm" onsubmit="return inputCheck()" method="post" action="${pageContext.request.contextPath}/boardInsert.do">
				<div class="mb-3">
					<input  class="form-control" type="text" name="title" id="title" placeholder="제목"> 
					<input  class="form-control" type="text" name="member_id" id="member_id" placeholder="작성자"> 
					<input type="file" id="file" name="file">
				</div>

				<div class="mb-3">
					<textarea class="form-control" rows="10" name="contents" id="contents" placeholder="내용을 입력하세요"></textarea>
				</div>
				<div class="mb-3">
					<input class="form-control" type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요">
				</div>
			<div>
				<button type="submit" class="btn btn-sm btn-primary">저장</button>
				<button type="button" class="btn btn-sm btn-primary">취소</button>
			</div>
			</form>
		</div>
	
</body>

</html>