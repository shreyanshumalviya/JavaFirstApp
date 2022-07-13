package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentAppView {
	public static void main(String[] args) {

		StudentController controller = new StudentController();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Student \n2. Admin\n3. Exit");
			int userType = sc.nextInt();

			if (userType == 1) {
				String choice = "y";
				do {
					String message = "" + "1. Sign Up" + "\n2. Update phone number" + "\n3. View all students"
							+ "\n4. Register for a course" + "\n5. Sign out.";
					System.out.println(message);
					int option = sc.nextInt();

					switch (option) {
					case 1:
						System.out.println("Enter name, dob (dd/MM/yyyy), ph no, email and address ");
						String name = sc.next();
						String dobString = sc.next();
						DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dob = LocalDate.parse(dobString, sdf);

						String phNo = sc.next();
						String email = sc.next();
						String address = sc.next();

						System.out.println("1. Master 2. Graduate 3 Intermediate 4. Matric ");
						int q = sc.nextInt();
						Qualification qualification = null;
						if (q == 1)
							qualification = Qualification.Master;
						if (q == 2)
							qualification = Qualification.Graduate;
						if (q == 3)
							qualification = Qualification.Intermidiate;
						if (q == 4)
							qualification = Qualification.Matric;

						Student student = new Student(name, dob, qualification, phNo, email, address);
						String controllerResponse = controller.addNewStudent(student);
						System.out.println(controllerResponse);
						break;
						
					case 4:
						System.out.println("Enter roll no, course to enrorll");
						int rollNo = sc.nextInt();
						int courseId = sc.nextInt();
						
						String regDateString = sc.next();
						sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate date = LocalDate.parse(regDateString, sdf);
						
						Registration registration = new Registration(date, courseId, rollNo);
						
						message = controller.registrationDb(registration);
						System.out.println(message);
						break;
						
					}

					System.out.println("to continue enter y");
					choice = sc.next();
				} while (choice.equalsIgnoreCase("y"));
			} else if (userType == 2) {
				String choice = "y";
				do {
					String message = "1. View All users\n" + "2. Find Student by Roll No\n" + "3. Add Course";
					System.out.println(message);
					int option = sc.nextInt();

					switch (option) {
					case 1:
						List<Student> students = controller.viewAllStudents();
						for (Student stu : students) {
							System.out.println(stu.toString());
						}
						break;
					case 2:
						System.out.println("Enter Roll no to find");
						int rollNo = sc.nextInt();
						Student student = controller.findStudentByRollNo(rollNo);
						if (student != null) {
							System.out.println(student.toString());
						} else {
							System.out.println("Student Not Found");
						}
						break;
					case 3:
						System.out.println("Enter course Name, duration, fee ");
						String name = sc.next();
						int duration = sc.nextInt();
						double fee = sc.nextDouble();

						System.out.println("Select Eligibility\n1. Master 2. Graduate 3 Intermediate 4. Matric ");
						int q = sc.nextInt();
						Qualification qualification = null;
						if (q == 1)
							qualification = Qualification.Master;
						if (q == 2)
							qualification = Qualification.Graduate;
						if (q == 3)
							qualification = Qualification.Intermidiate;
						if (q == 4)
							qualification = Qualification.Matric;

						Course course = new Course(name, duration, fee, qualification);
						String controllerResponse = controller.addNewCourse(course);
						System.out.println(controllerResponse);
						break;

					}

					System.out.println("to continue enter y");
					choice = sc.next();
				} while (choice.equalsIgnoreCase("y"));

			} else if (userType == 3) {
				System.out.println("Exiting");
				sc.close();
				System.exit(0);
			} else {
				System.out.println("Invalid choice.");
			}
		}

	}
}
