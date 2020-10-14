
package ru.vsu.cs;

public class Parabola
{
    private double a;
    private double b;
    private double c;

    public Parabola(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointInside(double x, double y)
    {
        return y <= a * (x * x) + b * x + c;
    }
}