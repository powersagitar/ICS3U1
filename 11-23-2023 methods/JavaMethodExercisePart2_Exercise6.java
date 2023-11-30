import java.io.*;
import java.text.DecimalFormat;

public class JavaMethodExercisePart2_Exercise6 {
    static final private int NUMBER_COUNT = 3;

    /**
     * Get 3 inputs, calculate sum, average and highest number, then print them.
     * 
     * @param args is unused.
     */
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numbers[] = new int[NUMBER_COUNT];

        for (int i = 0; i < NUMBER_COUNT;) {
            System.out.println("Enter an integer number:");

            try {
                numbers[i] = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number format: " + ex.getMessage());
                continue;
            }

            ++i;
        }

        System.out.println("Sum: " + getSum(numbers));
        System.out.println("Average: " + getAverageStr(numbers));
        System.out.println("Highest: " + getHighest(numbers));
    }

    /**
     * Get sum of numbers.
     * 
     * @param numbers is an array of numbers.
     * @return sum of numbers.
     */
    private static int getSum(int numbers[]) {
        int sum = 0;

        for (int i = 0; i < NUMBER_COUNT; ++i)
            sum += numbers[i];

        return sum;
    }

    /**
     * Get average of numbers.
     * 
     * @param numbers is an array of numbers.
     * @return average of numbers.
     */
    private static StringBuffer getAverageStr(int numbers[]) {
        double average = (double) getSum(numbers) / (double) NUMBER_COUNT;

        return new StringBuffer(new DecimalFormat(".00").format(average));
    }

    /**
     * Get highest number.
     * 
     * @param numbers is an array of numbers.
     * @return highest number.
     */
    private static int getHighest(int numbers[]) {
        int max = numbers[0];

        for (int i = 1; i < NUMBER_COUNT; ++i)
            if (numbers[i] > max)
                max = numbers[i];

        return max;
    }
}
