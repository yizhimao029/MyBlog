package myBlog.dao;

import java.util.List;

import myBlog.entity.Comment;

public interface CommentDao {
	List<Comment> getAll(int articleId,int pageNum,int pageSize);//根据文章id获取评论信息
	int getRows(int articleId);//获取分页行数
	void addComment(Comment comment);//添加评论
}
