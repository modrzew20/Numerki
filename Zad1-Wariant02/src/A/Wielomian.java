package A;

public class Wielomian extends Model {

    @Override
    public double pattern(double x) {
        return x*x-2;
    }

    @Override
    public double derived(double x) {
        return 2*x;
    }

    @Override
    public double doublederived(double x) {
        return 2;
    }
}
