package app;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private ArrayList<User> _registeredUsers;

    public void start() throws Exception {
        this._registeredUsers = new ArrayList<User>();

        // Create 10 users
        for (int i = 0; i < 10; i++) {
            this._registeredUsers.add(new User(String.format("user%d", i), String.format("password%d", i)));
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            // Print user info
            System.out.println("---");
            for (int i = 0; i < this._registeredUsers.size(); i++) {
                System.out.println(String.format("(%d)> %s", i, this._registeredUsers.get(i).getUsername()));
            }
            System.out.println("---");
            System.out.println(
                    "|| (L)ogin {id} - Login to selected account\n|| New {username} {password} - Create new account\n|| (I)mport - Load data from file\n|| (S)ave - Save to file\n|| (D)elete {id} - Delete an account\n|| (E)xit - Terminate the program");
            System.out.print("> ");

            // Wait for input
            String selection = "";
            while (selection.isBlank()) {
                selection = input.nextLine();

                if (selection.isBlank()) {
                    System.out.print("> ");
                }
            }

            // Parse input
            if (selection.toLowerCase().contains("l") || selection.toLowerCase().contains("login")) {
                int index;
                Scanner parser = new Scanner(selection.replaceAll("l", "").replace("ogin", ""));

                try {
                    index = this.clamp(parser.nextInt(), 0, this._registeredUsers.size());
                } catch (Exception e) {
                    System.out.println("Invalid!\n");
                    continue;
                }

                // Login screen
                System.out.println("---");
                System.out.println(
                        String.format("Enter the login for \"%s\"", this._registeredUsers.get(index).getUsername()));
                System.out.print("> ");

                // Wait for input
                String yep = "";
                while (true) {
                    yep = input.nextLine();

                    if (yep.isBlank()) {
                        System.out.print("> ");
                    }

                    if (yep.equals(this._registeredUsers.get(index).getPassword())) {
                        break;
                    } else {
                        System.out.print("> ");
                    }
                }

                // Show data
                System.out.println("---");
                System.out.println(String.format("User Information for \"%s\" (@%s)",
                        this._registeredUsers.get(index).personalName, this._registeredUsers.get(index).getUsername()));
                System.out.println(String.format("(0) Weight: %s\n(1) Age: %s\n(2) Height: (%s'%s)",
                        this._registeredUsers.get(index).personalWeight, this._registeredUsers.get(index).personalAge,
                        this._registeredUsers.get(index).personalHeight.getFeet(),
                        this._registeredUsers.get(index).personalHeight.getInches()));
                System.out.println("---");

                // Allow editing
                System.out.println(
                        "|| (E)dit {propertyIndex} {value, value} - Allows editing for the user\n|| (Si)gn-out");
                System.out.print("> ");

                // Wait for input
                while (true) {
                    String ugh = "";
                    while (ugh.isBlank()) {
                        ugh = input.nextLine();

                        if (ugh.isBlank()) {
                            System.out.print("> ");
                        }
                    }
                    if (ugh.toLowerCase().contains("e") || ugh.toLowerCase().contains("edit")) {
                        int prop = 0;
                        double val = 0;

                        Scanner pain = new Scanner(ugh.toLowerCase().replaceAll("e", "").replaceAll("dit", ""));
                        try {
                            prop = pain.nextInt();
                            val = pain.nextDouble();
                            // val = Double.parseDouble(ugh.toLowerCase().replaceAll("e", "").replace("dit",
                            // "").replace(""+prop, "").replace(" ", ""));
                        } catch (Exception e) {
                            System.out.println("Invalid!\n");
                            continue;
                        }

                        switch (prop) {
                            case 0:
                                this._registeredUsers.get(index).personalWeight = val;
                                System.out.println("---");
                                System.out.println(String.format("User Information for \"%s\" (@%s)",
                                        this._registeredUsers.get(index).personalName,
                                        this._registeredUsers.get(index).getUsername()));
                                System.out.println(String.format("(0) Weight: %s\n(1) Age: %s\n(2) Height: (%s'%s)",
                                        this._registeredUsers.get(index).personalWeight,
                                        this._registeredUsers.get(index).personalAge,
                                        this._registeredUsers.get(index).personalHeight.getFeet(),
                                        this._registeredUsers.get(index).personalHeight.getInches()));
                                System.out.println("---");
                                System.out.print("> ");
                                break;
                            case 1:
                                this._registeredUsers.get(index).personalAge = (int) val;
                                System.out.println("---");
                                System.out.println(String.format("User Information for \"%s\" (@%s)",
                                        this._registeredUsers.get(index).personalName,
                                        this._registeredUsers.get(index).getUsername()));
                                System.out.println(String.format("(0) Weight: %s\n(1) Age: %s\n(2) Height: (%s'%s)",
                                        this._registeredUsers.get(index).personalWeight,
                                        this._registeredUsers.get(index).personalAge,
                                        this._registeredUsers.get(index).personalHeight.getFeet(),
                                        this._registeredUsers.get(index).personalHeight.getInches()));
                                System.out.println("---");
                                System.out.print("> ");
                                break;

                            case 2:
                                int inch = 0;
                                try {
                                    inch = pain.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Invalid!\n");
                                    break;
                                }
                                this._registeredUsers.get(index).personalHeight = new Height(
                                        (int) clamp((int) val, 1, 7), (int) clamp(inch, 0, 11));
                                System.out.println("---");
                                System.out.println(String.format("User Information for \"%s\" (@%s)",
                                        this._registeredUsers.get(index).personalName,
                                        this._registeredUsers.get(index).getUsername()));
                                System.out.println(String.format("(0) Weight: %s\n(1) Age: %s\n(2) Height: (%s'%s)",
                                        this._registeredUsers.get(index).personalWeight,
                                        this._registeredUsers.get(index).personalAge,
                                        this._registeredUsers.get(index).personalHeight.getFeet(),
                                        this._registeredUsers.get(index).personalHeight.getInches()));
                                System.out.println("---");
                                System.out.print("> ");
                                break;
                        }
                    }

                    if (ugh.toLowerCase().contains("si") || ugh.toLowerCase().contains("sign-out")) {
                        break;
                    }
                }
            }
            if (selection.toLowerCase().contains("n") || selection.toLowerCase().contains("new")) {
                String[] yeah = selection.replace("n", "").replaceAll("ew ", "").split(" ");

                if (yeah.length != 2) {
                    System.out.println("Invalid!\n");
                    continue;
                }
                String user = yeah[0];
                String password = yeah[1];

                this._registeredUsers.add(new User(user, password));
                continue;
            }
            if (selection.toLowerCase().contains("i") || selection.toLowerCase().contains("import")) {
                Scanner asd;
                try {
                    asd = new Scanner(new File("data.txt"));
                } catch (Exception e) {
                    System.out.println("data.txt not found!");
                    continue;
                }

                this._registeredUsers.clear();

                while (asd.hasNext()) {
                    String[] yeps = asd.nextLine().split(",");
                    User mhm = new User(yeps[0], yeps[1]);
                    mhm.personalWeight = Double.parseDouble(yeps[2]);
                    mhm.personalAge = Integer.parseInt(yeps[3]);
                    mhm.personalHeight = new Height(Integer.parseInt(yeps[4]), Integer.parseInt(yeps[5]));
                    this._registeredUsers.add(mhm);
                }

                asd.close();
            }
            if (selection.toLowerCase().contains("s") || selection.toLowerCase().contains("save")) {
                FileWriter file = new FileWriter("data.txt");
                for (User user : this._registeredUsers) {
                    file.append(String.format("%s,%s,%s,%s,%s,%s\n", user.getUsername(), user.getPassword(),
                            user.personalWeight, user.personalAge, user.personalHeight.getFeet(),
                            user.personalHeight.getInches()));
                }
                file.close();
            }
            if (selection.toLowerCase().contains("d") || selection.toLowerCase().contains("delete")) {
                int index;
                Scanner parser = new Scanner(selection.replaceAll("d", "").replace("elete", ""));

                try {
                    index = this.clamp(parser.nextInt(), 0, this._registeredUsers.size());
                } catch (Exception e) {
                    System.out.println("Invalid!\n");
                    continue;
                }

                this._registeredUsers.remove(index);
            }
            if (selection.toLowerCase().equals("e") || selection.toLowerCase().equals("exit")) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App().start();
    }

    public int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

}