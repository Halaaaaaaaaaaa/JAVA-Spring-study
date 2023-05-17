<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
	h1 { font-size: 50px; margin-block-end: 0.5em; }
	body { margin-top: 20%; }
	table { text-align: center;	}
	hr { width: 310px; height: 3px; background-color: black; }
	button { border-radius: 10px; width: 310px; height: 40px; font-size: 15px; font-weight: bold; }
	input { width: 300px; height: 40px; }
</style>
<body>
<div align="center">
	<h1>로그인</h1>
	<hr><br>
	<form action="login.do" method="post">
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="아이디 입력"/></td>
			</tr>
			<tr>
				<td><input type="password" name="password" placeholder="비밀번호 입력"/></td>
			</tr>
			<tr>
				<td><button type="submit">로그인</button></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>