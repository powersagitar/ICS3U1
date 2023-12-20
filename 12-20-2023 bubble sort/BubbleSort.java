public class BubbleSort {
    public static void main(String[] args) {
        int arrDecending[] = { 5, 4, 3, 2, 1 };
        arrDecending = bubbleSortAscending(arrDecending);
        printArr(arrDecending);

        int arrAscending[] = { 1, 2, 3, 4, 5 };
        arrAscending = bubbleSortDecending(arrAscending);
        printArr(arrAscending);
    }

    private static void printArr(int arr[]) {
        for (final int i : arr)
            System.out.println(i);
    }

    private static int[] bubbleSortAscending(int[] arr) {
        for (int limit = arr.length - 1; limit > 0; --limit) {
            for (int curr = 0; curr < limit; ++curr) {
                if (arr[curr] > arr[curr + 1]) {
                    int tmp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = tmp;
                }
            }
        }

        return arr;
    }

    private static int[] bubbleSortDecending(int[] arr) {
        for (int limit = arr.length - 1; limit > 0; --limit) {
            for (int curr = 0; curr < limit; ++curr) {
                if (arr[curr] < arr[curr + 1]) {
                    int tmp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = tmp;
                }
            }
        }

        return arr;
    }
}