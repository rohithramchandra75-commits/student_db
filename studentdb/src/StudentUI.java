import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration System");

        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel l1 = new JLabel("Student ID:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Name:");
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Email:");
        JTextField t3 = new JTextField();

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");

        JTextArea output = new JTextArea();
        JScrollPane scroll = new JScrollPane(output);

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(t3);
        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(scroll);

        StudentDAO dao = new StudentDAO();

        // ADD BUTTON ACTION
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(t1.getText());
                String name = t2.getText();
                String email = t3.getText();

                dao.addStudent(new Student(id, name, email));
                output.setText("Student Added!");
            }
        });

        // VIEW BUTTON ACTION
        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");

                try {
                    java.sql.Connection con = DBConnection.getConnection();
                    java.sql.Statement st = con.createStatement();
                    java.sql.ResultSet rs = st.executeQuery("SELECT * FROM student");

                    while (rs.next()) {
                        output.append(
                                rs.getInt(1) + " " +
                                        rs.getString(2) + " " +
                                        rs.getString(3) + "\n"
                        );
                    }

                    con.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        frame.setVisible(true);
    }
}