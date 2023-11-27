import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise5 {
    /**
     * Main method to print a right triangle with the given side length and symbol.
     * 
     * @param args - command line arguments
     * 
     * @return void
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a side length:");
        int side = scanner.nextInt();

        System.out.println("Enter a symbol:");
        char symbol = scanner.next().charAt(0);

        scanner.close();

        print(side, symbol);
    }

    /**
     * Prints a right triangle with the given side length and symbol.
     * 
     * @param side   - side length of the triangle
     * @param symbol - symbol to print the triangle with
     * 
     * @return void
     */
    private static void print(int side, char symbol) {
        for (int i = 0; i < side; ++i) {
            for (int j = 0; j <= i; ++j)
                System.out.print(symbol);

            System.out.println();
        }
    }
}
