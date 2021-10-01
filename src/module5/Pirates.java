package module5;

import ui.UIAuxiliaryMethods;

import java.util.Scanner;

public class Pirates {
    // Name: Leon Lusic
    // Assignment: module5
    // Date: 10.11.2020.

    public static Coordinate createCoordinate(Scanner coordinateScanner) {

        coordinateScanner.useDelimiter(",");

        int x = (int) Double.parseDouble(coordinateScanner.next());
        int y = (int) Double.parseDouble(coordinateScanner.next());

        Coordinate coordinate = new Coordinate(x, y);   // consider re-shifting here

        return coordinate;

    }

    public static CoordinateRow createRow(Scanner rowScanner) {

        rowScanner.useDelimiter(" ");

        CoordinateRow coordinateRow = new CoordinateRow();

        while (rowScanner.hasNext()) {

            Scanner coordinateScanner = new Scanner(rowScanner.next());

            Coordinate coordinate = createCoordinate(coordinateScanner);

            coordinateRow.appendCoordinate(coordinate);

        }

        return coordinateRow;

    }

    public static void execute(Scanner fileScanner) {

        fileScanner.useDelimiter("=");

        boolean check = false;

        CoordinateRow finalRow = new CoordinateRow();

        boolean first = true;

        while (fileScanner.hasNext()) {

            Scanner rowScanner = new Scanner(fileScanner.next());

            CoordinateRow row = createRow(rowScanner);

            if (first) {
                finalRow = row;
                first = false;
            } else if (check) {
                finalRow.addBack(row);
            } else {
                finalRow.addFront(row);
            }

            check = !check;

        }

        finalRow.reshiftRow();

        System.out.println(finalRow.toString());

    }

    public static void main(String[] args) {

        Scanner fileScanner = UIAuxiliaryMethods.askUserForInput().getScanner();

        execute(fileScanner);

    }

}
