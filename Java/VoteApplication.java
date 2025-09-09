import java.util.*;
import java.security.SecureRandom;
public class VoteApplication{
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<String> votersName = new ArrayList<String>();
	public static ArrayList<Integer> votersAge = new ArrayList<Integer>();
	public static ArrayList<String> nationality = new ArrayList<String>();
	public static ArrayList<Integer> voterCardNumber = new ArrayList<Integer>();
	public static ArrayList<String> partyName = new ArrayList<String>();
	public static ArrayList<String> candidatesName = new ArrayList<String>();
	public static ArrayList<Integer> candidateCardNummber = new ArrayList<Integer>();
	public static SecureRandom random = new SecureRandom();
	public static ArrayList<Integer> ballotBox = new ArrayList<Integer>();
	public static ArrayList<Integer> voted = new ArrayList<Integer>();	

	public static void main (String [] args){
		int userInput = 12;
		while(userInput != 0){
			System.out.println(display());
			System.out.println("Choose From The Above Options");
			userInput = getNumberInput();
			switch(userInput){
			case 1 : registerCandidate();
			break;
			case 2 : registerVoters();
			break;
			case 3 : 
				if(partyName.size()>= 2) displayBallotBox();
				else System.out.println("registation Still Ongoing");
			break;
			case 0 :userInput = 0;
			break;
			case 4 : System.out.println(ballotBox);
				System.out.println(candidateCardNummber);
			break;
			default : System.out.println("Invalid Input");
				}
				System.out.println("Enter 00 to go Back to main Menu");
				int input = getNumberInput();
			}

		}
	
	public static boolean isAlpha(String input){
		boolean result = false;
		for(int count = 0; count < input.length();count++){
			char value = input.charAt(count);
			if(Character.isDigit(value)){ result = true;}	
				}
			return result;
			}
	public static boolean isDigit(String input){
		boolean result = false;
		for(int count = 0; count < input.length();count++){
			char value = input.charAt(count);
			if(Character.isLetter(value)){ result = true;}	
				}
			return result;
			}

	public static String getStringInput(){
		String input = scanner.nextLine();
		 boolean checkIfAlpha = isAlpha(input);
		while(true){
			if(input.isBlank() ||checkIfAlpha){
			System.out.println("Invalid Input Must Be a a String");
			input = scanner.nextLine();
			checkIfAlpha = isAlpha(input);
				}
			else break;
			}
		return input.toLowerCase();
			}

	public static int getNumberInput(){
		String input = scanner.nextLine();
		 boolean checkIfDigit = isDigit(input);
		while(true){
			if(input.isBlank() ||checkIfDigit){
			System.out.println("Invalid Input Must Be a Positive Interger");
			input = scanner.nextLine();
			checkIfDigit = isDigit(input);
				}
			else break;
			}
		int userInput = Integer.parseInt(input);
		return userInput;
			}

	public static String addCandidatesName(ArrayList<String> list){
		System.out.println("Enter Your FullName");
		String userName = getStringInput();
		 list.add(userName);
		return "Added Succesfuly";
			}

	public static String checkage(int expected){
		System.out.println("Enter Your age");
		int age = getNumberInput();
		String result = "null";
		if(age > expected && age < 100){
			votersAge.add(age);
			result = "Your Are Elligible To Vote";
			}
		else result = "Your Are not Elligible To Vote";
		return result;
		}

	public static String validateNationality(ArrayList<String> list){
		System.out.println("Enter Your Nationality");
		String nationality = getStringInput();
		String result = "Ab";
		if(nationality.equalsIgnoreCase("nigerian")){
			list.add(nationality);
			result = "You Can Vote";
			}
		else result = "Inelligible To Vote";
		return result;
			}

	public static int generatRandomNumber(){
		int voterCardNo =  random .nextInt(9000,40000);
		return voterCardNo;
		}
	public static int validateAddVoterNo(){
		int cardNo = generatRandomNumber();
		if(voterCardNumber.contains(cardNo)){
			cardNo = generatRandomNumber();
			}
		else voterCardNumber.add(cardNo);
		return cardNo;
			}
	public static String getuserPartyCandidates(ArrayList<String> list){
		System.out.println("Enter Your Party Name");
		String partyName = getStringInput();
		String result = "null";
		if(list.contains(partyName))result = "Party Has Chosen a Candidate";
		else{
			list.add(partyName);
			result =  "Added Succesfuly";}
		return result;
			}

	public static boolean validatecandidateSvc(){
		System.out.println("Enter Your Svc Number");
		int svc = getNumberInput();
		boolean result = false;
		if(svc >= 9000 && svc <= 40000 && (!candidateCardNummber.contains(svc))){
			result = true;
			candidateCardNummber.add(svc);
				}
		return result;
		}
	public static void registerVoters(){
		String checKfeedbackAge = checkage(17);
		if(checKfeedbackAge.equalsIgnoreCase("Your Are Elligible To Vote")){
				String chekFeedbackNationality = validateNationality(nationality);
				if(chekFeedbackNationality .equalsIgnoreCase("You Can Vote")){
					addCandidatesName(votersName);
					int svc = validateAddVoterNo();
					System.out.println("Your Svc Is " +svc );
					}else System.out.println("Inelligible To Vote");
			}else System.out.println(checKfeedbackAge);

			}

	public static void registerCandidate(){
			String checKfeedbackAge =checkage(45);
			if(checKfeedbackAge.equalsIgnoreCase("Your Are Elligible To Vote")){
					String chekFeedbackNationality = validateNationality(nationality);
						if(chekFeedbackNationality .equalsIgnoreCase("You Can Vote")){
							boolean checkSvc = validatecandidateSvc();
							if(checkSvc){
							String partyNameFeedback = getuserPartyCandidates(partyName);
								if(partyNameFeedback.equals("Added Succesfuly")){
									addCandidatesName(candidatesName );
									 ballotBox.add(0);
										}
								else System.out.println(partyNameFeedback);
							}else System.out.println("Svc Has Been Allocated To Another User");
								}else System.out.println(chekFeedbackNationality);
			}else System.out.println(checKfeedbackAge);

			}


	public static String display(){
		String display = """
					Welcome To Inec Portal.
				Reform the Nation in. Truth Justice and Equity
				1.>>> To Register Candidate
				2.>>> To Get Your Pvc(Register to get Voters Card)
				3.>>> Cast Your Vote
				4.>>>> Election Result
				0.>>>> To Break 
			""";
	return display;
		}
		
	public static void displayBallotBox(){                                                                                      
		for(int count = 0; count < partyName.size();count++){
			System.out.print(candidatesName.get(count) + "\t" );
			System.out.print(partyName.get(count) + "\t");
			System.out.println(ballotBox.get(count));
			System.out.println("\n\n");
			}
			System.out.println("Enter Your Svc To Cast Your Vote");
			int userInput = getNumberInput();
			if(voterCardNumber.contains(userInput) && (!voted.contains(userInput))){
					voted.add(userInput);
			System.out.println("Enter the party You Wish To Vote For");
			String votes = getStringInput().toLowerCase();
			int candidatePosition = partyName.indexOf(votes);
			int value = ballotBox.get(candidatePosition) + 1;
			ballotBox.set(candidatePosition,value);
					}
			else System.out.println("Invalid Svc Or Svc Has been Used To Vote");

			}


	/**public static void getWinner(){
		int highest = 0;
		for(int number:ballotBox) if(number > highest)highest = number;
		 int highestPosition = ballotBox.indexOf(highest);
		System.out.printf("The Winner Is %-2s",candidatesName.get(highestPosition));
				}**/

	}