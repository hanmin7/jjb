<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
<!-- <script>
	$(document).on('click', '#btnList', function(){
		location.href = "${pageContext.request.contextPath}/board/BoardList";
	});

</script> -->
</head>
<body>
<article>

		<div class="container" role="main">

			<h2>자유게시판</h2>

			<div class="title"><c:out value="${board.board_id}"/></div>
			
			<div class="bg-white rounded shadow-sm">

				<div class="title"><c:out value="${board.title}"/></div>

				<div class="board_info_box">

					<span class="member_id"><c:out value="${board.member_id}"/>,</span><span class="board_date"><c:out value="${board.board_date}"/></span>

				</div>

				<div class="contents">${board.contents}</div>

				</div>

			

			<div style="margin-top : 20px">

				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>
		</div>

	</article>

</body>
</html>