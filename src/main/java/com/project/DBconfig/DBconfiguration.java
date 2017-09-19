package com.project.DBconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan("com.project")
@Configuration
@EnableTransactionManagement
public class DBconfiguration 
{

//data source 
	
	@Bean(name = "dataSource")
	@Autowired
	public DataSource getDataSource()
	{
		BasicDataSource datasource =new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/shoe");
		datasource.setUsername("praveen");
		datasource.setPassword("praveen");
	return datasource;
	
	}
	//session-factory
	
	
	@Bean(name = "sessionFactory")
	@Autowired
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
	lsf.addProperties(hibernateProperties);
	lsf.scanPackages("com.project");
		
	    return lsf.buildSessionFactory();
	}
	
	//hibernate transaction manager
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}  
}