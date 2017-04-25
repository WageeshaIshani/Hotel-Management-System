public class Q {
	
	//Initializing array and variables	
	private String[] queueArray;
	private int remove, arrayelements, add, newElement;
	
	//Constructor
	Q(){
				
		queueArray = new String[7];
		remove = 0;
		arrayelements = 0;
		add = 0 ;
		newElement = 0;
	
		
	}
	
	//inserting values to the queue
	public void insert(String input){		
		//checking whether the no of added items are full or not
		if(arrayelements <= 7 && add<=6){
			//adding to the queue
			queueArray[add] = input;	
			//counting no of added items
			add++;
			//counting no of array elements
			arrayelements++;
			
			System.out.println(input + " Was Added to the queue\n");
		
		} else {
			//if the no of added items are full then checking queue is full or not
			if(arrayelements<7){
				//adding new items to the queue
				queueArray[newElement] = input;
				newElement++;
				arrayelements++;
				
			}else{
				//if full the display error msg and lodest customer
				System.out.println("ERROR: The Queue is Full");	
				System.out.println("The Oldest Customer is "+queueArray[0]);
				//removing oldest customer
				remove();
				///moving remaining elements to the front
				moveFWd();	
				//adding new element
				queueArray[6] = input;
				arrayelements++;
				
			}				
				
		}					
		
	}
	
	public void moveFWd(){
		//if queue is not full		
		if(arrayelements<8){
			//if first element is empty
			if(queueArray[0]==null){
				//moving forward
				for(int y=0;y<=arrayelements-1;y++){				

						queueArray[y] = queueArray[y+1];
						queueArray[y+1]=null;				
									
				}
				//getting new index if queue is not full but added items are full
				newElement=arrayelements;
				
			}
			//getting new index if added items are not full
			if(add<=6){
				add = arrayelements;
			}
		}				
		
	}	
	
	
	public void display(){
		System.out.println("QUEUE ");
		for(int y=0;y<7;y++){
			
			System.out.print(queueArray[y]+" | ");
		}
	}
	
	
	public boolean isEmpty(){
		
		int count=0;
		
		for(String val: queueArray){
			if(val==null){
				
				count++;
				
			}			
		}
		
		if(count==7){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
		
	}
	
	
	
	public void remove(){
		
		//If the array elements are existing then remove first element.
		if(arrayelements > 0){
			
			System.out.println(queueArray[0] + " Was Removed From the Queue\n");
			
			queueArray[0] = null;
					
			arrayelements--;
		
		} else {
			
			System.out.println("The Queue is Empty");			
			
		}
		
	}

}