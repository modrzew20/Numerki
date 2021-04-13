package zadanie3;

public class Newton
{
    public static double compute(double[] x, Function function, double X)
    {
        double f[] = new double[x.length];
        for(int i=0; i<x.length; i++)
        {
            f[i] = function.pattern(x[i]);
        }

        for(int j=0; j<x.length-1; j++)
        {
            for(int i=x.length-1;i>j;i--)
            {
                f[i] = (f[i] - f[i - 1]) / (x[i] - x[i - j - 1]);
            }
        }

        double result = 0;
        for(int i=x.length-1;i>=0;i--)
        {
            double m = 1;
            for(int j=0;j<i;j++)
            {
                m = m * (X - x[j]);
            }
            m = m * f[i];
            result = result + m;
        }
        return result;
    }
}
