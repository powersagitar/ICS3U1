/**
 * ********************************************************************************
 * 
 * @project Mohan_Dong_CashPurchaseAssignment 
 * @author  Mohan Dong <350877700@gapps.yrdsb.ca>
 * @date    11/10/2023
 * 
 * @environment JDK 21
 * 
 * ********************************************************************************
 * 
 * Problem definition
 * Ask for account balance and total expense, then output the change (remainder) in 
 * the combination of a list of denominations
 * 
 * Input
 * account balance and total expense
 * 
 * Output 
 * the change (account balance - total expense) in the combination of denominations
 * 
 * Processing
 * 1. change = account balance - total expense
 * 2. check total expense > account balance
 *     2.1 early return if condition is evaluated true
 * 3. loop while remainder >= $0.01 (1 cent)
 *     3.1 during each iteration of while loop, increment the corresponding counter
 * 4. dump the counter values representing the denomination combination
 * 
 * ********************************************************************************
 * 
 * List of variables
 * 
 * BufferedReader bufferedReader    - for reading inputs from stdin
 * 
 * final double BALANCE - the amount of account balance
 * final double EXPENSE - the amount of total expense 
 * double remainder     - the amount of change (balance - expense), will mutate as
 *                        main while loop iterates
 *                    
 * int <counters>       - a set of counters for keeping the denomination
 *                        combination for output, will mutate as main while loop
 *                        iterates
 * 
 * ********************************************************************************
 */

// types referenced by the project
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// start of class Mohan_Dong_CashPurchaseAssignment 
public class Mohan_Dong_CashPurchaseAssignment {
    
    // main method
    public static void main(String[] args) throws IOException {

        // instantiate a BufferedReader for reading from stdin
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // declare, define, and initialize an immutable double named BALANCE for keeping account balance
        System.out.println("Please enter the account balance:");
        final double BALANCE = Double.parseDouble(bufferedReader.readLine());
        
        // declare, define, and initialize an immutable double named EXPENSE for keeping total expense
        System.out.println("Please enter the total expense:");
        final double EXPENSE = Double.parseDouble(bufferedReader.readLine());
        
        // close bufferedReader and release all resource taken
        // will not read from stdin any more beyond this point
        bufferedReader.close();
        
        // only using if blocks because the inputs need to be evaluated positive 
        // before the amount check
        
        // early return if either EXPENSE or BALANCE is negative
        if (EXPENSE < 0 || BALANCE < 0) {
            System.out.println("Usage: Input can't be negative");
            return;
        }

        // early return if EXPENSE > BALANCE
        if (EXPENSE > BALANCE) {
            System.out.println("Insufficient budget: Expense is greater than account balance.");
            return;
        }
        
        // denomination counters
        // <cnt-number>:   number is the denomination
        // <cnt-0-number>: number * 0.01 is the denomination
        int cnt100  = 0;
        int cnt50   = 0;
        int cnt20   = 0;
        int cnt10   = 0;
        int cnt5    = 0;
        int cnt2    = 0;
        int cnt1    = 0;
        int cnt025  = 0;
        int cnt010  = 0;
        int cnt005  = 0;
        int cnt001  = 0;
        
        // remainder of change
        // will mutate as main while loop iterates
        double remainder = BALANCE - EXPENSE;

        // main while loop
        // loops while remainder >= 0.01
        while (true) {

            // this statement is for fixing floating point precision issues
            // reason for magic number being 100.0:
            //    money only has 2 decimal places,
            //    so we only need to fix the first two digits after the decimal point
            // a larger magic number (coefficient) would also break the code
            remainder = Math.round(remainder * 100.0) / 100.0;

            // not using else-if blocks to make sure the conditions will be evaluated in the order
            // from large denominations to small denominations
            if (remainder >= 100.0) {
                remainder -= 100.0;
                ++cnt100;
                continue;
            }
            if (remainder >= 50.0) {
                remainder -= 50.0;
                ++cnt50;
                continue;
            }
            if (remainder >= 20.0) {
                remainder -= 20.0;
                ++cnt20;
                continue;
            }
            if (remainder >= 10.0) {
                remainder -= 10.0;
                ++cnt10;
                continue;
            }
            if (remainder >= 5.0) {
                remainder -= 5.0;
                ++cnt5;
                continue;
            }
            if (remainder >= 2.0) {
                remainder -= 2.0;
                ++cnt2;
                continue;
            }
            if (remainder >= 1.0) {
                remainder -= 1.0;
                ++cnt1;
                continue;
            }
            if (remainder >= 0.25) {
                remainder -= 0.25;
                ++cnt025;
                continue;
            }
            if (remainder >= 0.1) {
                remainder -= 0.1;
                ++cnt010;
                continue;
            }
            if (remainder >= 0.05) {
                remainder -= 0.05;
                ++cnt005;
                continue;
            }
            if (remainder >= 0.01) {
                remainder -= 0.01;
                ++cnt001;
                continue;
            }
            
            // else
            break;

        } // while
        
        // dump the change in denominations
        System.out.println("Change:");

        System.out.println("Banknotes:");
        System.out.println("\t$100:\t\t" + cnt100);
        System.out.println("\t$50:\t\t" + cnt50);
        System.out.println("\t$20:\t\t" + cnt20);
        System.out.println("\t$10:\t\t" + cnt10);
        System.out.println("\t$5:\t\t" + cnt5);

        System.out.println("Coins:");
        System.out.println("\tToonie:\t\t" + cnt2);
        System.out.println("\tLoonie:\t\t" + cnt1);
        System.out.println("\tQuarter:\t" + cnt025);
        System.out.println("\tDime:\t\t" + cnt010);
        System.out.println("\tNickel:\t\t" + cnt005);
        System.out.println("\tPenny:\t\t" + cnt001);

    } // main()
    
} // class Mohan_Dong_CashPurchaseAssignment 
