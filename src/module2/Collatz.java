package module2;

import java.util.Scanner;

public class Collatz {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static String CollatzSequence(int n) {

        String sequence = Integer.toString(n);

        // Apply the Collatz rule for 'x_(n+1)', given 'x_n'
        while (n != 1) {
            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = 3*n+1;
            }
            sequence += " " + Integer.toString(n);
        }
        return sequence;
    }

    public static void main(String[] args) {

        // Create a scanner for input
        Scanner key = new Scanner(System.in);

        // Prompt input
        System.out.print("Enter the starting integer: ");

        int n = 0;

        // Verify that the input is a positive integer
        try {
            n = Integer.parseInt(key.nextLine());
            if (n < 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("The input should be a positive integer!");
        }

        // Instantiate the String representing the Collatz sequence of 'n'
        String sequence = CollatzSequence(n);

        // Print out the corresponding Collatz sequence
        System.out.print(sequence);

    }

}
