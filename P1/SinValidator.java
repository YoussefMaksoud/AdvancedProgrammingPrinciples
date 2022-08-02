import java.util.Scanner;


public class SinValidator {

private int[] SIN;

private int sumDigit(int x)
{
	int result =0;
	
	while(x > 0){
		result += x % 10;
		x = x /10;
	}
	
	return result;
}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		int step1 = 0;
		int step23 = 0;
		int step4 = 0;
		int step5 = 0;
		int step6 = 0;
		
		for(int i = 0; i < (this.SIN.length - 1); i += 2 ){
			step1 += this.SIN[i];
		}
		//the above is step 1 sum of terms 1,3,5,7,9

		for(int i = 1; i < (this.SIN.length); i += 2){
			step23 = 2 * (this.SIN[i]);
			int temp = step23/10;
			step4 = step4 + (step23%10) + temp;
		}
		//the above is step 2, 3, 4

		step5 = step1 + step4;
		step6 = 10 - (step5%10);

		if(step6 == this.SIN[8]){
			return true;
		} 

		
		//the above is step 4
		return false;
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 9 digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}
