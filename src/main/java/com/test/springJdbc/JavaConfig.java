package com.test.springJdbc;

import java.sql.DriverAction;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImp;
//here we can autowire method
@Configuration
@ComponentScan(basePackages= {"com.spring.jdbc.Dao"})
public class JavaConfig {
	@Bean("ds")
   public DataSource getDataSource()
     {
		 DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		 driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		 driverManagerDataSource.setUsername("root");
		 driverManagerDataSource.setPassword("engineer");
		return driverManagerDataSource;
     }
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	/*@Bean("studentDao")
	public StudentDao getStudentDao()
	{
		StudentDaoImp studentDao=new StudentDaoImp();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}*/

}
