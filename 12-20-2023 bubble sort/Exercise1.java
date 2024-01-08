
/**
 * Project: Exercise 1
 * Author:  Mohan Dong <350877700@gapps.yrdsb.ca>
 * Date:    01/08/2024
 * 
 * Description:
 * This project demonstrates a possible solution to bubble sort exercise 1
 */

import java.io.*;

public class Exercise1 {
    /**
     * Read 5 integer numbers from stdin, sort them in ascending and decending
     * orders and print the resulting array.
     * 
     * @param args Unused
     * @throws IOException Uncaught, may be thrown by BufferedReader::readLine()
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 5 integer numbers:");
        final int inputs[] = getIntInputs(bufferedReader, 5);

        System.out.println("\nSorting in ascending order:");
        final int arrDecending[] = bubbleSortAscending(inputs.clone());
        printArr(arrDecending);

        System.out.println("\nSorting in decending order:");
        final int arrAscending[] = bubbleSortDecending(inputs.clone());
        printArr(arrAscending);
    }

    /**
     * Read int inputs.
     * 
     * @param bufferedReader The buffered reader to be used
     * @param size           The size of the array, i.e., how many inputs to be read
     * @return The int array read
     * @throws IOException Uncaught, may be thrown by BufferedReader::readLine()
     */
    private static int[] getIntInputs(BufferedReader bufferedReader, final int size) throws IOException {
        int inputs[] = new int[size];

        for (int i = 0; i < size; ++i)
            inputs[i] = Integer.parseInt(bufferedReader.readLine());

        return inputs;
    }

    /**
     * Print array
     * 
     * @param arr The array to be printed
     */
    private static void printArr(int arr[]) {
        for (final int i : arr)
            System.out.println(i);
    }

    /**
     * Sort the array ascendingly using bubble sort.
     * 
     * @param arr The array to be sorted
     * @return The sorted array
     */
    private static int[] bubbleSortAscending(int[] arr) {
        for (int limit = arr.length - 1; limit > 0; --limit) {
            for (int curr = 0; curr < limit; ++curr) {
                if (arr[curr] > arr[curr + 1]) {
                    int tmp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = tmp;
                }
            }
        }

        return arr;
    }

    /**
     * Sort the array decendingly using bubble sort.
     * 
     * @param arr The array to be sorted
     * @return The sorted array
     */
    private static int[] bubbleSortDecending(int[] arr) {
        for (int limit = arr.length - 1; limit > 0; --limit) {
            for (int curr = 0; curr < limit; ++curr) {
                if (arr[curr] < arr[curr + 1]) {
                    int tmp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = tmp;
                }
            }
        }

        return arr;
    }
}