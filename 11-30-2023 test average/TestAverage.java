import java.io.*;

public class TestAverage {
    /**
     * A program that reads the name of a student and their actual mark and total
     * mark for a test, and prints out
     * whether they passed or failed the test.
     * 
     * @param args is unused
     */
    public static void main(String[] args) {
        final String name = readInput("Enter your name: ");
        final double actualMark = readDoubleInput("Enter your actual mark: ");
        final double totalMark = readDoubleInput("Enter the total mark: ");

        final double average = actualMark / totalMark;

        if (average >= 0.5) {
            System.out.println("Congratulations " + name + "! You passed the test.");
        } else {
            System.out.println("Sorry " + name + ", you failed the test.");
        }
    }

    /**
     * Reads a line of input from the user.
     * 
     * @param prompt the prompt to display to the user
     * @return the line of input from the user
     */
    private static String readInput(String prompt) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print(prompt);
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Invalid input");
                continue;
            }
        }
    }

    /**
     * Reads a double from the user.
     * 
     * @param prompt the prompt to display to the user
     * @return the double read from the user
     */
    private static double readDoubleInput(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readInput(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }
        }
    }
}
