package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Picture picture = new Picture(new Line(-1, -7), new Circle(-8, -4, 5),
                new Parabola(-0.25, 2.5, -10.25));

        System.out.println("-----------------TEST-----------------");

        boolean testResult = test(picture);

        if (testResult)
        {
            startProgram(picture);
        }
        else
        {
            System.out.println(' ');
            System.out.println("Test failed. Find the mistakes and try again.");
        }
    }

    private static double readPointCoordinate(char coordinateName)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %S: ", coordinateName);

        return scanner.nextDouble();
    }

    private static void startProgram(Picture picture)
    {
        double x = readPointCoordinate('x');
        double y = readPointCoordinate('y');

        SimpleColour colour = picture.getColour(x, y);

        printColourForPoint(colour);
    }

    private static void printColourForPoint(SimpleColour colour)
    {
        System.out.println("The area which contains this point is " + colour);
    }

    private static boolean test(Picture picture)
    {
        double[][] coordinates = {{-5, -1}, {-7, -2}, {6, -5}, {-2, -7}, {2, -10}, {2, 2}};
        SimpleColour[] correctResultsArray = {SimpleColour.GRAY, SimpleColour.WHITE, SimpleColour.WHITE,
                SimpleColour.GREEN, SimpleColour.BLUE, SimpleColour.BLUE};

        boolean testResult = true;

        for (int k = 0; k < coordinates.length; k++)
        {
            SimpleColour currentResults = picture.getColour(coordinates[k][0], coordinates[k][1]);
            SimpleColour correctResults = correctResultsArray[k];

            {
                if (currentResults == correctResults)
                {
                    print(currentResults, correctResults, "successful");
                }
                else
                {
                    print(currentResults, correctResults, "wrong");
                    testResult = false;
                }
            }
        }
        return testResult;
    }

    private static void print(SimpleColour currentResults, SimpleColour correctResults, String testResult)
    {
        System.out.printf("The result is %s: %s is %s \n", testResult, currentResults, correctResults);
    }
}