package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Picture picture = new Picture(new Line(-1,-7), new Circle(-8, -4, 5), new Parabola(-0.25,2.5,-10.25));

        test(picture);

        double x = readPointCoordinate('x');
        double y = readPointCoordinate('y');

        outputColourForPoint(x, y, picture);
    }

    private static void outputColourForPoint (double x, double y, Picture picture)
    {
        System.out.printf("(%.1f, %.1f) The area which contains this point is %S%n", x, y, picture.getColour(x, y));
    }

    private static double readPointCoordinate(char coordinateName)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %S: ", coordinateName);

        return scanner.nextDouble();
    }

    private static void test(Picture picture)
    {
        double [] coordinateX = {-5, -7, -5, -2, 2, 2};
        double [] coordinateY = {-1, -2, 6, -7, -10, 2};

        for (int k = 0; k <= 5; k++ )
        {
            outputColourForPoint(coordinateX[k], coordinateY[k], picture);
        }
    }
}