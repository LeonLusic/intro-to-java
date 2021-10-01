package module7;

import java.util.Scanner;

public class Coordinate {

    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }

    public String toString() {
        return Integer.toString(x) + ", " + Integer.toString(y);
    }

    public static Coordinate toCoordinate(Scanner scanner) {

        scanner.useDelimiter(" ");

        int x = Integer.parseInt(scanner.next());
        int y = Integer.parseInt(scanner.next());

        return new Coordinate(x, y);

    }

    public static Coordinate[] toWall(String path) {

        String[] coordinates = path.split("\n");

        Coordinate[] wall = new Coordinate[coordinates.length];

        for(int i = 0; i < coordinates.length; i++) {

            Scanner coordinateScanner = new Scanner(coordinates[i]);

            coordinateScanner.useDelimiter(" ");

            wall[i] = toCoordinate(coordinateScanner);

        }

        return wall;

    }

    boolean isEqual(Coordinate comparison) {

        return this.x == comparison.getX() && this.y == comparison.getY();

    }

}
