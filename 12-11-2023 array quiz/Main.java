public class Main {
    public static void main(String[] args) {
        int array[] = generateArray();

        array = evenToOdd(array);

        print(array);
    }

    private static int[] generateArray() {
        int array[] = new int[6];
        for (int i = 0; i < 6; ++i)
            array[i] = i;

        return array;
    }

    private static int[] evenToOdd(int array[]) {
        for (int i = 0; i < array.length; ++i)
            if (array[i] % 2 == 0)
                ++array[i];

        return array;
    }

    private static void print(int array[]) {
        for (int i : array)
            System.out.println(i);
    }
}