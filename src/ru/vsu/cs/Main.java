package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Picture picture = new Picture(new Line(-1, -7), new Circle(-8, -4, 5),
                new Parabola(-0.25, 2.5, -10.25));

        double x = readPointCoordinate('x');
        double y = readPointCoordinate('y');

        SimpleColour colour = picture.getColour(x, y);

        printColourForPoint(colour);

        System.out.println("---------------TEST---------------");
        test(picture);
    }

    static double readPointCoordinate(char coordinateName)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %S: ", coordinateName);

        return scanner.nextDouble();
    }

    static void printColourForPoint(SimpleColour colour)
    {
        System.out.println("The area which contains this point is " + colour);
    }

    static void test(Picture picture)
    {
        double[][] coordinates = {{-5, -7, 6, -2, 2, 2}, {-1, -2, -5, -7, -10, 2}};
        SimpleColour[] correctResultsArray = {SimpleColour.GRAY, SimpleColour.WHITE, SimpleColour.WHITE,
                SimpleColour.GREEN, SimpleColour.BLUE, SimpleColour.BLUE};

        for (int k = 0; k <= 5; k++)
        {
            SimpleColour currentResults = picture.getColour(coordinates[0][k], coordinates[1][k]);
            SimpleColour correctResults = correctResultsArray[k];

            if (currentResults == correctResults)
            {
                print(currentResults, correctResults, "true");
            }

            else
            {
                print(currentResults, correctResults, "false");
            }
        }
    }

    static void print(SimpleColour currentResults, SimpleColour correctResults, String testResult)
    {
        System.out.printf("Result is %s: %s is %s \n", testResult, currentResults, correctResults);
    }
}