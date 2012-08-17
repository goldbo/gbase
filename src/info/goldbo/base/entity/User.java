package info.goldbo.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="t_user")
public class User extends BaseEntity {
	
    private String userName; 
    private String password; 
    private int score; 
    private long lastLogonTime = 0;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getLastLogonTime() {
		return lastLogonTime;
	}
	public void setLastLogonTime(long lastLogonTime) {
		this.lastLogonTime = lastLogonTime;
	}  
    
    
}
