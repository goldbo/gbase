package info.goldbo.base.service;

import info.goldbo.base.entity.User;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {
	
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Resource
    private ScoreService scoreService;

    public void update(String userName) {
        System.out.println("logon method...");
        updateLastLogonTime(userName); //①使用Hibernate数据访问技术
        scoreService.addScore(userName, 30); //②使用Spring JDBC数据访问技术
    }

    public void updateLastLogonTime(String userName) {
        System.out.println("updateLastLogonTime...");
        User user = hibernateTemplate.load(User.class, "402881d6390e44b001390e44b1720001");
        //User user = hibernateTemplate.get(User.class,userName);
        user.setLastLogonTime(System.currentTimeMillis());
        hibernateTemplate.flush(); //③请看下文的分析
    }
}

