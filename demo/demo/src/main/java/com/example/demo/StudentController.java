package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.sql.*;

@RestController
@CrossOrigin(origins = "*")   // 🔥 VERY IMPORTANT (fixes your error)
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
                    "Mysql@2005"
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


    @GetMapping("/students")
    public String getStudents() {

        StringBuilder result = new StringBuilder();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "Mysql@2005"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            result.append("<table border='1'>");
            result.append("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (rs.next()) {
                result.append("<tr>");
                result.append("<td>").append(rs.getString(1)).append("</td>");
                result.append("<td>").append(rs.getString(2)).append("</td>");
                result.append("<td>").append(rs.getString(3)).append("</td>");
                result.append("</tr>");
            }

            result.append("</table>");
            con.close();

        } catch (Exception e) {
            return e.toString();
        }

        return result.toString();
    }
}