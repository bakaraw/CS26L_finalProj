package utils;

public class Employee {
	private String id;
	private String name;
	private String birthday;
	private String username;
	private String password;
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(String bday) {
		this.birthday = bday;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
