import java.util.List;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Arrays;
public class UniversityRecordSystem{
	
	private static ArrayList<StudentsCreation> studentsDataBase= new ArrayList<StudentsCreation>();
	private static String [] courses = {"math",   "physics",   "computer science",   "biology",   "chemistry", 
					"statistics",    "english",    "economics",    "history",    "philosophy", 
					"sociology",   "political science",    "geography",   "psychology",   "art", 
					"music",   "engineering",   "law",    "medicine",    "business"};
	private static List<String> courseList = Arrays.asList(courses);

	public static void createObjectOfStudents(){
		 ArrayList<String> course = new ArrayList<String>();
		System.out.println("Enter Your Name");
		String userName = VoteApplication.getStringInput();
		StudentsCreation studentsObjets = new StudentsCreation("Egberongbe", 25,course,"20,Ayinke", "Lagos");
		studentsObjets.setName(userName);	
		System.out.println("Enter Your age");
		int studentsAge = VoteApplication.getNumberInput();
		studentsObjets.setAge(studentsAge);
		studentsObjets.setCourses(addCourse(courseList));
		studentsDataBase.add(studentsObjets);
			}

	public static ArrayList<String>addCourse(List subjects){
		ArrayList<String> studentCourse = new ArrayList<String>();
			while(true)
				{
				System.out.println("Enter The Courses You Offer");
				String input =  VoteApplication.getStringInput();
				if(subjects.contains(input) && !(studentCourse.contains(input))) studentCourse.add(input);
				else System.out.println("Course May Have Been Chossed or Course Is Not Part Of The Curriculum");
				System.out.println("Do You Wish to add More Courses yes or no");
				String response =  VoteApplication.getStringInput();
				if (response.equals("no")) break;
				}
				return studentCourse;
			}
	public static String displayEachtudent(ArrayList<StudentsCreation>){
		System.out.println("Enter Your U");


	}


/** VoteApplication.getStringInput();
		VoteApplication.getNumberInput();
			**/