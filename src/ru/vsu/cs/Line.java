package ru.vsu.cs;

public class Line
{
    public double k;
    public double b;

    public Line(double k, double b)
    {
        this.k = k;
        this.b = b;
    }
    public boolean isPointInside(double x, double y)
    {
        return y > k * x + b;
    }
}
