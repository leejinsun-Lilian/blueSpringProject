<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${contextPath}/resources/css/header.css" type="text/css">
<title>header</title>
</head>
<body>
	<c:set var="contextPath" scope="application" value="${pageContext.servletContext.contextPath}"></c:set>

	<div class="header_wrap">

		<div class="header_menu">
			<a id="logo_link" href="#"><img id="logo" src="${contextPath}/resources/img/bluespringlogo.png"></a>
			<ul id="nav">
				<li>
					<div class="notice nav_title">공지사항</div>
					<div class="sub">
						<ul>
							<li><a href="#">정부정책</a></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="community nav_title">커뮤니티</div>
					<div class="sub">
						<ul>
							<li><a href="#">자유게시판</a></li>
						</ul>
					</div>
				</li>
				<li>
					<div class="challengers nav_title">챌린지</div>
					<div class="sub">
						<ul>
							<li><a href="/challenge/challengeList.jsp">챌린지</a></li>
							<li><a href="/challengeCrtfd/challengeCrtfdList.jsp">인증게시판</a></li>
						</ul>				
					</div>
				</li>
				<li>
					<div class="center nav_title">기관찾기</div>
					<div class="sub">
						<ul>
							<li><a href="#">센터/병원찾기</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
	
		<div class="login">
			<button type="button" id="header_login">로그인</button>
			<button type="button" id="header_join">회원가입</button>
		</div>
	
		
	</div>

</body>

</html>
