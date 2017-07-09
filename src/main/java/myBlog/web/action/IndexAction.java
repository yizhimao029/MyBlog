package myBlog.web.action;

import java.util.List;
import java.util.Map;

import myBlog.dao.ArticleDao;
import myBlog.dao.UserDao;
import myBlog.entity.Article;
import myBlog.entity.User;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("IndexAction")
public class IndexAction extends ActionSupport{
	private List<Article> topClicksList;//点击率最高的5篇博文
	private List<User> topNickNameList;//点击率最高的10位博主的姓名
	private List<Article> newArticleTitleList;////显示最新发表的10篇博文的标题

	public List<Article> getTopClicksList() {
		return topClicksList;
	}


	public List<User> getTopNickNameList() {
		return topNickNameList;
	}


	public List<Article> getNewArticleTitleList() {
		return newArticleTitleList;
	}
	
	
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private UserDao userDao;
		
	public String execute() throws Exception {
		this.topClicksList=articleDao.getTop(5);
		this.topNickNameList=userDao.getList(10);
		this.newArticleTitleList=articleDao.getNewArticleTitle(10);	
		return SUCCESS;
	}
	
	
	
	
	
	
	

}
