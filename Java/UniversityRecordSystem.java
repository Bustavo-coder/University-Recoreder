import java.util.ArrayList;
import java.security.SecureRandom
public class UniversityRecordSystem{
	
	private static ArrayList<StudentsCreation> studentsDataBase= new ArrayList<StudentsCreation>();
	private static String [] courses = {"math",   "physics",   "computer science",   "biology",   "chemistry", 
					"statistics",    "english",    "economics",    "history",    "philosophy", 
					"sociology",   "political science",    "geography",   "psychology",   "art", 
					"music",   "engineering",   "law",    "medicine",    "business"};
	public static void createObjectOfStudents(){
		 ArrayList<String> course = new ArrayList<String>();
		System.out.println("Enter Your Name");
		String userName = VoteApplication.getStringInput();
		StudentsCreation userName = new StudentsCreation("Egberongbe", 25,course,"20,Ayinke", "Lagos")
			}
	
	}


/** VoteApplication.getStringInput();
		VoteApplication.getNumberInput();
			**/