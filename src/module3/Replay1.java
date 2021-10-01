package module3;

import ui.OthelloReplayUserInterface;
import ui.UserInterfaceFactory;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;

class Replay1 {
    // Name: Leon Lusic
    // Assignment: module3
    // Date: 09.10.2020.

    static OthelloReplayUserInterface ui;

    Replay1() {
        ui = UserInterfaceFactory.getOthelloReplayUI();
        UserInterfaceFactory.enableLowResolution(true);
    }

    static int position(char[] chars, char item) {
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == item) {
                return i;
            }
        }
        return -1;
    }

    static int columnCharToInt(char column) {
        int[] columnsInt = new int[ui.NUMBER_OF_COLUMNS];
        for(int i = 0; i < ui.NUMBER_OF_COLUMNS; i++) {
            columnsInt[i] = i+1;
        }
        char[] columnsChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        try {
            return columnsInt[position(columnsChar, column)];
        } catch(Exception e) {
            System.out.println("Error, wrong column passed!");
        }
        return -1;
    }

    static int colorInt(String s) {
        if(s.equals("white")) {
            return ui.WHITE;
        } else if(s.equals("black")) {
            return ui.BLACK;
        } else {
            return ui.EMPTY;
        }
    }

    void initialPosition() {
        ui.place(ui.NUMBER_OF_COLUMNS - 4, ui.NUMBER_OF_ROWS - 5, ui.BLACK);
        ui.place(ui.NUMBER_OF_COLUMNS - 5, ui.NUMBER_OF_ROWS - 4, ui.BLACK);
        ui.place(ui.NUMBER_OF_COLUMNS - 4, ui.NUMBER_OF_ROWS - 4, ui.WHITE);
        ui.place(ui.NUMBER_OF_COLUMNS - 5, ui.NUMBER_OF_ROWS - 5, ui.WHITE);
        ui.showChanges();
    }

    void start() {

        initialPosition();

        int column;
        int row;
        int color;
        String[] line;
        Scanner fileScanner = UIAuxiliaryMethods.askUserForInput().getScanner();

        while(fileScanner.hasNext()) {
            line = fileScanner.nextLine().split("\\s");
            if(line[2].equals("move")) {
                color = colorInt(line[0]);
                column = columnCharToInt(line[3].charAt(0));
                row = Integer.parseInt(line[4]);

                ui.place(column-1, row-1, color);
                ui.showChanges();
                ui.wait(Integer.parseInt(line[1]));
            }
        }
    }

    public static void main(String[] argv) {
        new Replay1().start();
    }

}
