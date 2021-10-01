package module7;

import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;

import java.io.PrintStream;
import java.util.Scanner;

public class Labyrinth {

    PrintStream out;
    Scanner labyrinthScanner;

    Coordinate startPath;
    Coordinate endPath;
    Coordinate current;
    Direction direction;
    Coordinate[] wall;

    enum Direction {
        WEST (-1,0),
        NORTH (0,1),
        EAST (1,0),
        SOUTH (0,-1);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }

    }

    public Labyrinth() {

        out = new PrintStream(System.out);
        labyrinthScanner = UIAuxiliaryMethods.askUserForInput().getScanner();

    }

    boolean isWall(Coordinate potential) {

        for(int i = 0; i < wall.length; i++) {
            if(wall[i].isEqual(potential)) {
                return true;
            }
        }
        return false;

    }

    boolean tryDirection(Direction direction) {

        Coordinate potential = new Coordinate(current.x + direction.x, current.y + direction.y);

        return isWall(potential);

    }

    void move() {



    }

    void execute() {

        labyrinthScanner.useDelimiter("=");

        Scanner start = new Scanner(labyrinthScanner.next());
        Scanner end = new Scanner(labyrinthScanner.next());

        startPath = Coordinate.toCoordinate(start);
        endPath = Coordinate.toCoordinate(end);

        current = startPath;

        wall = Coordinate.toWall(labyrinthScanner.next());

    }

    public static void main(String[] args) {

        new Labyrinth().execute();

    }

}
