package myBlog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Album（相册）*/
@Entity
public class Album implements Serializable{
	
	public Album(){}

	public Album(int id, User user, String name, String description,
			String cover) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.description = description;
		this.cover = cover;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; //主键Id
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;//相册所有者ID
	private String name;//相册名称
	private String description;//相册描述
	private String cover;//相册封面图片路径
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	

}
