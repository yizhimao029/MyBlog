package myBlog.dao.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.dao.UserDao;
import myBlog.entity.Article;
import myBlog.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public boolean checkUserName(String username) {
		List<String> list=(List<String>) hibernateTemplate.find("from User u where u.userName=?",username);
		return list.size()==0?false:true;
	}
	@Override
	public User checkUser(String username,String password) {
		List<User> list=(List<User>) hibernateTemplate.find("from User u where username=? and password=?",username,password);
		return list.size()==0?null:list.get(0);
	}
	
	@Override
	public User getUser(int id) {
		List<User> list=(List<User>) hibernateTemplate.find("from User u where u.id=?",id);
		return list.size()==0?null:list.get(0);
	}
	
	@Override
	public void updateUser(User user) {
		hibernateTemplate.update(user);
		
	}
	@Override
	public List<User> getList(final int num) {
		
		return hibernateTemplate.execute(new HibernateCallback<List<User>>(){

			@Override
			public List<User> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="select distinct (u) from User u left join u.artList as a order by a.clicks desc";				
				return session.createQuery(hql).setMaxResults(num).list();
			}});
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao target=(UserDao) ctx.getBean("userDao");
		System.err.println(target.getList(10).size());

			
	}
}




