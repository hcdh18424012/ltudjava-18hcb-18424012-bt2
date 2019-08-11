package pojo;
// Generated Aug 11, 2019 9:16:50 AM by Hibernate Tools 5.4.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserPassId generated by hbm2java
 */
@Entity
@Table(name = "user_pass")
public class UserPass implements java.io.Serializable {
	
	private String username;
	private String password;

	public UserPass() {
	}

	public UserPass(String username, String password) {
		this.username = username;
		this.password = password;
	}
	@Id
	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserPass))
			return false;
		UserPass castOther = (UserPass) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}
