import java.util.ArrayList;
public class StudentsCreation{
	private String name;
	private int age;
	private ArrayList<String> courses;
	private String address;
	private String city;

	StudentsCreation(String name , int age,ArrayList<String>courses,String address ,String city){
		this.name = name;
		this.age = age;
		this.courses = courses;
		this.city = city;
		this. address =  address;
			}
	public void setName(String name){
		this.name = name;
			}
	public String getName(){
		return name;
			}
	public void setAge(int age){
		this.age = age;
			}
	public int getAge(){
		return age;
			}
	public void setCourses(ArrayList<String>courses){
		this.courses = courses;
			}
	public ArrayList getCourse(){
		return courses;
			}
	public void setAddress(String address){
		this.address = address;
			}
	public String getAddress(){
		return address;
		}
	public void setCity(String city){
		this.city = city;
			}
	public String getCity(){
		return city;
		}


	

	}