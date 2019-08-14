package pojo;

/**
 * UserPass generated by hbm2java
 */
public class UserPass implements java.io.Serializable {

	private String username;
	private int id;
	private String password;

	public UserPass() {
	}

	public UserPass(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
