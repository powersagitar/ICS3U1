
/**
 * Project: Exercise 2
 * Author:  Mohan Dong <350877700@gapps.yrdsb.ca>
 * Date:    01/08/2024
 * 
 * Description:
 * This project demonstrates a possible solution to bubble sort exercise 2
 */

import java.io.*;

public class Exercise2 {
    /**
     * Ask user for 5 names and their marks, then sort the inputs in ascending order
     * of the marks and output the resulting list.
     * 
     * @param args Unused
     * @throws IOException Uncaught, may be thrown by BufferedReader::readLine()
     */
    public static void main(String[] args) throws IOException {
        final int arrSize = 5;
        String names[] = new String[arrSize];
        int marks[] = new int[arrSize];

        readInputs(arrSize, names, marks);
        sortAscending(arrSize, names, marks);
        printList(arrSize, names, marks);
    }

    /**
     * Read the names and marks from stdin.
     * 
     * @param size  The amount of names and marks to be read
     * @param names The reference to the name array
     * @param marks The reference to the mark array
     * @throws IOException Uncaught, may be thrown by BufferedReader::readLine()
     */
    private static void readInputs(final int size, String names[], int marks[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < size; ++i) {
            System.out.print("Enter the name: ");
            names[i] = bufferedReader.readLine();

            System.out.print("Enter the mark: ");
            marks[i] = Integer.parseInt(bufferedReader.readLine());

            System.out.println();
        }
    }

    /**
     * Sort the list in ascending order of the marks. Algorithm used is bubble sort.
     * 
     * @param size  The size of the list
     * @param names The reference to the name array
     * @param marks The reference to the mark array
     */
    private static void sortAscending(final int size, String names[], int marks[]) {
        for (int limit = size - 1; limit > 0; --limit)
            for (int current = 0; current < limit; ++current)
                if (marks[current] > marks[current + 1]) {
                    final int tmpInt = marks[current];
                    marks[current] = marks[current + 1];
                    marks[current + 1] = tmpInt;

                    final String tmpString = names[current];
                    names[current] = names[current + 1];
                    names[current + 1] = tmpString;
                }
    }

    /**
     * Prints the list to stdout.
     * 
     * @param size  The size of the list
     * @param names The reference to the name array
     * @param marks The reference to the mark array
     */
    private static void printList(final int size, String names[], int marks[]) {
        for (int i = 0; i < size; ++i)
            System.out.println(names[i] + ": " + marks[i]);
    }
}