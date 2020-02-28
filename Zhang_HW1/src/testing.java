import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class testing {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File csvFile = null;
		File saveFile = new File("Courses.ser");
		
		if(saveFile.exists()) 
			oldStart();
		else
			newStart();
		
		logIn();
	}
	public static void logIn() {
		Admin a = new Admin("Admin", "Admin001", "", "");
		Scanner in = new Scanner(System.in);
		
		System.out.println("Press 0 to login as Admin");
		System.out.println("Press 1 to login as Student");
		System.out.println("Press 2 to exit the system");
		int user = in.nextInt();
		switch(user) {
			case 0:
				System.out.println("Enter username: ");
				if(in.next().equals(a.getUsername())) {
					System.out.println("Enter password: ");
					if(in.next().equals(a.getPassword())) {
						listAdminActions();
					}else {
						System.out.println("Wrong password.");
						logIn();
					}	
				}else {
					System.out.println("User does not exist.");
					logIn();
				}
				break;
				
			case 1:
				System.out.println("Enter username: ");
				String username = in.next();
				
				for(Student s: Data.totalStudents) {
					if(username.equals(s.getUsername())) {
						Student b = s;
						System.out.println("Enter password: ");
						String password = in.next();
						if(password.compareTo(b.getPassword()) == 0) {
								listStudentActions();
						}else {
							System.out.println("Wrong password.");
							logIn();
						}
					}
				}
				break;
				
			case 2:
				System.exit(0);
				break;
				
			default:
				System.out.println("Something went wrong.");
				break;
				
		}
		in.close();
	}
	
	public static void newStart() {
		System.out.println("Welcome to your first time using the Course Registration System!");
		File csvFile = new File("MyUniversityCourses.csv");
        String line = "";
        final String COMMA = ",";
        BufferedReader br = null;
        try  {
        	br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA);
                
                Data.totalCourses.add(new Course(values[0], values[1], values[2], values[5], values[6], values[7])); 
                for(Course a: Data.totalCourses) {
        			Student temp = new Student("placeholder", "also placeholder");
        			ArrayList<Student> tempAlso = new ArrayList<Student>();
        			tempAlso.add(temp);
        			a.setStudentsRegistered(tempAlso);
        			a.getStudentsRegistered().remove(0);
        		}
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        	if(br!=null){
        		try {
        			br.close();
        		}catch(IOException e){
        			throw new RuntimeException();
        		}
        	}
		}
	}
	
	public static void oldStart() throws ClassNotFoundException, IOException {
		System.out.println("Welcome back to the Course Registration System!");
		loadCourses("Courses.ser");
		loadStudents("Students.ser");
	}
	
	public static void save() {
		String courses = "Courses.ser"; 
        String students = "Students.ser";
        
        // Serialize courses
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(courses); 
            ObjectOutputStream out = new ObjectOutputStream(file); 

            // Method for serialization of object 
            out.writeObject(Data.totalCourses); 
            out.close(); 
            file.close(); 
            System.out.println("Courses have been serialized"); 
  
        }catch(IOException ex){System.out.println("IOException is caught");} 
        
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(students); 
            ObjectOutputStream out = new ObjectOutputStream(file); 

            // Method for serialization of object 
            out.writeObject(Data.totalStudents); 
            out.close(); 
            file.close(); 
            System.out.println("Students have been serialized"); 
            
        }catch(IOException ex){System.out.println("IOException is caught");} 
	}
	
	@SuppressWarnings("unchecked")
	public static void loadCourses(String file) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Data.totalCourses = (ArrayList<Course>)objectInputStream.readObject();
		objectInputStream.close();	
	}
	
	@SuppressWarnings("unchecked")
	public static void loadStudents(String file) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Data.totalStudents = (ArrayList<Student>)objectInputStream.readObject();
		objectInputStream.close();
	}
	
	
	public static void listAdminActions() {
		Admin a = new Admin("Admin", "Admin001", "spongebob", "squarepants");
		System.out.println("Choose from the following functions: ");
		System.out.println("1: Create Course");
		System.out.println("2: Delete Course");
		System.out.println("3: Edit Course");
		System.out.println("4: Display Info On Specific Course");
		System.out.println("5: View All Courses");
		System.out.println("6: View Enrolled Students in a Course");
		System.out.println("7: Create a New Student");
		System.out.println("8: View Full Courses");
		System.out.println("9: View Courses a Student has Registered For");
		System.out.println("10: Sort Courses");
		System.out.println("11: Log Out");

		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		in.nextLine();
		switch(option) {
		case 1:
			String name, courseID, maxStudents, instructor, section, location;
			System.out.println("Enter Name: ");
			name = in.nextLine();
			
			System.out.println("Enter Course ID: ");
			courseID = in.nextLine();
		
			System.out.println("Enter Maximum Students: ");
			maxStudents = in.nextLine();
			
			System.out.println("Enter Name of the Instructor: ");
			instructor = in.nextLine();
			
			System.out.println("Enter Section Number: ");
			section = in.nextLine();
			
			System.out.println("Enter Location: ");
			location = in.nextLine();
			
			a.createCourse(name, courseID, maxStudents, instructor, section, location);
			save();
			listAdminActions();
			break;
		case 2:
			System.out.println("Enter Course ID: ");
			courseID = in.next();
			a.deleteCourse(courseID);
			save();
			listAdminActions();
			break;
		case 3:
			System.out.println("Enter Course ID: ");
			courseID = in.next();
			System.out.println("Do you want to edit \n1: Maximum Number of Students\n2: Instructor \n3: Section Number \n4: Location ");
			int choice = in.nextInt();
			System.out.println("Insert new: ");
			String newVar = in.next();
			a.editCourse(courseID, choice, newVar);
			save();
			listAdminActions();
			break;
		case 4:
			String courseID2;
			System.out.println("Enter Course ID: ");
			courseID2 = in.next();
			a.displayInfo(courseID2);
			listAdminActions();
			break;
		case 5:
			a.adminViewCourses();
			listAdminActions();
			break;
		case 6:
			String courseID3;
			System.out.println("Enter Course ID: ");
			courseID3 = in.next();
			AdminActions.viewEnrolledStudents(courseID3);
			listAdminActions();
			break;
		case 7:
			String username, password, firstName, lastName;
			System.out.println("Enter Username: ");
			username = in.next();
			System.out.println("Enter Password: ");
			password = in.next();
			System.out.println("Enter First Name: ");
			firstName = in.next();
			System.out.println("Enter Last Name: ");
			lastName = in.next();
			a.createStudent(username, password, firstName, lastName);
			listAdminActions();
			break;
		case 8:
			a.viewFullCourses();
			listAdminActions();
			break;
		case 9:	
			System.out.println("Enter First Name: ");
			firstName = in.next();
			System.out.println("Enter Last Name: ");
			lastName = in.next();
			User.viewRegisteredCourses(firstName, lastName);
			listAdminActions();
			break;
		case 10:
			a.sortCourses();
			listAdminActions();
			break;
		case 11:
			save();
			logIn();
			break;
		default:
			System.out.println("This option does not exist.");
			listAdminActions();
			break;
		}
		in.close();
	}
	
	public static void listStudentActions() {
		System.out.println("Choose from the following functions: ");
		System.out.println("1: Register in a course");
		System.out.println("2: Withdraw from a course");
		System.out.println("3: View all courses");
		System.out.println("4: View all courses that are not full");
		System.out.println("5: View all courses you are registered in");
		System.out.println("6: Log Out");
		
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		in.nextLine();
		switch(option) {
			case 1:
				String name, section, firstName, lastName;
				Student theStudent = Data.totalStudents.get(0);
				System.out.println("Enter your first name: ");
				firstName = in.nextLine();
				System.out.println("Enter your last name: ");
				lastName = in.nextLine();
				for(Student t: Data.totalStudents) {
					if(t.getFirstName() == firstName && t.getLastName() == lastName) {
						theStudent = t;
					}
				}
				
				System.out.println("Enter the course name: ");
				name = in.nextLine();
				System.out.println("Enter the section number: ");
				section = in.nextLine();
				
				theStudent.register(name, section);
				listStudentActions();
				break;
			case 2:
				System.out.println("Enter the course name: ");
				name = in.nextLine();
				StudentActions.withdraw(name);
				listStudentActions();
				break;
			case 3:
				Student.studentViewCourses();
				listStudentActions();
				break;
			case 4:
				Student.viewNotFull();
				listStudentActions();
				break;
			case 5:
				System.out.println("Enter your first name:");
				firstName = in.nextLine();
				System.out.println("Enter your last name:");
				lastName = in.nextLine();
				User.viewRegisteredCourses(firstName, lastName);
				listStudentActions();
				break;
			case 6:
				save();
				logIn();
				break;
			default:
				System.out.println("This option does not exist.");
				listStudentActions();
				break;
		}
		in.close();
	}

}
