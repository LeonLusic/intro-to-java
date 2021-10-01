package module2;

import java.util.Scanner;

public class Othello {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static void main(String[] args) {

        final double BOARD_SIZE = 64;

        Scanner key = new Scanner(System.in);

        System.out.print("Enter the number of white pieces on the board: ");
        double whitePieces = Double.parseDouble(key.nextLine());
        System.out.print("Enter the number of black pieces on the board: ");
        double blackPieces = Double.parseDouble(key.nextLine());

        double totalPieces = whitePieces + blackPieces;

        double boardPercentage = 100*blackPieces/BOARD_SIZE;
        double blackPercentage = 100*blackPieces/totalPieces;

        System.out.printf("The percentage of black pieces on the board is: %.2f%% \n", boardPercentage);
        System.out.printf("The percentage of black pieces of all the pieces on the board is: %.2f%%", blackPercentage);

    }

}