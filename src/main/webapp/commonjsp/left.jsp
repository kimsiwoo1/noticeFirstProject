<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@page import="kr.or.ddit.board.service.BoardService"%>
<%@page import="kr.or.ddit.board.model.BoardPro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	IBoardService boardService = new BoardService();
	List<BoardPro> list = boardService.getAllBoard();
	pageContext.setAttribute("list", list);
%>
<ul class="nav nav-sidebar">
	<!-- a tag : get method -->
	<li class="active"><a href="${cp }/noticeCreat">게시판 생성 <span class="sr-only">(current)</span></a></li>
	<c:forEach items="${list }" var="board" varStatus="loop">
		<li class="active"><a href="${cp }/boardView?boardNo=${board.boardNo }">${board.boardNm } <span class="sr-only">(current)</span></a>
		</li>
	</c:forEach>
</ul>