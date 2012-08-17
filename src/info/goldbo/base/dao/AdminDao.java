package info.goldbo.base.dao;

import info.goldbo.base.entity.Admin;

import org.springframework.stereotype.Repository;

/**
 * Dao实现类-管理员
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2012-8-10 下午3:08:45
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
