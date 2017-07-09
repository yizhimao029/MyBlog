package myBlog.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import myBlog.dao.ArticleDao;
import myBlog.entity.Article;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Article> getTop(final int num) {
		return hibernateTemplate.execute(new HibernateCallback<List<Article>>(){

			@Override
			public List<Article> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="from Article a order by a.clicks desc";
				return session.createQuery(hql).setMaxResults(num).list();			
			}
		
		});
	}
	

	@Override
	public List<Article> getNewArticleTitle(final int num) {		
		return hibernateTemplate.execute(new HibernateCallback<List<Article>>(){
			@Override
			public List<Article> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="from Article a order by a.clicks desc";				
				return session.createQuery(hql).setMaxResults(num).list();
			}
			
		});
	}
	
	@Override
	public List<Article> getArticleList(final int userId,final int categoryId,final int pageNum,final int pageSize) {
			return hibernateTemplate.execute(new HibernateCallback<List<Article>>(){
				public List<Article> doInHibernate(Session session)
						throws HibernateException, SQLException {
					if(categoryId<=0){
					return session.createQuery("from Article a where a.user.id=? and a.state=1 order by a.createTime desc").setInteger(0, userId).setFirstResult(pageSize*(pageNum-1)).setMaxResults(pageSize).list();
					}else{
						return session.createQuery("from Article a where a.user.id=? and a.category.id=? and a.state=1 order by a.createTime desc").setInteger(0, userId).setInteger(1, categoryId).setFirstResult(pageSize*(pageNum-1)).setMaxResults(pageSize).list();	
					}
				}				
			});
	}
	
	@Override
	public int getRows(int userId,int categoryId) {
		List<Number> list=new ArrayList<Number>();
		if(categoryId>0){
		String hql="select count(a.id) from Article a where a.user.id=? and a.category.id=? and a.state=1 order by a.createTime desc";
		 list=(List<Number>) hibernateTemplate.find(hql,userId,categoryId);
		}else{
		String hql="select count(a.id) from Article a where a.user.id=? and a.state=1 order by a.createTime desc";
		list=(List<Number>) hibernateTemplate.find(hql,userId);	
		}
		return list.get(0).intValue();
	}
	
	@Override
	public Article getArticle(int id,int userId) {
		List<Article> list=(List<Article>) hibernateTemplate.find("from Article a where a.id=? and a.user.id=?",id,userId);	
		return list.size()==0?null:list.get(0);
	}
	
	@Override
	public Article getArticle(int id) {
		List<Article> list=(List<Article>) hibernateTemplate.find("from Article a where a.id=?",id);	
		return list.size()==0?null:list.get(0);
	}
	@Override
	public List<Article> getList(int userId) {		
		return (List<Article>) hibernateTemplate.find("from Article a where a.user.id=? order by a.createTime desc",userId);
	}
	
	@Override
	public List<Article> getList(final int userId,final int categoryId, final String title) {
		return hibernateTemplate.execute(new HibernateCallback<List<Article>>(){
			public List<Article> doInHibernate(Session session)
					throws HibernateException, SQLException {				
				HashMap<String,Object> params = new HashMap<String, Object>();
				String hql="from Article a where a.user.id=:uid";
				params.put("uid", userId);
				if(categoryId > 0){
					hql += " and a.category.id=:cid";
					params.put("cid", categoryId);
				}
				if(title != null && !title.isEmpty()){
					hql += " and a.title like :title";
					params.put("title", "%"+title+"%");
				}				
				return session.createQuery(hql).setProperties(params).list();						
			}				
		});
	}
	
	@Override
	public void delArticle(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(Article.class, id));		
	}
	
	@Override
	public void addArticle(Article article) {
		hibernateTemplate.save(article);		
	}

	@Override
	public void updateArticle(Article article) {
		hibernateTemplate.update(article);		
	}
	

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleDao target=(ArticleDao) ctx.getBean("articleDao");
		
	}















}
