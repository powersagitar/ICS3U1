public class Exercise3 {
    public static void main(String[] args) {
        printArray(createArray(2, 4));
    }

    private static int[][] createArray(int rows, int cols) {
        int a[][] = new int[rows][cols];

        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                k = k + 1;
                a[i][j] = k;
            }
        }

        return a;
    }

    private static void printArray(int[][] array) {
        for (final int[] row : array) {
            for (final int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}