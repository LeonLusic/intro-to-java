package module5;

import ui.UIAuxiliaryMethods;

import java.util.Scanner;

public class PiratesCopy {
    // Name: Leon Lusic
    // Assignment: module5
    // Date: 10.11.2020.

    public static Coordinate toCoordinate(String coordinateString) {

        String[] coordinateValues = coordinateString.split(",");

        int x = Integer.parseInt(coordinateValues[0]);
        int y = Integer.parseInt(coordinateValues[1]);

        Coordinate coordinate = new Coordinate(x, y);

        return coordinate;
    }

    public static CoordinateRow toRow(String row) {

        String[] coordinateStrings = row.split(" ");

        int numCoordinates = coordinateStrings.length;

        Coordinate[] coordinates = new Coordinate[numCoordinates];

        for(int i = 0; i < numCoordinates; i++) {
            coordinates[i] = toCoordinate(coordinateStrings[i]);
        }

        CoordinateRow coordinateRow = new CoordinateRow(coordinates);

        return coordinateRow;

    }

    public static void execute(Scanner fileScanner) {

        String[] rows = fileScanner.next().split("=");

        boolean check = false;

        CoordinateRow finalRow = new CoordinateRow();

        for(int i = 0; i < rows.length; i++) {

            CoordinateRow iterRow = toRow(rows[i]);

            if (check) {

                finalRow.addBack(iterRow);

            } else {

                finalRow.addFront(iterRow);

            }

            check = !check;

        }

        System.out.println(finalRow.toString());

    }

    public static void main(String[] args) {

        Scanner fileScanner = UIAuxiliaryMethods.askUserForInput().getScanner();
        System.out.println("Step 1");
        execute(fileScanner);
        System.out.println("Step 2");

    }

}
