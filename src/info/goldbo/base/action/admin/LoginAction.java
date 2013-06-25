package info.goldbo.base.action.admin;

import info.goldbo.base.entity.User;

import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * 登录处理
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2013-6-25 上午9:31:13
 * ==================================
 */
@ParentPackage("admin")
public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 5548944731228992860L;
	private User user;
	
	public String login(){
		String s = getParameter("user.userName");
		System.out.println(s+",s");
		String userName = user.getUserName();
		System.out.println(userName);
		return INDEX;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
