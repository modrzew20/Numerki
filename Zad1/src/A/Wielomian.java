package A;

public class Wielomian implements Model {

    @Override
    public double pattern(double x) {
        return x*x+ 5*x -3  ;
    }

    @Override
    public double derived(double x) {
        return 2*x +5;
    }

    @Override
    public double doublederived(double x) { return 2;}
}
