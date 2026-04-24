import java.sql.*;
import java.util.*;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, s.studentId);
            ps.setString(2, s.name);
            ps.setString(3, s.email);

            ps.executeUpdate();

            System.out.println("Student Added!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW STUDENTS
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // SEARCH STUDENT (STRING CONCEPT)
    public void searchStudent(String name) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM student WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}