package info.goldbo.base.bean;

import info.goldbo.base.entity.SystemListNo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SystemListNoRowMapper implements RowMapper<SystemListNo>{

	@Override
	public SystemListNo mapRow(ResultSet rs, int arg1) throws SQLException {
		SystemListNo systemListNo = new SystemListNo();	
		systemListNo.setId(rs.getInt("id"));
		systemListNo.setCode(rs.getString("code"));
		systemListNo.setPrefix(rs.getString("prefix"));
		systemListNo.setNum(rs.getInt("num"));
		systemListNo.setDigits(rs.getInt("digits"));
		systemListNo.setTitle(rs.getString("title"));
		systemListNo.setDateFormatType(rs.getInt("date_format_type"));
		return systemListNo;
	}

}
