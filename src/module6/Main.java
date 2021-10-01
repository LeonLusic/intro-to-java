package module6;

import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

import java.util.Scanner;

public class Main {

    SnakeUserInterface ui;

    static final int WIDTH = 40;
    static final int HEIGHT = 30;
    static final double initialFPS = 24.0;

    double fps = initialFPS;
    int x = 0;
    int y = 0;
    boolean snake = false;

    Main() {
        ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
    }

    void processEvent(Event event) {

        String name = event.name;
        String data = event.data;

        if(name.equals("click")) {

            ui.printf(name + ": " + data + "\n");

            Scanner coordinateScanner = new Scanner(data);

            int x = Integer.parseInt(coordinateScanner.next());
            int y = Integer.parseInt(coordinateScanner.next());

            ui.place(x,y,ui.WALL);
            ui.showChanges();

        } else if(data.equals("Space")) {

            ui.printf(name + ": " + data + "\n");

            ui.clear();
            ui.showChanges();

        }
    }

    public void startEvents() {

        UserInterfaceFactory.enableLowResolution(true);

        while (true) {
            Event event = ui.getEvent();
            processEvent(event);
        }
    }

    public void processAnimation(Event event) {

        if(!event.name.equals("mouseover")) {

            if(event.name.equals("arrow")) {

                arrowHandler(event);

            } else if(event.name.equals("letter")) {

                if (event.data.equals("g")) {
                    snake = !snake;
                }

            } else {

                move();

            }

        }

    }

    public void initialize() {

        UserInterfaceFactory.enableLowResolution(true);

        ui.setFramesPerSecond(initialFPS);

        ui.place(x,y,ui.SNAKE);
        ui.place(x+1,y,ui.SNAKE);
        ui.showChanges();

    }

    public void move() {

        ui.place(x,y,ui.EMPTY);

        x += 1;

        if(x >= WIDTH) {
            x = 0;
            y += 1;
            if(y >= HEIGHT) {
                y = 0;
            }
        }

        if (snake) {
            ui.place(x,y,ui.SNAKE);
        } else {
            ui.place(x,y,ui.WALL);
        }

        ui.showChanges();

    }

    public void arrowHandler(Event event) {

        if(event.data.equals("L")) {

            if(fps != 0) {
                fps -= 0.5;
            }
            ui.setFramesPerSecond(fps);

        } else if (event.data.equals("R")) {

            fps += 0.5;
            ui.setFramesPerSecond(fps);

        }

    }

    public void startAnimation() {

        initialize();

        while (true) {

            Event event = ui.getEvent();

            processAnimation(event);

        }

    }

    public static void main(String[] args) {

        // new Main().startEvents();

        new Main().startAnimation();

    }

}