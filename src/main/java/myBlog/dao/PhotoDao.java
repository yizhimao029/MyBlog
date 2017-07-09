package myBlog.dao;

import java.util.List;

import myBlog.entity.Photo;

public interface PhotoDao {
	List<Photo> getPhotoList(int albumId);//根据相册分类id获取图片列表
	Photo getPhtotInfos(int photoId);
	void AddPhoto(Photo photo);
}
