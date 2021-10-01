package module4;

import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class Administration {
    // Name: Leon Lusic
    // Assignment: module4
    // Date: 30.10.2020.

    static final double PASSING_THRESHOLD = 5.5;
    static final double CLOSE_PASS = 6;
    static final double ROUNDING_FACTOR = 0.5;

    static String printStudent(Scanner studentScanner) {

        studentScanner.useDelimiter("_");

        String name = studentScanner.next();

        Scanner gradesScanner = new Scanner(studentScanner.next());

        String grade = getMean(gradesScanner);

        return name + " has an average of " + grade;
    }

    static String getMean(Scanner gradesScanner) {

        double sum = 0;
        int counter = 0;

        while (gradesScanner.hasNext()) {
            sum += Integer.parseInt(gradesScanner.next());
            counter += 1;
        }

        if (sum/counter >= PASSING_THRESHOLD && sum/counter < CLOSE_PASS) {
            return "6-";
        } else {
            return String.valueOf(Math.floor(sum/counter+ROUNDING_FACTOR));
        }
    }

    static String[] getSimilarityGraph(Scanner similarityScoresScanner) {

        similarityScoresScanner.useDelimiter("=");

        StringBuilder similarityGraph = new StringBuilder();

        boolean similarityPass = false;
        int positionCounter = 0;

        while (similarityScoresScanner.hasNext()) {

            double score = Double.parseDouble(similarityScoresScanner.next());

            if (positionCounter > 6 && score != 0) {
                similarityPass = true;
            }

            if (score == 0) similarityGraph.append("_");
            else if (score < 20) similarityGraph.append("-");
            else similarityGraph.append("^");

            positionCounter += 1;
        }

        String[] output = new String[2];
        output[0] = similarityGraph.toString();
        output[1] = String.valueOf(similarityPass);

        return output;
    }

    static String printSimilarityNames(Scanner similarityNamesScanner, boolean similarityPass) {

        StringBuilder similarityNames = new StringBuilder();

        similarityNamesScanner.useDelimiter(",");

        if (!similarityPass) return "No matches found";

        while (similarityNamesScanner.hasNext()) {

            similarityNames.append("\t\t").append(similarityNamesScanner.next());

            if (similarityNamesScanner.hasNext()) similarityNames.append("\n");
        }

        return similarityNames.toString();
    }

    static String printSimilarity(Scanner similarityScanner) {

        similarityScanner.useDelimiter(";");

        Scanner similarityScoresScanner = new Scanner(similarityScanner.next());

        String[] similaritySummary = getSimilarityGraph(similarityScoresScanner);

        String similarityGraph = "\t\t" + similaritySummary[0];

        boolean similarityPass = Boolean.parseBoolean(similaritySummary[1]);

        if (similarityScanner.hasNext()) {

            Scanner similarityNamesScanner = new Scanner(similarityScanner.next());

            String similarityNames = printSimilarityNames(similarityNamesScanner, similarityPass);

            return similarityGraph + "\n" + similarityNames;
        }

        return similarityGraph + "\n" + "\t\t" + "No matches found";
    }

    static String printSummary(Scanner studentLine, Scanner scoreLine) {

        String student = printStudent(studentLine);
        String similarity = printSimilarity(scoreLine);

        return student + "\n" + similarity;
    }

    static void execute(Scanner fileScanner) {

        StringBuilder output = new StringBuilder();

        while (fileScanner.hasNextLine()) {

            Scanner studentScanner = new Scanner(fileScanner.nextLine());
            Scanner scoreScanner = new Scanner(fileScanner.nextLine());

            output.append(printSummary(studentScanner, scoreScanner));

            if (fileScanner.hasNextLine()) output.append("\n");
        }

        System.out.print(output.toString());
    }

    public static void main(String[] args) {

        Scanner fileScanner = UIAuxiliaryMethods.askUserForInput().getScanner();

        execute(fileScanner);

    }

}
