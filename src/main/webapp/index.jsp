<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>欢迎来到 ${currentUser==null?"我的":currentUser.nickName}Blog</title>
<link rel="Stylesheet" type="text/css" href='Content/base.css' />
<link rel="Stylesheet" type="text/css" href='Content/index.css' />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<img id="header-logo" src="Content/images/logo.jpg" alt="blog-logo" />
		</div>
		<div id="content">
			<div id="sideBar">
				<div id="sideBar-login">
				<form action="LoginAction" method="post" id="login">
					<fieldset>
					<c:if test="${currentUser==null}">
						<div>
							<label class="title">用户名：</label><input class="txt" type="text"
								id="username" name="userName" />
						</div>
						<div class="clearBoth">
							<label class="title">密码：</label><input class="txt"
								type="password" id="password" name="password" />
								<c:if test="${!empty message}">															
								<label class="login-error">${message}</label>	
								</c:if>								
						</div>
						<div class="clearBoth">
							<input type="submit" id="btnLogin" name="btnLogin" value="" /> <a
								href="#" id="btnRegister"></a>
						</div>
						</c:if>
					</fieldset>
					</form>
					
				<c:if test="${currentUser!=null}">
                        <div id="function-panel">
                            <h3>欢迎回来，${currentUser.nickName}。</h3>
                            <ul>
                                <li><a href="MyBlogAction?userId=${currentUser.id}">去维护我的博客和相册</a></li>
                                <li><a href="MessageSearchAction?userId=${currentUser.id}">维护个人资料</a></li>
                                <li><a href="LogoutAction">注销登录</a></li>
                            </ul>
                        </div>
                 </c:if>  
				</div>
				<div class="sideBar-block">
					<h3 class="sideBar-block-title">最新博文</h3>
					<div id="newArticles" class="sideBar-block-body">
						<ul>
							<c:forEach var="c" items="${newArticleTitleList}">
								<li><a href="DetailsAction?id=${c.id}&userId=${c.user.id}">${c.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="sideBar-block">
					<h3 class="sideBar-block-title">热门博主</h3>
					<div id="hotAuthors" class="sideBar-block-body">
						<ul>
							<c:forEach var="u" items="${topNickNameList}">
								<li><a href="MyBlogAction?userId=${u.id }">${u.nickName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div id="main">
				<div>
					<img src="Content/images/index-ad.gif" alt="" />
				</div>
				<div id="hotArticles">
					<h3>热门博文</h3>
					<div class="linedot"></div>
					<c:forEach var="a" items="${topClicksList}">
					<table class="article">
						<tr>
							<td rowspan="3" class="article-author"><img
								src="UserFiles/UserHeads/${a.user.id}.jpg" alt="" /></td>
							<td class="article-title"><h3><a href="DetailsAction?id=${a.id}&userId=${a.user.id}">${a.title}</a></h3></td>
						</tr>
						<tr>
							<td class="article-body">${a.contentInfo}....</td>
						</tr>
						<tr>
							<td class="article-link"><a href="DetailsAction?id=${a.id}&userId=${a.user.id}">查看全文>></a></td>
						</tr>
					</table>
					<div class="linedot"></div>
					</c:forEach>				
				</div>
			</div>
			<div class="clearBoth"></div>
		</div>
		<div id="footer">
			<p>媒体报道 | 关于我们 | 工作机会 | 相关法律 | 广告服务 | Bus小店 | 申请博客 | 网站地图 | 合作伙伴
			</p>
			<p>© 2002 - 2011 SamsBlog.com, All Rights Reserved. Sams Blog
				版权所有 粤ICP B2-20080056号</p>
		</div>
	</div>
</body>
</html>