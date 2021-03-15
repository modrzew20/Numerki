package sample;

public class functions {

    //Funkcja f(x) = x*x - 2

    static double first(double epsilon, boolean way) {
        double section1 = 0;
        double section2 = 2;
        double x;

        if(firstp(section2)*doublederivedfirst() > 0) x=section2;
        else x=section1;

        double px;
        do {
            px=x;
            x=x-(firstp(x)/derivedfirst(x));
        }while (way && Math.abs(x-px)>epsilon || !way && Math.abs(firstp(x))> epsilon);

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
