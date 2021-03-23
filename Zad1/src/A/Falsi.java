package A;

import sample.ChoiceWindow;

public class Falsi implements Wariant{

    static public int it = 1;
    static public boolean validationCheck = true;

    @Override
    public double compute(double epsilon, double section1, double section2, int iteration, byte way) {


        if(sign(ChoiceWindow.m.pattern(section1)) == sign(ChoiceWindow.m.pattern(section2))) validationCheck = false;

        double a = section2;
        double b = section1;
        double factorA = ((ChoiceWindow.m.pattern(a) - ChoiceWindow.m.pattern(b)) / (a - b));
        double factorB = (ChoiceWindow.m.pattern(a) - factorA * a);
        double x = linearEquationResult(factorA, factorB);
        it = 1;

        double px;
        do {
            px = x;
            factorA = ((ChoiceWindow.m.pattern(a) - ChoiceWindow.m.pattern(b)) / (a - b));
            factorB = (ChoiceWindow.m.pattern(a) - factorA * a);
            x = linearEquationResult(factorA, factorB);
            if (sign(a) == sign(x)) a = x;
            else b = x;
            it++;
        } while (way == 3 && Math.abs(x - px) > epsilon || way == 4 && Math.abs(ChoiceWindow.m.pattern(x)) > epsilon || way == 2 && it != iteration);
        return x;
    }

    private int sign(double a) {
        return (a >= 0 ? 1 : -1);
    }

    private double linearEquationResult(double a, double b) {
        return (-b/a);
    }
}
