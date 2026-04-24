import java.sql.*;

public class CourseDAO {

    public void addCourse(Course c) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO course VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, c.courseId);
            ps.setString(2, c.courseName);

            ps.executeUpdate();

            System.out.println("Course Added!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewCourses() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM course";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("course_id") + " " +
                                rs.getString("course_name")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}