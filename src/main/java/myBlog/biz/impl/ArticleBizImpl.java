package myBlog.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myBlog.biz.ArticleBiz;
import myBlog.dao.ArticleDao;
import myBlog.entity.Article;

@Repository("articleBiz")
public class ArticleBizImpl implements ArticleBiz {
	@Autowired
	private ArticleDao articleDao;
		
	@Override
	public List<Article> getAll(int userId, int categoryId, String title) {			
		return articleDao.getList(userId, categoryId, title);
	}
	
public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	ArticleBiz target=(ArticleBiz) ctx.getBean("articleBiz");
	System.out.println(target.getAll(1, 1, "一").size());
}

}
