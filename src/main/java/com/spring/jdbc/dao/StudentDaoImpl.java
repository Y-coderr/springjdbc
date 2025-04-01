package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    public int insert(Student student){
        String query ="insert into student(id,name,city) values(?,?,?)";
        int r =this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        //updating data
        String qurey = "UPDATE student set name=?,city=? WHERE id=?";
        int r = this.jdbcTemplate.update(qurey,student.getName(),student.getCity(),student.getId());
        return r;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
