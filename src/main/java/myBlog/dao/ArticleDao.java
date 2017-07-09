package myBlog.dao;

import java.util.List;

import myBlog.entity.Article;

public interface ArticleDao {
	List<Article> getTop(int num);//点击率最高的5篇博文
	List<Article> getNewArticleTitle(int num);//显示最新发表的10篇博文的标题
	List<Article> getArticleList(int userId,int categoryId,int pageNum,int pageSize);//根据id获取指定对象列表分页查询
	int getRows(int userId,int categoryId);//分页查询总行数
	Article getArticle(int id,int userId);//获取指定文章信息
	Article getArticle(int id);//获取文章信息
	List<Article> getList(int userId);//获取用户自己的文章
	List<Article> getList(int userId,int categoryId,String title);
	void delArticle(int id);
	void addArticle(Article article);
	void updateArticle(Article article);

}
