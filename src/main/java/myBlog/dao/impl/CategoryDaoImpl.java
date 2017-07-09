package myBlog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.dao.CategoryDao;
import myBlog.entity.Category;
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Category> getAll() {	
		return (List<Category>) hibernateTemplate.find("from Category");
	}
	
	@Override
	public List<Category> getAll(int userId) {
		return (List<Category>) hibernateTemplate.find("from Category where userId=?",userId);		
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryDao c=(CategoryDao) ctx.getBean("categoryDao");
		System.out.println(c.getAll().size());
		for(Category c1:c.getAll(1)){
			System.out.println(c1.getId()+","+c1.getName());
		}
	}


}
