package com.test.SpringBootwithHibernate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.test.SpringBottwithHibernate.Entity.Country;
import com.test.SpringBottwithHibernate.Entity.Employee;
import com.test.SpringBottwithHibernate.Entity.EmployeeTable;

@Configuration
public class Springbootconfig {

	
	@Autowired
	DataSource dataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setAnnotatedClasses(Employee.class,EmployeeTable.class,Country.class);
		return sessionFactory;
	}


}
