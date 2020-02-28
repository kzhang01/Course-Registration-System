import java.util.Collections;

public class Admin extends User implements AdminActions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 298456L;

	@Override
	public void createCourse(String name, String courseID, String maxStudents, String instructor, String section, String location) {
		
		Data.totalCourses.add(new Course(name, courseID, maxStudents, instructor, section, location));
		System.out.println("The following course has been created:");
		System.out.println("Course Name: " + name);
		System.out.println("Course ID: " + courseID);
		System.out.println("\tMaximum Students: " + maxStudents);
		System.out.println("\tInstructor: " + instructor);
		System.out.println("\tSection: " + section);
		System.out.println("\tLocation: " + location);
		
	}

	@Override
	public void deleteCourse(String courseID) {
		for(Course a: Data.totalCourses) {
			if(a.getCourseID().compareTo(courseID) == 0) {
				Data.totalCourses.remove(a);
				System.out.println("The course has been deleted");
			}
		}
	}

	@Override
	public void editCourse(String courseID, int changed, String newVar) {
		Course change = Data.totalCourses.get(2);
		
		for(Course a: Data.totalCourses) {
			if(a.getCourseID().equals(courseID)) {
				change = a;
				switch(changed) {
				case 1:
					change.setMaxStudents(newVar);
					break;
				case 2:
					change.setInstructor(newVar);
					break;
				case 3:
					change.setSection(newVar);
					break;
				case 4:
					change.setLocation(newVar);
					break;
				default:
					System.out.println("Option not found.");
					break;
				}
				displayInfo(courseID);
			}
		}
	}

	@Override
	public void displayInfo(String courseID) {
		for(Course a: Data.totalCourses) {
			if(a.getCourseID().compareTo(courseID) == 0) {
				System.out.println("Course Name: " + a.getName());
				System.out.println("\tMaximum Students: " + a.getMaxStudents());
				System.out.println("\tInstructor: " + a.getInstructor()); //instructor is zero somehow???
				System.out.println("\tSection: " + a.getSection());
				System.out.println("\tLocation: " + a.getLocation());
				System.out.println("\tNumber of students registered: " + a.getNumStudentsRegistered());
				System.out.println("\tStudents registered: ");
				AdminActions.viewEnrolledStudents(courseID);

			}
		}
		
	}

	@Override
	public void createStudent(String username, String password, String firstName, String lastName) {
		Data.totalStudents.add(new Student(username, password, firstName, lastName));
		
		System.out.println("The following student has been added to the system:");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		
	}
	
	public void adminViewCourses() {
		for(Course a: Data.totalCourses) {
			System.out.println("Course Name: " + a.getName());
			System.out.println("\tCourse ID: " + a.getCourseID());
			System.out.println("\tMaximum Students: " + a.getMaxStudents());
			System.out.println("\tInstructor: " + a.getInstructor());
			System.out.println("\tSection: " + a.getSection());	
			System.out.println("\tLocation: " + a.getLocation());
			System.out.println("\tNumber of students registered: " + a.getNumStudentsRegistered());
			System.out.println("\tStudents registered: ");
			AdminActions.viewEnrolledStudents(a.getCourseID());
		}
	}
	
	@Override
	public void sortCourses() {
		Collections.sort(Data.totalCourses);
		adminViewCourses();
	}

	public Admin(String username, String password, String firstName, String lastName) {
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	
}
