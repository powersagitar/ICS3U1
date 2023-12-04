
/**
 * program: RandomNumber
 * author:  Mohan Dong
 * date:    12/04/2023
 * 
 * description
 * This program generates a random number in range 1..=100, then asks the user to guess it.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

public class RandomNumber {
    /**
     * Generates a random number in range 1..=100, then asks the user to guess it.
     * 
     * @param args is unused
     */
    public static void main(final String[] args) {
        // generates a random number in range 0..=99, then adds 1 to make it 1..=100
        final int randomNumber = new Random().nextInt(100) + 1;

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int trials = 1;; ++trials) {
            final int input = readInt(bufferedReader, "Enter an integer number:");

            if (input < randomNumber) {
                System.out.println("Too low!");
            } else if (input > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("You guessed it in " + trials + " trials!");
                break;
            }
        }
    }

    /**
     * Reads an integer number from the user.
     * 
     * @param bufferedReader is the reader to read from
     * @param prompt         is the prompt to display
     * @return the integer number read
     */
    private static int readInt(final BufferedReader bufferedReader, final String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(bufferedReader.readLine());
            } catch (final NumberFormatException e) {
                System.out.println("Invalid number!");
            } catch (final IOException e) {
                System.out.println("Error reading input!");
            }
        }
    }
}
