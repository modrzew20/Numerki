package A;

public class Funkcja1 implements Model {
    @Override
    public double pattern(double x) {
        // 2 * cos((x^2 + 5x + 3)+1)
        // Złożenie wielomianowej i trygonometrycznej
        double[] factors = {1, 5, 3}; // x^2 + 5x + 3
        return 2*Math.cos(Wielomian.horner(factors, x)+1);
    }
}

