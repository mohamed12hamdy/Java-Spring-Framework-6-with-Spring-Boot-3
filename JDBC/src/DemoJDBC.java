import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {
         String url = "jdbc:postgresql://localhost:5432/Demo";   //THIS IP ADDRESS AND PORT NUMBER
         String uname = "postgres";
         String Password = "0000";
         Connection conn = DriverManager.getConnection(url,uname,Password);


         System.out.println("Connection is Established");
         String Query = "select * from student where sname = ?";
         PreparedStatement statement = conn.prepareStatement(Query);
         statement.setString(1,"mohamed");
         ResultSet rs = statement.executeQuery();
         while(rs.next()){
             int sid = rs.getInt("sid");
             String name = rs.getString("sname");
             int marks = rs.getInt("marks");

             System.out.println("ID: " + sid + ", Name: " + name + ", marks: " + marks);

         }

    }

}
