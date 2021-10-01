package module6;

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

}
