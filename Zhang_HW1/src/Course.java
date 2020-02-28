import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable, Comparable<Course>{
	
	private static final long serialVersionUID = 9831750983175L;
	private String name;
	private String courseID;
	private String maxStudents;
	private ArrayList<Student> studentsRegistered = new ArrayList<Student>();
	private int numStudentsRegistered = studentsRegistered.size();
	private String instructor;
	private String section;
	private String location;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(String maxStudents) {
		this.maxStudents = maxStudents;
	}

	public ArrayList<Student> getStudentsRegistered() {
		return studentsRegistered;
	}

	public void setStudentsRegistered(ArrayList<Student> studentsRegistered) {
		this.studentsRegistered = studentsRegistered;
	}
	
	public int getNumStudentsRegistered() {
		return studentsRegistered.size();
	}

	public void setNumStudentsRegistered(int numStudentsRegistered) {
		this.numStudentsRegistered = numStudentsRegistered;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Course(String name, String courseID, String maxStudents, String instructor, String section, String location) {
		super();
		this.name = name;
		this.courseID = courseID;
		this.maxStudents = maxStudents;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
	}


	@Override
	public int compareTo(Course c) {
			if(c.getNumStudentsRegistered() != this.getNumStudentsRegistered())
				return this.getNumStudentsRegistered() - c.getNumStudentsRegistered();
			return getName().compareTo(c.getName());
	}
}
