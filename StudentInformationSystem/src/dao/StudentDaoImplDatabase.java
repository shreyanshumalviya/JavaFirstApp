package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import connection.OracleConnection;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentDaoImplDatabase implements StudentDao {

	Connection conn;
	PreparedStatement ps; // used to run SQL queries

	public StudentDaoImplDatabase() {
		conn = OracleConnection.getConnection();
		if (conn != null) {
			System.out.println("Connected");
		} else {
			System.out.println("NOT Connected");
		}
	}

	@Override
	public String addNewStudent(Student student) {

		String sql = "insert into tbl_students values(seq_stud.nextval,?,?,?,?,?,?)";
		int count;
		String message;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setDate(2, Date.valueOf(student.getDateOfBirth()));
			ps.setString(3, student.getQualification().name());
			ps.setString(4, student.getPhoneNo());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getAddress());
			
			count = ps.executeUpdate();
			System.out.println("count is "+ count);
			
			if(count>0) {
				message = "New Student Added successfully";
			}else {
				message = "Insert count was 0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			e.printStackTrace();
		}
		return message;
		
	}

	@Override
	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub
		String sql = "update tbl_students set name = ?, dateofbirth = ?, phoneno = ?, email = ?";
	}

	@Override
	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub

	}
	
	public String registrartionDb(Registration registration) {
		String sql = "insert into tbl_registrations values(seq_reg.nextval, ?,?,?)";
		String message="";
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setDate(1, Date.valueOf(registration.getRegistrationDate()));
			ps.setInt(2, registration.getRollNo());
			ps.setInt(3, registration.getCourseId());
			
			int count = ps.executeUpdate();
			message = count>0?"Registration Successful":"Insertion count was 0";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
		
	}

	@Override
	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		String sql = "select * from tbl_students where rollNo=?";
		ResultSet result = null; 
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rollNo);
			
			result = ps.executeQuery();
			
			Student st = null;
			
			if(result.next()) {
				st = new Student();
				st.setRollNo(result.getInt(1));
				st.setName(result.getString(2));
				st.setDateOfBirth(result.getDate(3).toLocalDate());
				st.setQualification(Qualification.valueOf(result.getString(4)));
				st.setPhoneNo(result.getString(5));
				st.setEmail(result.getString(6));
				st.setAddress(result.getString(7));
			}
			return st;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> viewAllStudents() {
		String sql = "select * from tbl_students";
		ResultSet result = null; 
		try {
			List<Student> students = new ArrayList<>();
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			
			Student st = null;
			
			while(result.next()) {
				st = new Student();
				st.setRollNo(result.getInt(1));
				st.setName(result.getString(2));
				st.setDateOfBirth(result.getDate(3).toLocalDate());
				st.setQualification(Qualification.valueOf(result.getString(4)));
				st.setPhoneNo(result.getString(5));
				st.setEmail(result.getString(6));
				st.setAddress(result.getString(7));
				
				students.add(st);
			}
			return students;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addNewCourse(Course course) {

		String sql = "insert into tbl_courses values(seq_crs.nextval,?,?,?,?)";
		int count;
		String message;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getDurationInMonths());
			ps.setDouble(3, course.getFee());
			ps.setString(4, course.getEligibility().name());
			
			count = ps.executeUpdate();
			System.out.println("count is "+ count);
			
			if(count>0) {
				message = "New Student Added successfully";
			}else {
				message = "Insert count was 0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			e.printStackTrace();
		}
		return message;

	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourseById(int courseId) {
		String sql = "select * from tbl_courses where courseid=?";
		ResultSet result = null; 
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, courseId);
		
		result = ps.executeQuery();
		
		Course cr = null;
		
		if(result.next()) {
			cr = new Course();
			cr.setCourseId(result.getInt(1));
			cr.setCourseName(result.getString(2));
			cr.setDurationInMonths(result.getInt(3));
			cr.setFee(result.getDouble(4));
			cr.setEligibility(Qualification.valueOf(result.getString(5)));
		}
		return cr;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

}
