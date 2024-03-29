package A;

import sample.ChoiceWindow;
import sample.Controller;

import static sample.Controller.sign;

public class Falsi implements Wariant{

    static public int it = 1;
    static public boolean validationCheck = true;

    @Override
    public double compute(double epsilon, double section1, double section2, int iteration, byte way) {
        it = 1;
        if(sign(ChoiceWindow.m.pattern(section1)) == sign(ChoiceWindow.m.pattern(section2))) validationCheck = false;
        else validationCheck = true;

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
            if (sign(ChoiceWindow.m.pattern(a)) == sign(ChoiceWindow.m.pattern(x))) a = x;
            else b = x;
            it++;
        } while (way == 3 && Math.abs(x - px) > epsilon || way == 4 && Math.abs(ChoiceWindow.m.pattern(x)) > epsilon || way == 2 && it != iteration);
        System.out.println(" Ostatni zakres Falsi: [" + a +",  "+ b + "]");

        return x;
    }

    private double linearEquationResult(double a, double b) {
        return (-b/a);
    }
}
