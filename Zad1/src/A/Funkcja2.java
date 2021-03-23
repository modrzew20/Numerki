package A;

public class Funkcja2 implements Model {
    @Override
    public double pattern(double x) {
        // 2^(x^2 + 5x + 3) - 12
        // Złożenie wielomianowej i wykładniczej
        double[] factors = {1, 5, 3}; // x^2 + 5x + 3
        return Math.pow(2, Wielomian.horner(factors, x)) - 12;
    }
}
