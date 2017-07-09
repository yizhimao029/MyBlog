package myBlog.web.action;

import java.util.List;

import myBlog.dao.ArticleDao;
import myBlog.dao.CommentDao;
import myBlog.dao.UserDao;
import myBlog.entity.Article;
import myBlog.entity.Comment;
import myBlog.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("BlogAction")
public class BlogAction extends ActionSupport {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;
	
	private int userId;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private List<Article> articleListByList;
	
	public List<Article> getArticleListByList() {
		return articleListByList;
	}
	
	private int pageNum=1;
	private int pageSize=3;
	private int totalPages;
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private int categoryId;

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String execute() throws Exception {
		this.articleListByList=articleDao.getArticleList(userId,categoryId, pageNum, pageSize);
		int rows=articleDao.getRows(userId,categoryId);
		this.totalPages=(rows%pageSize==0?(rows/pageSize):(rows/pageSize+1));		
		return SUCCESS;		
	}
	
	private int id;
		
	public void setId(int id) {
		this.id = id;
	}
	
	private Article article;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	private List<Comment> commentList;
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	
	
	public String details() throws Exception{		
		this.article=articleDao.getArticle(id, userId);	
		this.pageSize=10;
		this.commentList=commentDao.getAll(id,pageNum,pageSize);
		int rows=commentDao.getRows(id);
		this.totalPages=(rows%pageSize==0?(rows/pageSize):(rows/pageSize+1));
		return SUCCESS;
	}
	
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String addComment() throws Exception{
		this.user=(User) ActionContext.getContext().getSession().get("currentUser");
		this.userId=this.user.getId();
		this.article=articleDao.getArticle(id);
		Comment c=new Comment(0, this.article,new java.sql.Date(System.currentTimeMillis()), user, comment.getContent(), "127.0.0.1", 1);		
		commentDao.addComment(c);
//		userDao.updateUser(u);
		return SUCCESS;
	}
	
	
	
	

}
