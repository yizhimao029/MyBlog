package myBlog.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.FetchType;*/
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Comment（博文评论）*/
@Entity
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键Id
	@ManyToOne/*(fetch = FetchType.LAZY) */
	@JoinColumn(name="articleId")
	private Article article;//文章ID
	@Column
	private Date commentTime;//评论时间
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;//发表者Id
	@Column
	private String content;//内容
	@Column
	private String ip;//发表者IP
	@Column
	private int state;//状态
	public Comment(){}
	public Comment(int id, Article article, Date commentTime, User user,
			String content, String ip, int state) {
		super();
		this.id = id;
		this.article = article;
		this.commentTime = commentTime;
		this.user = user;
		this.content = content;
		this.ip = ip;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

	

	
	
	
	

}
