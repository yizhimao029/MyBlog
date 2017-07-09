package myBlog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*Category（博文分类）*/
@Entity
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键Id
	@Column
	private String name;//分类名称
	private int userId;//所属用户（用户有自己的分类）
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Category(){}
	public Category(int id, String name, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
	}
	
	

}
