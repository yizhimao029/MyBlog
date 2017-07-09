package myBlog.web.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import myBlog.dao.AlbumDao;
import myBlog.dao.PhotoDao;
import myBlog.entity.Album;
import myBlog.entity.Photo;
import myBlog.entity.User;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("PhotoListAction")
public class PhotoListAction extends ActionSupport {
	@Autowired
	private AlbumDao albumDao;
	
	private List<Album> list;

	public List<Album> getList() {
		return list;
	}
	
	private User u=(User) ActionContext.getContext().getSession().get("currentUser");

	@Override
	public String execute() throws Exception {
		this.list=albumDao.getList(u.getId());
		return SUCCESS;
	}
	
	private Album album;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	private File albumImage;
	
	public void setAlbumImage(File albumImage) {
		this.albumImage = albumImage;
	}
	private String albumImageFileName;
	private String albumImageContentType;
	public void setAlbumImageFileName(String albumImageFileName) {
		this.albumImageFileName = albumImageFileName;
	}
	public void setAlbumImageContentType(String albumImageContentType) {
		this.albumImageContentType = albumImageContentType;		
	}
	
	public String save() throws Exception{
		this.album.setUser(u);	
		this.album.setCover(new Date().getTime()+".jpg");
		if(this.albumImage!=null){
			String vpath="/UserFiles/Albums/"+u.getId()+"/"+this.album.getCover();
			ServletContext application=ServletActionContext.getServletContext();
			String path=application.getRealPath(vpath);
			File destFile=new File(path);
			FileUtils.copyFile(albumImage, destFile);
		}		
		albumDao.addAlbum(this.album);
		return SUCCESS;
		
	}
	
	@Autowired
	private PhotoDao photoDao;
	
	private List<Photo> photoList;
	
	public List<Photo> getPhotoList() {
		return photoList;
	}

	private int albumId;
	
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	private String albumName;
		
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumName() {
		return albumName;
	}

	private Photo  photo;
	
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String show() throws Exception{
		this.photoList=photoDao.getPhotoList(albumId);
		this.album=albumDao.getAlbum(albumId);
		return SUCCESS;
	}
	
	private File photoImage;
	private String photoImageFileName;								
	private String photoImageContentType;
	public void setPhotoImage(File photoImage) {
		this.photoImage = photoImage;
	}

	public void setPhotoImageFileName(String photoImageFileName) {
		this.photoImageFileName = photoImageFileName;
	}

	public void setPhotoImageContentType(String photoImageContentType) {
		this.photoImageContentType = photoImageContentType;
	}

	private String photoName;
	
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String photoSave() throws Exception{
		this.photo.setUser(u);
		this.photo.setFilePath(new Date().getTime()+".jpg");
		if(this.photoImage!=null){
			String vpath="/UserFiles/Albums/1/"+photo.getAlbum().getId()+"/Thumbnail/"+this.photo.getFilePath();
			ServletContext application=ServletActionContext.getServletContext();
			String path=application.getRealPath(vpath);
			File destFile=new File(path);
			FileUtils.copyFile(photoImage, destFile);
		}
		photoDao.AddPhoto(photo);
		return SUCCESS;
	}
	
	
	
	

}
