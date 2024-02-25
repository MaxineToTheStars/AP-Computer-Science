// Package Declaration
package app;

import org.checkerframework.checker.units.qual.radians;

// Import Statements

// File Docstring
/**
 * @author @MaxineToTheStar <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class Date {
	// Enums

	// Interfaces

	// Constants

	// Public Variables

	// Private Variables
	private int _day;
	private int _month;

	// Constructor
	public Date(final int day, final int month) {
		this._day = day;
		this._month = month;
	}

	// Public Static Methods

	// Public Inherited Methods
	public void setDate(final int day, final int month) {
		this._day = day;
		this._month = month;
	}

	public void nextDay() {
		// April, June, September, or November are 0 <= x <= 30
		if (this._isAJSNMonth() && this._day == 30) {
			// Increment the month
			this._incrementMonth();

			// Early return
			return;
		}

		// February exception
		if (this._isFebruary() && this._day == 28) {
			// Increment the month
			this._incrementMonth();

			// Early return
			return;
		}

		// The normal months
		if (this._day == 31) {
			// Increment the month
			this._incrementMonth();

			// Early return
			return;
		}

		// Increment by 1
		this._day++;

	}

	public int getDay() {
		// Return day
		return this._day;
	}

	public int getMonth() {
		// Return month
		return this._month;
	}

	public Date addDays(final int days) {
		// New date
		final Date newDate = new Date(this.getDay(), this.getMonth());

		// Increment
		for (int i = 0; i < days; i++) {
			newDate.nextDay();
		}

		// Return date
		return newDate;
	}

	@Override
	public String toString() {
		return String.format("%s/%s/2024", this.getDay(), this.getMonth());
	}

	public boolean equals(final Date test) {
		return (test.getMonth() == this.getMonth()) && (this.getDay() == test.getDay());
	}

	// Private Static Methods

	// Private Inherited Methods
	private void _incrementMonth() {
		// Check if at the end of the year
		if (this._month == 12) {
			// Set month back to 1
			this._month = 1;

			// Reset the day
			this._day = 1;

			// Early return
			return;
		}
		// Increment month by 1
		this._month++;

		// Reset the day
		this._day = 1;
	}

	private boolean _isAJSNMonth() {
		// April, June, September, or November
		return ((this._month == 4) || (this._month == 6) || (this._month == 9) || (this._month == 11));
	}

	private boolean _isFebruary() {
		// Is February
		return (this._month == 2);
	}

}