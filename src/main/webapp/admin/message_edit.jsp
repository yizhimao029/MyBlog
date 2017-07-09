<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <title>${currentUser==null?"我的":currentUser.nickName} Blog</title>
    <link rel="Stylesheet" type="text/css" href="Content/blogManager.css" />    
    <style type="text/css">
    	.mainCol-head{
		    background-image:url(Content/images/ihome-main-bg.gif);
			background-position:-2px 0px; 
		    height:27px;		  
		}
		.mainCol-head .title{
		    color:#333333;
		    float:left;
		    font-weight:700; 
		    padding-left:10px;
		    height:26px;
		    line-height:26px;
		    
		}
		.clearBoth{
		    clear:both;	
		}
		.but{
			width:69px;
			height:23px;
			background:url(Content/images/ihome-header-navBg.gif) no-repeat;
			border:0px;
		}

    </style>
    <script type="text/javascript" src="JQuery/jquery-1.11.3.js"></script>
    <script src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#header-nav li a").hover(function(){
    			$(this).addClass('current')
    		},function(){
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
                   <span class="title">我的博文</span>
              </div>
              <form action="SaveMessageAction" method="post"> 
              <input type="hidden" name="articleId" value="${article.id}"/>
              <table style="margin-top:10px;margin-left:10px;">
              	<tr><td style="width:50px;">标题:</td><td><input type="text" value="${article.title}" name="title"/></td></tr>
              	<tr><td>分类:</td><td>
              	<select  name="categoryId">
              	<option value="0">---请选择---</option>
              	<c:forEach var="c" items="${categoryList}">             	
              	<c:if test="${c.id==article.category.id}">
              	<option value="${c.id}" selected="selected">${c.name}</option>
              	</c:if>
              	<option value="${c.id}">${c.name}</option>
              	</c:forEach>
              	</select>
              	</td></tr>
              	<tr><td>内容:</td><td><textarea name="description" class="ckeditor">${article.content}</textarea></td></tr>
              	<tr><td>发表:</td><td><input type="checkbox" checked="checked" name="ckb" value="ckb"/></td></tr>
              	<tr><td></td><td><button type="submit" class="but">保存</button></td></tr>
              </table>
              </form>            
            </div>
            <div class="clearBoth"></div>
        </div>
        <div id="footer">
            <hr />
            <p> 帮助中心 | 空间客服 | 投诉中心 | 空间协议</p>
            <p>© 2002 - 2011 SamsBlog.com, All Rights Reserved. Sams Blog 版权所有 粤ICP B2-20080056号 </p>
        </div>
    </div>
</body>
</html>