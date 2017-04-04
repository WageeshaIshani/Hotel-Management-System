import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Booking{

	Scanner input = new Scanner(System.in);	
	 String[] hotel = new String[10];
	 Room r1 = new Room();
	 Customer c1 = new Customer();
	 Q q = new Q();
			
	 
	  void initialise(){
			for(int x=0; x<10; x++){
				hotel[x] = "e";			
			}
		}	
	 
		 void addCustomer(){
			 			 	
			//prompt for room number
			System.out.println("Enter room number to add a customer(1-10): ");	
			//validating integer input.
			while(!input.hasNextInt()){
				System.out.println("Invalid input");
				input.next();
			 }
			
			r1.setRoom_no(input.nextInt());		
			int roomNo = r1.getRoom_no();
				
				//check the room number is valid or invalid
				if(roomNo<11 && roomNo>0){
					
					//check the room is empty or not
					if(hotel[roomNo-1].equals("e")){	

						//if empty, prompt the customer name and assign it into the array.
						System.out.println("Customer name: ");
						c1.setCustomer_name(input.next());
						String cName = c1.getCustomer_name();
						hotel[roomNo-1]=cName;
						System.out.println("Room "+roomNo+" occupied by "+hotel[roomNo-1]);
						
						//Inserting Customer and Rooms to the Queues.
						q.insert(cName);
						q.display();
						
					}else{
						//if not then display error message.
						System.out.println("Room has already boooked.\n");
					}					
					
				}else{
					//if the the room number is invalid then display error message.
					System.out.println("Invalid room number.\n");
				}
					
			}

		 void viewAll(){		
				
				//read the array until 9th index and display room details.
				for(int x=0; x<10; x++){
					//if the room is empty then display the relevant room is empty.
					if(hotel[x].equals("e")){
						System.out.println("room "+(x+1)+" is empty.");
					}else{
						//if not then display the relevant customer name.
						System.out.println(hotel[x]);
					}
					
				}
				
			}
		 
		 void dis(){
			 
			//Checking whether Queue is Empty or not.	
			 if(!q.isEmpty()){
				 
				 //Displaying Customers and  removing them from the Queue.
					for(int x=0;x<3;x++){
					
						//removing first item of the Queue.
						q.remove();
						//adding remaining elements to the front.
						q.moveFWd();
						
					}					
			}else{
				//displaying error message.
				System.out.println("ERROR: The Queue is Empty.");
			}
		}
		 
		 void deleteCustomer(){
			 
			 System.out.println("Enter room number to delete customer(1-10): ");	
			 
			//validating integer input.
				while(!input.hasNextInt()){
					System.out.println("Invalid input");
					input.next();
				 }
			 r1.setRoom_no(input.nextInt());
			 
			 int rNo = r1.getRoom_no();
				//checking room number is valid or not.
				if(rNo>0 && rNo<11){
					//if the room is not empty delete the customer name
					if(!hotel[rNo-1].equals("e")){
						hotel[rNo-1] = "e";
						System.out.println("Deleted");
						//Deleting customer from the queue.
												
					}
					else{
						//displaying error message.
						System.out.println("The room is already empty.");
					}
				}
				else{
					//displaying error message.
					System.out.println("Invalid room number");
				}
				
			}
		 
		 
		 void save(){
				
				File file = new File("Customer.txt");		
				FileWriter fw = null;		
				PrintWriter pw = null;		
			
			try {

				fw = new FileWriter(file);		
				pw = new PrintWriter(fw);		
			
			
				for(int x=0; x<10; x++){
				
					//write values of the array into a text file.
						pw.println(hotel[x]);
					
				}
				System.out.println("The data have been Successfully saved into a text file.");
					
			
				}
				 catch (FileNotFoundException e) {		
				System.out.println("File not found please check the file");
					e.printStackTrace();		
				} catch (IOException e) {	
				System.out.println("Something wrong with IO please check");
					e.printStackTrace();		
				}
			
				finally{		
					try {			
					fw.close();		
				} catch (IOException e) {				
					e.printStackTrace();			
				}			
					pw.close();	
			}

			}
		 
		 void load(){
				
				String line="";
				File file = new File("Customer.txt");		
					
			try {

				//Read the text file.
				FileReader fr = new FileReader(file);		
				BufferedReader br = new BufferedReader(fr);		
					
				//inside a loop read line by line and assign into the array.
				for(int y=0;y<10;y++){
					line = br.readLine();	
					hotel[y]=line;
					
				}
						
				System.out.println("The data have been Successfully loaded from the text file.");
				br.close();	
					
			
			}	
			
				 catch (FileNotFoundException e) {		
				System.out.println("File not found please check the file");
					e.printStackTrace();		
				}catch (IOException e) {	
				System.out.println("Something wrong with IO please check");
					e.printStackTrace();		
				}
			
				
			}
		 
	

}
