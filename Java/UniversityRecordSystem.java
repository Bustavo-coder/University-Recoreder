import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class UniversityRecordSystem {
    private static HashMap<String, StudentsCreation> studentsDataBase = new HashMap<>();

    public static final String[] courses = {"math", "physics", "computer science", "biology", "chemistry",
            "statistics", "english", "economics", "history", "philosophy",
            "sociology", "political science", "geography", "psychology", "art",
            "music", "engineering", "law", "medicine", "business"};
    public static List<String> studentcourseList = Arrays.asList(courses);

    public void addNewStudents(String username, StudentsCreation student) {
        if (!studentsDataBase.containsKey(username)) {
            studentsDataBase.put(username, student);
        } else throw new IllegalArgumentException("Username already exists");
    }

    public String displayEachStudents(String username) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation students = studentsDataBase.get(username);
            return students.toString();
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public ArrayList<String> displayCourses(String username) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation student = studentsDataBase.get(username);
            return student.getCourse();
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public String displaycity(String username) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation student = studentsDataBase.get(username);
            return student.getCity();
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public void addNewCourse(String username, String newCourse) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation student = studentsDataBase.get(username);
            if (!student.getCourse().contains(newCourse) && studentcourseList.contains(newCourse)) {
                student.getCourse().add(newCourse);
                System.out.println("Course Added Successfully");
            } else
                throw new IllegalArgumentException("Course already exists or Course Is NOT Part Of Department Course");
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public void updateCourse(String username, String course) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation student = studentsDataBase.get(username);
            if (student.getCourse().contains(course)) {
                student.getCourse().remove(course);
                System.out.println("Removed Course Successfully");
            } else throw new IllegalArgumentException("Course doesn't exist");
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public void updateStudentDataBase(String username) {
        if (studentsDataBase.containsKey(username)) {
            StudentsCreation student = studentsDataBase.get(username);
            studentsDataBase.remove(username);
        } else throw new IllegalArgumentException("Username doesn't exist");
    }

    public void displayAllStudents() {
        for (StudentsCreation student : studentsDataBase.values()) {
            System.out.println(student.toString());
        }
    }

}


/**
 * VoteApplication.getStringInput();
 * VoteApplication.getNumberInput();
 **/