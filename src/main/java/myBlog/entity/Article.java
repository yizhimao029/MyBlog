package myBlog.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;*/

/*Article（博文）*/
@Entity
public class Article implements Serializable {
	
	public Article(){}
	public Article(int id, String title, String content, Date createTime,
			Date updateTime, User user, Category category, int clicks,
			int commentTimes, int state) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.user = user;
		this.category = category;
		this.clicks = clicks;
		this.commentTimes = commentTimes;
		this.state = state;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键Id
	@Column
	private String title;//文章标题
	private String content;//文章内容
	private Date createTime;//发表时间
	private Date updateTime;//更新时间
	@ManyToOne
	@JoinColumn(name="userId")
	/*@Fetch(FetchMode.JOIN)*/
	private User user;//作者ID
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;//分类Id
	private int clicks;//点击次数
	private int commentTimes;//评论次数
	private int state;//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public String getContentInfo(){
		if(content.length()>100){
			return content.substring(0, 100);
		}else{
			return content;
		}
	}
	
	public String getContentInfos(){
		if(content.length()>200){
			return content.substring(0, 200);
		}else{
			return content;
		}
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public int getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
