<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>
<html>
<head>
<title>${currentUser==null?"我的":currentUser.nickName}Blog</title>
<link rel="Stylesheet" type="text/css" href="Content/blogManager.css" />
<link type="text/css" rel="Stylesheet" href="Content/jquery-ui.min.css" />
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

.col {
	background-color: #F0F8FF;
}

.main-a {
	width: 100%;
	over-flow: hidden;
}

.main-a a {
	height: 25px;
	float: right;
	margin-right: 50px;
	height: 20px;
	line-height: 20px;
	color: red;
}

.main-a p {
	float: left;
	margin-left: 30px;
	margin-right: 300px;
	height: 30px;
	line-height: 30px;
}

.main-a hr {
	clear: both;
	/* display:inline-block; */
}

.main-b table {
	width: 100%;
}

.main-b table thead {
	font-weight: 700;
	text-align: center;
}

.dtn {
	display: block;
	width: 43px; 
	border: 1px solid #CCC;
	background: #eeeeee;
	margin:2px 0px;
}

.dtn a {
	font-size: 14px;
	padding: 2px 6px;
	display: block;
	color: black;
}

.a{
	 text-decoration:none; 
}
</style>
<script type="text/javascript" src="JQuery/jquery-1.11.3.js"></script>
<script type="text/javascript" src="JQuery/jquery-ui-1.9.2.js"></script>
<script type="text/javascript">
	$(function() {
		//光标移动变色
		$("#header-nav li a").hover(function() {
			$(this).addClass('current')
		}, function() {
			$(this).removeClass('current')
		});
	});
</script>
</head>
<body>
	<div id="dialog-confirm" title="系统消息" style="display: none;">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>确定删除？
		</p>
	</div>
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
					<span class="title">我的博文</span>
				</div>
				<div class="main-a">

					<a href="PutMessageAction">发表博文&gt;&gt;</a>
					<form action="MessageSearchAction?userId=${param.userId}" method="post" id="artForm">
						<p>
							博文分类: <select name="categoryId">
								<option value="0">全部&nbsp;&nbsp;</option>
								<c:forEach var="c" items="${categoryList}">
									<c:if test="${c.id==param.categoryId}">
									<option value="${c.id}" selected="selected">${c.name }</option>
									</c:if>
									<c:if test="${c.id!=param.categoryId}">
									<option value="${c.id}">${c.name }</option>
									</c:if>
								</c:forEach>
							</select>&nbsp;&nbsp; 博文标题(模糊): <input type="text" name="title" value="" />
							<button type="submit" id="btns">查询</button>
							<button type="reset">重置</button>
						</p>
					</form>
					<hr />
				</div>
				<div class="main-b">
						<c:if test="${fn:length(articleList)==0}">
						<span>暂无文章</span>
						</c:if>
						<c:if test="${fn:length(articleList)>0}">	
					<table cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<td>博文标题</td>
								<td>最后更新时间</td>
								<td style="width: 60px; text-align: left;">删除</td>
							</tr>
						</thead>
						<tbody id="artList">											
							<c:forEach var="a" items="${articleList}" varStatus="i">
								<c:if test="${i.index%2!=0}">
									<tr>
										<td><a href="PutMessageAction?articleId=${a.id}" class="a">${a.title}</a></td>
										<td>${a.updateTime}</td>
										<td><div class="dtn"><a href="DelMessage?articleId=${a.id}"
											style="text-decoration: none;">删除</a></div></td>
									</tr>
								</c:if>
								<c:if test="${i.index%2==0}">
									<tr class="col">
										<td><a href="PutMessageAction?articleId=${a.id}" class="a">${a.title}</a></td>
										<td>${a.updateTime}</td>
										<td style="width: 60px;"><div class="dtn">
												<a href="DelMessage?articleId=${a.id}"
													style="text-decoration: none;">删除</a>
											</div></td>
									</tr>
								</c:if>
							</c:forEach>				
						</tbody>
					</table>
					</c:if>
				</div>
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