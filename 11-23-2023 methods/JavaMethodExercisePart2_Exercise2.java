import java.util.Scanner;

public class JavaMethodExercisePart2_Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a count: ");
        int count = scanner.nextInt();

        scanner.close();

        for (int i = 0; i < count; ++i)
            print();
    }

    private static void print() {
        for (int i = 0; i < 10; ++i)
            System.out.print('+');

        System.out.println();
    }
}
