import java.sql.*;

public class RegistrationDAO {

    public void registerStudent(Registration r) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO registration VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, r.regId);
            ps.setInt(2, r.studentId);
            ps.setInt(3, r.courseId);

            ps.executeUpdate();

            System.out.println("Registration Successful!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewRegistrations() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM registration";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("reg_id") + " " +
                                rs.getInt("student_id") + " " +
                                rs.getInt("course_id")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}