package module2;

import java.util.Scanner;

public class Manny {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static void main(String[] args) {

        final int MIN_DONATION = 50;

        Scanner key = new Scanner(System.in);

        boolean scamCheck = false;
        double donation = 0;

        while (!scamCheck) {
            System.out.println("Enter the amount you want to donate: \n");

            donation = Double.parseDouble(key.nextLine());

            if (donation >= MIN_DONATION) {
                scamCheck = true;
            }
        }

        System.out.printf("Thank you very much for your contribution of %.2f euro.", donation);

    }

}
