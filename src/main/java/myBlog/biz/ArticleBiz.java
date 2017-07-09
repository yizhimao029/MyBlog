package myBlog.biz;

import java.util.List;

import myBlog.entity.Article;

public interface ArticleBiz {
	List<Article> getAll(int userId,int categoryId,String title);

}
