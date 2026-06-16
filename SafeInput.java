package mainPackage;

/*
A brief overview of this class..
This utility class provides safe and robust user input handling by validating data types and ranges before returning values,
It completely prevents "InputMismatchException" by pre-checking each input with "hasNextInt()" and similar methods, ensuring the program never crashes due to invalid user entry.
*/ 

import java.util.Scanner;
import java.time.LocalDate;
import java.time.DateTimeException;
/* 
The package "java.lang" is automatically imported in every Java program 
without the need to write an import statement.
Its methods like "String.charAt(i)" and "Character.isLetterOrDigit(ch)" and et..
*/

public class SafeInput {

    // Global static Scanner object for the entire program
    private static final Scanner in = new Scanner(System.in);

    // Prevents instantiation of this utility class
    private SafeInput() {}

    /*
     Reads a valid integer from the user.
    */
    public static int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            if (in.hasNextInt()) {
                int value = in.nextInt();
                in.nextLine(); // Clear input buffer
                return value;
            } 
            else {
                System.out.println("Error: Please enter a valid integer number.");
                in.nextLine(); // Clear input buffer
            }
        }
    }

    /*
     Reads a valid double from the user.
    */
    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (in.hasNextDouble()) {
                double value = in.nextDouble();
                in.nextLine(); // Clear input buffer
                return value;
            } 
            else {
                System.out.println("Error: Please enter a valid decimal number.");
                in.nextLine(); // Clear input buffer
            }
        }
    }

    /*
     Reads a string input and ensures it contains ONLY letters
     (Arabic/English) and underscores (_).
     No spaces, digits, or other symbols allowed.
    */
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = in.nextLine().trim();
            // Read input and remove leading/trailing spaces

            // 1. Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
                continue; // It immediately transfers the program execution to the beginning of the `while (true)` loop.
            }

            boolean isValid = true;
            // 2. Loop through each character to validate
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                /*
                 If the character is not a letter and not an underscore,
                 it's invalid
                */
                if (!Character.isLetter(ch) && ch != '_') {
                    isValid = false;
                    break; // Stop checking immediately if an invalid character is found
                }
            }

            // 3. Final decision
            if (isValid) {
                return input; // Input is valid, return it
            } 
            else {
                System.out.println(
                    "Error: Only letters and underscores are allowed \"No spaces or numbers\""
                );
            }
        }
    }

    /*
     Reads a string that allows:
     - letters
     - numbers
     - underscore (_)

     No spaces or other symbols allowed.
    */
    public static String readNumericString(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = in.nextLine().trim();

            // 1. empty check
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
                continue; // It immediately transfers the program execution to the beginning of the `while (true)` loop.
            }

            boolean isValid = true;
            // 2. validation loop
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                // allow letters or digits or underscore
                if (!Character.isLetterOrDigit(ch) && ch != '_') {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return input;
            } 
             else {
                System.out.println(
                    "Error: Only letters, numbers, and underscore are allowed \"No spaces or symbols\""
                );
            }
        }
    }

    /*
     Reads a boolean value from the user based on yes/no confirmations.
    */
    public static boolean readBoolean(String prompt) {

        while (true) {
            System.out.print(prompt + " (yes/no): ");

            String input = in.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y") || input.equals("true")) {

                return true;

            } else if (input.equals("no") || input.equals("n") || input.equals("false")) {
                return false;
            } else {
                System.out.println("Error: Please enter (yes) or (no).");
            }
        }
    }

/*
 Reads a valid integer within a specific range
 Re-prompts the user until a valid value is entered.
*/
public static int readIntRange(String prompt, int min, int max) {

    while (true) {
        int value = readInt(prompt);
        
        if (value >= min && value <= max) {
            return value;
        }

        System.out.println(
            "Error: Enter a value between "
            + min + " and " + max + "."
        );
    }
}

/*
 Reads a valid LocalDate from the user.
 Handles invalid calendar dates and validates
 year, month, and day ranges.
*/
public static LocalDate readDate(String prompt) {
    while (true) {
        System.out.println(prompt);

        // YEAR
        int currentYear = LocalDate.now().getYear(); 
        int year;

        while (true) {
          year = readInt("Enter year:  ");

          if (year <= currentYear && year >= currentYear-100) {
            break; 
           }

      System.out.println("Error: Enter a valid date.");
   }

        // MONTH
        int month = readIntRange("Enter month: ", 1, 12);

        // DAY
        int day = readIntRange("Enter day: ", 1, 31);

        // Validate actual calendar date
        try {
            return LocalDate.of(year, month, day);
        } catch (DateTimeException e) {

            System.out.println(
                "Error: The entered date does not exist, Please try again."
            );
        }
    }
}

        /*
         Reads a valid LocalDate from the user.
         Handles invalid birth dates and validates (year ranges)
        */
        public static LocalDate readValidBirthDate(String prompt) {
        LocalDate birth;

        while (true) {
            birth = readDate(prompt);

            int currentYear = LocalDate.now().getYear();
            int age = currentYear - birth.getYear();

            if (age >= 18 && age <= 80) {
                return birth;
            }

            System.out.println(" Age must be between 18 and 80 years.");
        }
    }

    /*
     Reads a string that allow only numbers
     No strings, spaces or other symbols allowed.
    */
    public static String readStringButOnlyNumbers(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = in.nextLine().trim();

            // 1. empty check
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
                continue; // It immediately transfers the program execution to the beginning of the `while (true)` loop.
            }

            boolean isValid = true;
            // 2. validation loop
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                // allow letters OR digits OR underscore
                if (!Character.isDigit(ch)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return input;
            } 
             else {
                System.out.println("Error: Only numbers are allowed \"No spaces or symbols\"");
            }
        }
    }
}
