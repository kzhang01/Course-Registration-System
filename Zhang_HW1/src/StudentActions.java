
public interface StudentActions {
	public static void withdraw(String name) {
		for(Course a: Data.totalCourses) {
			if(a.getName().compareTo(name) == 0) {
				for(Student b: Data.totalStudents) {
					a.getStudentsRegistered().remove(b);
				}
			}
		}
	}

	default void register(String name, String section){
		for(Course a: Data.totalCourses) {
			if(a.getName().equals(name) && a.getSection().equals(section) && a.getStudentsRegistered().contains((Student) this) == false) {
				a.getStudentsRegistered().add((Student) this);
				System.out.println("You have been registered for the following course:");
				System.out.println("Course Name: " + name);
				System.out.println("\tSection: " + section);
			}
		}
		
		
	}
}
