import java.util.Scanner;
import java.time.LocalDate;
import java.time.DateTimeException;

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

            } else {

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

            } else {

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
                continue;
            }

            boolean isValid = true;

            // 2. Loop through each character to validate
            for (int i = 0; i < input.length(); i++) {

                char ch = input.charAt(i);

                // If the character is not a letter and not an underscore,
                // it's invalid
                if (!Character.isLetter(ch) && ch != '_') {

                    isValid = false;
                    break; // Stop checking immediately if an invalid character is found
                }
            }

            // 3. Final decision
            if (isValid) {

                return input; // Input is valid, return it

            } else {

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
                continue;
            }

            boolean isValid = true;

            // 2. validation loop
            for (int i = 0; i < input.length(); i++) {

                char ch = input.charAt(i);

                // allow letters OR digits OR underscore
                if (!Character.isLetterOrDigit(ch) && ch != '_') {

                    isValid = false;
                    break;
                }
            }

            if (isValid) {

                return input;

            } else {

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

            if (input.equals("yes")
                    || input.equals("y")
                    || input.equals("true")) {

                return true;

            } else if (input.equals("no")
                    || input.equals("n")
                    || input.equals("false")) {

                return false;

            } else {

                System.out.println("Error: Please enter (yes) or (no).");
            }
        }
    }

/*
 Reads a valid integer within a specific range.
 Re-prompts the user until a valid value is entered.
*/
public static int readIntInRange(
        String prompt,
        int min,
        int max) {

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
        System.out.println(
            "Please enter a valid year between 1900 and 2008."
        );

        int year;

        while (true) {

            year = readInt("Enter year: ");

            if (year >= 1900 && year <= 2008) {
                break;
            }

            if (year > 2008) {

                System.out.println(
                    "User must be at least 18 years old."
                );

            } else {

                System.out.println(
                    "Error: Year must be between 1900 and 2008."
                );
            }
        }

        // MONTH
        int month = readIntInRange(
            "Enter month: ",
            1,
            12
        );

        // DAY
        int day = readIntInRange(
            "Enter day: ",
            1,
            31
        );

        // Validate actual calendar date
        try {

            return LocalDate.of(year, month, day);

        } catch (DateTimeException e) {

            System.out.println(
                "Error: The entered date does not exist. Please try again."
            );
        }
    }
}