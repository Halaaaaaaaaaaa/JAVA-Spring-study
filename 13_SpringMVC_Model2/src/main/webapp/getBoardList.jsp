<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ezen.biz.dao.BoardDAO" %>
<%@ page import="com.ezen.biz.dto.BoardVO" %>
<%
	//세션에 저장된 boardList 정보(게시글 목록) 가져오기
	//object 타입이기 때문에 List로 형변환
	List<BoardVO> boardList = (List)session.getAttribute("boardList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<style>
	a {
		text-decoration-line: none;
	}
	table {
		width:700; 
		text-align:center;
	}
</style>
<div align="center">
	<h1>게시글 목록</h1>
	<h3>테스트님 환영합니다&emsp;<a href="logout.do">LogOut</a></h3>
	
	<!-- 검색 파트 -->
	<form action="getBoardList.do" method="post">
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<td>
				<select name="searchCondition">
					<option value="TITLE">제목
					<option value="CONTENT">내용
				</select>
				<input type="text" name="searchKeyword"/>
				<input type="submit" value="검색"/>
			</td>
			<td width="100px"><a href="insertBoard.jsp">새 글 등록</a></td>
		</tr>
	</table>
	</form>
	<!-- 검색 파트 종료 -->
	
	<!-- 게시글 목록 출력 -->
	<br>
	<table border="1">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
<!-- Java 코드를 통해 전달된 게시글 목록 데이터를 반복하여 읽어 출력 -->
<%
	for (BoardVO board : boardList) {
%>
	<tr>	
		<td><%= board.getSeq() %></td>
		<td><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
		<td><%= board.getWriter() %></td>
		<td><%= board.getRegDate() %></td>
		<td><%= board.getCnt() %></td>
	</tr>
<% } %>
	</table>
	<!-- 게시글 목록 출력 종료-->
</div>
</body>
</html>