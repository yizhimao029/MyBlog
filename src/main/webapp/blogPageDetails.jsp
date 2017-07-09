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
    	over-flow:hidden;
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
    .imgs{    	
	  	background-color:#eeeeee;
	    background-position:1450px 0;    
	    height:26px; 
	   
    }
    .imgs strong{
    	float:left;
    	margin-top:5px;
    	margin-left:5px; 
    	
    }
    #imgsmall{
    	width:100px;
    	height:100px;
    }
    
    .a{
    	float:left;
    	margin-top:5px;
    	margin-left:15px;
    }
    .b{
    	float:right;
    	
    }
    .tab{
    width:100%;   
    }
    .c{
    	float:left;
    }
    .addTab{
    margin-top:10px;   
    margin-left:50px;
    width:300px;
    }
    .addTab tr{
    width:100%;
    height:30px;
    
    }
    .addTab td{
    font-weight:bold;
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
                   
                        <div id="articles">                       
                            <div class="article">
                                <h2 class="article-title">
                                    <a href="#">${article.title}</a>
                                </h2>
                                <div class="article-body">
                                    ${article.content}
                                </div>
                               
                                <div class="article-footer">
                                   ${article.updateTime }<br />
                                    阅读（1000）| 评论（30）    
                                </div>
                            </div>
                            <div class="linedot"></div>                
                        </div>
					<div class="imgs">
                        <strong>评论</strong>
                    </div>
                    <table class="tab">
                    <c:forEach var="c" items="${commentList}">
                    <tr><td><strong class="a">${c.user.nickName}</strong></td><td class="b">${c.commentTime}</td></tr>
                    <tr>
                    <td style="width:100px;"><img src="UserFiles/UserHeads/${c.user.id}.jpg" alt="" id="imgsmall"/></td>                   
                    <td>&nbsp;&nbsp;${c.content}</td></tr>
                    </c:forEach>
                    </table>
                    <div class="linedot"></div>
                    <c:if test="${totalPages>0}">  
                   <ul class="blogPage">
                    	<li><a href="DetailsAction?pageNum=1&id=${param.id}&userId=${param.userId}">&lt;&lt;</a></li>
                    	<c:if test="${pageNum>1}">
                    	<li><a href="DetailsAction?pageNum=${pageNum-1}&id=${param.id}&userId=${param.userId}">&lt;</a></li>
                    	</c:if>
                    	<c:forEach var="i" begin="1" end="${totalPages}" step="1">
                    		<li><a href="DetailsAction?pageNum=${i}&id=${param.id}&userId=${param.userId}">${i}</a></li>
                    	</c:forEach> 
                    	<c:if test="${pageNum<totalPages}">
                    	<li><a href="DetailsAction?pageNum=${pageNum+1}&id=${param.id}&userId=${param.userId}">&gt;</a></li>
                    	</c:if>
                   		<li><a href="DetailsAction?pageNum=${totalPages}&id=${param.id}&userId=${param.userId}">&gt;&gt;</a></li> 
                    </ul>
                    </c:if> 
                    <c:if test="${totalPages<=0}">
                    <div>暂无评论</div>
                    </c:if> 
                     <c:if test="${currentUser!=null}">              
                    <div class="imgs" style="margin-top:20px;">
                        <strong>发表评论</strong>                   
                    </div>                   
                    <form action="AddComment" method="post">
                    <input type="hidden" name="id" value="${param.id}"/>
                    <table class="addTab">                   
                   <!--  <tr><td>昵称:</td><td><input type="text" value="" name="comment.user.nickName"/></td></tr> -->
                    <tr><td>评论:</td><td><textarea name="comment.content"></textarea></td></tr>
                    <tr><td></td><td><input type="submit" value="提交"/></td></tr>
                    </table> 
                    </form>
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