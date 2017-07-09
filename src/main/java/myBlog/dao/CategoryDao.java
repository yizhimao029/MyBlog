package myBlog.dao;

import java.util.List;

import myBlog.entity.Category;

public interface CategoryDao {
	List<Category> getAll(); //获取所有列表信息
	List<Category> getAll(int userId);//根据id获取相关信息

}
