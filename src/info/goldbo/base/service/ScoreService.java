package info.goldbo.base.service;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScoreService extends BaseService{
    @Resource
    private JdbcTemplate jdbcTemplate;
    public void addScore(String userName, int toAdd) {
        System.out.println("addScore...");
        String sql = "UPDATE t_user u SET u.score = ? WHERE userName =?";
        jdbcTemplate.update(sql, toAdd, userName);
        //�� �鿴�˴����ݿ⼤���������
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        System.out.println("��������������"+basicDataSource.getNumActive());
    }
}
