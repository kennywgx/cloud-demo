package com.kenny.shirodemo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.kenny.shirodemo.repository")
@EntityScan(basePackages = "com.kenny.shirodemo.entity")
@EnableTransactionManagement
public class JPAConfig {
	
	
}
