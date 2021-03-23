package A;

public class functions implements Wariant {


    static public int it =0;

    @Override
    public double siecznych(double epsilon, double x0, double x1, int iteration, byte way, byte whichfunction) {

        Model m = null;
        if(whichfunction==1) m = new Wielomian();
        if(whichfunction==2) m = new Trygonometryczna();
        if(whichfunction==3) m = new Wykladnicza();
        //if(whichfunction==4) m = new ();
       // if(whichfunction==5) m = new ();

        double x;

        double px;
        do {
            x=x1-((m.pattern(x1)*(x1*x0))/(m.pattern(x1)-m.pattern(x0)));

            x0=x1;
            x1=x;
            it++;


        }while (way==3 && Math.abs(x-x1)>epsilon || way==4 && Math.abs(m.pattern(x))> epsilon || way==2 && it!=iteration );
        return x;

    }
}
