package info.goldbo.base;

import static org.junit.Assert.assertEquals;
import info.goldbo.base.bean.SystemListNoRowMapper;
import info.goldbo.base.entity.SystemListNo;
import info.goldbo.base.util.AuthRandom;
import info.goldbo.base.util.NoUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 生成ID、编号测试类
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2013-6-14 上午10:54:01
 * ==================================
 */
public class GenerateNoTest {
	ApplicationContext context = null;
	
	@Before
	public void load(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testGetAuthRandom(){
		AuthRandom authRandom = new AuthRandom();
		authRandom.setCharset("A-Z0-9");
		authRandom.setLength("6");
		String randomStr = authRandom.getRandom();
		System.out.println(randomStr);
	}
	
	@Test
	public void testGaineUserId(){
		String userId = NoUtil.gainedNo("User");
		System.out.println(userId);
	}
	
	@Test
	public void testGaineNo(){
		String roleId = NoUtil.gainedNo("Role");
		System.out.println(roleId);
	}
	
	@Test
	public void testAddSystemListNo(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		String sql = "insert into system_list_no(title,code,prefix,num,digits,date_format_type)" +
				" values('角色编号','Role','ROLE',0,4,3)";
		jdbcTemplate.update(sql);
	}
	
	@Test
	public void testGetSystemListNo(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		String code = "Role";
		String sql = "select * from system_list_no where code = ?";
		SystemListNo systemListNo = null;
		try{
			systemListNo = (SystemListNo)jdbcTemplate.queryForObject(sql, 
					new Object[]{ code }, new SystemListNoRowMapper());
		} catch(Exception e){
			systemListNo = null;
		}
		System.out.println(systemListNo.getPrefix());
	}
	
}
