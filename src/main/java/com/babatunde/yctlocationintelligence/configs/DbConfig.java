package com.babatunde.yctlocationintelligence.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ConfigurationProperties("spring.datasource")
@Slf4j
public class DbConfig {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	public String devDBConfig() {
		log.info("db Driver class name: {}",driverClassName);
		log.info("db url name: {}",url);
		log.info("db username: {}",username);
		return "Connected to the dev DB";
	}
	
	@Profile("prod")
	public String ProdDBConfig() {
		log.info("db Driver class name: {}",driverClassName);
		log.info("db url name: {}",url);
		log.info("db username: {}",username);
		return "Connected to the prod DB";
	}

}
