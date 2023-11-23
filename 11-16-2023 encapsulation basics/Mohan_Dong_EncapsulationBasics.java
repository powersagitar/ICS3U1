import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Vector;
import java.util.Random;

import java.nio.charset.Charset;

public class Mohan_Dong_EncapsulationBasics {
    public static void main(String[] args) throws IOException {
        Mohan_Dong_EncapsulationBasics main = new Mohan_Dong_EncapsulationBasics();

        // exercise 1
        System.out.println(main.sum(1.0, 2.0));

        // exercise 2
        System.out.println(main.add5(0));

        // exercise 3
        System.out.println(main.getCircleArea(10.0));

        // exercise 4
        Vector<Integer> numbers = new Vector<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter some integer numbers, \"end\" to indicate the end of the array:");
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("end")) {
                break;
            }

            numbers.add(Integer.parseInt(input));
        }
        System.out.println(main.getLargestInt(numbers));

        // exercise 5
        main.guessPassword(5);
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private int add5(int num) {
        return num + 5;
    }

    private double getCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    private int getLargestInt(Vector<Integer> numbers) {
        int largest = numbers.get(0);
        for (int i = 1; i < numbers.size(); ++i) {
            if (numbers.get(i) > largest) {
                largest = numbers.get(i);
            }
        }

        return largest;
    }

    private void guessPassword(int passwordLenth) throws IOException {
        // the random password string may contain non-typable characters
        // random string is unbounded for a simplistic demonstration
        byte[] correctPasswordBytes = new byte[passwordLenth];
        new Random().nextBytes(correctPasswordBytes);
        String correctPassword = new String(correctPasswordBytes, Charset.forName("UTF-8"));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; ++i) {
            System.out.println("Enter password:");
            String input = bufferedReader.readLine();
            if (input.equals(correctPassword)) {
                System.out.println("Correct!");
                return;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("password incorrect 3 times -- good-bye");
        System.out.println("Correct password: " + correctPassword);
    }
}