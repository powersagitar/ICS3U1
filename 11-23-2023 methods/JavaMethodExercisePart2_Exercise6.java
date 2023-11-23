import java.util.Scanner;
import java.text.DecimalFormat;

public class JavaMethodExercisePart2_Exercise6 {
    static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers[] = new int[NUMBER_COUNT];

        for (int i = 0; i < NUMBER_COUNT; ++i) {
            System.out.println("Enter an integer number:");
            numbers[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("Sum: " + getSum(numbers));
        System.out.println("Average: " + getAverageStr(numbers));
        System.out.println("Highest: " + getHighest(numbers));
    }

    private static int getSum(int numbers[]) {
        int sum = 0;

        for (int i = 0; i < NUMBER_COUNT; ++i)
            sum += numbers[i];

        return sum;
    }

    private static StringBuffer getAverageStr(int numbers[]) {
        double average = (double) getSum(numbers) / (double) NUMBER_COUNT;

        return new StringBuffer(new DecimalFormat(".00").format(average));
    }

    private static int getHighest(int numbers[]) {
        int max = numbers[0];

        for (int i = 1; i < NUMBER_COUNT; ++i)
            if (numbers[i] > max)
                max = numbers[i];

        return max;
    }
}
