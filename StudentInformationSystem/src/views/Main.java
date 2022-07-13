package views;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.StudentDao;
import dao.StudentDaoImplInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImplInMemory();
		Student student1 = new Student("John", LocalDate.of(2000,10,20), Qualification.Graduate, "8787878787", "john@gmail.com", "Pune");
		Student student2 = new Student("Lily", LocalDate.of(2000,10,20), Qualification.Matric, "1234123412", "lily@gmail.com", "Mumbai");
		Student student3 = new Student("Brett", LocalDate.of(2000,10,20), Qualification.Master, "5678567856", "brett@gmail.com", "Bengaluru");
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		
		
		Iterator<Student> iterator = dao.viewAllStudents().iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.toString());
		}
		
		Scanner sc = new Scanner(System.in);
//		int rollNo = sc.nextInt();
		
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student!=null) {
//			System.out.println(student.getRollNo());
//		}else {
//			System.out.println("Student not found");
//		}
		
//		Student student = dao.findStudentByRollNo(rollNo);
//		if(student!=null) {
//			System.out.println(student.toString());
//			String phoneNo = sc.next();
//			student.setPhoneNo(phoneNo);
//			dao.updateStudentProfile(student);
//		}else {
//			System.out.println("Student not found");
//		}
		
//		Iterator<Student> iterator = dao.viewAllStudents().iterator();
//		while(iterator.hasNext()) {
//			Student studenta = iterator.next();
//			System.out.println(studenta.toString());
//		}

		Course course1 = new Course("Java", 6, 4000, Qualification.Graduate);
		Course course2 = new Course("Python", 5, 2000, Qualification.Intermidiate);
		Course course3 = new Course("Azure", 3, 8000, Qualification.Master);
		Course course4 = new Course(".Net", 8, 5000, Qualification.Matric);

		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);
		
		List<Course> courses = dao.viewAllCourses();
		
		Iterator<Course> iterator2 = courses.iterator();
		while(iterator2.hasNext()) {
			Course course = iterator2.next();
			System.out.println(course.toString());
		}
		
		System.out.println("enter roll no and course Id");
		int rollNo = sc.nextInt();
		int courseId = sc.nextInt();

		Student stud = dao.findStudentByRollNo(rollNo);
		Course cour = dao.findCourseById(courseId);
		if(stud!=null) {
			if(cour!=null) {
				dao.registration(stud, cour);
			}else {
				System.out.println("course not found");
			}
		}else {
			System.out.println("Student not found");
		}
		
		Map<Student, Course> registration  = dao.viewAllRegistrations();
		for(Map.Entry<Student, Course> entry: registration.entrySet()) {
			System.out.println(entry.getKey().getName()+" is taking a course on "+entry.getValue().getCourseName());
		}
		sc.close();
	}

}
