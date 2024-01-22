// Package
package engine.game.classes;

// Imports
import engine.classes.audio.Audio;
import engine.classes.input.Input;
import engine.classes.io.File;
import engine.classes.game.Position;
import engine.classes.game.GameObject;
import engine.classes.graphics.Graphics;
import engine.classes.graphics.Pixel;
import engine.classes.game.GameObjectType;

import java.util.Scanner;

// Docstring
/**
 * Game.java || Modified: 13/11/23
 * Index of the game
 * 
 * @author https://github.com/MaxineToTheStars
 * @category Game/Main
 * @version v1.0.0
 */

// Class
public class Game {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables
	private Input _libInput;
	private Graphics _libGraphics;

	// Constructor
	/**
	 * Instances a new {@link Game} object
	 * 
	 * @param libInput    - Reference to the {@link Input} API
	 * @param libGraphics - Reference to the {@link Graphics} API
	 * @return {@link Game}
	 */
	public Game(Input libInput, Graphics libGraphics) {
		// Set data
		this._libInput = libInput;
		this._libGraphics = libGraphics;
	}

	// Public Static Methods

	// Public Inherited Methods
	/**
	 * Initializes the game
	 * 
	 * @return void
	 */
	public void init() {
		/**
		 * A simple example game showcasing all the various API's working together
		 * 
		 * To write your own game simply delete the example code below OR
		 * export to a .jar file to test the game yourself!
		 */

		// Get the screen height and width
		int screenHeight = this._libGraphics.getScreenHeight();
		int screenWidth = this._libGraphics.getScreenWidth();

		// Load the music
		Audio introAudio = new Audio("intro_music.wav");

		// Play it
		introAudio.play();

		// Play the intro movie
		this._showIntroMovie(screenHeight, screenWidth);

		// Show tutorial sequence
		this._showTutorialSequence(screenHeight, screenWidth);

		// Stop audio
		introAudio.stop();

		this._yeah();
	}

	private void _yeah() {
		int screenHeight = this._libGraphics.getScreenHeight();
		int screenWidth = this._libGraphics.getScreenWidth();

		Audio bgAudio = new Audio("bg_music.wav");

		bgAudio.loop(-1);
		bgAudio.play();

		// Player
		GameObject player = new GameObject(GameObjectType.PLAYER, 'P', this._libGraphics);

		int x = (screenHeight - 1) / 2;
		int y = (screenWidth - 1) / 2;

		// Spawn character
		player.spawn(x, y);

		// Draw map
		this._libGraphics.drawRectangle(0, 0, screenHeight - 1, screenWidth - 1, '*', '░');
		this._libGraphics.drawRectangle(10, 20, 40, 50, ' ', '▓');

		// Game loop
		while (true) {
			// Draw the player
			player.setPosition(x, y);

			// Input handling
			if (this._libInput.isPressed('w')) {
				// Move player up 1
				x--;

				if ((Math.random() * 100) > 85) {
					bgAudio.stop();
					this._encounter(screenHeight, screenWidth, player.getPosition());
					break;
				}
			}

			if (this._libInput.isPressed('a')) {
				// Move player left 1
				y--;

				if ((Math.random() * 100) > 85) {
					bgAudio.stop();
					this._encounter(screenHeight, screenWidth, player.getPosition());
					break;
				}
			}
			if (this._libInput.isPressed('s')) {
				// Move player down 1
				x++;

				if ((Math.random() * 100) > 85) {
					bgAudio.stop();
					this._encounter(screenHeight, screenWidth, player.getPosition());
					break;
				}
			}
			if (this._libInput.isPressed('d')) {
				// Move player right 1
				y++;

				if ((Math.random() * 100) > 85) {
					bgAudio.stop();
					this._encounter(screenHeight, screenWidth, player.getPosition());
					break;
				}
			}

			if (this._libInput.isPressed('q')) {
				System.exit(0);
			}
		}
	}

	// Private Static Methods

	// Private Inherited Methods
	/**
	 * Plays the intro movie
	 * 
	 * @param screenHeight - The screen height
	 * @param screenWidth  - The screen width
	 * @return {@link void}
	 */
	private void _showIntroMovie(int screenHeight, int screenWidth) {
		// Draw the border
		this._libGraphics.drawRectangle(0, 0, screenHeight - 1, screenWidth - 1, '*');

		// Open the title text file
		File titleTextFile = new File("title.txt");

		// Create a new Scanner
		Scanner reader = new Scanner(titleTextFile.getFileStream());

		// Text offset
		int textOffset = -12;

		// Loop
		while (reader.hasNextLine()) {
			// Draw the current line
			this._libGraphics.drawText(((screenHeight - 1) / 2) + textOffset, (screenWidth - 1) / 2, reader.nextLine(),
					true);

			// Decrease the offset
			textOffset++;
		}

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(5000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// Draw the text
		this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2, "Made using Engine!", true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(5000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// Draw the text
		this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2,
				"Made by your favorite 99% :3", true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(3000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// Clear screen
		this._libGraphics.clearBuffer();
	}

	/**
	 * Plays the tutorial sequence
	 * 
	 * @param screenHeight - The screen height
	 * @param screenWidth  - The screen width
	 * @return {@link void}
	 */
	private void _showTutorialSequence(int screenHeight, int screenWidth) {
		// Draw the border
		this._libGraphics.drawRectangle(0, 0, screenHeight - 1, screenWidth - 1, '#');

		// Open the title text file
		File titleTextFile = new File("prof.txt");

		// Create a new Scanner
		Scanner reader = new Scanner(titleTextFile.getFileStream());

		// Offset
		int offset = 0;

		// Draw Prof Oak
		while (reader.hasNextLine()) {
			// Draw the current line
			this._libGraphics.drawText(10 + offset, (screenWidth - 1) / 2, reader.nextLine(), true);

			offset++;
		}

		// Tutorial time bitches
		this._libGraphics.drawText((screenHeight + 20) / 2, (screenWidth - 1) / 2, "Hello There! Glad you made it!",
				true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(3000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// More text
		this._libGraphics.drawText((screenHeight + 20) / 2, (screenWidth - 1) / 2,
				"And welcome to the world of Pokemon!", true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(3000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// More text
		this._libGraphics.drawText((screenHeight + 20) / 2, (screenWidth - 1) / 2,
				"My name if Professor Oak. I study everything Pokemon!", true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(3000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// More text
		this._libGraphics.drawText((screenHeight + 20) / 2, (screenWidth - 1) / 2,
				"Anyways WASD+Enter to move, 0-9 for other stuff, q to exit, just make sure you hit enter after everything",
				true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(3000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}

		// More text
		this._libGraphics.drawText((screenHeight + 25) / 2, (screenWidth - 1) / 2, "Toodles!", true);

		// Try to sleep
		try {
			// Sleep
			Thread.sleep(4000);
		} catch (Exception e) {
			// Unhandled exception
			return;
		}
	}

	private void _encounter(int screenHeight, int screenWidth, Position playerPosition) {
		Audio battleAudio = new Audio("battle_music.wav");

		battleAudio.loop(-1);
		battleAudio.play();

		// HP
		int enemyHP = 20;
		int playerHP = 20;

		// vgh
		int enemyOff = 0;
		int playerOff = 0;

		// Clear buffer
		this._libGraphics.clearBuffer();

		// Draw border
		this._libGraphics.drawRectangle(0, 0, screenHeight - 1, screenWidth - 1, '*');

		// Draw pokemon
		// Open the title text file
		File enemyTextFile = new File("enemy.txt");
		File playerTextFile = new File("player.txt");

		// Create a new Scanner
		Scanner reader = new Scanner(enemyTextFile.getFileStream());

		// Offset
		int offset = 0;

		// Draw Prof Oak
		while (reader.hasNextLine()) {
			// Draw the current line
			this._libGraphics.drawText(2 + offset, (screenWidth - 40), reader.nextLine(), true);
			offset++;
		}

		// Yeah
		this._libGraphics.drawText(offset + 5, screenWidth - 40, "Bulbasaur || " + enemyHP + "HP", false);
		enemyOff = offset;

		// Create a new Scanner
		Scanner playerReader = new Scanner(playerTextFile.getFileStream());

		// Offset
		offset = 0;

		// Draw Prof Oak
		while (playerReader.hasNextLine()) {
			// Draw the current line
			this._libGraphics.drawText(30 + offset, 20, playerReader.nextLine(), true);
			offset++;
		}

		playerOff = offset;

		// Draw HUD
		this._libGraphics.drawText(offset + 33, 20, "Pikachu || " + playerHP + "HP", false);

		int[] useCount = { (int) (Math.random() * 20), (int) (Math.random() * 20), (int) (Math.random() * 20),
				(int) (Math.random() * 20) };
		int[] useAmount = { useCount[0], useCount[1], useCount[2], useCount[3] };

		this._libGraphics.drawText((screenHeight + 1) / 2, (screenWidth - 1) / 2,
				"1. Quick Attack (" + useAmount[0] + "/" + useCount[0] + ")", false);
		this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2,
				"2. Thundershock (" + useAmount[1] + "/" + useCount[1] + ")", false);
		this._libGraphics.drawText((screenHeight + 6) / 2, (screenWidth - 1) / 2,
				"3. Iron Tail (" + useAmount[2] + "/" + useCount[2] + ")", false);
		this._libGraphics.drawText((screenHeight + 9) / 2, (screenWidth - 1) / 2,
				"4. Tackle (" + useAmount[3] + "/" + useCount[3] + ")", false);

		// Wait for input
		Scanner yeah = new Scanner(System.in);

		// Loop
		while (true) {
			int selection = -1;

			while (selection == -1) {
				if (this._libInput.isPressed('1')) {
					if (useAmount[0] <= 0) {
						continue;
					}

					selection = 0;
					break;
				}
				if (this._libInput.isPressed('2')) {
					if (useAmount[1] <= 0) {
						continue;
					}

					selection = 1;
					break;
				}
				if (this._libInput.isPressed('3')) {
					if (useAmount[2] <= 0) {
						continue;
					}

					selection = 2;
					break;
				}
				if (this._libInput.isPressed('4')) {
					if (useAmount[3] <= 0) {
						continue;
					}

					selection = 3;
					break;
				}
			}

			// Attack
			enemyHP = enemyHP - ((int) ((Math.random() + 1) * 4));
			playerHP = playerHP - ((int) ((Math.random() + 1) * 4));
			useAmount[selection]--;

			// Visual
			this._libGraphics.drawText(enemyOff + 5, screenWidth - 40, "Bulbasaur || " + enemyHP + "HP", false);
			this._libGraphics.drawText(playerOff + 33, 20, "Pikachu || " + playerHP + "HP", false);
			this._libGraphics.drawText((screenHeight + 1) / 2, (screenWidth - 1) / 2,
					"1. Quick Attack (" + useAmount[0] + "/" + useCount[0] + ")", false);
			this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2,
					"2. Thundershock (" + useAmount[1] + "/" + useCount[1] + ")", false);
			this._libGraphics.drawText((screenHeight + 6) / 2, (screenWidth - 1) / 2,
					"3. Iron Tail (" + useAmount[2] + "/" + useCount[2] + ")", false);
			this._libGraphics.drawText((screenHeight + 9) / 2, (screenWidth - 1) / 2,
					"4. Tackle (" + useAmount[3] + "/" + useCount[3] + ")", false);

			// Check
			if (playerHP <= 0) {
				// game loose
				// Try to sleep
				try {
					// Sleep
					Thread.sleep(2000);
				} catch (Exception e) {
					// Unhandled exception
					continue;
				}

				// ugh
				this._libGraphics.clearBuffer();

				// yeah
				this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2, "You Lost :(", true);

				// Try to sleep
				try {
					// Sleep
					Thread.sleep(2000);
				} catch (Exception e) {
					// Unhandled exception
					continue;
				}

				battleAudio.stop();

				this._yeah();
			}

			if (enemyHP <= 0) {
				// game win
				// Try to sleep
				try {
					// Sleep
					Thread.sleep(2000);
				} catch (Exception e) {
					// Unhandled exception
					continue;
				}

				// ugh
				this._libGraphics.clearBuffer();

				// yeah
				this._libGraphics.drawText((screenHeight + 3) / 2, (screenWidth - 1) / 2, "You Won!", true);

				// Try to sleep
				try {
					// Sleep
					Thread.sleep(2000);
				} catch (Exception e) {
					// Unhandled exception
					continue;
				}

				battleAudio.stop();

				this._yeah();
			}

		}
	}
}