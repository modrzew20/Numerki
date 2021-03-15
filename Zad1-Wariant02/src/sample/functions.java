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

    static double second(double epsilon, boolean way, double section1, double section2, boolean op, int iteration) {
        double x;

        if(secondp(section2)*doublederivedsecond(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(secondp(x)/derivedsecond(x));
            it++;
        }while (op && way && Math.abs(x-px)>epsilon ||op && !way && Math.abs(firstp(x))> epsilon || !op && it!=iteration );
        return x;
    }



    static double secondp(double x) {
        return ((((x + 1.0) * x) - 2.0) * x) - 1.0;
    }

    static double derivedsecond(double x) {
        return (((3.0 * x) + 2.0) * x) - 2.0;
    }

    static double doublederivedsecond(double x) {
        return (3.0 * x) + 2.0;
    }


    static double third(double epsilon, boolean way, double section1, double section2, boolean op, int iteration) {
        double x;

        if(thirdp(section2)*doublederivedthird(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(thirdp(x)/derivedthird(x));
            it++;
        }while (op && way && Math.abs(x-px)>epsilon ||op && !way && Math.abs(firstp(x))> epsilon || !op && it!=iteration );
        return x;
    }



    static double thirdp(double x) {
        return Math.sin(x) - Math.cos(x + 1.0);
    }

    static double derivedthird(double x) {
        return Math.cos(x) + Math.sin(x + 1.0);
    }

    static double doublederivedthird(double x) {
        return Math.cos( 1.0 + x)- Math.sin(x);
    }


    static double fourth(double epsilon, boolean way, double section1, double section2, boolean op, int iteration) {
        double x;

        if(fourthp(section2)*doublederivedfourth(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(fourthp(x)/derivedfourth(x));
            it++;
        }while (op && way && Math.abs(x-px)>epsilon ||op && !way && Math.abs(firstp(x))> epsilon || !op && it!=iteration );
        return x;
    }



    static double fourthp(double x) {
        return Math.exp(x) - 4.0 * x;
    }

    static double derivedfourth(double x) {
        return Math.exp(x) - 4.0;
    }

    static double doublederivedfourth(double x) {
        return Math.exp(x);
    }

    static double fifth(double epsilon, boolean way, double section1, double section2, boolean op, int iteration) {
        double x;

        if(fifthp(section2)*doublederivedfifth(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(fifthp(x)/derivedfifth(x));
            it++;

        }while (op && way && Math.abs(x-px)>epsilon ||op && !way && Math.abs(firstp(x))> epsilon || !op && it!=iteration );
        return x;

    }



    static double fifthp(double x) {
        return Math.sin(Math.exp(-x*x)) - 0.5;
    }

    static double derivedfifth(double x) {
        if(x==0) return 0;
        return -2.0 * x *( Math.exp(-x*x)) * (Math.cos(Math.exp(-x*x)));
    }

    static double doublederivedfifth(double x) {
        return Math.exp(-2*x*x) * (Math.exp(x*x)*(4*x*x-2)*Math.cos(Math.exp(-x*x))-4*x*x*Math.sin(Math.exp(-x*x)));
    }

}
