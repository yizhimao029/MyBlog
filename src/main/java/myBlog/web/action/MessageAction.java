package myBlog.web.action;

import java.sql.Date;
import java.util.List;

import myBlog.biz.ArticleBiz;
import myBlog.dao.ArticleDao;
import myBlog.dao.CategoryDao;
import myBlog.entity.Article;
import myBlog.entity.Category;



import myBlog.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("MessageAction")
public class MessageAction extends ActionSupport {
	
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ArticleBiz articleBiz;
	
	private List<Article> articleList;

	public List<Article> getArticleList() {
		return articleList;
	}
	
	private User u=(User) ActionContext.getContext().getSession().get("currentUser");
	private List<Category> categoryList;
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	private int categoryId;
	private String title;

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String search() throws Exception{
		this.categoryList=categoryDao.getAll(u.getId());
		articleList=articleBiz.getAll(u.getId(),categoryId, title);
		return SUCCESS;
	}
	
	private int articleId; 
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String del() throws Exception{
		articleDao.delArticle(articleId);
		return SUCCESS;
	}
	
	private Article article;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article artcile) {
		this.article = article;
	}

	public String put() throws Exception{
		this.article=articleDao.getArticle(articleId, u.getId());
		this.categoryList=categoryDao.getAll(u.getId());
		return SUCCESS;
	}
	
	private String description;
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String ckb;
	

	public String getCkb() {
		return ckb;
	}

	public void setCkb(String ckb) {
		this.ckb = ckb;
	}

	public String save() throws Exception{
		Category c=new Category();
		this.article=articleDao.getArticle(articleId, u.getId());
		if(articleId>0){			
			article.setTitle(title);			
			c.setId(categoryId);
			article.setCategory(c);
			article.setContent(description);
			if(ckb==null){
				article.setState(0);
			}else{
				article.setState(1);
			}
			articleDao.updateArticle(article);	
		}else{
			c.setId(categoryId);
			int status=0;
			if(ckb==null){
				status=0;
			}else{
				status=1;
			}
			Article a=new Article(0, title, description, new java .sql.Date(System.currentTimeMillis()), new java .sql.Date(System.currentTimeMillis()), u, c,0, 0, status);
			articleDao.addArticle(a);	
		}
		return SUCCESS;
	}
	
	
	
	
	
	

}
