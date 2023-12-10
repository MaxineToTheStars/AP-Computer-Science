// Package Declaration
package app;

// Import Statements
import java.util.Scanner;
import app.classes.Story;
import app.classes.Player;

// File Docstring
/**
 * Week #3 || Maze Game v2.0
 * <p>
 * Instead of having a visual GUI based maze (yucky), we can make a
 * text based terminal maze instead (massive W)
 * 
 * Get in the mood -> https://open.spotify.com/track/6ovO3FOX127WFAd8WS78Om
 * 
 * @author https://github.com/MaxineToTheStars
 */

// Class Dentation
public class App {
	// Enums

	// Interfaces

	// Constants
	private int DICE_SIDES = 20;
	private int MAX_LUCK_PERCENTAGE = 100;
	private int MIN_LUCK_PERCENTAGE = 0;
	private int MAX_ESCAPE_PERCENTAGE = 100;
	private int MIN_ESCAPE_PERCENTAGE = 0;
	private int MAX_MONSTER_AGGRESSION = 100;
	private int MIN_MONSTER_AGGRESSION = 0;

	// Public Variables

	// Private Variables
	private boolean _skipFirstRoll = true;
	private int _luckPercentage = this.MAX_LUCK_PERCENTAGE;
	private int _escapePercentage = this.MIN_ESCAPE_PERCENTAGE;
	private int _monsterAggression = this.MIN_MONSTER_AGGRESSION;
	private Scanner _rawInputScanner;

	// Constructor

	// Public Static Methods
	public static void main(String[] args) {
		// Show welcome message
		System.out.println("Week #3 | MazeGamev2.0");
		System.out.println("Created by: Your favorite #4");
		System.out.println("----------------------------\n");

		new App().run();
	}

	// Public Inherited Methods
	public void run() {
		// Set-up input scanner
		this._rawInputScanner = new Scanner(System.in);

		// Show a small tutorial
		System.out.println("~~ [How To Play] ~~");
		System.out.println("\n[Movement]");
		System.out.println(
				"During each move chance you are given a series of options. Selecting one of said options triggers an action event.");
		System.out.println("\n[Actions]");
		System.out.println(
				"When an action event is triggered there are three possible outcomes.\n(1) Neutral Action Event: Your player moves in the cave.\n(2) Positive Action Event: Your player moves in the cave and encounters a magical wonder. Your survival chance increases.\n(3) Negative Action Event: Your player moves in the cave and gets hurt. Your survival chance decreases.");
		System.out.println("\n[Monster]");
		System.out.println(
				"When the game starts the monster has an aggression percentage of 0. Overtime as you play the game that percentage increases.\n- Negative action events will add-on to the aggression percentage by an undetermined amount\n- Positive action events will decrease the aggression by an undetermined amount.\n- Neutral action events don't add-on or subtract from the aggression percentage.");
		System.out.println(
				"You can estimate how close the monster is by the status message you get BEFORE picking an action event.");
		System.out.println("\n[Escape]");
		System.out.println(
				"When the game starts the player has an escape percentage of 0. Overtime as you play the game that percentage increases.\nAll action events increase your escape percentage with Positive Action Events increasing it more than Negative Action Events.");
		System.out.println("\n~~ Good luck and have fun! ~~\n");
		System.out.println("Type \"Play\" to continue...");

		// Wait for input
		while (!this._rawInputScanner.nextLine().toLowerCase().equals("play")) {

		}

		// Prompt for player name
		System.out.println("\nWhat is your name traveler?");

		// Wait for input
		String playerName = "";
		while (playerName.equals("") == true) {
			playerName = this._rawInputScanner.nextLine();
		}

		// Instance a new Player
		Player player = new Player(playerName, (playerName.toLowerCase().equals("rico")) ? true : false);

		// Print out the character backstory
		System.out.println("\n[My Story]\n" + Story.getRandomBackstoryString(player.getPlayerName()) + "\n");

		// Game Loop
		while (true) {
			// Roll a D20 dice
			int diceRoll = rollDice();

			// Stops the game from rolling before we even start
			if (!this._skipFirstRoll) {
				// Check the outcome
				int outcome = this.partitionDiceRoll(diceRoll);
				if (outcome == 5) {
					// Show outcome
					System.out.println(
							"[" + Story.getRandomActionTitleString() + "]\n" + Story.getRandomPositiveMovementString());

					// Show changes
					System.out.println("\n- " + Story.getRandomPositiveStatusString() + " -\n");

					// Cause changes
					this._luckPercentage += Math.floor(Math.random() * (diceRoll));
					this._escapePercentage += Math.floor(Math.random() * (diceRoll / outcome));
				}

				if (outcome == 4 || outcome == 3) {
					// Show outcome
					System.out.println("[" + Story.getRandomActionTitleString() + "]\n"
							+ ((Math.floor(Math.random() * 2) == 1) ? Story.getRandomPositiveMovementString()
									: Story.getRandomNeutralMovementString()));

					// Show changes
					System.out.println("\n- " + Story.getRandomPositiveStatusString() + " -\n");

					// Cause changes
					this._luckPercentage += Math.floor(Math.random() * (diceRoll / 10));
					this._escapePercentage += Math.floor(Math.random() * (diceRoll / 10));
				}

				if (outcome == 2 || outcome == 1) {
					// Show outcome
					System.out.println("[" + Story.getRandomActionTitleString() + "]\n"
							+ ((Math.floor(Math.random() * 2) == 1) ? Story.getRandomNegativeMovementString()
									: Story.getRandomNeutralMovementString()));

					// Show changes
					System.out.println("\n- " + Story.getRandomNegativeStatusString() + " -\n");

					// Cause changes
					this._luckPercentage += Math.floor(Math.random() * (diceRoll / 15));
					this._escapePercentage += Math.floor(Math.random() * (diceRoll / 15));
				}
			}

			// Escape/Death roll
			if (this._escapePercentage >= Math.floor(Math.random() * this.MAX_ESCAPE_PERCENTAGE)) {
				System.out.println("[Escaped]\n" + Story.getRandomEscapeString());
				break;
			}

			if (this._monsterAggression >= Math.floor(Math.random() * this.MAX_MONSTER_AGGRESSION) && player.isInvincible() == false) {
				System.out.println("[Death]\n" + Story.getRandomDeathString());
				break;
			}

			// Show neutral message
			System.out.println(
					"-- [" + Story.getRandomChoiceTitleString() + "] --\n" + Story.getRandomNeutralIdleString());

			// Show monster aggression level
			System.out.print((this._monsterAggression <= Math.floor(Math.random() * this.MAX_MONSTER_AGGRESSION))
					? "\n~~ " + Story.getRandomFarMessageString() + " ~~\n"
					: "\n~~ " + Story.getRandomCloseMessageString() + " ~~\n");

			// Get available movement options
			String[][] availableOptionStrings = Story.getRandomMovementOptionsString();

			// Show available movement options
			System.out.println("---\n");
			for (int i = 0; i < availableOptionStrings.length; i++) {
				System.out.println("(" + i + ")" + " " + availableOptionStrings[i][0]);
			}
			System.out.println("\n---");

			// Wait for input
			String movementSelection = "";
			while (movementSelection.equals("") == true) {
				// Get input
				movementSelection = this._rawInputScanner.nextLine();

				// Check if int
				if (!this._isInt(movementSelection)) {
					movementSelection = "";
				}
			}

			// Show outcome
			System.out.println(
					"\nYou " + availableOptionStrings[this._clamp(Integer.parseInt(movementSelection), 0,
							availableOptionStrings.length - 1)][0].toLowerCase() + "\n"
							+ availableOptionStrings[this._clamp(Integer.parseInt(movementSelection), 0,
									availableOptionStrings.length - 1)][1]);

			// Alter luck, escape, and aggression percentage
			this._luckPercentage = (int) Math.max((this._luckPercentage - Math.abs(Math.floor((diceRoll / 6) + 0.5))),
					this.MIN_LUCK_PERCENTAGE);
			this._escapePercentage += (int) Math.min(
					(Math.floor(this._luckPercentage / 75) + Math.abs(Math.floor((diceRoll / 12) + 0.5))),
					this.MAX_ESCAPE_PERCENTAGE);
			this._monsterAggression += (int) Math.min(
					Math.abs(Math.abs(Math.floor((diceRoll / 12) + 0.5))
							- Math.abs(Math.floor(this._luckPercentage / 45))),
					this.MAX_MONSTER_AGGRESSION);

			// Don't skip the first roll now
			this._skipFirstRoll = false;
		}

		// Show quit message
		System.out.println("\nPress \"Enter\" to quit");

		// Wait for input
		while (!this._rawInputScanner.nextLine().toLowerCase().equals("")) {

		}

	}

	// Private Static Methods

	// Private Inherited Methods
	/**
	 * Rolls a theoretical D20 die
	 * 
	 * @return {@link int}
	 */
	private int rollDice() {
		return (int) (Math.floor(Math.random() * this.DICE_SIDES));
	}

	/**
	 * Petitions a given dice roll into 5 sections
	 * 
	 * @param roll The roll of the dice
	 * @return {@link int}
	 */
	private int partitionDiceRoll(int roll) {
		if (roll == 20) {
			return 5;
		}

		if (roll >= 15 && roll <= 19) {
			return 4;
		}

		if (roll >= 10 && roll <= 14) {
			return 3;
		}

		if (roll >= 5 && roll <= 9) {
			return 2;
		}

		if (roll >= 0 && roll <= 4) {
			return 1;
		}

		return -1;
	}

	/**
	 * Checks if the given string is an int
	 * 
	 * @param testString - The string to test
	 * @return {@link boolean}
	 */
	private boolean _isInt(String testString) {
		try {
			Integer.parseInt(testString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Clamps a given number (x) between the minimum and maximum value
	 * 
	 * @param x   - The number to clamp
	 * @param min - The minimum value
	 * @param max - The maximum value
	 * @return {@link int}
	 */
	private int _clamp(int x, int min, int max) {
		return Math.max(min, Math.min(max, x));
	}

}
