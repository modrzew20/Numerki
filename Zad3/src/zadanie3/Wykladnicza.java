package zadanie3;

public class Wykladnicza extends Function
{
    public Wykladnicza()
    {
        name = "2^x - 12";
    }

    @Override
    public double pattern(double x)
    {
        return Math.pow(2, x) - 12;
    }
}
