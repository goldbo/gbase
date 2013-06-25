package info.goldbo.base;

import info.goldbo.base.entity.User;

import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class HibernateTest {
	
	@Test
	public void testBulid(){
		Session session = HibernateSessionFactory.getSession();
		System.out.println(session);
		session.close();
	}
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setName("admin");
		user.setPassword("123456");
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){
		Session session = HibernateSessionFactory.getSession();
		User admin = (User) session.load(User.class, "297e0cc1390b866d01390b866fec0001");
		admin.setName("admin2");
		session.beginTransaction();
		session.update(admin);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDel(){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(session.load(User.class, "297e0cc1390b859101390b8595b70001"));
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testQuery(){
		Session session = HibernateSessionFactory.getSession();
		List list = session.createQuery("from Admin").list();
		Assert.assertTrue(list.size()>0);
	}
}
