package com.telusko.spring_data_jpa_ex;

import com.telusko.spring_data_jpa_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s WHERE s.Name = :name")
    /// Name in s. must match the name in the model
    List<Student> findByName( String name);


    @Query("SELECT s FROM Student s WHERE s.Marks = :marks")
    List<Student> findByMarks(int marks);


}
