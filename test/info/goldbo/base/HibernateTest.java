package info.goldbo.base;

import info.goldbo.base.entity.Admin;

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
		Admin admin = new Admin();
		admin.setName("admin");
		admin.setPassword("123456");
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){
		Session session = HibernateSessionFactory.getSession();
		Admin admin = (Admin) session.load(Admin.class, "297e0cc1390b866d01390b866fec0001");
		admin.setUsername("admin");
		admin.setEmail("admin@goldbo.info");
		session.beginTransaction();
		session.update(admin);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDel(){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(session.load(Admin.class, "297e0cc1390b859101390b8595b70001"));
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
