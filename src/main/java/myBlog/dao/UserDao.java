package myBlog.dao;

import java.util.List;

import myBlog.entity.User;

public interface UserDao {
	boolean checkUserName(String username);//检查用户名是否存在
	User checkUser(String username,String password);//检查用户名密码是否正确
	User getUser(int id);
	void updateUser(User user);
	List<User> getList(int num);//点击前10名的用户


}
