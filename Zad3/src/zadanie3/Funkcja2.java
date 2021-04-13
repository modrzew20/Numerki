package zadanie3;

public class Funkcja2 extends Function
{
    public Funkcja2() // Złożenie wielomianowej i wykładniczej
    {
        name = "2^(x^2 + 5x + 3) - 12";
    }

    @Override
    public double pattern(double x)
    {
        double[] factors = {1, 5, 3}; // x^2 + 5x + 3
        return Math.pow(2, Wielomian.horner(factors, x)) - 12;
    }
}
