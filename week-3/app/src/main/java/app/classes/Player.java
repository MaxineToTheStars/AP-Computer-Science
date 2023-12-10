// Package Declaration
package app.classes;

// Import Statements

// File Docstring
/**
 * MazeGamev2 || Player.java
 * <p>
 * Data representation of a {@link Player}
 * 
 * @author https://github.com/MaxineToTheStars
 */

// Class Dentation
public class Player {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables
	private String _playerNameString;
	private String _playerRaceString;
	private String _playerClassString;
	private boolean _isInvincible;

	// Constructor
	/**
	 * Instances a new {@link Player} object
	 * 
	 * @param playerName   The name of the player
	 * @param isInvincible Is the player invincible
	 * @return {@link Player}
	 */
	public Player(String playerName, boolean isInvincible) {
		// Set player name
		this._playerNameString = playerName;
		// Ser invincibility status
		this._isInvincible = isInvincible;
	}

	// Public Static Methods

	// Public Inherited Methods
	/**
	 * Returns the {@link Player}'s name
	 * 
	 * @return {@link String}
	 */
	public String getPlayerName() {
		return this._playerNameString;
	}

	/**
	 * Returns the {@link Player}'s class
	 * 
	 * @return {@link String}
	 */
	public String getPlayerClassName() {
		return this._playerClassString;
	}

	/**
	 * Returns the {@link Player}'s race
	 * 
	 * @return {@link String}
	 */
	public String getPlayerRaceName() {
		return this._playerRaceString;
	}

	/**
	 * Returns the {@link Player}'s invincibly state
	 * 
	 * @return {@link boolean}
	 */
	public boolean isInvincible() {
		return this._isInvincible;
	}

	// Private Static Methods

	// Private Inherited Methods
}
