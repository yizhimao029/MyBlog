package myBlog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*Photo（相片）*/
@Entity
public class Photo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键Id
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;//相片所有者ID
	@ManyToOne
	@JoinColumn(name="albumId")
	private Album album;//相册ID
	@Column
	private String title;//相片标题
	private String description;//相片描述
	private String filePath;//文件路径
	public Photo(){}
	public Photo(int id, User user, Album album, String title,
			String description, String filePath) {
		super();
		this.id = id;
		this.user = user;
		this.album = album;
		this.title = title;
		this.description = description;
		this.filePath = filePath;
	}
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
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
