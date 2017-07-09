package myBlog.web.action;



import java.util.List;

import myBlog.dao.ArticleDao;
import myBlog.dao.CategoryDao;
import myBlog.dao.UserDao;
import myBlog.entity.Article;
import myBlog.entity.Category;
import myBlog.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("SidebarAction")
public class SidebarAction extends ActionSupport {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private UserDao userDao;
	
	private List<Category> categoryList;
	private List<Article> articleList;
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	
	private int userId;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String showList() throws Exception {
		this.categoryList=categoryDao.getAll(userId);
		this.articleList=articleDao.getList(userId);
		this.user=userDao.getUser(userId);
		return SUCCESS;
	}
	
	public String head() throws Exception{
		this.user=userDao.getUser(userId);
		return SUCCESS;
	}
	
	
	
	

}
