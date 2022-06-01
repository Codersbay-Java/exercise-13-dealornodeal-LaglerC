package application;

import java.util.Scanner;

public class Methods {

	public void draw(String[] scI) {
		System.out.print("\n\nSuitcases: ");
		for (int i = 0; i < scI.length; i++) {
			System.out.print(scI[i]);
		}
		System.out.println("\n");

	}

	public void drawValues(int[] scV) {
		System.out.println("\n");
		for (int i = 0; i < scV.length; i++) {
			System.out.print(" " + scV[i] + " ");
		}
		System.out.println("\n");
	}

	public void eliminateSC(String[] scI, int[] scV) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Pick a suitcase to eliminate from the game:");

		int nextInt = scan.nextInt();
		if (nextInt < 1 || nextInt > 26) {
			System.out.println("Please type in a correct number");
			eliminateSC(scI, scV);
		} else if (scI[nextInt - 1] == " [-] ") {
			System.out.println("Please choose a free Case");
			eliminateSC(scI, scV);
		}

		for (int i = 0; i < scI.length; i++) {

			if (i == (nextInt - 1)) {
				System.out.println("Case " + scI[i] + " was eliminated");
				System.out.println("It contains " + scV[i] + " $");
				scI[i] = " [-] ";
				scV[i] = 0;
			}
		}

	}

	public int bankOffer(String[] scI, int[] scV, int pV, int round) {

		Scanner scan = new Scanner(System.in);
		int counter = 0;
		int sum = 0;
		for (int i = 0; i < scV.length; i++) {
			sum = sum + scV[i];
			if (scV[i] != 0) {
				counter++;
			}
		}
		sum = sum + pV;
		sum = sum / counter;
		sum = sum * round;
		sum = sum / 10;

		System.out.println("The bank offers you: " + sum + " $");

		System.out.println("Do you accept the offer?");
		System.out.println("Please press y for yes or n for no: ");

		String answer = scan.next();
		if (answer.equalsIgnoreCase("y")) {
			System.out.println("You decided to end the game.");
			System.out.println("Congratulations, you won " + sum + " $");
			return sum;
		} else if (answer.equalsIgnoreCase("n")) {
			System.out.println("Okay, then we go on!");
		} else if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
			System.out.println("Please type in y or n!");
			bankOffer(scI, scV, pV, round);
		}

		return 0;
	}

	public String lastSCI(String[] scI) {
		for (int i = 0; i < scI.length; i++) {

			if (scI[i] != " [-] ") {
				return scI[i];
			}
		}
		return null;
	}

	public int lastSCV(int[] scV) {

		for (int i = 0; i < scV.length; i++) {

			if (scV[i] != 0) {
				return scV[i];
			}
		}
		return -1;

	}
}
