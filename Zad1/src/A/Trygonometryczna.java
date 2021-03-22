package A;

public class Trygonometryczna implements Model{
    @Override
    public double pattern(double x) {
        return 2*Math.cos(x+1);
    }

    @Override
    public double derived(double x) {
        return -2 * Math.sin(1+x);
    }

    @Override
    public double doublederived(double x) {
        return -2 * Math.cos(1+x);
    }
}
