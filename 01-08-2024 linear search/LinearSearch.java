public class LinearSearch {
    public static void main(String[] args) {
        System.out.println("Array has key: " + linearSearch(0, new int[] { 1, 2, 3, 4, 5 }));
    }

    private static boolean linearSearch(int key, int arr[]) {
        for (final int i : arr)
            if (i == key)
                return true;

        return false;
    }
}