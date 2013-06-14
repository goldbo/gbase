package info.goldbo.base.dao;

import info.goldbo.base.entity.Admin;

import org.springframework.stereotype.Repository;

/**
 * 
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2013-6-9 下午4:31:49
 * ==================================
 */
@Repository
public class AdminDao extends BaseDao<Admin, String>  {

	public boolean isExistByUsername(String username) {
		String hql = "from Admin admin where lower(admin.username) = lower(?)";
		Admin admin = (Admin) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}

	public Admin getAdminByUsername(String username) {
		return null;
	}
	
}
