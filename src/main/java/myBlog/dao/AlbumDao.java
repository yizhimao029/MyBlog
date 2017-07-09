package myBlog.dao;

import java.util.List;

import myBlog.entity.Album;

public interface AlbumDao {
	List<Album> getList(int userId);//获取所有信息
	void addAlbum(Album album);
	Album getAlbum(int albumId);//获取对象名字
}
