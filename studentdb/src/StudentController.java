import org.springframework.web.bind.annotation.*;
import java.sql.*;

@RestController
public class StudentController {

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String id,
                             @RequestParam String name,
                             @RequestParam String email) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "root123"
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student VALUES (?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, email);

            ps.executeUpdate();

            con.close();

            return "Student Added Successfully";

        } catch (Exception e) {
            return e.toString();
        }
    }
}