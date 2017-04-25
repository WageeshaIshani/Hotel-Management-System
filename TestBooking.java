import java.util.Scanner;

public class TestBooking {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String continueCmd = "";
		String choice = "";
				
		Booking b = new Booking();		
		b.initialise();
		
		do{
			
			//Displaying menu and prompt for choice.
			System.out.println("---------------------Menu---------------------\n"
					+ "V: View all rooms\n"
					+ "A: Add customer to room\n"
					+ "D: Delete customer from room\n"
					+ "S: Save to a text file\n"
					+ "L: Load from text file\n"
					+ "3:Display first 3 Customers\n"
					+ "----------------------------------------------");
			choice = input.next().toUpperCase();
						
			//call methods according to the choice.
			switch(choice){
			case "V":
				b.viewAll();
				break;
			case "A":
				b.addCustomer();				
				break;
			case "D":				
				b.deleteCustomer();
				break;				
			case "S":
				b.save();				
				break;
			case "L":
				b.load();
				break;		
			case "3":
				b.dis();
				break;		
			default :
				System.out.println("Invalid input");
				break;
			}
			
			//ask user that continue or not.
			System.out.println("\nDo you want to continue?(y/n)");
			continueCmd = input.next().toLowerCase(); 
			}while(continueCmd.equals("y"));

	}

}
