package A;

import sample.ChoiceWindow;

public class Siecznych implements Wariant {

    static public int it = 0;

    @Override
    public double compute(double epsilon, double x0, double x1, int iteration, byte way) {
        double x = x1-((ChoiceWindow.m.pattern(x1)*(x1-x0))/(ChoiceWindow.m.pattern(x1)-ChoiceWindow.m.pattern(x0)));
        do {
            x0=x1;
            x1=x;
            x = x1-((ChoiceWindow.m.pattern(x1)*(x1-x0))/(ChoiceWindow.m.pattern(x1)-ChoiceWindow.m.pattern(x0)));
            it++;
        }while (way==3 && Math.abs(x-x1)>epsilon || way==4 && Math.abs(ChoiceWindow.m.pattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }
}
