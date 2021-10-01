package module2;

import java.util.Scanner;

public class Plumber2 {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static void main(String[] args) {

        final double CALLOUT_COST = 16.00;

        Scanner key = new Scanner(System.in);

        System.out.print("Enter the hourly wages: ");
        double wages = Double.parseDouble(key.nextLine());

        System.out.print("Enter the number of billable hours: ");
        double hours = Double.parseDouble(key.nextLine());

        hours = hours  - ((hours + 0.5) % 1);

        double total_cost = CALLOUT_COST + wages*Math.round(hours);

        System.out.printf("The total cost of this repair is: €%.2f", total_cost);

    }

}