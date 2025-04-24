package com.telusko.SpringBootJDBC.Service;

import com.telusko.SpringBootJDBC.Repository.StudentRepo;
import com.telusko.SpringBootJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


   private StudentRepo Repo;

   public StudentRepo getRepo() {
      return Repo;
   }
   @Autowired
   public void setRepo(StudentRepo repo) {
      Repo = repo;
   }

   public void AddStudent(Student s){
         Repo.save(s);
   }

   public List<Student> GetAllStudents() {
      return Repo.findAll();
   }
}
