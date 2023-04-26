package com.himedia.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.himedia.jdbc.util.JDBCConnectionManager;

@Configuration //JDBCConnectionManager를 bean으로 등록하는 환경설정 class
public class BoardAutoConfiguration {

	@Bean 
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
		manager.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		manager.setUsername("hr");
		manager.setPassword("12341234");
		return manager;
	}

} 
