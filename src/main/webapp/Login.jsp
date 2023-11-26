<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/Login.css">
<title>로그인</title>
</head>
<body>

<div class="navbar">
  <h1>Logo</h1>
  <div class="menu">Menu</div>
  <div class="menu">Menu</div>
  <div class="menu">Menu</div>
  <div class="search">Search</div>
</div>

<div class="main-content">
    <div class="center">
    <h1>로그인</h1>
    <p>아이디와 비밀번호를 입력해주세요.</p>
    <form action="login" method="post">
        <label for="UserID">아이디</label>
        <input type="text" id="UserID" name="UserID" placeholder="아이디를 입력해주세요"/>
        <br>
        <label for="UserPassword">비밀번호</label>
        <input type="text" id="UserPassword" name="UserPassword" placeholder="비밀번호을 입력해주세요"/>
        <button type="submit">로그인</button>
        <br><a>회원가입</a>
        <a>아이디 찾기</a>
        <a>비밀번호 찾기</a>
    </div>
  </form>
</div>

<div class="footer">
  <div class="additional-link">Logo</div>
  <div class="additional-link">Additional Link</div>
  <div class="additional-link">Additional Link</div>
  <div class="copyright">© Your Company 2022. We love you!</div>
</div>
</body>
</html>