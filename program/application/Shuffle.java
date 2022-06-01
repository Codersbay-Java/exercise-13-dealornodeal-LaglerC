package application;

import java.util.Random;
import java.util.Scanner;

public class Shuffle {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Methods m = new Methods();

	public static String[] scI = { " [1] ", " [2] ", " [3] ", " [4] ", " [5] ", " [6] ", " [7] ", " [8] ", " [9] ",
			" [10] ", " [11] ", " [12] ", " [13] ", " [14] ", " [15] ", " [16] ", " [17] ", " [18] ", " [19] ",
			" [20] ", " [21] ", " [22] ", " [23] ", " [24] ", " [25] ", " [26] " };

	public static int[] scVR = { 0, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000,
			75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000 };

	String pI = "";
	int pV = 0;
	int round = 1;
	boolean run = true;

	public void gameRandom() {
		for (int i = 0; i < scVR.length; i++) {
			int randomIndex = rand.nextInt(scVR.length);
			int temp = scVR[randomIndex];
			scVR[randomIndex] = scVR[i];
			scVR[i] = temp;
		}

		while (run) {
			m.draw(scI);

			System.out.println("\nPlease choose your suitcase 1-26 with your price: ");

			int nextInt = scan.nextInt();
			for (int i = 0; i < scI.length; i++) {
				if (i == (nextInt - 1)) {
					pI = scI[i];
					scI[i] = " [-] ";
					pV = scVR[i];
					scVR[i] = 0;
				}
			}

			System.out.println("\nROUND " + round);
			for (int i = 0; i < 6; i++) {
				m.eliminateSC(scI, scVR);
			}
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			for (int i = 0; i < 5; i++) {
				m.eliminateSC(scI, scVR);
			}
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			for (int i = 0; i < 4; i++) {
				m.eliminateSC(scI, scVR);
			}
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			for (int i = 0; i < 3; i++) {
				m.eliminateSC(scI, scVR);
			}
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			for (int i = 0; i < 2; i++) {
				m.eliminateSC(scI, scVR);
			}
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			m.eliminateSC(scI, scVR);
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			m.eliminateSC(scI, scVR);
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			m.eliminateSC(scI, scVR);
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}
			round++;

			System.out.println("\nROUND " + round);
			m.eliminateSC(scI, scVR);
			m.draw(scI);
			// m.drawValues(scVR);
			if (m.bankOffer(scI, scVR, pV, round) > 0) {
				break;
			}

			int lpsV = m.lastSCV(scVR);
			String lpsI = m.lastSCI(scI);

			System.out.println("\nSo now you can choose between your suitcase number" + pI
					+ "and the last suitcase number" + lpsI);
			System.out.println("Do you want to switch?, press y for yes or n for no");

			String finish = scan.next();

			if (finish.equalsIgnoreCase("n")) {
				System.out.println("Congratulations, you won " + pV + " $");
				System.out.println("GAME OVER");
				break;
			} else if (finish.equalsIgnoreCase("y")) {
				System.out.println("\nYou have switched, so you won " + lpsV + " $ -> Congratulation!");
				System.out.println("\n\nGAME OVER");
				break;
			} else if (!finish.equalsIgnoreCase("y") && !finish.equalsIgnoreCase("n")) {
				System.out.println("\nYou won 0 $, because you aren't able to type in y or n");
				System.out.println("\n\nGAME OVER");
				break;
			}

			scan.close();
			System.out.println("GAME OVER");
			break;
		}
	}
}
