package info.goldbo.base.util;

import info.goldbo.base.bean.SystemListNoRowMapper;
import info.goldbo.base.entity.SystemListNo;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * 生成编号工具类 ==================================
 * 
 * @author huangjinbo
 * @email goldbo891218@gmail.com 2013-6-9 下午3:52:12
 *        ==================================
 */
public class NoUtil {
	protected static JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringUtil.getBean("jdbcTemplate");
	public static AuthRandom authRandom = null;

	public static String gainedNo(String code) {
		if ("User".equals(code)) {
			return getUserId();
		} else {
			return gainedNo(code, true);
		}
	}

	private static String gainedNo(String code, boolean b) {
		StringBuffer randomStr = new StringBuffer();
		SystemListNo systemListNo = getSystemListNo(code);
		if(systemListNo==null){
			throw  new NullPointerException(code+"未配置编号！");
		}
		systemListNo.setNum(systemListNo.getNum()+1);
		randomStr.append(systemListNo.getPrefix()).append(gainedDate(systemListNo.getDateFormatType()));
		randomStr.append(formatNum(systemListNo.getDigits(),systemListNo.getNum()));
		randomStr.append(getAuthRandom());
		if(randomStr.length()>24){
			randomStr.substring(randomStr.length()-24);
		}
		updateSystemListNo(systemListNo);
		return randomStr.toString();
	}


	public static String formatNum(Integer digits, Integer num) {
		if(digits==0){
			return "";
		}
		String formatStr = "%0"+digits+"d";
		String formatNum = String.format(formatStr, num);   
		return formatNum;
	}

	public static String gainedDate(int dateType){
		DateFormat dateFormat = null; 
		if(dateType==3){
			dateFormat = new SimpleDateFormat("yyMMdd");
		} else if(dateType==2){
			dateFormat = new SimpleDateFormat("yyMM");
		} else if(dateType==1){
			dateFormat = new SimpleDateFormat("yy");
		} else {
			return "";
		}
		return dateFormat.format(new Date());
	}
	
	private static String getUserId() {
		String userId = getAuthRandom();
		while (existUserRecord(userId)) {
			userId = getAuthRandom();
		}
		return userId;
	}

	public static String getAuthRandom() {
		if (authRandom == null) {
			authRandom = new AuthRandom();
			authRandom.setCharset("A-Z0-9");
			authRandom.setLength("4");
		}
		return authRandom.getRandom();
	}

	private static  boolean existUserRecord(String userId) {
		String sql = "select user_id from user where user_id='"+userId+"' and active=1";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);	
		return rowSet.first();
	}
	
	private static SystemListNo getSystemListNo(String code){
		String sql = "select * from system_list_no where code = ?";
		SystemListNo systemListNo = null;
		try{
			systemListNo = (SystemListNo)jdbcTemplate.queryForObject(sql, 
					new Object[]{ code }, new SystemListNoRowMapper());
		} catch(Exception e){
			systemListNo = null;
		}
		return systemListNo;
	}
	
	private static void updateSystemListNo(SystemListNo systemListNo) {
		String sql = "update system_list_no set num = ? where code = ?";
		jdbcTemplate.update(sql, new Object[]{systemListNo.getNum(),systemListNo.getCode()});		
	}
}
