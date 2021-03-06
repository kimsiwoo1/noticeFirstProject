<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

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

<title>Jsp-basicLib</title>
<%@ include file="/commonjsp/basicLib.jsp"%>

<script>
//문서 로딩이 완료되고 나서
$(document).ready(function(){
	
	//사용자 정보 클릭시 이벤트 핸들러
	$(".postTr").on("click", function(){
		if($(this).data("del") == 0){
			
			console.log("postTr click");
			
			//클릭된 tr 태그의 자식태그(td)중 첫번째 자식의 텍스트 문자열
							
			//td태그의 텍스트 가져오기(두번째 자식)
			var tdText = $($(this).children()[1]).text();
			console.log("tdText : " + tdText);
			
			//input태그에 저장된 값 확인
			var inputValue = $(this).find("input").val();
			console.log("inputValue : " + inputValue);
			
			//data속성으로 값 가져오기
			//data속성명은 소문자로 치환된다!!
			//data-userId $(this).data("userid");
			//대소문자 주의!!!!!!
			var dataValue = $(this).data("postno");
			console.log("dataValue : " + dataValue);
			
			//input 태그에 값 설정
			$("#postNo").val(dataValue);
			
			//form 태그이용 전송
			console.log("serialize : "  + $("#frm").serialize());
			
			$("#frm").submit();
		}
		
	});
});
</script>
</head>

<body>
<form id="frm" action="${cp }/post" method="get">
	<input type="hidden" id="postNo" name="postNo" />
	<input type="hidden" id="boardNo" name="boardNo" value="${boardPro.boardNo }"/>
</form>
	
	<!-- header -->
	<%@ include file="/commonjsp/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonjsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${boardPro.boardNm }</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>
								<c:forEach items="${postList }" var="post" varStatus="loop">
									<c:set var="del" value="${post.del }"/>
										<c:if test="${del =='0' }">
											<tr class="postTr" data-postNo="${post.postNo }" data-del="${post.del }" >
												<td>${post.postNo }</td>
												<td>
													<c:forEach begin="0" end="${(post.level-1)*2 }">
														&nbsp;
													</c:forEach>
													${post.postNm }</td>
												<td>${post.userId }</td>
												<td>${post.writeDate }</td>
											</tr>
										</c:if>
										
										<c:if test="${del =='1' }">
											<tr class="postTr" data-postNo="${post.postNo }" data-del="${post.del }">
												<td></td>
												<td>
													<c:forEach begin="0" end="${(post.level-1)*2 }">
														&nbsp;
													</c:forEach>
													[삭제된 게시글 입니다]</td>
												<td></td>
												<td></td>
											</tr>
										</c:if>
										
								</c:forEach>
							</table>
						</div>

						<a href="${cp }/postNew?boardNo=${boardPro.boardNo }" class="btn btn-default pull-right">새 글 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%--이전 페이지 가기 :지금 있는 페이지에서 한 페이지 전으로
									단 1페이지인 경우는 li 태그에 class="disabled"를 추가를 하고
									이동 경로는 차단 
								--%>
									<c:choose>
										<c:when test="${pageVo.page == 1 }">
											<li class="disabled">
												<span aria-hidden="true">&laquo;</span>
											</li>
										</c:when>
										<c:otherwise>
											<li>
												<a href="${cp }/boardView?boardNo=${boardPro.boardNo }&page=${pageVo.page-1 }" aria-label="Previous"> 
													<span aria-hidden="true">&laquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
								

								<c:forEach begin="1" end="${paginationSize }" var="page">
									
									<c:choose>
										<c:when test="${page == params.page }">
											<li class="active"><span>${page }</span></li>
										</c:when>
										<c:otherwise>
											<li><a href="${cp }/boardView?boardNo=${boardPro.boardNo }&page=${page }">${page }</a></li>
										</c:otherwise>
									</c:choose>
									
								</c:forEach>
								
								<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled">
											<span aria-hidden="true">&raquo;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${cp }/boardView?boardNo=${boardPro.boardNo }&page=${pageVo.page+1 }" aria-label="Next"> 
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>