package info.goldbo.base.action.admin;

import info.goldbo.base.service.UserService;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("admin")
public class UserAction  extends BaseAction{
	@Resource
	private UserService userService;
	
	public String list(){
		System.out.println("I am here!!!");
		userService.findByPager(pager);
		return LIST;
	}

}
