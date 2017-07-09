<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <div id="blogHead">
                <div id="blogHead-info">
                    <h1 id="blogHead-info-signName">${user.signature}</h1>
                    <a id="blogHeader-info-link" href="http://localhost:4359/BlogPage.htm">http://localhost:4359/BlogPage.htm</a>
                    <ul id="blogHead-info-nav">
                        <li><a href="IndexAction">首页</a></li>
                        <li>|</li>
                        <li><a href="MyBlogAction?userId=${user.id}">博文目录</a></li>
                        <li>|</li>
                        <li><a href="PhotoListAction?userId=${user.id}">图片</a></li>
                        <li>|</li>
                        <li><a href="#">关于我</a></li>
                    </ul>
                    <div class="clearBoth"></div>
                </div>
            </div>