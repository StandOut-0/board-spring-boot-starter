package com.himedia.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//application properties에 정보를 가져와 객체를 만든다.
@ConfigurationProperties(prefix="board.jdbc")
public class JDBCConnectionManagerProperties {
	private String driverClass;
	private String url;
	private String username;
	private String password; 
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
