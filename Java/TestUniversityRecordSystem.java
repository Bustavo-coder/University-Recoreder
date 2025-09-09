import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestUniversityRecordSystem{
	@Test
	public void testFunctionAddCourse(){
	ArrayList<String> studentCourse = new ArrayList<String>();
	studentCourse.add("maths");studentCourse.add("english");
	 UniversityRecordSystem student = new UniversityRecordSystem();
	ArrayList<String> result = student.addCourse(studentCourse);
	assertEquals(result ,studentCourse);

			}

	}









//java -jar junit-platform-console-standalone-1.9.2.jar -cp . --select-class CalculatorTest
//javac -cp "junit-platform-console-standalone-1.9.2.jar" Calculator.java CalculatorTest.java
