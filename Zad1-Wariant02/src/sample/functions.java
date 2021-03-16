package sample;

public class functions {

    //Funkcja f(x) = x*x - 2
    static double first(double epsilon, double section1, double section2 ,int iteration, byte way) {
        double x;
        if(firstpattern(section2)*doublederivedfirst() > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(firstpattern(x)/derivedfirst(x));
            it++;

        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(firstpattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }

    static double firstpattern(double x) {
        return x*x-2;
    }

    static double derivedfirst(double x) {
        return 2*x;
    }

    static double doublederivedfirst() {
        return 2;
    }



    // Funkcja f(x)=((x + 1.0) * x - 2.0) * x - 1.0
    static double second(double epsilon, double section1, double section2 ,int iteration, byte way) {
        double x;
        if(secondpattern(section2)*doublederivedsecond(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(secondpattern(x)/derivedsecond(x));
            it++;
        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(secondpattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }

    static double secondpattern(double x) {
        return ((((x + 1.0) * x) - 2.0) * x) - 1.0;
    }

    static double derivedsecond(double x) {
        return (((3.0 * x) + 2.0) * x) - 2.0;
    }

    static double doublederivedsecond(double x) {
        return (3.0 * x) + 2.0;
    }



    // Funkcja f(x)=sin(x) - cos(x + 1.0)
    static double third(double epsilon, double section1, double section2 ,int iteration, byte way) {
        double x;
        if(thirdpattern(section2)*doublederivedthird(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(thirdpattern(x)/derivedthird(x));
            it++;
        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(thirdpattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }

    static double thirdpattern(double x) {
        return Math.sin(x) - Math.cos(x + 1.0);
    }

    static double derivedthird(double x) {
        return Math.cos(x) + Math.sin(x + 1.0);
    }

    static double doublederivedthird(double x) {
        return Math.cos( 1.0 + x)- Math.sin(x);
    }


    // Funkcja f(x)=exp(x) - 4.0 * x
    static double fourth(double epsilon, double section1, double section2 ,int iteration, byte way) {
        double x;
        if(fourthpattern(section2)*doublederivedfourth(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(fourthpattern(x)/derivedfourth(x));
            it++;
        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(fourthpattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }

    static double fourthpattern(double x) {
        return Math.exp(x) - 4.0 * x;
    }

    static double derivedfourth(double x) {
        return Math.exp(x) - 4.0;
    }

    static double doublederivedfourth(double x) {
        return Math.exp(x);
    }



    // Funkcja f(x)=sin(exp(-x*x)) - 0.5
    static double fifth(double epsilon, double section1, double section2 ,int iteration, byte way) {
        double x;
        if(fifthpattern(section2)*doublederivedfifth(section2) > 0) x=section2;
        else x=section1;
        int it=0;
        double px;
        do {
            px=x;
            x=x-(fifthpattern(x)/derivedfifth(x));
            it++;

        }while (way==3 && Math.abs(x-px)>epsilon || way==4 && Math.abs(fifthpattern(x))> epsilon || way==2 && it!=iteration );
        return x;
    }

    static double fifthpattern(double x) {
        return Math.sin(Math.exp(-x*x)) - 0.5;
    }

    static double derivedfifth(double x) { return -2.0 * x *( Math.exp(-x*x)) * (Math.cos(Math.exp(-x*x))); }

    static double doublederivedfifth(double x) {return Math.exp(-2*x*x) * (Math.exp(x*x)*(4*x*x-2)*
            Math.cos(Math.exp(-x*x))-4*x*x*Math.sin(Math.exp(-x*x)));}

}
