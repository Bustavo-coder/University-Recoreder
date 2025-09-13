import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
      UniversityRecordSystem recordSystem = new UniversityRecordSystem();
        String welcome = """
                    Bright University Where The Future Is\s
                    Block 19,100 Carrington Manchester United Kingdom
                    +124-912_112_1222
                    1.>>>>>>> To Display Sub-Menu""";
        System.out.println(welcome);
      VoteApplication.getNumberInput();
    String menu = """
        1.>>>>>>> Register New Students
        2.>>>>>> Display Student Portfolio
        3.>>>>>> Display Student Address
        4.>>>>>> Add New Course
        5.>>>>> Update Student Fields
        6.>>>>>	Remove Courses
        7.>>>> Display All Students PortFolio
        8.>>>>> Display Courses
        0.>>>>> To Exit""";
    System.out.println(menu);
    System.out.println("Choose From the above Menu");
    int userInput = VoteApplication.getNumberInput();
    switch (userInput) {
        case 1 -> {
            StudentsCreation students = createStudents();
            recordSystem.addNewStudents(students.getName(),students);
            main(use);
        }
        case 2 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            System.out.println(recordSystem.displayEachStudents(userName));
            main(use);
        }
        case 3 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            System.out.println(recordSystem.displaycity(userName));
            main(use);
        }
        case 4 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            print("course You Wish To add ");
            String course = VoteApplication.getStringInput();
            recordSystem.addNewCourse(userName,course);
            main(use);
        }
        case 5 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            recordSystem.updateStudentDataBase(userName);
            StudentsCreation students = createStudents();
            recordSystem.addNewStudents(students.getName(),students);
            main(use);
        }
        case 6 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            print("course You Wish To Remove");
            String course = VoteApplication.getStringInput();
            recordSystem.updateCourse(userName,course);
            main(use);
        }
        case 7 ->{
                recordSystem.displayAllStudents();
            main(use);
        }
        case 8 ->{
            print("Username");
            String userName = VoteApplication.getStringInput();
            System.out.println(recordSystem.displayCourses(userName));
            main(use);
        }
        case 0 -> System.out.println("Exit........Log Out Successful");

    }
    }
    public static StudentsCreation createStudents(){
        ArrayList<String> Course = new ArrayList<String>();
        StudentsCreation students = new StudentsCreation("Adeyemi",25,Course,"20,Oshodi Street","lagos");
        print("Name");
        String userName = VoteApplication.getStringInput();
        students.setName(userName);
       print("age");
        int age = VoteApplication.getNumberInput();
        students.setAge(age);
        print("Address");
        String address = VoteApplication.scanner.nextLine();
        students.setAddress(address);
        print("City");
        String city = VoteApplication.getStringInput();
        students.setCity(city);
        while(true){
            System.out.println("Enter the Course You Wish To Offer:");
            String course = VoteApplication.getStringInput();
            if(UniversityRecordSystem.studentcourseList.contains(course)) {
                Course.add(course);
            }else System.out.println("Course Not Found");
            System.out.println("Enter No to Stop Adding course yes to continue");
            String cont = VoteApplication.getStringInput();
            if(cont.equalsIgnoreCase("no")) break;
        }
        return students;
    }
    public static void print(String input) {
        System.out.println("Enter Your " + input + ":");
    }
    private static String [] use = {"yam"};
}
