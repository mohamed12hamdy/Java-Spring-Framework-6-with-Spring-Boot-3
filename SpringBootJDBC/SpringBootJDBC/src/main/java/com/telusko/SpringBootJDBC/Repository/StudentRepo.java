package com.telusko.SpringBootJDBC.Repository;

import com.telusko.SpringBootJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
   private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student(rollNo,Name,Marks) values(?,?,?)";
       int rows = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student>mapper = new RowMapper<Student>() {
            @Override
            /// it fetches data from resultSet and put it in StudentObject to map row by row
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stud = new Student();
                stud.setRollNo(rs.getInt("rollNo"));
                stud.setMarks(rs.getInt("Marks"));
                stud.setName(rs.getString("Name"));
                return stud;
            }

        };
       return jdbc.query(sql,mapper);
    }
}
