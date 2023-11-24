import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise3 {
    /**
     * main method
     * This procedural method prompts the user to enter a length and width and then
     * calls the print method using those inputs.
     * 
     * @param args - unused
     * 
     * @return void
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a length:");
        int length = scanner.nextInt();

        System.out.println("Enter a width:");
        int width = scanner.nextInt();

        scanner.close();

        print(length, width);
    }

    /**
     * print method
     * This procedural method prints a filled rectangle of '&' characters to the
     * console with a line feed at the end of
     * each line using for loops.
     * 
     * @param length - the length (horizontal) of the rectangle
     * @param width  - the width (vertical) of the rectangle
     * 
     * @return void
     */
    private static void print(int length, int width) {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j)
                System.out.print('&');

            System.out.println();
        }
    }
}
