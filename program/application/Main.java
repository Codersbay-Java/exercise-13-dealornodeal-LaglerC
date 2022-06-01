package application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Default d = new Default();
		Shuffle s = new Shuffle();

		System.out.println("        ------------------------------");
		System.out.println("        | Welcome to Deal or no Deal |");
		System.out.println("        ------------------------------\n\n");

		System.out.println("Do you want to play with default or shuffled suitcases?");
		System.out.print("\nPlease type in d for default or s for shuffled: ");
		String chooseGame = scan.next();

		if (chooseGame.equalsIgnoreCase("d")) {
			System.out.println("You have choosen default suitcases");
			d.gameDefault();
		} else if (chooseGame.equalsIgnoreCase("s")) {
			System.out.println("You have choosen shuffled suitcases");
			s.gameRandom();
		} else if (!chooseGame.equalsIgnoreCase("d") && !chooseGame.equalsIgnoreCase("s")) {
			System.out.println("Please restart the game and type in d or s next time!");
			System.out.println("Game over!");
		}

		scan.close();
	}
}
