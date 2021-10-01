package module2;

import java.util.Scanner;

public class Electronics {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static void main(String[] args) {

        final double REDUCTION = 0.15;

        Scanner key = new Scanner(System.in);

        // Instantiate the variables to be used later
        double total_price;
        double discount;

        System.out.print("Enter the price of the first article: ");
        double price_1 = key.nextDouble();
        System.out.print("Enter the price of the second article: ");
        double price_2 = key.nextDouble();
        System.out.print("Enter the price of the third article: ");
        double price_3 = key.nextDouble();

        if (price_1 > price_2) {
            if (price_1 > price_3) {
                discount = price_1*REDUCTION;
                price_1 -= discount;
                System.out.print("New price: " + price_1);
            } else {
                discount = price_3*REDUCTION;
                price_3 -= discount;
                System.out.print("New price: " + price_3);
            }
        } else if (price_2 > price_3) {
            discount = price_2*REDUCTION;
            price_2 -= discount;
            System.out.print("New price: " + price_2);
        } else {
            discount = price_3*REDUCTION;
            price_3 -= discount;
            System.out.print("New price: " + price_3);
        }

        total_price = price_1 + price_2 + price_3;

        System.out.printf("Discount: %.2f \n", discount);
        System.out.printf("Total: %.2f", total_price);

    }

}
