package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {
	String addNewStudent(Student student);
	void updateStudentProfile(Student student);
	void registration(Student student, Course course);
	String registrartionDb(Registration registration);
	Map<Student, Course> viewAllRegistrations();
	Student findStudentByRollNo(int rollNo);
	List<Student> viewAllStudents();
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	Course findCourseById(int courseId);
}
