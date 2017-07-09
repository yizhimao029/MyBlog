<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="Stylesheet" type="text/css" href="Content/base.css" />
    <link rel="Stylesheet" type="text/css" href="Content/blogPage.css" />
    <link rel="Stylesheet" type="text/css" href="Content/blogPage_articles.css" />
	<style>
		.photoList li{
			float:left;
			margin:10px 10px;
			text-align:center;
			
		}
		.photoList img{
			width:210px;
			height:170px;
			
		}
	</style>
</head>
<body>
    <div id="page">
        <div id="blog">       		
			<s:action name="head" namespace="/" executeResult="true"></s:action>
            <div id="blogBody">
            <s:action name="sidebar" namespace="/" executeResult="true"></s:action>
                <div id="mainCol">
                    <div class="mainCol-head">
                        <span class="title">相册</span>
                    </div>
                    <div class="mainCol-body">
					<strong style="font-size:20px;">相册:${param.title}</strong>
					<ul class="photoList">
					<c:forEach var="a" items="${detailsList}">
						<li><a href="PhotoShowAction?photoId=${a.id}&userId=${user.id}"><img src="UserFiles/Albums/1/${a.album.id}/${a.filePath}" alt=""/></a><p>${a.title }</p></li>
					</c:forEach>	
					</ul>
					<div style="clear:both;"></div>	
						
                    </div>
                    <div class="mainCol-foot">
					
                    </div>
                </div>
            </div>
            <div id="blogFoot">
            	
            </div>
        </div>
    </div>
</body>
</html>