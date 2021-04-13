package zadanie3;

public class Funkcja1 extends Function
{
    public Funkcja1() // Złożenie wielomianowej i trygonometrycznej
    {
        name = "2 * cos((x^2 + 5x + 3)+1)";
    }

    @Override
    public double pattern(double x)
    {
        double[] factors = {1, 5, 3}; // x^2 + 5x + 3
        return 2*Math.cos(Wielomian.horner(factors, x)+1);
    }
}

