import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a side length:");
        int side = scanner.nextInt();

        System.out.println("Enter a symbol:");
        char symbol = scanner.next().charAt(0);

        scanner.close();

        print(side, symbol);
    }

    private static void print(int side, char symbol) {
        for (int i = 0; i < side; ++i) {
            for (int j = 0; j <= i; ++j)
                System.out.print(symbol);

            System.out.println();
        }
    }
}
