package info.goldbo.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * id生成配置表
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2013-6-14 上午11:08:37
 * ==================================
 */
@Entity
@Table(name="system_list_no")
public class SystemListNo {
	private Integer id;           //自增id
	private String title;          //描述
	private String code;          //模块标识
	private String prefix;        //前缀 
	private Integer num;           //当前编号
	private Integer digits;        //编号位数
	private Integer dateFormatType;      //日期格式化类型，0为不格式化，1为年，2为年月，3为年月日，
	
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getDigits() {
		return digits;
	}
	public void setDigits(Integer digits) {
		this.digits = digits;
	}
	@Column(name="date_format_type")
	public Integer getDateFormatType() {
		return dateFormatType;
	}
	public void setDateFormatType(Integer dateFormatType) {
		this.dateFormatType = dateFormatType;
	}

}
