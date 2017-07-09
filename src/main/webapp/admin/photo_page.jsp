<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<title>${currentUser==null?"我的":currentUser.nickName}Blog</title>
<link rel="Stylesheet" type="text/css" href="Content/blogManager.css" />
<style type="text/css">
.mainCol-head {
	background-image: url(Content/images/ihome-main-bg.gif);
	background-position: -2px 0px;
	height: 27px;
}

.mainCol-head .title {
	color: #333333;
	float: left;
	font-weight: 700;
	padding-left: 10px;
	height: 26px;
	line-height: 26px;
}

.clearBoth {
	clear: both;
}

.photoList{
	margin: 0px 30px;
}

.photoList li {
	float: left;
	margin: 10px 10px;
	text-align: center;
	
}

.photoList img {
border:1px solid #999999;
	width: 210px;
	height: 170px;
	padding:7px;
}
</style>
<script type="text/javascript" src="JQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#header-nav li a").hover(function() {
			$(this).addClass('current')
		}, function() {
			$(this).removeClass('current')
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="header-logo">
				<img src="Content/images/logo.jpg" alt="blog-logo" />
			</div>
			<ul id="header-nav">
				<li><a href="MessageSearchAction">个人中心</a></li>
				<li><a href="MyBlogAction?userId=${currentUser.id}">我的主页</a></li>
			</ul>
			<div class="clearBoth"></div>
			<hr />
		</div>
		<div id="content">
			<div id="sideBar">
				<div id="sideBar-author">
					<img src="UserFiles/UserHeads/${currentUser.id}.jpg" alt="" />
					<h3>${currentUser.nickName}</h3>
					<a href="#">修改个人资料</a>
				</div>
				<div class="line"></div>
				<ul id="sideBar-function">
                 	<li><a href="MessageSearchAction">文章</a></li>
					<li><a href="PhotoList">相册</a></li>
					<li><a href="IndexAction">首页</a></li>
				</ul>
			</div>
			<div id="main">
				<div class="mainCol-head">
					<span class="title">相册:${album.name}</span>
				</div>
				<ul class="photoList">
				<c:if test="${fn:length(photoList)==0}">
				<li><img src="UserFiles/Albums/emptyAlbum.jpg" alt="" /><p>暂无相片</p></li>
				</c:if>
				<c:if test="${fn:length(photoList)>0}">
				<c:forEach var="a" items="${photoList}">
					<li><a
						href="#"><img
							src="UserFiles/Albums/1/${a.album.id}/Thumbnail/${a.filePath}" alt="" /></a>
					<p>${a.title}</p></li>
				</c:forEach>
				</c:if>
				</ul>
				<div class="clearBoth"></div>
				<div class="mainCol-head">
					<span class="title">上传相片</span>
				</div>
              <form action="PhotoSave" method="post" enctype="multipart/form-data"> 
              <input type="hidden" value="${param.albumId}" name="photo.album.id"/>
              <table style="margin-top:10px;margin-left:50px;">
              	<tr><td style="width:100px;">相片名称:</td><td><input type="text" name="photo.title"/></td></tr>
              	<tr><td>相片描述:</td><td>
       			<textarea rows="5" cols="50" name="photo.description"></textarea>
              	</td></tr>
              	<tr><td>上传:</td><td><input type="file" name="photoImage"/></td></tr>
              	<tr><td></td><td><button type="submit">上传相片</button></td></tr>
              </table>
              </form>
			</div>
			<div class="clearBoth"></div>
		</div>
		<div id="footer">
			<hr />
			<p>帮助中心 | 空间客服 | 投诉中心 | 空间协议</p>
			<p>© 2002 - 2011 SamsBlog.com, All Rights Reserved. Sams Blog
				版权所有 粤ICP B2-20080056号</p>
		</div>
	</div>
</body>
</html>