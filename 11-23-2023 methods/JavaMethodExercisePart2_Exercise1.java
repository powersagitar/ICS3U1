public class JavaMethodExercisePart2_Exercise1 {
    public static void main(String[] args) {
        star();

        for (int i = 0; i < 5; ++i)
            number();

        star();
    }

    private static void star() {
        for (int i = 0; i < 10; ++i)
            System.out.print('*');

        System.out.println();
    }

    private static void number() {
        for (int i = 0; i < 5; ++i)
            System.out.print('#');

        System.out.println();
    }
}