package myBlog.web.action;

import java.util.List;

import myBlog.dao.AlbumDao;
import myBlog.dao.PhotoDao;
import myBlog.dao.UserDao;
import myBlog.entity.Album;
import myBlog.entity.Photo;
import myBlog.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("PhotoAction")
public class PhotoAction extends ActionSupport {
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private UserDao userDao;
	
	private User u=(User) ActionContext.getContext().getSession().get("currentUser");
	
	private List<Album> list;

	public List<Album> getList() {
		return list;
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

	@Override
	public String execute() throws Exception {
		this.list=albumDao.getList(u.getId());
		this.user=userDao.getUser(u.getId());
		return SUCCESS;
	}
	
	private int id;//AlbumId
	
	public void setId(int id) {
		this.id = id;
	}
	
	private List<Photo> detailsList;
		
	public List<Photo> getDetailsList() {
		return detailsList;
	}
	
	public String photoDetails() throws Exception{
		this.user=userDao.getUser(u.getId());
		this.detailsList=photoDao.getPhotoList(id);	
		return SUCCESS;
	}
	
	private int photoId;

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	private Photo photo;
	
	
	public Photo getPhoto() {
		return photo;
	}


	public void setPhoto(Photo photo) {
		this.photo = photo;
	}


	public String photoShow() throws Exception{
		this.user=userDao.getUser(u.getId());
		this.photo=photoDao.getPhtotInfos(photoId);		
		return SUCCESS;
	}
	
	

	

	
	
	
	
	

}
