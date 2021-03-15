package sample;

public class functions {

    //Funkcja f(x) = x*x - 2

    static double first(double epsilon, boolean way, double section1, double section2, boolean op, int iteration) {
        double x;

        if(firstp(section2)*doublederivedfirst() > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(firstp(x)/derivedfirst(x));
            it++;
        }while (op && way && Math.abs(x-px)>epsilon ||op && !way && Math.abs(firstp(x))> epsilon || !op && it!=iteration );
        return x;
    }

    static double firstp(double x) {
        return x*x-2;
    }

    static double derivedfirst(double x) {
        return 2*x;
    }

    static double doublederivedfirst() {
        return 2;
    }



}
