package module2;

import java.util.Scanner;

public class Othello2 {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    // Method that converts time in milliseconds to hh:mm:ss format
    public static String timeFormat(int time) {
        int trueSeconds = time/1000; // total time in seconds
        String onlySeconds = String.format("%02d", trueSeconds % 60); // number of seconds in hh:mm:ss format
        int trueMinutes = trueSeconds/60; // total time in minutes
        String onlyMinutes = String.format("%02d", trueMinutes % 60); // number of minutes in hh:mm:ss format
        int trueHours = trueMinutes/1000; // total time in hours
        String onlyHours = String.format("%02d", trueHours % 60); // number of hours in hh:mm:ss format

        return onlyHours+":"+onlyMinutes+":"+onlySeconds;
    }

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        int blackTime;

        // Takes two inputs, each in milliseconds, only stores the black time as only that one is necessary
        System.out.println("Enter the time black player thought: ");
        blackTime = Integer.parseInt(key.nextLine());

        String blackTimeString = timeFormat(blackTime);

        System.out.print("The time the human player has spent thinking is: " + blackTimeString);

    }

}
