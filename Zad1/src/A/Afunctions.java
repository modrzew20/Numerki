package A;

public class Afunctions implements WariantA{
    @Override
    public double Newton(double epsilon, double section1, double section2, int iteration, byte way, byte whichfunction) {

        Model m = null;
        if(whichfunction==1) m = new Wielomian();
        if(whichfunction==2) m = new Trygonometryczna();
        if(whichfunction==3) m = new Wykladnicza();
        //if(whichfunction==4) m = new ();
       // if(whichfunction==5) m = new ();

        double x;
        if(m.pattern(section2)*m.doublederived(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(m.pattern(x)/ m.derived(x));
            it++;

        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(m.pattern(x))> epsilon || way==2 && it!=iteration );
        return x;

    }
}
