package module2;

import java.util.Scanner;

public class VAT {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static void main(String[] args) {

        final double VAT = 0.21;

        Scanner key = new Scanner(System.in);

        System.out.print("Enter the price of an article including VAT: ");
        double price = Double.parseDouble(key.nextLine());

        double priceInitial = price/(1+VAT);

        System.out.printf("The price before VAT is: %.2f", priceInitial);

    }

}
