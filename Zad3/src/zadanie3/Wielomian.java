package zadanie3;

public class Wielomian extends Function
{
    public Wielomian()
    {
        name = "x^2 + 5x + 3";
    }

    @Override
    public double pattern(double x)
    {
        double[] factors = {1, 5, 3};
        return horner(factors, x);
    }
}
