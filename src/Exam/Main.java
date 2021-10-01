package Exam;

import java.io.PrintStream;

public class Main {

    PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {

        double[][] matrix = new double[5][3];

        int count = 0;

        for(int i = 0; i < matrix.length; i += 2) {
            for(int j = 0; j < matrix[0].length; j += 2) {
                if(matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }

        System.out.println(matrix.length);
    }

    A a = new A(3);
    double[][] matrix = new double[5][3];

}
