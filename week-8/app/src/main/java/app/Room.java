// Package Declaration
package app;

// Import Statements
import app.Date;

// File Docstring
/**
 * @author @MaxineToTheStar <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class Room {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private Date _endingDate;
    private Date _startingDate;
    private String _personName;
    private Date _finalStartDate;
    private boolean _isBooked = false;

    // Constructor

    // Public Static Methods

    // Public Inherited Methods
    public boolean isBooked() {
        return this._isBooked;
    }

    public String getStatus() {
        if (this.isBooked() == true) {
            // final Date testingDate = this._startingDate;
            // testingDate.nextDay();
            // final boolean isCleaningDay = testingDate.equals(this._endingDate);

            // if (isCleaningDay == true) {
            // return "Cleaning Room";
            // }

            return String.format("Booked by \"%s\" [%s - %s]", this._personName, this._finalStartDate.toString(),
                    this._endingDate.toString());
        }

        if (this._isBooked == false) {
            return "Available";
        }

        return "";
    }

    public boolean bookRoom(final int stayAmount, final Date startDate, final String person) {
        if (this.isBooked()) {
            return false;
        }

        // Set the starting date
        this._startingDate = startDate;

        // Set the ending date + cleaning date
        this._endingDate = startDate.addDays(stayAmount + 1);

        // Set the booker's name
        this._personName = person;

        this._finalStartDate = startDate;

        // Set booked
        this._isBooked = true;

        // Return
        return true;
    }

    public void nextDay() {
        // Null check
        if (this._startingDate == null || this._endingDate == null) {
            return;
        }

        if ((this._startingDate.getDay() == this._endingDate.getDay())
                && (this._startingDate.getMonth() == this._endingDate.getMonth())) {
            // Set to nll
            this._startingDate = null;
            this._endingDate = null;

            // Set booked to false
            this._isBooked = false;

            // Early return
            return;
        }

        // Increment by 1
        this._startingDate = this._startingDate.addDays(1);
    }

    public boolean yeah(final Date yeah) {
        int offset = 0;
        // int apart = 0;
        if (this._endingDate == null) {
            return false;
        }

        final Date yeahDate = new Date(this._finalStartDate.getDay(), this._finalStartDate.getMonth());

        while (true) {
            if (yeahDate.equals(this._endingDate)) {
                break;
            }
            yeahDate.nextDay();
            offset++;
        }

        // System.out.println(offset);

        boolean yes = false;
        for (int i = 0; i <= offset; i++) {
            if (yeah.equals(yeahDate)) {
                yes = true;
            }
            yeah.nextDay();
        }

        return yes;
    }

    public boolean yeah(final String name) {
        if (name == null) {
            return false;
        }
        return name.equals(this._personName);
    }

    // Private Static Methods

    // Private Inherited Methods
}