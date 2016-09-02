import java.util.Scanner;

public class AStackDriver {
	
	static AStack<Integer> numbers = new AStack<Integer>(5);
	static boolean quit = false;

	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		printMenu();
		
		while(!quit){
			Object store = scn.nextLine();
			if(store instanceof String){
				act((String)store, scn);
			}
			else{
				throw new AStack.MyException("WOH THERE!! Input is not of type String! Please enter a string character!");
			}
		}
		
		System.out.println("Program Terminated...!");
	}
	
	private static void printMenu(){
		System.out.println("Choose one of the following operations:");
		System.out.println("   • push/add (enter the letter a)");
		System.out.println("   • pop/delete (enter the letter d)");
		System.out.println("   • peek (enter the letter p)");
		System.out.println("   • check if the stack is empty (enter the letter e)");
		System.out.println("   • quit (enter the letter q)");
	}
	
	private static void act(String s, Scanner scn){
		if(s.equals("a") || s.equals("A")){
			System.out.println("Please enter an integer to be pushed");
			actPush(scn);
		}
		else if(s.equals("d") || s.equals("D")){
			actPop(scn);
		}
		else if(s.equals("p") || s.equals("P")){
			actPeek();	
		}
		else if(s.equals("e") || s.equals("E")){
			actIsEmpty();
		}
		else if(s.equals("q") || s.equals("Q")){
			actQuit();
		}
		else{
			System.out.println("invalid choice");
		}
		
	}
	
	private static void actPush(Scanner scn){
		
		if(scn.hasNextInt()){
			int store = scn.nextInt();
			String dump = scn.nextLine();
			numbers.push(store);
			System.out.println(store + " has been pushed!");
		}
		else{
			String store2 = scn.nextLine();
			System.out.println(store2 + " is not an integer");
			//store2 = null;
		}
	}
	
	private static void actPop(Scanner scn){
		if(numbers.isEmpty()){
			System.out.println("The stack is empty, no value to pop");
		}
		else{
			System.out.println(numbers.pop() + " has been popped!");
		}
	}
	
	private static void actPeek(){
		if(numbers.isEmpty()){
			System.out.println("The stack is empty, no value to peek at");
		}
		else{
			System.out.println(numbers.peek());
		}
	}
	
	private static void actIsEmpty(){
		if(numbers.isEmpty()){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
	
	private static void actQuit(){
		quit = true;
		int size = numbers.getSize();
		for(int i = 0; i<size; i++){
			System.out.print(numbers.pop() + " ");
		}
	}
	
}


