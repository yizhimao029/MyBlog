package myBlog.web.action;

import java.util.Map;

import myBlog.dao.UserDao;
import myBlog.entity.User;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("UserAction")
public class UserAction extends ActionSupport implements SessionAware {
	@Autowired
	private UserDao userDao;
	//session
	private Map<String, Object> session;
	public void setSession(Map<String, Object> sess) {
		session = sess;
	}	
	private String message;//错误信息
	
	public String getMessage() {
		return message;
	}
	private User loginUser;

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
	public String checkUser() throws Exception{
		loginUser=userDao.checkUser(userName, password);
		if(loginUser!=null){			
			session.put("currentUser", loginUser);
			return SUCCESS;
		}else{						
			this.message="用户名或密码错误!";
			return LOGIN;
		}		
	}
	
	public String logoutUser() throws Exception{
		session.put("currentUser", null);
		return SUCCESS;
	}
	


}
