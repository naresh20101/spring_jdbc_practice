package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;
@Component("studentDao")
public class StudentDaoImp implements StudentDao{
	@Autowired
  private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	public int insert(Student student) {
		 String query="insert into student(id,name,city) values(?,?,?)";
		 int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}
	public int updateStudent(Student student) {
		String query="update student set name=?,city=? where id=?";
		int result=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return result;
	}
	public int deleteStudent(int studentId) {
	    String query="delete from student where id=?";
	    int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}
	public Student getStudent(int studentId) {
		// Selecting any single row
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImp();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		System.out.println(student);
		return student;
	}
	public List<Student> getAllStudents() {
		// Selecting all data
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImp());
		return students;
	}

}
