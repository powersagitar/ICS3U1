import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Exercise4 {
    private static final int SIZE = 10;

    public static void main(String args[]) {
        int array[] = new int[SIZE];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; ++i) {
            array[i] = readIntInput(bufferedReader, "Enter number: ");
        }

        System.out.println("Numbers entered:");
        printArray(array);

        System.out.println("Sum: " + sum(array));
    }

    private static int readIntInput(BufferedReader bufferedReader, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.out.println("Error reading input");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static int sum(int array[]) {
        int sum = 0;
        for (int i = 0; i < SIZE; ++i) {
            sum += array[i];
        }
        return sum;
    }

    private static void printArray(int array[]) {
        for (int i = 0; i < SIZE; ++i) {
            System.out.println(array[i]);
        }
    }
}