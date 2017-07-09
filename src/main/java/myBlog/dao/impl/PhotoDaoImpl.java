package myBlog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.dao.PhotoDao;
import myBlog.entity.Photo;

@Repository("photoDao")
public class PhotoDaoImpl implements PhotoDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Photo> getPhotoList(int albumId) {
		return (List<Photo>) hibernateTemplate.find("from Photo p where p.album.id=?",albumId);
		
	}
	
	@Override
	public Photo getPhtotInfos(int photoId) {
		return (Photo)hibernateTemplate.find("from Photo p where p.id=?",photoId).get(0);
	
	}
	
	@Override
	public void AddPhoto(Photo photo) {
		hibernateTemplate.save(photo);
		
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		PhotoDao p=(PhotoDao) ctx.getBean("photoDao");
		System.out.println(p.getPhotoList(1));
		System.out.println(p.getPhtotInfos(1).getTitle());
	}




}
