import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements StudentActions, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -193471396L;

	public static void studentViewCourses() {
		for(Course a: Data.totalCourses) {
			System.out.println("Course Name: " + a.getName());
			System.out.println("\tCourse ID: " + a.getCourseID());
			System.out.println("\tMaximum Students: " + a.getMaxStudents());
			System.out.println("\tInstructor: " + a.getInstructor());
			System.out.println("\tSection: " + a.getSection());	
			System.out.println("\tLocation: " + a.getLocation());
			System.out.println("\tNumber of students registered: " + a.getNumStudentsRegistered());
		}
	}
	
	public static void viewNotFull() {
		for(Course a:Data.totalCourses) {
			if(Integer.parseInt(a.getMaxStudents()) != a.getNumStudentsRegistered()) {
				System.out.println("Course Name: " + a.getName());
				System.out.println("\tCourse ID: " + a.getCourseID());
				System.out.println("\tMaximum Students: " + a.getMaxStudents());
				System.out.println("\tInstructor: " + a.getInstructor());
				System.out.println("\tSection: " + a.getSection());	
				System.out.println("\tLocation: " + a.getLocation());
				System.out.println("\tNumber of students registered: " + a.getNumStudentsRegistered());
			}
		}
	}

	
	public Student(String username, String password, String firstName, String lastName) {
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public Student(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername("username");
		this.setPassword("password");
		
	}
}
