// Package Declaration
package calculator;

// Import Statements
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

// File Docstring
/**
 * Week #2 || Calculator
 * <p>
 * Here is an over engineered multifunction calculator
 * that works in the command line
 * 
 * @author https://github.com/MaxineToTheStars
 * @implNote No safety checks are being done so theoretically speaking this has
 *           a very bad security flaw lmao
 */

// Classes
public class Calculator {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables

	// Constructor

	// Public Static Methods
	public static void main(String[] args) {
		// Run the calculator
		new Calculator().run();
	}

	// Public Inherited Methods
	public void run() {
		// Show the title
		System.out.println("An Over-Engineered Multi-Function Calculator in Java (v1.0.0)\nType \"help\" for help!");

		// Input handler
		Scanner rawInputScanner = new Scanner(System.in);

		// Create an engine manager
		ScriptEngineManager engineManager = new ScriptEngineManager();

		// Evaluation engine
		// “Any application that can be written in JavaScript, will eventually be
		// written in JavaScript.” -- Jeff Atwood
		ScriptEngine javaScriptEngine = engineManager.getEngineByName("js");

		// Custom commands that can be executed
		String customCommandsString = "function rand(x){ return Math.floor(Math.random() * x); } function sqrt(x){ return Math.sqrt(x); } function pow(x, y){ return Math.pow(x, y); } function abs(x){ return Math.abs(x); }";

		// Execution loop
		while (true) {
			// Prompt
			System.out.println("\nEnter an equation to evaluate\n----------------------------");

			// Wait for user input
			String rawUserInputString = "";
			while (rawUserInputString.equals("") == true) {
				rawUserInputString = rawInputScanner.nextLine().toLowerCase();
			}

			// Parse commands
			if (rawUserInputString.equals("help") == true) {
				// Show help text
				System.out.println("\nhelp -> Shows this message");
				System.out.println("exit -> Quits the program");
				System.out.println("+ -> Adds two numbers (x + y)");
				System.out.println("- -> Subtracts two numbers (x - y)");
				System.out.println("* -> Multiplies two numbers (x * y)");
				System.out.println("/ -> Divides two numbers (x / y)");
				System.out.println(
						"() -> Does the specified evaluations in the parenthesis first before moving to the rest outside ( (a + b) + x * y ) ");
				System.out.println("pow(x,y) -> to the Nth power ( pow(x, y) )");
				System.out.println("rand(x) -> Returns a random number from 0 to X ( ran(x) ) [*]");
				System.out.println("sqrt(x) -> Does the square root of a number ( sqrt(x) )");
				System.out.println("abs(x) -> Returns the absolute value of a number ( abs(x) )");
				System.out.println("-------------------------------------------------------");
				System.out.println("[*] Output is converted to an integer");

				// Continue the loop
				continue;
			}

			if (rawUserInputString.equals("exit") == true) {
				// Exit the calculator
				System.exit(0);
			}

			// Execute
			try {
				System.out.println(javaScriptEngine.eval(customCommandsString + rawUserInputString));
			} catch (Exception e) {
				System.err.println("Syntax Error or something");
			}
		}

	}

	// Private Static Methods

	// Private Inherited Methods
}