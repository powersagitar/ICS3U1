import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a length:");
        int length = scanner.nextInt();

        System.out.println("Enter a width:");
        int width = scanner.nextInt();

        scanner.close();

        print(length, width);
    }

    private static void print(int length, int width) {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j)
                System.out.print('&');

            System.out.println();
        }
    }
}
