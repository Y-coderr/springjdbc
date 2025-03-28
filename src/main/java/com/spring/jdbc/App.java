package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started..." );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        //Insert Query
        String query ="insert into student(id,name,city) values(?,?,?)";
        
        //fire query
        //we are using template to fire query
        int result = template.update(query,4,"demo","mumbai");
        System.out.println("Number of record inserted "+result);

    }
}
