package A;

public class Wykladnicza implements Model {
    @Override
    public double pattern(double x) {
        // 2^x - 12
        return Math.pow(2, x) - 12;
    }
}
