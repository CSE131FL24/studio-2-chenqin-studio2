package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Starting amount: ");
		double startAmount = in.nextDouble();

		System.out.print("Win probability: ");
		double winChance = in.nextDouble();

		System.out.print("Win limit: ");
		double winLimit = in.nextDouble();

		System.out.print("Number of days played: ");
		
		int totalSimulations = in.nextInt();
		
		System.out.println();
		
		//Counts # of plays
		int count = 0;
		

		for (int i = 1; i <= totalSimulations; i++) {
			//Temp is the temporary varialbe used for startAmount
			double temp = startAmount;
			while (temp > 0 && temp < winLimit) {
				double outcome = Math.random();
				if (outcome < winChance) {
					temp++;
				} else {	
					temp--;
				}
				count++;
			}

			System.out.println("Day " + i + ":");
			System.out.println("Number of plays: " + count);
			if (temp == 0) {
				System.out.println("Ruin");
			} else {
				System.out.println("Success");
			}
			System.out.println();
			count = 0;
		}
		
		double ruinRate;
		double equation = ((1.0 - winChance) / winChance);
		
		if (winChance == 0.5) {
			ruinRate = (1 - (startAmount / winLimit));
		}else {
			ruinRate = ((Math.pow(equation, startAmount)) - (Math.pow(equation, winLimit)) / (1.0 - (Math.pow(equation, winLimit))));
		}
		System.out.println();
		System.out.println("Expected Ruin Rate: " + ruinRate);

	}

}
