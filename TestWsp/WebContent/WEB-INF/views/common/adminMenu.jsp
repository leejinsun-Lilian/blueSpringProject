<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
	
	
	.adminMenu_area{
		width: 20%;
		margin : 20px 0 0 3px; /* 위  오른쪽 아래 왼쪽 */
		padding : 0;
		display : inline-block;
		border : 1px solid rgb(166 167 169 / 89%);
		float: left;
	}
	
	.adminMenu {
		margin : auto;
		width : 90%;
	}
	
	.adminMenu > ul {
		margin : 0;
		padding : 0;
	}
	
	.adminMenu_list {
		background-color: rgb(210 212 218 / 89%);
	}
	
	.adminMenu > ul > li {
		text-align: center;
		padding : 5px 0 5px;
		margin : 8px 0 8px;
		list-style-type: none;
	}
	
	.adminMenu_title {
		text-decoration: none;
		color : black;
		margin : auto;
	}
	
	.adminMenu_title_area > a:hover {
		text-decoration: none;
		color : black;
	}
	</style>
	
<div class="adminMenu_area">
	<div class="adminMenu">
		<ul>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminMemberInfo.do">회원정보 조회</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminReport.do">신고목록 조회</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminBlacklistInfo.do">블랙리스트 조회</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminCenterInfo.do">기관정보 조회</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminBoard.do">자유게시판 관리</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminChall.do">챌린지 관리</a>
				</div>
			</li>
			<li class="adminMenu_list">
				<div class="adminMenu_title_area">
					<a class="adminMenu_title" href="${contextPath}/admin/adminCrtfd.do">인증게시판 관리</a>
				</div>
			</li>
		</ul>
	</div>
</div>