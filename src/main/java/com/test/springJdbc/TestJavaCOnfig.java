package com.test.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class TestJavaCOnfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "My Computer....!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        Student student=new Student();
         student.setId(47);
         student.setName("Naresh");
         student.setCity("Islamkot");
         studentDao.insert(student);
        
         List<Student> students=studentDao.getAllStudents();
         for(Student s: students)
         {
         	System.out.println(s);
         }
      

	}

}
