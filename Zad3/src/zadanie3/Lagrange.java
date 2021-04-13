package zadanie3;

public class Lagrange
{
    public static double compute(double[] x, Function function, double X)
    {
        double resultY = 0;
        for(int i=0; i<x.length; i++)
        {
            double y = function.pattern(x[i]);
            double nextPart = 1;
            for(int j=0; j<x.length; j++)
            {
                if(j != i)
                {
                    nextPart = nextPart * (X - x[j]) / (x[i] - x[j]);
                }
            }
            resultY = resultY + y * nextPart;
        }
        return resultY;
    }
}
