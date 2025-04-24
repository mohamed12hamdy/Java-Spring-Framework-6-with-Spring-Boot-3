package com.telusko.SpringBootJDBC;

import com.telusko.SpringBootJDBC.Service.StudentService;
import com.telusko.SpringBootJDBC.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext Context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		Student s = 	Context.getBean(Student.class);
		s.setRollNo(104);
        s.setName("Nivin");
		s.setMarks(50);
		StudentService service = Context.getBean(StudentService.class);
		service.AddStudent(s);
		List<Student> Students = service.GetAllStudents();
		System.out.println(Students);
    }
}





