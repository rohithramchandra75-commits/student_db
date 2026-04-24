import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO sdao = new StudentDAO();
        CourseDAO cdao = new CourseDAO();
        RegistrationDAO rdao = new RegistrationDAO();

        while (true) {
            System.out.println("\n1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Search Student");
            System.out.println("4.Add Course");
            System.out.println("5.View Courses");
            System.out.println("6.Register Course");
            System.out.println("7.View Registrations");
            System.out.println("8.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter ID, Name, Email:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    String email = sc.nextLine();

                    sdao.addStudent(new Student(id, name, email));
                    break;

                case 2:
                    sdao.viewStudents();
                    break;

                case 3:
                    System.out.println("Enter name to search:");
                    sc.nextLine();
                    String search = sc.nextLine();
                    sdao.searchStudent(search);
                    break;

                case 4:
                    System.out.println("Enter Course ID and Name:");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    String cname = sc.nextLine();

                    cdao.addCourse(new Course(cid, cname));
                    break;

                case 5:
                    cdao.viewCourses();
                    break;

                case 6:
                    System.out.println("Enter RegID, StudentID, CourseID:");
                    int rid = sc.nextInt();
                    int sid = sc.nextInt();
                    int coid = sc.nextInt();

                    rdao.registerStudent(new Registration(rid, sid, coid));
                    break;

                case 7:
                    rdao.viewRegistrations();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}