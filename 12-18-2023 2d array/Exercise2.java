import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Exercise2 {
    public static void main(String[] args) {
        // input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String names[] = new String[10];
        float marks[][] = new float[10][5];

        for (int i = 0; i < names.length; ++i) {
            names[i] = readString(bufferedReader, "Enter your name: ");

            for (int j = 0; j < marks[i].length; ++j) {
                marks[i][j] = readFloat(bufferedReader, ("Enter mark " + (j + 1) + ": "));
            }
        }

        // output
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("Name\tMark 1\tMark 2\tMark 3\tMark 4\tMark 5\tAverage");

        for (int i = 0; i < names.length; ++i) {
            System.out.print(names[i] + "\t");

            float sum = 0.0F;

            for (final float mark : marks[i]) {
                sum += mark;
                System.out.print(decimalFormat.format(mark) + "\t");
            }

            final float average = sum / marks[i].length;

            System.out.println(decimalFormat.format(average));
        }
    }

    private static String readString(BufferedReader bufferedReader, String prompt) {
        System.out.print(prompt);

        while (true) {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Error reading input. Try again.");
            }
        }
    }

    private static float readFloat(BufferedReader bufferedReader, String prompt) {
        while (true) {
            try {
                return Float.parseFloat(readString(bufferedReader, prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}