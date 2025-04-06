package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class jdbcConfig {

    @Bean("ds")
    public DataSource getDataSource(){
       DriverManagerDataSource ds = new DriverManagerDataSource();
       ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
       ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
       ds.setUsername("root");
       ds.setPassword("root");
       return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
       JdbcTemplate jdbcTemplate = new JdbcTemplate();
       jdbcTemplate.setDataSource(getDataSource());
       return jdbcTemplate;
    }

    @Bean("studentDao")
    public StudentDao getStudentDao(){
         StudentDaoImpl studentDao = new StudentDaoImpl();
         studentDao.setJdbcTemplate(getTemplate());
         return studentDao;
    }
}
