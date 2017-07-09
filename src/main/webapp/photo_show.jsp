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
		.bigImg{
		width:650px;
		height:450px;		
		}
		
		.ph{
			width:100%;
			height:100%;
		}
		 .ph p{
		text-align:center;
		}
		.ph img{
		margin-left:20px;
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
                    	<div class="ph">
						<p><strong>${photo.title }</strong></p>
						<img src="UserFiles/Albums/1/${photo.album.id}/${photo.filePath}" alt="" class="bigImg"/>
						<p><strong>博主介绍:${photo.description}</strong></p>
						</div>
						<div class="linedot"></div>						
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