// Package
package engine.game.classes;

// Imports
import engine.classes.audio.Audio;
import engine.classes.core.Core;
import engine.classes.game.Position;
import engine.classes.game.GameObject;
import engine.classes.game.GameObjectType;
import engine.classes.graphics.Graphics;
import engine.classes.input.Input;

// Docstring
/**
 * Game.java || Modified: 01/02/24
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
	private int[][] _boardPositions;
	private int _currentUserControl;

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
		// Get the screen height and width
		int screenHeight = this._libGraphics.getScreenHeight();
		int screenWidth = this._libGraphics.getScreenWidth();

		// Load up the background music
		Audio backgroundAudio = new Audio("theme.wav");
		backgroundAudio.play();
		backgroundAudio.loop(-1);

		// Load up win music
		Audio winAudio = new Audio("win.wav");

		// Create a new board array
		this._boardPositions = new int[(screenHeight - 1) / 5][(screenWidth - 1) / 5];

		// Fill the board with empty int values
		for (int i = 0; i < this._boardPositions.length; i++) {
			for (int j = 0; j < this._boardPositions[i].length; j++) {
				this._boardPositions[i][j] = -1;
			}
		}

		// Set the cursor position in the center
		int cursorPosition = 1;

		// Set the current user
		this._currentUserControl = 0;

		// Game loop
		while (true) {
			// Draw the board
			this.drawBoard(screenHeight, screenWidth);

			// Check for user input
			if (this._libInput.isPressed('a')) {
				// Move cursor left by 1
				cursorPosition = (int) this.clamp(cursorPosition - 1, 1, this._boardPositions.length - 1);
				continue;
			}

			if (this._libInput.isPressed('d')) {
				// Move cursor right by 1
				cursorPosition = (int) this.clamp(cursorPosition + 1, 1, this._boardPositions.length - 1);
				continue;
			}

			if (this._libInput.isPressed('s')) {
				// Place a play object
				for (int i = this._boardPositions[0].length - 1; i > 0; i--) {
					// Check if is an empty space
					if (this._boardPositions[i][cursorPosition] == -1) {
						// Draw the play object
						this._boardPositions[i][cursorPosition] = this._currentUserControl;
						break;
					}
				}

				// Trigger the switch
				this.switchControl();
			}

			// Draw the overlay
			this.drawOverlay(screenHeight, screenWidth, cursorPosition);

			// Check for win
			if (this.winCheck(0) == 0) {
				// Stop background music
				backgroundAudio.stop();
				
				// Play the win audio
				winAudio.play();

				// Re-draw the board
				this.drawBoard(screenHeight, screenWidth);

				// Re-draw the overlay
				this.drawOverlay(screenHeight, screenWidth, cursorPosition);

				// Show the win menu
				this._libGraphics.drawText(20, 20, "Player #1 Wins!", true);

				// Kill
				break;
			}

			if (this.winCheck(1) == 1) {
				// Stop background music
				backgroundAudio.stop();
				
				// Play the win audio
				winAudio.play();

				// Re-draw the board
				this.drawBoard(screenHeight, screenWidth);

				// Re-draw the overlay
				this.drawOverlay(screenHeight, screenWidth, cursorPosition);

				// Show the win menu
				this._libGraphics.drawText(20, 20, "Player #2 Wins!", true);

				// Kill
				break;
			}

			// Try to sleep the thread
			try {
				// Sleep the thread
				Thread.sleep(Core.updateInterval);
			} catch (Exception exception) {
				// Unhandled
				continue;
			}
		}
	}

	public void drawBoard(int screenHeight, int screenWidth) {
		// Draw the board
		this._libGraphics.drawRectangle(0, 0, screenHeight - 1, screenWidth - 1, '*', ' ');

		// Draw the play objects
		for (int i = 0; i < this._boardPositions.length; i++) {
			for (int j = 0; j < this._boardPositions[i].length; j++) {
				// Get the current value of said position
				int objectType = this._boardPositions[i][j];

				// Is Empty?
				if (objectType == -1) {
					// Continue the loop
					continue;
				}

				// Is Player?
				if (objectType == 0) {
					// Draw the player object
					this._libGraphics.drawCircle(i * 5, j * 5, 5, 5, '0', '.');

					// Continue the loop
					continue;
				}

				// Is Enemy?
				if (objectType == 1) {
					// Draw the enemy object
					this._libGraphics.drawCircle(i * 5, j * 5, 5, 5, '#', ' ');

					// Continue the loop
					continue;
				}

			}
		}
	}

	public void drawOverlay(int screenHeight, int screenWidth, int cursorPosition) {
		// Draw the play objects
		for (int i = this._boardPositions[0].length - 1; i > 0; i--) {
			// Check if is an empty space
			if (this._boardPositions[i][cursorPosition] == -1) {
				// Draw the play object
				this._libGraphics.drawCircle(i * 5, cursorPosition * 5, 5, 5, '^', ' ');
				break;
			}
		}
	}

	public int winCheck(int objectType) {
		// Horizontal win check
		for (int i = 1; i < this._boardPositions.length; i++) {
			// Horizontal counter/Reset counter
			int horizontalCount = 0;
			int neededHorizontalCount = 4;

			// Loop
			for (int j = 1; j < this._boardPositions[i].length; j++) {
				// Get the current play object
				int currentObject = this._boardPositions[i][j];

				// Win check
				if (horizontalCount == neededHorizontalCount) {
					return objectType;
				}

				// Increment count by 1
				if (currentObject == objectType) {
					horizontalCount += 1;
				} else {
					horizontalCount = 0;
				}
			}
		}

		// Vertical win check
		for (int i = 1; i < this._boardPositions.length; i++) {
			// Vertical counter/Reset counter
			int verticalCount = 0;
			int neededVerticalCount = 3;

			// Loop
			for (int j = 1; j < this._boardPositions[i].length; j++) {
				// Get the current play object
				int currentObject = this._boardPositions[j][i];

				// Win check
				if (verticalCount == neededVerticalCount) {
					return objectType;
				}

				// Increment count by 1
				if (currentObject == objectType) {
					verticalCount += 1;
				} else {
					verticalCount = 0;
				}
			}
		}

		// Diagonal win check

		return -1;
	}

	public float clamp(float val, float min, float max) {
		return Math.max(min, Math.min(max, val));
	}

	public void switchControl() {
		if (this._currentUserControl == 0) {
			this._currentUserControl = 1;
		} else {
			this._currentUserControl = 0;
		}
	}

	// Private Static Methods

	// Private Inherited Methods
}