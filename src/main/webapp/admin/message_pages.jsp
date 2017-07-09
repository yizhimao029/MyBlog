<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>${currentUser==null?"我的":currentUser.nickName} Blog</title>
    <link rel="Stylesheet" type="text/css" href="Content/blogManager.css" />
    <link type="text/css" rel="Stylesheet" href="Content/jquery-ui.min.css" />    
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
		.col{
		background-color:#F0F8FF;
		}
		.main-a{
			width:100%;
			over-flow:hidden;
		}
		.main-a a{
		height:25px;
		float:right;
		margin-right:50px;
		height:20px;
		line-height:20px;
		color:red;		
		}
		.main-a p{
		float:left;
		
		margin-left:30px;	
		margin-right:300px;
		
		height:30px;
		line-height:30px;
		}
		.main-a hr{
		clear:both;
		/* display:inline-block; */
		}
		.main-b table{
		width:100%;		
		}
		.main-b table thead{
		font-weight:700;
		text-align:center; 
		}
    </style>
    <script type="text/javascript" src="JQuery/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="JQuery/jquery-ui-1.9.2.js"></script>
    <script type="text/javascript">
	
    //列表
   	 function getArticle(){
 		$.ajax({
 			url:"admin/SearchAction",
 			type:"post",
 			dataType:"json",			
 			success:function(json){
 				$("#artList").empty(); 
 				$.each(json.articleList,function(i,a){
 					if(i%2!=0){
 						var line="<tr><td>"+a.title+"</td><td>"+a.updateTime+"</td><td><input type='hidden' value='"+a.id+"' name='articleId'/><button type='button' class='btn' data-ref='"+a.id+"'>删除</button></td></tr>";
 					}else{
 						var line="<tr class='col'><td>"+a.title+"</td><td>"+a.updateTime+"</td><td><input type='hidden' value='"+a.id+"' name='articleId'/><button type='button' class='btn' data-ref='"+a.id+"'>删除</button></td></tr>";
 					} 					
 					$("#artList").append(line);					
 				});
 			},
 			error:function(){
 				alert("hi");
 			}		
 		});
 	}
    //chaxun
       	 function getArticles(){
 		$.ajax({
 			url:"admin/SearchAction",
 			type:"post",
 			data:$("#artForm").serialize(),
 			dataType:"json",			
 			success:
 				function(json){
 				$("#artList").empty(); 
 				$.each(json.articleList,function(i,a){
 					if(i%2!=0){
 						var line="<tr><td>"+a.title+"</td><td>"+a.updateTime+"</td><td><input type='hidden' value='"+a.id+"' name='articleId'/><button type='button' class='btn' data-ref='"+a.id+"'>删除</button></td></tr>";
 					}else{
 						var line="<tr class='col'><td>"+a.title+"</td><td>"+a.updateTime+"</td><td><input type='hidden' value='"+a.id+"' name='articleId'/><button type='button' class='btn' data-ref='"+a.id+"'>删除</button></td></tr>";
 					} 					
 					$("#artList").append(line);					
 				});
 			},
 			error:function(){
 				alert("hisdsfdsfsfsfdffs");
 			}		
 		});
 	}
    
   	 //删除方法
 	function delegateArticle(id){
				$.ajax({
				url:"admin/DelMessage",
				type:"post",
				data:{articleId:id},
				success:getArticle,
				error:function(){alert("???")}			
			});			
 	}
    
    	$(function(){
    		//光标移动变色
    		$("#header-nav li a").hover(function(){
    			$(this).addClass('current')
    		},function(){
    			$(this).removeClass('current')
    		});
    		//
    		$("#btns").click(function(){		
     			getArticles();
    		}); 
 			
    		//ajax列表
    		getArticle();
    		  		
    		//删除,模态对话框
    		$("#artList").delegate("button.btn","click",function(){
    			var id=$(this).attr("data-ref");
    			$("#dialog-confirm").dialog({
    				resizable: false,
    			    height:140,
    			    modal: true,
    			    buttons:{
    			    	"确定":function(){
    			    		$("#dialog-confirm").dialog ("close");
    			    		delegateArticle(id);
    			    		alert("删除成功");     			    			    		
    			    		return false;			    		    					    		
    			    	},
    			    	"取消":function(){ $("#dialog-confirm").dialog ("close"); }
    			    }			   		
    		});
    			
    		});
    	});
    </script>
</head>
<body>
	<div id="dialog-confirm" title="系统消息" style="display:none;" >
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
                <li><a href="#">个人中心</a></li>
                <li><a href="#">我的主页</a></li>
            </ul>
            <div class="clearBoth"></div>
            <hr />
        </div>
        <div id="content">
            <div id="sideBar">
                <div id="sideBar-author">
                    <img src="UserFiles/UserHeads/1.jpg" alt="" />
                    <h3>${currentUser.nickName}</h3>
                    <a href="#">修改个人资料</a>
                </div>
                <div class="line"></div>
                <ul id="sideBar-function">
                    <li><a href="MessageSearchAction">文章</a></li>
                    <li><a href="#">相册</a></li>
                    <li><a href="IndexAction">首页</a></li>
                </ul>
            </div>
            <div id="main">
              <div class="mainCol-head">
                   <span class="title">我的博文</span>
              </div>
               <div class="main-a">
              
               <a href="">发表博文&gt;&gt;</a>
               <form action="MessageSearchAction" method="post" id="artForm">
               	<p>博文分类:
               	<select name="cagtegotyId">
               		<option value="0">全部&nbsp;&nbsp;</option>
               		<c:forEach var="c" items="${categoryList}">
               		<option value="${c.id}">${c.name }</option>
               		</c:forEach>
               	</select>&nbsp;&nbsp;
               	博文标题(模糊):
               	<input type="text" name="title" value=""/>
               	<button type="submit" id="btns">查询</button>
               	<button type="reset">重置</button>
               	</p>
               	</form>
               	<hr/>
               </div>               
               <div class="main-b">
               <table cellspacing="0" cellpadding="0">
               <thead>
               	<tr><td>博文标题</td><td>最后更新时间</td><td style="width:60px;text-align:left;">删除</td></tr>
               </thead>
               <tbody id="artList">
<%--                <c:forEach var="a" items="${articleList}" varStatus="i">
               <c:if test="${i.index%2!=0}">
               <tr><td>${a.title}</td><td>${a.updateTime}</td><td><input type="hidden" value="${a.id}" name="articleId"/><button type="button" class="btn">删除</button></td></tr>
               </c:if> 
               <c:if test="${i.index%2==0}">           
               <tr class="col"><td>${a.title}</td><td>${a.updateTime}</td><td style="width:60px;"><input type="hidden" value="${a.id}" name="articleId"/><button type="button" class="btn">删除</button></td></tr>
               </c:if> 
               </c:forEach>  --%>
               </tbody>              
               </table>               
               </div>              
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