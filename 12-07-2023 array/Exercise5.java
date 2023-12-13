
/**
 * program: Exercise5
 * date:    12-12-2023
 * author:  Mohan Dong <350877700@gapps.yrdsb.ca>
 * 
 * description
 * This program demostrates a possible solution to https://classroom.google.com/c/NjE5ODgzNDI2MjE4/a/NjQ1Njc4NjEzODU0/details
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5 {
    /**
     * Main method
     * 
     * Driver code for the program
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        double array[] = getDoubleArray(15);

        System.out.println("Largest value: " + getLargest(array));

        System.out.println("Smallest value: " + getSmallest(array));

        final double average = getAverage(array);
        System.out.println("Average value: " + average);

        System.out.println("Number of values above average: " + getAboveAverageCount(array, average));

        System.out.println("Number of values below average: " + getBelowAverageCount(array, average));

        System.out.println("Number of values equal to average: " + getEqualsAverageCount(array, average));

        final double mostOccurredElements[] = getMostOccurredElement(array);
        System.out.println("Most occurred elements:");
        printArray(mostOccurredElements);
    }

    /**
     * Print elements of an array to stdout with each element on a new line
     * 
     * @param array the array to print
     */
    private static void printArray(double array[]) {
        for (final double i : array)
            System.out.println(i);
    }

    /**
     * Read a line with error handling
     * 
     * @param bufferedReader the BufferedReader to read from
     * @param prompt         the prompt to display
     * @return the line read
     */
    private static String readLine(BufferedReader bufferedReader, String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Error reading from stdin. Try again.");
            }
        }
    }

    /**
     * Get an array of doubles from stdin
     * 
     * @param size the size of the array
     * @return the array of doubles
     */
    private static double[] getDoubleArray(int size) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double array[] = new double[size];

        for (int i = 0; i < size;) {
            try {
                array[i] = Double.parseDouble(readLine(bufferedReader, "Enter a double value\n"));
            } catch (NumberFormatException e) {
                System.out.println("Invalid double value. Try again.");
                continue;
            }

            ++i;
        }

        return array;
    }

    /**
     * Get the largest value in an array
     * 
     * @param array the array to get the largest value from
     * @return the largest value in the array
     */
    private static double getLargest(double array[]) {
        double largest = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }

    /**
     * Get the smallest value in an array
     * 
     * @param array the array to get the smallest value from
     * @return the smallest value in the array
     */
    private static double getSmallest(double array[]) {
        double smallest = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        return smallest;
    }

    /**
     * Get the average value of an array
     * 
     * @param array the array to get the average value from
     * @return the average value of the array
     */
    private static double getAverage(double array[]) {
        double sum = 0;

        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }

        return sum / array.length;
    }

    /**
     * Get the number of values above average in an array
     * 
     * @param array   the array to get the number of values above average from
     * @param average the average value of the array
     * @return the number of values above average in the array
     */
    private static int getAboveAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] > average) {
                ++count;
            }
        }

        return count;
    }

    /**
     * Get the number of values below average in an array
     * 
     * @param array   the array to get the number of values below average from
     * @param average the average value of the array
     * @return the number of values below average in the array
     */
    private static int getBelowAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] < average) {
                ++count;
            }
        }

        return count;
    }

    /**
     * Get the number of values equal to average in an array
     * 
     * @param array   the array to get the number of values equal to average from
     * @param average the average value of the array
     * @return the number of values equal to average in the array
     */
    private static int getEqualsAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == average) {
                ++count;
            }
        }

        return count;
    }

    /**
     * Do a linear search for an element in an array
     * 
     * @param array   the array to search
     * @param element the element to search for
     * @return whether the element is in the array
     */
    private static boolean isInArray(double array[], double element) {
        for (final double i : array)
            if (i == element)
                return true;

        return false;
    }

    /**
     * Push an element to the end of an array
     * 
     * @param oldArray the array to push the element to
     * @param element  the element to push
     * @return the new array with the element pushed
     */
    private static double[] arrayPush(double oldArray[], double element) {
        double newArray[] = new double[oldArray.length + 1];

        for (int i = 0; i < oldArray.length; ++i)
            newArray[i] = oldArray[i];

        newArray[oldArray.length] = element;

        return newArray;
    }

    /**
     * Check if two floating point numbers are equal
     * 
     * @param a the first floating point number
     * @param b the second floating point number
     * @return whether the two floating point numbers are equal
     */
    private static boolean floatingPointEquals(double a, double b) {
        return Math.abs(a - b) < 0.00000000000001;
    }

    /**
     * Get the most occurred elements in an array
     * 
     * @param array the array to get the most occurred elements from
     * @return an array of the most occurred elements in the array
     */
    private static double[] getMostOccurredElement(double array[]) {
        double mostOccurredElements[] = new double[0];
        int mostOccurrence = 0;

        double processed[] = new double[0];

        for (int i = 0; i < array.length; ++i) {
            if (isInArray(processed, array[i]))
                continue;

            int currentElementOccurrence = 1;

            for (int j = i + 1; j < array.length; ++j)
                if (floatingPointEquals(array[i], array[j]))
                    ++currentElementOccurrence;

            if (currentElementOccurrence > mostOccurrence) {
                mostOccurrence = currentElementOccurrence;
                mostOccurredElements = arrayPush(new double[0], array[i]);
            } else if (currentElementOccurrence == mostOccurrence) {
                mostOccurredElements = arrayPush(mostOccurredElements, array[i]);
            }

            processed = arrayPush(processed, array[i]);
        }

        return mostOccurredElements;
    }
}
