package myBlog.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*User（用户/博主）*/
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键
	@Column
	private String userName;//用户名
	private String password;//密码
	private String nickName;//昵称
	private String signature;//博客签名
	private int score;//博主积分
	private String email;//邮箱
	private int visitTimes;//访问次数
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;//角色Id
	private int state;//状态	
	@OneToMany(targetEntity=Article.class,cascade=CascadeType.ALL) 
	@Fetch(FetchMode.JOIN) 
	//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)  
	@JoinColumn(name="userId",updatable=false)
	private Set<Article> artList;		
	public Set<Article> getArtList() {
		return artList;
	}
	public void setArtList(Set<Article> artList) {
		this.artList = artList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User(){}
	public User(int id, String userName, String password, String nickName,
			String signature, int score, String email, int visitTimes,
			Role role, int state, Set<Article> artList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.signature = signature;
		this.score = score;
		this.email = email;
		this.visitTimes = visitTimes;
		this.role = role;
		this.state = state;
		this.artList = artList;
	}


	

	
		
}
