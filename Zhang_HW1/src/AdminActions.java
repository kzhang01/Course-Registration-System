

public interface AdminActions {
	
	public abstract void createCourse(String name, String courseID, String maxStudents, String instructor, String section,
			String location);
	public abstract void deleteCourse(String courseID);
	public abstract void editCourse(String courseID, int changed, String newVar);
	public abstract void displayInfo(String courseID);
	public static void viewEnrolledStudents(String courseID) {
		for(Course a: Data.totalCourses) {
			if(a.getCourseID().equals(courseID)){
				for(Student b: a.getStudentsRegistered()) {
					System.out.println("\t" + b.getFirstName() + " " + b.getLastName() + ", ID: " + b.getUsername());
				}
			}
		}
	}
	public abstract void sortCourses();
	public abstract void createStudent(String username, String password, String firstName, String lastName);
	
	
}
