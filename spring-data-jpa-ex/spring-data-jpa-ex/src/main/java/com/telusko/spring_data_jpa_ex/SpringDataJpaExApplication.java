package com.telusko.spring_data_jpa_ex;

import com.telusko.spring_data_jpa_ex.model.Student;
import org.hibernate.sql.ast.tree.expression.SqlTuple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {



		ApplicationContext Context = SpringApplication.run(SpringDataJpaExApplication.class, args);

		StudentRepo Repo = Context.getBean(StudentRepo.class);

		Student student1 = Context.getBean(Student.class);
		Student student2 = Context.getBean(Student.class);
		Student student3 = Context.getBean(Student.class);


		student1.setName("Navin");
		student1.setRollNo(65);
		student1.setMarks(100);
//
		student2.setName("Harsh");
		student2.setRollNo(90);
		student2.setMarks(112);
////
////		student3.setName("Eman");
////		student3.setRollNo(80);
////		student3.setMarks(112);
//
//
////		Repo.save(student1);
////		Repo.save(student2);
////
////		Optional<Student>s = Repo.findById(112);
////
////		System.out.println(s.orElse(new Student()));
////		System.out.println(Repo.findByName("Navin"));
////
////		System.out.println(Repo.findByMarks(112));
//
//		Repo.save(student1);



	}

}
