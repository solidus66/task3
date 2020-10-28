package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Picture picture = new Picture(new Line(-1, -7), new Circle(-8, -4, 5),
                new Parabola(-0.25, 2.5, -10.25));

        System.out.println("---------------------------------------TEST---------------------------------------");

        boolean testResult = test(picture);

        if (testResult)
        {
            System.out.println(' ');
            System.out.println("Everything is OK. Enter coordinates.");
            startProgram(picture);
        }
        else
        {
            System.out.println(' ');
            System.out.println("Test failed. Find mistakes and try again.");
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
        Point[] coordinates = {new Point(-5, -1), new Point(-7, -2), new Point(6, -5),
                new Point(-2, -7), new Point(2, -10), new Point(2, 2)};

        SimpleColour[] correctResultsArray = {SimpleColour.GRAY, SimpleColour.WHITE, SimpleColour.WHITE,
                SimpleColour.GREEN, SimpleColour.BLUE, SimpleColour.BLUE};

        boolean testResult = true;

        for (int k = 0; k < coordinates.length; k++)
        {
            SimpleColour currentResults = picture.getColour(coordinates[k].x, coordinates[k].y);
            SimpleColour correctResults = correctResultsArray[k];

            {
                if (currentResults == correctResults)
                {
                    print(coordinates[k],currentResults, correctResults,"successful");
                }
                else
                {
                    print(coordinates[k],currentResults, correctResults,"wrong");
                    testResult = false;
                }
            }
        }
        return testResult;
    }

    private static void print(Point point,SimpleColour currentResults, SimpleColour correctResults, String testResult)
    {
        System.out.printf("For coordinates (%.0f;%.0f) the result is %s; Expected: %s -> Тhe result is %s \n",
                point.X(), point.Y(), testResult, currentResults, correctResults);
    }
}