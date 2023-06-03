package gr.upatras.junit.askisi1;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MainClass {

	public static void main(String[] args) {
		
		String ans = subtract();
		System.out.println(ans);
	}
	public static String subtract() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two integers:"); 
		int x = 0 ,y = 0;
		boolean validInputs = false; 
		
		while(!validInputs)
		{
			try { 
				x = in.nextInt();
				y = in.nextInt();
				validInputs = true;
			    }	  
			catch (NoSuchElementException e) {
				System.out.println("Invalid input! Please enter integers only.");
				in.nextLine();
			}
		} 
		in.close();  
	
		String answer = ((x - y)<0) ? "NEGATIVE" : "POSITIVE";
		return answer;		
	}
}


