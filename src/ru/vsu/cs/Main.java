package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Picture picture = new Picture(new Line(-1,-7), new Circle(-8, -4, 5), new Parabola(-0.25,2.5,-10.25));

        double x = readPointCoordinate('x');
        double y = readPointCoordinate('y');
        outputColorForPoint(x, y, picture);
    }

    private static void outputColorForPoint (double x, double y, Picture picture)
    {
        System.out.printf("(%.1f, %.1f) This Area colour is %S%n", x, y, picture.getColour(x, y));
    }

    private static double readPointCoordinate(char coordinateName)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %S: ", coordinateName);
        {
            return scanner.nextDouble();
        }
    }
}