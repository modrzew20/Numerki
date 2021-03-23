package A;

public class Wielomian implements Model {

    @Override
    public double pattern(double x) {
        double[] factors = {1, 5, 3}; // x^2 + 5x + 3
        return horner(factors, x);
    }

    public static double horner(double[] factors, double x) {
        double result = factors[0];
        for(int i=1; i<factors.length; i++) {
            result = result * x + factors[i];
        }
        return result;
    }
}
