// Package Declaration
package app;

// Import Statements
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// File Docstring
/**
 * Week #4 || Encryption/Decryption
 * <p>
 * A very shity turing machine
 * 
 * @author https://github.com/MaxineToTheStars
 * @implNote May god save this world from me
 */

// Classes
public class App {
	// Enums

	// Interfaces

	// Constants
	final Pattern PAIR_SEARCH_PATTERN = Pattern.compile("\\([0-9]+,[0-9]+\\)", Pattern.CASE_INSENSITIVE);

	// Public Variables

	// Private Variables
	private Scanner _rawInputScanner;

	// Constructor

	// Public Static Methods
	public static void main(String[] args) {
		// Title
		System.out.println("Not A Turing Machine™");
		// Run
		new App().run();
	}

	// Public Inherited Methods
	public void run() {
		// Create Scanner
		this._rawInputScanner = new Scanner(System.in);

		// Show welcome UI
		this._uiShowHelpMessage();

		// Process loop
		while (true) {
			// Wait for input
			String rawUserPrompt = "";
			while (rawUserPrompt.equals("") == true) {
				rawUserPrompt = this._rawInputScanner.nextLine();
			}

			// Test input
			if (!this._isStringInt(rawUserPrompt)) {
				// Invalid input handling
				System.out.println("Invalid Input!");

				// Skip to next cycle
				continue;
			}

			// Convert to int and handle in separate functions
			int convertedString = Integer.parseInt(rawUserPrompt);
			switch (convertedString) {
				case 1:
					this._handleEncryption();
					break;
				case 2:
					this._handleDecryption();
					break;
				case 3:
					break;
				case 4:
					// Show help message
					this._uiShowHelpMessage();
					break;
				default:
					// Option not valid
					System.out.println("Invalid Option!");
					break;
			}

			// Show help message again
			this._uiShowHelpMessage();
		}

	}

	// Private Static Methods

	// Private Inherited Methods
	/**
	 * Handles the Encryption portion of the program
	 * 
	 * @return {@link void}
	 */
	private void _handleEncryption() {
		// Request for row/col size
		System.out.println("Enter in the size of the row and column as a pair || (2,2), (5,3), (1,1)");

		// Wait for input
		String rawUserPrompt = "";
		while (rawUserPrompt.equals("") == true) {
			rawUserPrompt = this._rawInputScanner.nextLine();
		}

		// Compare against the regex pattern
		Matcher match = this.PAIR_SEARCH_PATTERN.matcher(rawUserPrompt);

		// Check if a match is found
		if (!match.matches()) {
			// User did a whoops
			System.out.println("Invalid Input!");

			// Early return
			return;
		}

		// Split the pair
		int rowValue = Integer.parseInt(rawUserPrompt.split(",")[0].replace("(", ""));
		int colValue = Integer.parseInt(rawUserPrompt.split(",")[1].replace(")", ""));

		// Request for row/col size
		System.out.println("Enter in a message to encrypt");

		// Wait for input
		rawUserPrompt = "";
		while (rawUserPrompt.equals("") == true) {
			rawUserPrompt = this._rawInputScanner.nextLine();
		}

		// Create message block
		String[][] block = new String[rowValue][colValue];

		// Encrypt text
		for (int i = 0; i < rowValue; i++) {
			for (int j = 0; j < colValue; j++) {
				// Do some cool math
				int selection = ((i * colValue) + j);

				// Bounds check
				if (selection >= rawUserPrompt.length()) {
					// Pad with A
					block[i][j] = "A";

					// To next iteration
					continue;
				}

				// Insert character
				block[i][j] = Character.toString(rawUserPrompt.charAt(selection)).replace("A", "*");
			}
		}

		/**
		 * Encryption Method
		 * 
		 * dick and
		 * balls be
		 * 
		 * -> dbicclkl sa nbde
		 */

		// Encrypt
		String encryptedMessageString = "";

		for (int i = 0; i < colValue; i++) {
			for (int j = 0; j < rowValue; j++) {
				encryptedMessageString += block[j][i];
			}
			encryptedMessageString += "#^@!";
		}

		// Print
		System.out.println("Your encrypted message -> " + encryptedMessageString);
	}

	private void _handleDecryption() {
		// Request for row/col size
		System.out.println("Enter in the encrypted message");

		// Wait for input
		String rawUserPrompt = "";
		while (rawUserPrompt.equals("") == true) {
			rawUserPrompt = this._rawInputScanner.nextLine();
		}

		// Ready output
		String decryptedMessageString = "";

		// Split it by the delimiter
		String[] chunkedMessageStrings = rawUserPrompt.split("#\\^@!");

		// Retrieve the row and column counts
		int colCount = chunkedMessageStrings.length;
		int rowCount = chunkedMessageStrings[0].length();

		// Prepare a decryption block
		String[][] decryptionBlock = new String[rowCount][colCount];

		// Chunked message string
		String chunkedMessage = "";

		// Add to chunked message string
		for (String sChar : chunkedMessageStrings) {
			chunkedMessage += sChar;
		}

		// Add to decryption block
		for (int i = 0; i < colCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				// Do some cool math
				int selection = ((i * rowCount) + j);

				// Add to decryption block
				decryptionBlock[j][i] = Character.toString(chunkedMessage.charAt(selection));
			}
		}

		// Append to decryption message
		for (String[] col : decryptionBlock) {
			for (String sChar : col) {
				decryptedMessageString += sChar;
			}
		}

		// Print
		System.out.print("Decrypted message -> " + decryptedMessageString.replace("A", "").replace("*", "A"));
	}

	/**
	 * Shows the help message
	 * 
	 * @return {@link void}
	 */
	private void _uiShowHelpMessage() {
		System.out.println(
				"\n--------\n(1) Encrypt Message\n(2) Decrypt Message\n(3) Verbose Encryption and Decryption\n(4) Show this Help Message\n--------");
	}

	/**
	 * Checks if a {@link String} is an {@link int}
	 * 
	 * @param string - The string to test
	 * @return {@link boolean}
	 */
	private boolean _isStringInt(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}