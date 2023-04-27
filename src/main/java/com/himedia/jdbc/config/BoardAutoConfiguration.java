package com.himedia.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.himedia.jdbc.util.JDBCConnectionManager;

@Configuration //JDBCConnectionManager를 bean으로 등록하는 환경설정 class
public class BoardAutoConfiguration {

	//@ConditionalOnMissingBean 해당 JDBCConnectionManager bean이 메모리에 없는 경우에만 빈 등록을 처리한다.
	
	@Bean 
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
		manager.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		manager.setUsername("hr");
		manager.setPassword("12341234");
		return manager;
	}

} 
