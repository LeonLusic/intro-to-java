package module6;

public class SnakeBody {

    Coordinate[] bodyPositions;
    int snakeLength;

    public SnakeBody(Coordinate head, Coordinate tail) {

        this.bodyPositions = new Coordinate[2];
        this.snakeLength = 2;

        bodyPositions[0] = head;
        bodyPositions[1] = tail;
    }

    Coordinate getHead() {
        return bodyPositions[0];
    }

    Coordinate getTail() {
        return this.bodyPositions[this.snakeLength-1];
    }

    void update(Coordinate newHead) {
        Coordinate[] copy = bodyPositions;
        for(int i = snakeLength-1; i > 0; i--) {
            copy[i] = bodyPositions[i-1];
        }
        copy[0] = newHead;
        bodyPositions = copy;
    }

    void extendBody(Coordinate head) {

        this.snakeLength++;

        Coordinate[] newBody = new Coordinate[this.snakeLength];

        for(int i = snakeLength-1; i > 0; i--) {
            newBody[i] = this.bodyPositions[i-1];
        }

        newBody[0] = head;

        this.bodyPositions = newBody;

    }

    public String toString() {
        String s = "";
        for(int i = 0; i < snakeLength; i++) {
            s += bodyPositions[i].toString() + "\n";
        }
        return s;
    }

}
