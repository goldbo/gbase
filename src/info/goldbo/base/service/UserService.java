package info.goldbo.base.service;

import info.goldbo.base.dao.UserDao;
import info.goldbo.base.entity.User;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, String> {
	@Resource
	private UserDao userDao;

	@Resource
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}
}

