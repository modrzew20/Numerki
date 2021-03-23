package A;

public class Trygonometryczna implements Model{
    @Override
    public double pattern(double x) {
        return 2*Math.cos(x+1);
    }

}
