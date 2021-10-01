package module5;

public class Coordinate {

    public int RESHIFT_X = 1;

    private int x;
    private int y;

    public Coordinate() {
        this.x = 1;
        this.y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void reshift() {
        this.x += this.RESHIFT_X;
    }

    public String toString() {
        return this.x + "," + this.y;
    }

}
