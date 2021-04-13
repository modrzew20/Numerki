package zadanie3;

public abstract class Function
{
    public String name;
    public abstract double pattern(double x);

    public static double horner(double[] factors, double x)
    {
        double result = factors[0];
        for(int i=1; i<factors.length; i++)
        {
            result = result * x + factors[i];
        }
        return result;
    }
}
