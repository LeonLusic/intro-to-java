package module6;

import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.UIAuxiliaryMethods;

public class Snake {

    SnakeUserInterface ui;

    static final int WIDTH = 40;
    static final int HEIGHT = 30;
    static final double FPS = 6;

    Coordinate head;
    Coordinate tail;
    SnakeBody body;
    int[][] placements = new int[WIDTH][HEIGHT];
    Direction direction;
    boolean foodPresent;
    boolean gameOver;
    boolean growing;

    enum Direction {
        LEFT (-1,0),
        RIGHT (1,0),
        UP (0,1),
        DOWN (0,-1);

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

    Snake() {
        ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
    }

    void arrowHandler(Event event) {

        String data = event.data;

        switch (data) {
            case "L":
                if (direction != Direction.RIGHT) {
                    direction = Direction.LEFT;
                }
                break;
            case "R":
                if (direction != Direction.LEFT) {
                    direction = Direction.RIGHT;
                }
                break;
            case "U":
                if (direction != Direction.UP) {
                    direction = Direction.DOWN;
                }
                break;
            case "D":
                if (direction != Direction.DOWN) {
                    direction = Direction.UP;
                }
                break;
        }

    }

    void spawnFood() {

        int foodX = UIAuxiliaryMethods.getRandom(0, WIDTH);
        int foodY = UIAuxiliaryMethods.getRandom(0, HEIGHT);

        if(placements[foodX][foodY] != ui.SNAKE) {

            ui.place(foodX, foodY, ui.FOOD);
            ui.showChanges();

            placements[foodX][foodY] = ui.FOOD;

            foodPresent = true;

        } else {
            spawnFood();
        }
    }

    Coordinate updateInDirection() {

        int x = head.getX();
        int y = head.getY();

        x += direction.getX();

        if(x >= WIDTH) {
            x = 0;
        } else if(x < 0) {
            x = WIDTH-1;
        }

        y += direction.getY();

        if(y >= HEIGHT) {
            y = 0;
        } else if(y < 0) {
            y = HEIGHT - 1;
        }

        return new Coordinate(x,y);
    }

    void updateField(int x, int y, int type) {
        ui.place(x,y,type);
        placements[x][y] = type;
    }

    void move() {

        Coordinate nextCoordinate = updateInDirection();

        if(placements[nextCoordinate.getX()][nextCoordinate.getY()] == ui.SNAKE) {
            gameOver = true;
            UIAuxiliaryMethods.showMessage("GAME OVER");
        } else if(placements[nextCoordinate.getX()][nextCoordinate.getY()] == ui.FOOD) {
            foodPresent = false;
            body.extendBody(nextCoordinate);
        } else {
            body.update(nextCoordinate);

            updateField(tail.getX(),tail.getY(),ui.EMPTY);
        }

        head = body.getHead();
        tail = body.getTail();

        updateField(head.getX(),head.getY(),ui.SNAKE);

        if(!foodPresent) {
            spawnFood();
        }

        ui.showChanges();

    }

    void processEvent(Event event) {

        if(!event.name.equals("mouseover")) {

            if(event.name.equals("arrow")) {

                arrowHandler(event);

            } else {

                move();

            }

        }

    }

    void initializePlacements() {
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                placements[i][j] = ui.EMPTY;
            }
        }
    }

    void initialize() {

        UserInterfaceFactory.enableLowResolution(true);

        ui.setFramesPerSecond(FPS);

        direction = Direction.RIGHT;
        foodPresent = false;
        gameOver = false;
        growing = false;

        head = new Coordinate(1,0);
        tail = new Coordinate(0,0);

        body = new SnakeBody(head, tail);

        initializePlacements();

        updateField(head.getX(),head.getY(),ui.SNAKE);
        updateField(tail.getX(),tail.getY(),ui.SNAKE);

        ui.showChanges();

    }

    void start() {

        initialize();

        while (!gameOver) {

            Event event = ui.getEvent();

            processEvent(event);

        }

    }

    public static void main(String[] args) {

        new Snake().start();

    }

}
