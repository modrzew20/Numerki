package A;

import sample.ChoiceWindow;

public class Siecznych implements Wariant {

    static public int it = 1;

    @Override
    public double compute(double epsilon, double od, double dok, int iteration, byte way) {
        double x0 = od;
        double x1 = dok;
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
