package controller;

import java.util.List;
import java.util.Map;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {
	StudentDao dao = new StudentDaoImplDatabase();

	public String addNewStudent(Student student) {
		if (student.getPhoneNo().length() != 10) {
			try {
				throw new PhoneException("Invalid Phone Number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
		}
		return dao.addNewStudent(student);
	}

	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub

	}

	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub

	}

	public String registrationDb(Registration registration) {
		String message = "";
		Student st = dao.findStudentByRollNo(registration.getRollNo());
		Course cr = dao.findCourseById(registration.getCourseId());
		if (st != null) {
			if (cr != null) {
				if (st.getQualification().equals(cr.getEligibility())) {
					message = dao.registrartionDb(registration);
				} else {
					message = "You are not eligible";
				}
			} else {
				message = "Course not found";
			}
		} else {
			message = "Student does not exist";
		}
		return message;
	}

	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student findStudentByRollNo(int rollNo) {
		return dao.findStudentByRollNo(rollNo);
	}

	public List<Student> viewAllStudents() {
		return dao.viewAllStudents();
	}

	public String addNewCourse(Course course) {
		return dao.addNewCourse(course);

	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}
