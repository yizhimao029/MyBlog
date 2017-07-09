package myBlog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.dao.AlbumDao;
import myBlog.entity.Album;

@Repository("albumDao")
public class AlbumDaoImpl implements AlbumDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Album> getList(int userId) {
		return (List<Album>) hibernateTemplate.find("from Album a where a.user.id=?",userId);	
	}
	
	@Override
	public void addAlbum(Album album) {
			hibernateTemplate.save(album);
	}
	

	@Override
	public Album getAlbum(int albumId) {
		return hibernateTemplate.get(Album.class, albumId);		
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		AlbumDao d=(AlbumDao) ctx.getBean("albumDao");
		System.out.println(d.getList(1));
		System.out.println(d.getAlbum(1).getDescription());
		
	}

}
