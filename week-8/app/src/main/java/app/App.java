// Package Declaration\
package app;

// Import Statements
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.lang.Exception;
import java.util.ArrayList;

// File Docstring
/**
 * @author @MaxineToTheStars <https://github.com/MaxineToTheStars>
 */

// Class Definition
public class App {
    // Enums

    // Interfaces

    // Constants

    // Public Variables

    // Private Variables
    private final Date _currentDate = new Date(1, 1);
    private final Scanner _inputScanner = new Scanner(System.in);
    private final ArrayList<Room> _roomList = new ArrayList<Room>();
    private final ArrayList<String> _profitMargin = new ArrayList<String>();

    // Constructor

    // Public Static Methods
    public static void main(String[] args) {
        new App().start();
    }

    // Public Inherited Methods
    public int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public void start() {
        // Create new room
        for (int i = 0; i < 3; i++) {
            this._roomList.add(new Room());
        }

        // Loop
        while (true) {
            // Title
            final String title = String.format("Available Rooms (%s/%s/2024)\n", this._currentDate.getDay(),
                    this._currentDate.getMonth());

            // Print title
            System.out.println(title);

            // Print room info
            System.out.println("---");
            for (int i = 0; i < this._roomList.size(); i++) {
                // Print room
                final String roomString = String.format("(%s) Room #%s || %s", i, (i + 1),
                        this._roomList.get(i).getStatus());

                // Print room
                System.out.println(roomString);
            }
            System.out.println("---\nType \"(h)elp\" for help!");

            // Wait for input
            while (true) {
                // Print
                System.out.print(":");

                // Get the current line
                final String currentInput = this._inputScanner.nextLine().toLowerCase();

                // Help
                if (currentInput.startsWith("h") == true) {
                    // Print help menu
                    this._printHelp();

                    // Next loop
                    continue;
                }

                // Get
                if (currentInput.startsWith("g") == true) {
                    // Print
                    System.out.println(this._getMethod(currentInput.replaceAll("g", "").replace("et", "")) == -1
                            ? "Invalid Input(s)"
                            : "");

                    // Next loop
                    continue;
                }

                // Reserve
                if (currentInput.startsWith("r") == true) {
                    // Print
                    System.out.println(this._reserveMethod(
                            currentInput.replaceAll("r", "").replace("eseve", "").replace(",", " ")) == -1
                                    ? "Invalid Input(s)"
                                    : "");

                    // Next loop
                    continue;
                }

                if (currentInput.startsWith("f") == true) {
                    // Print
                    System.out.println(this
                            ._findMethod(currentInput.replaceAll("f", "").replace("ind", "").replace(",", " ")) == -1
                                    ? "Invalid Input(s)"
                                    : "");

                    // Next loop
                    continue;
                }

                // export
                if (currentInput.startsWith("e") == true) {
                    // Loop
                    this._exportToFile();

                    System.out.println("Data exported!");

                    // Next loop
                    continue;
                }

                // Next day
                if (currentInput.startsWith("n") == true) {
                    // Loop
                    for (Room room : this._roomList) {
                        room.nextDay();
                    }

                    // Break
                    break;
                }

            }

            // Next day
            this._currentDate.nextDay();
        }

    }

    // Private Static Methods

    // Private Inherited Methods

    private void _printHelp() {
        // Print
        System.out.println("\n---");
        System.out.println(
                "(G)et <ID> - Returns the day(s) a room is booked for(including the cleaning time) and the booker's name.");
        System.out.println("(F)ind <Name> - Finds the given room(s) reserved by the specific name.");
        System.out.println("(F)ind <Day,Month> - Finds the given room(s) reserved at the specified day and month.");
        System.out.println(
                "(R)eserve <ID> <Nights> <Day,Month> <Name> - Reserves a Room with the given ID for X amount of the nights starting at the specified date. Will return \"Room Unavailable\" if conflicting.");
        System.out.println("(N)ext - Move on to the next simulated day");
        System.out.println("(E)xport - Export your earnings into a nice text file");
        System.out.println("---\n");
    }

    private int _reserveMethod(final String input) {
        // Create a parser
        final Scanner inputParser = new Scanner(input);

        // Create temporary variables
        int roomID;
        int stayAmount;
        int startingDay;
        int startingMonth;
        String reservingName;

        // Try retrieving data
        try {
            roomID = this.clamp(inputParser.nextInt(), 0, (this._roomList.size() - 1));
            stayAmount = inputParser.nextInt();
            startingDay = inputParser.nextInt();
            startingMonth = inputParser.nextInt();
            reservingName = input.replaceAll(" ", "").replace(String.valueOf(roomID), "")
                    .replace(String.valueOf(stayAmount), "").replace(String.valueOf(startingDay), "")
                    .replace(String.valueOf(startingMonth), "");
        } catch (Exception ex) {
            // Error occurred
            return -1;
        }

        // Yeah
        final int yeah = (int) (((Math.random() * 100) + (Math.random() * 50) + (Math.random() * 25)));

        this._profitMargin.add(Yeah.out(new Date(startingDay, startingMonth),
                new Date(startingDay, startingMonth).addDays(stayAmount), roomID, yeah, reservingName));

        // Book a room
        System.out.println(this._roomList.get(roomID).bookRoom(stayAmount, new Date(startingDay, startingMonth),
                reservingName) == true ? String.format("Total Cost = %s$", yeah) : "Room Unavailable");

        // Success
        return 0;
    }

    private int _getMethod(final String input) {
        // Create a parser
        final Scanner inputParser = new Scanner(input);

        // Create temporary variables
        int roomID;

        // Try retrieving data
        try {
            roomID = this.clamp(inputParser.nextInt(), 0, (this._roomList.size() - 1));
        } catch (Exception ex) {
            // Error occurred
            return -1;
        }

        System.out.println(this._roomList.get(roomID).getStatus());

        return 0;
    }

    private int _findMethod(final String input) {
        // Create a parser
        final Scanner inputParser = new Scanner(input);

        // Create temporary variables
        int day = -1;
        int month = -1;
        String name = "";

        // Try retrieving data
        try {
            day = inputParser.nextInt();
            month = inputParser.nextInt();
        } catch (Exception ex) {
            // Error occurred
            try {
                if (input.isBlank()) {
                    throw new Exception("yeah");
                }
                name = input;
            } catch (Exception exx) {
                return -1;
            }
        }

        if (name.isBlank()) {
            for (Room room : this._roomList) {
                if (room.yeah(new Date(day, month))) {
                    System.out.println(room.getStatus());
                }
            }
            return 0;
        }

        int counter = 1;
        for (Room room : this._roomList) {
            if (room.yeah(name.replace(" ", ""))) {
                System.out.println(String.format("Room #%s ", counter) + room.getStatus());
            }
            counter++;
        }
        return 0;
    }

    private int _exportToFile() {
        try {
            FileWriter file = new FileWriter("data.txt");
            for (String yeah : this._profitMargin) {
                file.append(yeah);
            }
            file.close();
        } catch (Exception ex) {
            return -1;
        }

        return 0;
    }

}