package zadanie3;

public class Czybyszew
{
    static double[] getNodes(int n, double a, double b)
    {
        double[] nodes = new double[n];
        for(int i=0; i<n; i++)
        {
            double w = (2 * ((double)i+1) - 1) / (2*(double)n);
            double cos = (w == 0.5d ? 0 : Math.cos(Math.PI * w));
            nodes[i] = (a + b)/2
                    + cos * (b - a)/2;
        }
        return removeDuplicates(nodes);
    }

    private static double[] removeDuplicates(double[] a)
    {
        int newSize = a.length;
        for(int i=1; i<a.length; i++)
        {
            if(a[i] == a[i-1]) newSize--;
        }
        double[] result = new double[newSize];
        result[0] = a[0];
        int newI = 0;
        for(int i=1; i<a.length; i++)
        {
            if(result[newI] != a[i])
            {
                newI++;
                result[newI] = a[i];
            }
        }
        return result;
    }
}
