package module2;

import java.util.Scanner;

public class SecondSmallest {
    // Name: Leon Lusic
    // Assignment: module2
    // Date: 24.09.2020.

    public static int SecondSmallest(int[] numbers) {

        int smallest = numbers[0];
        int second_smallest = numbers[1];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                second_smallest = smallest;
                smallest = numbers[i];
            } else if (numbers[i] < second_smallest) {
                second_smallest = numbers[i];
            }
        }

        return second_smallest;
    }

    public static int[] StringToIntArray(String s) {

        String[] sequenceArray = s.split(" ");
        int[] numbers = new int[sequenceArray.length];

        for (int i = 0; i < sequenceArray.length; i++) {
            numbers[i] = Integer.parseInt(sequenceArray[i]);
        }

        return numbers;
    }

    public static void main(String[] args)  {

        Scanner key = new Scanner(System.in);

        System.out.println("Enter the sequence of numbers: ");

        int[] numbers = StringToIntArray(key.nextLine());

        int secondSmallest = SecondSmallest(numbers);

        System.out.println("The second smallest number is: " + secondSmallest);

    }

}
