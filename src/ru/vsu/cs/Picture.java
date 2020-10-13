package ru.vsu.cs;

public class Picture
{
    private final Line line;
    private final Parabola parabola;
    private final Circle circle;

    public Picture(Line line, Circle circle, Parabola parabola)
    {
        this.line = line;
        this.parabola = parabola;
        this.circle = circle;
    }

    public SimpleColour getColour(double x, double y)
    {
      if (!line.isPointInside(x, y) && parabola.isPointInside(x, y)) return SimpleColour.BLUE;

      if (parabola.isPointInside(x, y)) return SimpleColour.WHITE;

      if (circle.isPointInside(x, y) && line.isPointInside(x, y)) return SimpleColour.GRAY;

      if (circle.isPointInside(x, y)) return SimpleColour.WHITE;

      if (!circle.isPointInside(x, y) && !line.isPointInside(x, y)) return SimpleColour.GREEN;

      return SimpleColour.BLUE;
    }
}
