package info.goldbo.base;

import info.goldbo.base.entity.Admin;
import info.goldbo.base.entity.User;
import info.goldbo.base.service.AdminService;
import info.goldbo.base.service.UserService;
import info.goldbo.base.util.NoUtil;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest  {

	@Test
	public void testBuild() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Assert.assertTrue(context.containsBean("baseDao"));
	}
	
	@Test
	public void testAdminService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("adminService");
		boolean isExist = adminService.isExistByUsername("admin");
		Assert.assertTrue(isExist);
	}
	
	@Test
	public void testBaseDao(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = adminService.load("402881d6390e44b001390e44b1720001");
		System.out.println(admin.getId()+","+admin.getUsername());
		//System.out.println("good!");
	}
	
	@Test
	public void testAdd(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = new Admin();
		admin.setName("huangjinbo");
		admin.setUsername("xxx");
		admin.setPassword("123456");
		adminService.save(admin);
	}
	
	@Test
	public void testUpdate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = adminService.get("402881d639335bc60139335bca230001");
		//System.out.println(admin.getId());
		admin.setUsername("test123");
		adminService.update(admin);
	}
	
	@Test
	public void testDelete(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = adminService.load("402881d639336a3a0139336a3ee20001");
		adminService.delete(admin);
	}
	
	@Test
	public void testMixTransation(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
	}
	
	@Test
	public void testAddUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		System.out.println(userService);
		User user = new User();
		user.setUserId(NoUtil.gainedNo("User"));
		user.setUserName("user");
		userService.save(user);
	}
}
