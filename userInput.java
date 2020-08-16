import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class userInput {

	/*
	 * In order to customize our recommendation to each user, we need to know the
	 * area (zipcode) they are looking for and the age of their kids to begin with.
	 * And this class will process all the input we get from the user, including
	 * handling all invalid inputs
	 */

	private String zipcode;
	private int childcareTypeNum; 
	private String childcareType; 

	public String getZipcode() {
		return zipcode;
	}
	
	public int getChildcareTypeNum() {
		return childcareTypeNum; 
	}
	
	public String getChildcareType() {
		return childcareType; 
	}
	
	 String transChildcareType (int childcareTypeNum) {
		if(childcareTypeNum == 1) {
			childcareType =  "Child Care - Pre School"; 
		}if(childcareTypeNum == 2) {
			childcareType = "Child Care - Infants/Toddlers"; 
		}if(childcareTypeNum == 3) {
			childcareType = "School Based Child Care"; 
		}if(childcareTypeNum == 4) {
			childcareType = "Camp"; 
		}
		return childcareType; 
	}

	boolean isValidZipcode(String zipcode) {
		/*
		 * This function checks whether the user-inputed zipcode is a valid zipcode
		 * TODO: building the following 2 check rules 1. the string contains 5 numbers
		 * 2. this is a zipcode in NYC area (check it against a complete list of NYC
		 * zipcodes)
		 */
		File nycZipcodes = new File("nycZipcodes");
		try {
			String zip = "";
			Scanner scanner = new Scanner(nycZipcodes);
			while(scanner.hasNextLine()) {
				zip = scanner.nextLine();
				if(zipcode.equals(zip.substring(0, 5))) {
					scanner.close();
					return true; 
				}
			}
			scanner.close();
			return false; 
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file, try again.");
			return false; 
		}  
		
	}
	
	boolean isValidChildcareType (int childcareTypeNum) {
		/*
		 * This function checks whether the childcare type the user selected is valid between 1-4. 
		 */
		if(childcareTypeNum>=1 && childcareTypeNum<=4) {
			return true; 
		}else {
			return false; 
		}
	}

	void getUserInput() {
		// Asking user for the zipcode input
		Scanner scanner = new Scanner(System.in);
		System.out.println("In which area are you looking for a childcare? Please enter a valid zipcode in NYC.");

		while (true) {
			String zipcode = scanner.nextLine();
			if (isValidZipcode(zipcode)) {
				this.zipcode = zipcode;
				break;
			}
			System.out.println("This is not an valid zipcode in NYC, please enter again.");
		}
		// Ask the user for Child Care Type 
		System.out.println("Which type of child care are you interested in? Please select from below 4 types:");
		System.out.println("1. Child Care - Pre School"+"\n"+"2. Child Care - Infants/Toddlers"+"\n"
		+"3. School Based Child Care"+"\n"+"4. Camp");
		while(true) {
			try {
				String userChildcareType = scanner.nextLine();
				int userChildcareTypeNum = Integer.parseInt(userChildcareType); 
				
				if (isValidChildcareType(userChildcareTypeNum)) {
					this.childcareTypeNum = userChildcareTypeNum; 
					this.childcareType = transChildcareType(userChildcareTypeNum); 
					break; 
				}
			}catch(NumberFormatException e) {
				// Ask the user to try again using the printout line below. 				
			}
			System.out.println("This is not a valid Child Care Type number, please enter a number between 1-4.");					
		}
		scanner.close();
	}
}
