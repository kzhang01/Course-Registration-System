import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable{

	private static final long serialVersionUID = 6783249L;
	private String username, password, firstName, lastName;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public void viewFullCourses() {
		for(Course a: Data.totalCourses) {
			if(a.getStudentsRegistered().size() == Integer.parseInt(a.getMaxStudents())) {
				System.out.println("Course Name: " + a.getName());
				System.out.println("\tCourse ID: " + a.getCourseID());
				System.out.println("\tMaximum Students: " + a.getMaxStudents());
				System.out.println("\tInstructor: " + a.getInstructor());
				System.out.println("\tSection: " + a.getSection());	
				System.out.println("\tLocation: " + a.getLocation() + "\n");
			}
		}
	}

	public static void viewRegisteredCourses(String firstName, String lastName) {
		for(Course a: Data.totalCourses) {
			for(Student b: a.getStudentsRegistered()) {
				if(b.getFirstName().equals(firstName) && b.getLastName().equals(lastName)) {
					System.out.println("Course Name: " + a.getName());
					System.out.println("\tCourse ID: " + a.getCourseID());
					System.out.println("\tMaximum Students: " + a.getMaxStudents());
					System.out.println("\tInstructor: " + a.getInstructor());
					System.out.println("\tSection: " + a.getSection());	
					System.out.println("\tLocation: " + a.getLocation() + "\n");
				}
			}
			
		}
	}
}
