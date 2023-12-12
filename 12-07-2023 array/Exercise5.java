import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5 {
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

    private static void printArray(double array[]) {
        for (final double i : array)
            System.out.println(i);
    }

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

    private static double getLargest(double array[]) {
        double largest = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }

    private static double getSmallest(double array[]) {
        double smallest = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        return smallest;
    }

    private static double getAverage(double array[]) {
        double sum = 0;

        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }

        return sum / array.length;
    }

    private static int getAboveAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] > average) {
                ++count;
            }
        }

        return count;
    }

    private static int getBelowAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] < average) {
                ++count;
            }
        }

        return count;
    }

    private static int getEqualsAverageCount(double array[], double average) {
        int count = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == average) {
                ++count;
            }
        }

        return count;
    }

    private static boolean isInArray(double array[], double element) {
        for (final double i : array)
            if (i == element)
                return true;

        return false;
    }

    private static double[] arrayPush(double array[], double element) {
        double newArray[] = new double[array.length + 1];

        for (int i = 0; i < array.length; ++i)
            newArray[i] = array[i];

        newArray[array.length] = element;

        return newArray;
    }

    private static boolean floatingPointEquals(double a, double b) {
        return Math.abs(a - b) < 0.00000000000001;
    }

    private static double[] getMostOccurredElement(double array[]) {
        double mostOccurredElements[] = new double[0];
        int mostOccurrence = 0;

        double counted[] = new double[0];

        for (int i = 0; i < array.length; ++i) {
            if (isInArray(counted, array[i]))
                continue;

            int currentElementOccurrence = 1;

            for (int j = i + 1; j < array.length; ++j) {
                if (floatingPointEquals(array[i], array[j]))
                    ++currentElementOccurrence;
            }

            if (currentElementOccurrence > mostOccurrence) {
                mostOccurrence = currentElementOccurrence;
                mostOccurredElements = arrayPush(new double[0], array[i]);
            } else if (currentElementOccurrence == mostOccurrence) {
                mostOccurredElements = arrayPush(mostOccurredElements, array[i]);
            }

            counted = arrayPush(counted, array[i]);
        }

        return mostOccurredElements;
    }
}
