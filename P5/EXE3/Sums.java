
import java.io.*;

public class Sums {

	public static void sum(BufferedReader in) throws IOException, NumberFormatException {
		// takes a sequence of integers as inputs, and outputs their sum

		int s, nextInt;
		s = 0;
		while(true) {
			try {
				if(s == 0) {
					System.out.println("Please input the sequence of integers to sum, terminated by a 0");
				}

				nextInt = Integer.parseInt(in.readLine());
				//Read next datum in input. An integer is expected

				while (nextInt != 0) {
					s = s + nextInt;
					nextInt = Integer.parseInt(in.readLine());
				}

				System.out.println("The sum is " + s);
				break;
			} catch (NumberFormatException e) {
				System.out.println("invalid input please re-enter");
			}

		}
	}

	public static void main(String[] arg) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//"in" will receive data from the standard input stream
		String c;

		System.out.println("Do you wish to calculate a sum? (y/n)");
		while (true) {
			try {

				c = in.readLine();
				break;

			} catch (NumberFormatException e) {

				System.out.println("The input is not an integer");

			} catch (IOException e) {

				System.out.println("An error has occured reading your input, please re-enter your input");

			}
		}
		//Read next datum in input. A string "y" or "n" is expected

		while (!c.equals("y") && !c.equals("n")) {
			System.out.println("Please answer y or n");
			//while (true) {
				try {

					c = in.readLine();
					break;

				} catch (IOException e) {

					System.out.println("An error has occured reading your input, please re-enter your input");

				}
			//}
		}

		while (c.equals("y")) {

			try {

				sum(in);
				System.out.println("Do you wish to calculate another sum? (y/n)");
				c = in.readLine();

			} catch (NumberFormatException e) {

				System.out.println("The input is not an integer please re-enter");


			} catch (IOException e) {

				System.out.println("An error has occured reading your input, please re-enter your input");

			}

			while (!c.equals("y") && !c.equals("n")) {
				System.out.println("Please answer y or n");
				while (true) {
					try {

						c = in.readLine();
						break;

					} catch (IOException e) {

						System.out.println("An error has occured reading your input, please re-enter your input");

					}
				}
			}
			if(c.equals("n"))
				System.out.print("Goodbye");

		}
	}
}
