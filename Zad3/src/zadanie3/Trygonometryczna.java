package zadanie3;

public class Trygonometryczna extends Function
{
    public Trygonometryczna()
    {
        name = "2cos(x + 1)";
    }

    @Override
    public double pattern(double x)
    {
        return 2*Math.cos(x+1);
    }
}
