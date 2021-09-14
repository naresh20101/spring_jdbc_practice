package com.test.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImp;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Computer....!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("com/test/springJdbc/config.xml");
        StudentDao studentDao=context.getBean("studentDaoImp",StudentDao.class);
        //INSERT AND UPDATE 
       Student student=new Student();
        student.setId(45);
        student.setName("Turab Bajeer");
        student.setCity("Islamkot");
       studentDao.insert(student);
       //UPDATE
       student.setId(45);
       student.setName("Turab Bajeer Programmer ");
       student.setCity("Islamkot");
      studentDao.updateStudent(student);
       // JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
        //String query="insert into student(id,name,city) values(?,?,?)";
        // int result=template.update(query,6,"Naresh Kumar","khatri");
        //DELETE
        int r=studentDao.deleteStudent(5);
        //Selecting single row
        Student s=studentDao.getStudent(1);
        System.out.println(s);
        //Selecting Multiple rows
        List<Student> students=studentDao.getAllStudents();
        for(Student st: students)
        {
        	System.out.println(st);
        }
       
    }
    
}
