package info.goldbo.base;

import info.goldbo.base.entity.User;
import info.goldbo.base.service.UserService;
import info.goldbo.base.util.NoUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest  {
	
	ApplicationContext context = null;	
	@Before
	public void load(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testBuild() throws Exception {
		Assert.assertTrue(context.containsBean("baseDao"));
	}
	
	@Test
	public void testUserService(){
		UserService UserService = (UserService) context.getBean("UserService");
		boolean isExist = UserService.isExist("name", "admin");
		Assert.assertTrue(isExist);
	}
	
	@Test
	public void testBaseDao(){
		UserService UserService = (UserService) context.getBean("UserService");
		User User = UserService.load("402881d6390e44b001390e44b1720001");
		System.out.println(User.getUserId()+","+User.getUserName());
	}
	
	@Test
	public void testAdd(){
		UserService userService = (UserService)context.getBean("userService");
		User user = new User();
		user.setUserId(NoUtil.gainedNo("User"));
		user.setUserName("user");
		userService.save(user);
	}
	
	@Test
	public void testUpdate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService UserService = (UserService) context.getBean("UserService");
		User user = UserService.get("402881d639335bc60139335bca230001");
		user.setUserName("test123");
		UserService.update(user);
	}
	
	@Test
	public void testDelete(){
		UserService UserService = (UserService) context.getBean("UserService");
		User user = UserService.load("402881d639336a3a0139336a3ee20001");
		UserService.delete(user);
	}
	
	@Test
	public void testMixTransation(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
	}
	
}
