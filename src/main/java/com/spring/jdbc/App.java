package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
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
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student = new Student();
        student.setId(666);
        student.setName("Janhvi");
        student.setCity("Mumbai");

        int result = studentDao.insert(student);
        System.out.println("Student added"+result);


        //Updating student with new object
        Student student1 = new Student();

        student1.setId(4);
        student1.setName("Raj Kumar");
        student1.setCity("Haidrabad");

        int result1 = studentDao.change(student1);
        System.out.println("Number of datachanged "+result1);
        //JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        //Insert Query
        //String query ="insert into student(id,name,city) values(?,?,?)";
        
        //fire query
        //we are using template to fire query
        //int result = template.update(query,4,"demo","mumbai");
        //System.out.println("Number of record inserted "+result);

    }
}
