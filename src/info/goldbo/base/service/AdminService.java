package info.goldbo.base.service;

import info.goldbo.base.dao.AdminDao;
import info.goldbo.base.entity.Admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * service实现类-管理员
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2012-8-10 下午2:29:24
 * ==================================
 */

@Service
public class AdminService extends BaseService<Admin, String>  {

	@Resource
	private AdminDao adminDao;

	@Resource
	public void setBaseDao(AdminDao adminDao) {
		super.setBaseDao(adminDao);
	}
	
	public Admin getLoginAdmin() {
		System.out.println("Success!");
		return null;
	}
	
	public boolean isExistByUsername(String username) {
		return adminDao.isExistByUsername(username);
	}
	
	public Admin getAdminByUsername(String username) {
		return adminDao.getAdminByUsername(username);
	}

	@Override
	public void delete(Admin entity) {
		super.delete(entity);
		Admin admin = new Admin();
		admin.setEmail("test@admin.com");
		admin.setUsername("huang1");
		super.save(admin);
	}

}
