package com.dbs.hack2hire.fxRateAlert.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class FxRateAlertConfiguration {
	
	@Value("${oracle.driver.class.name}")
	private String oracleDriverClassName;
	
	@Value("${oracle.url}")
	private String oracleUrl;
	
	@Value("${oracle.username}")
	private String oracleUserName;
	
	@Value("${oracle.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(oracleDriverClassName);
		dataSource.setUrl(oracleUrl);
		dataSource.setUsername(oracleUserName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.dbs.hack2hire" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		return em;

	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
