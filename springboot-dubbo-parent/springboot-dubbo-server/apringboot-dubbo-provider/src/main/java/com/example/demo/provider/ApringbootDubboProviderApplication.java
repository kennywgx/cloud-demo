package com.example.demo.provider;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 路径：com.example.demo.provider
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/6/15 16:15
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@SpringBootApplication
@MapperScan("com.example.demo.provider.dao")
@ImportResource("classpath:provider.xml")
public class ApringbootDubboProviderApplication {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ApringbootDubboProviderApplication.class, args);
		//pom中没有加spring-boot-starter-web依赖，启动时没有tomcat容器，会自动退出，所以加了一个sleep防止自动退出
		Thread.sleep(Long.MAX_VALUE);
	}
}
