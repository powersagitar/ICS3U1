import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise2 {
    /**
     * main method
     * This procedural method prompts the user to enter a count and then calls the
     * print method that many times using a for loop.
     * 
     * @param args - unused
     * 
     * @return void
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a count: ");
        int count = scanner.nextInt();

        scanner.close();

        for (int i = 0; i < count; ++i)
            print();
    }

    /**
     * print method
     * This procedural method prints 10 '+' characters and a line feed at the end to
     * the console by using a for loop.
     * 
     * @return void
     */
    private static void print() {
        for (int i = 0; i < 10; ++i)
            System.out.print('+');

        System.out.println();
    } // print()
}
