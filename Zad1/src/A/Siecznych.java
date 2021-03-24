package A;

import sample.ChoiceWindow;

import static sample.Controller.sign;

public class Siecznych implements Wariant {

    static public int it = 1;
    static public boolean validationCheck = true;


    @Override
    public double compute(double epsilon, double od, double dok, int iteration, byte way) {
        it = 1;
        double x0 = od;
        double x1 = dok;

        if(sign(ChoiceWindow.m.pattern(od)) == sign(ChoiceWindow.m.pattern(dok))) validationCheck = false;
        else validationCheck = true;

        double x = ((ChoiceWindow.m.pattern(x1)*x0-ChoiceWindow.m.pattern(x0)*x1))/(ChoiceWindow.m.pattern(x1)-ChoiceWindow.m.pattern(x0));
        // x1-((ChoiceWindow.m.pattern(x1)*(x1-x0))/(ChoiceWindow.m.pattern(x1)-ChoiceWindow.m.pattern(x0)));
        do {
            x0=x1;
            x1=x;
            if(ChoiceWindow.m.pattern(x1) != ChoiceWindow.m.pattern(x0)) x = ((ChoiceWindow.m.pattern(x1)*x0-ChoiceWindow.m.pattern(x0)*x1))/(ChoiceWindow.m.pattern(x1)-ChoiceWindow.m.pattern(x0));
            else {
                System.out.println("Nie da się osiągnąć większego przybliżenia");
                way = 2;
                iteration = it + 1;
            }
            it++;
        } while (way==3 && Math.abs(x-x1)>epsilon || way==4 && Math.abs(ChoiceWindow.m.pattern(x)) > epsilon || way==2 && it!=iteration );
        return x;
    }
}
