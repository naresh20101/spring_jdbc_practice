package com.spring.jdbc.Dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();

}
