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
    <style type="text/css">
    .blogPage{
    	margin-left:420px;
    	height:20px;	
    }
    .blogPage li {
    	float:left;
    	border:solid 1px #999999;
    	margin-left:15px;
    	margin-bottom:15px;
    	width:20px;
    	height:20px;
    	text-align:center;
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
                        <span class="title">博文</span>
                    </div>
                    <div class="mainCol-body">
                     <c:forEach var="a" items="${articleListByList}">                    
                        <div id="articles">                       
                            <div class="article">
                                <h2 class="article-title">
                                    <a href="DetailsAction?id=${a.id}&userId=${a.user.id}">${a.title}</a>
                                </h2>
                                <div class="article-body">
                                    ${a.contentInfos}
                                </div>
                                <div class="article-link"><a href="DetailsAction?id=${a.id}&userId=${a.user.id}">查看全文&gt;&gt;</a></div>
                                <div class="article-footer">
                                   ${a.updateTime}<br />
                                    阅读（1000）| 评论（30）    
                                </div>
                            </div>
                            <div class="linedot"></div>                                        
                        </div>  
                        </c:forEach> 
                        <c:if test="${totalPages==0}">
                        <span>暂无文章</span>
                        </c:if>
                        <c:if test="${totalPages>0}">                       
                        <ul class="blogPage">
                    	<li><a href="MyBlogAction?pageNum=1&userId=${param.userId}">&lt;&lt;</a></li>
                    	<c:if test="${pageNum>1}">
                    	<li><a href="MyBlogAction?pageNum=${pageNum-1}&userId=${param.userId}">&lt;</a></li>
                    	</c:if>
                    	<c:forEach var="i" begin="1" end="${totalPages}" step="1">
                    		<li><a href="MyBlogAction?pageNum=${i}&userId=${param.userId}">${i}</a></li>
                    	</c:forEach> 
                    	<c:if test="${pageNum<totalPages}">
                    	<li><a href="MyBlogAction?pageNum=${pageNum+1}&userId=${param.userId}">&gt;</a></li>
                    	</c:if>
                   		<li><a href="MyBlogAction?pageNum=${totalPages}&userId=${param.userId}">&gt;&gt;</a></li>                    	
                    </ul>
                    </c:if>
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