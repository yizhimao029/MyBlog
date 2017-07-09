<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>				
				<div id="sideCol">
                    <div id="sideCol-module-001" class="module">
                        <div class="sideCol-head">
                            <span class="title">个人资料</span>
                        </div>
                        <div class="sideCol-body">
                            <img id="userHead" src="UserFiles/UserHeads/${user.id}.jpg" alt="" />
                            <h3 id="nickName">${user.nickName}</h3>
                            <div class="linedot"></div>
                            <div id="interaction">
                                <a class="linkButton">加为好友</a>
                                <a class="linkButton">发纸条</a>
                                <div class="clearBoth"></div>
                            </div>
                            <div class="linedot"></div>
                            <ul id="integration">
                                <li>博客等级：100</li>
                                <li>博客积分：${user.score}</li>
                                <li>博客访问：${user.visitTimes}</li>
                                <li>关注人气：1000</li>
                                <li><a href="IndexAction">回到${currentUser==null?"我的":currentUser.nickName} Blog首页</a></li>
                            </ul>
                        </div>
                        <div class="sideCol-foot">
                        </div>
                    </div>
                    <div id="sideCol-module-002" class="module">
                        <div class="sideCol-head">
                            <span class="title">博文分类</span>
                        </div>
                        <div class="sideCol-body">
                            <ul id="postCategories">
                            <c:forEach var="c" items="${categoryList}">
                                <li><a href="MyBlogAction?userId=${user.id}&categoryId=${c.id}">${c.name}</a></li>
                            </c:forEach>
                            </ul>
                            <div class="linedot"></div>
                            <ul id="ablums">
                                <li><a href="PhotoListAction?userId=${user.id}">相册</a></li>
                            </ul>
                        </div>
                        <div class="sideCol-foot">
                        </div>
                    </div>
                    <div id="sideCol-module-003" class="module">
                        <div class="sideCol-head">
                            <span class="title">热门博文</span>
                        </div>
                        <div class="sideCol-body">
                            <ul>
                            <c:forEach var="a" items="${articleList}">                         
                                <li><a href="DetailsAction?id=${a.id}&userId=${a.user.id}">${a.title}</a></li>
                            </c:forEach>   
                            </ul>
                        </div>
                        <div class="sideCol-foot">
                        </div>
                    </div>
                </div>