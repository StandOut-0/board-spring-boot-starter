package com.himedia.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.himedia.jdbc.util.JDBCConnectionManager;

//@Configuration  JDBCConnectionManager를 bean으로 등록하는 환경설정 class
//@EnableConfigurationProperties 활성화할 프로퍼티 클래스를 지정할때 사용
@Configuration 
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)  
public class BoardAutoConfiguration {
	
	//활성화된 프로퍼티객체(JDBCConnectionManagerProperties)는 @autowired
	@Autowired
	private JDBCConnectionManagerProperties properties;

	//@ConditionalOnMissingBean 해당 JDBCConnectionManager bean이 메모리에 없는 경우에만 빈 등록을 처리한다.
	
	@Bean 
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
//		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
//		manager.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//		manager.setUsername("hr");
//		manager.setPassword("12341234");
		
		//데이터베이스 객체정보를 get한다.
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}

} 
