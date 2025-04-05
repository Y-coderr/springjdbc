package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

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

    @Override
    public int delete(int studentID) {
        String query = "DELETE from student where id=?";
        int r =this.jdbcTemplate.update(query,studentID);
        return r;
    }

    @Override
    public Student getStudent(int studentId) {
        //selecting single student data
        String query="SELECT * FROM student WHERE id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper , studentId);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        // selecting multiple students
        String query = "SELECT * FROM student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
