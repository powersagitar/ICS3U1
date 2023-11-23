import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a length:");
        int length = scanner.nextInt();

        System.out.println("Enter a width:");
        int width = scanner.nextInt();

        System.out.println("Enter a symbol:");
        char symbol = scanner.next().charAt(0);

        scanner.close();

        print(length, width, symbol);
    }

    private static void print(int length, int width, char symbol) {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j) {
                if (i == 0 || i == width - 1 || j == 0 || j == length - 1)
                    System.out.print(symbol);
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }
}
