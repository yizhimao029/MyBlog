package myBlog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.dao.CommentDao;
import myBlog.entity.Article;
import myBlog.entity.Comment;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Comment> getAll(final int articleId,final int pageNum,final int pageSize) {		
		return hibernateTemplate.execute(new HibernateCallback<List<Comment>>(){
			public List<Comment> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("from Comment c where c.article.id=?").setInteger(0, articleId).setFirstResult(pageSize*(pageNum-1)).setMaxResults(pageSize).list();
			}
				});
	}
	
	@Override
	public int getRows(int articleId) {
		String hql="select count(*) from Comment c where c.article.id=?";
		List<Number> list=(List<Number>) hibernateTemplate.find(hql,articleId);
		return list.get(0).intValue();
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		CommentDao target=(CommentDao) ctx.getBean("commentDao");
		
	}

	@Override
	public void addComment(Comment comment) {
		hibernateTemplate.save(comment);		
	}


}
