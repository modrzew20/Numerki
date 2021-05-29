#ifndef METODY_NUMERYCZNE_NEWTONCOTES_H
#define METODY_NUMERYCZNE_NEWTONCOTES_H

#include "Model.h"

class NewtonCotes
{
public:

    static double intergrate(double epsilon, Model &f);

    static double simpson(Model &f, double epsilon, double start, double end);

    static double VOFMBW(double valueOfF, double x);
};


#endif //METODY_NUMERYCZNE_NEWTONCOTES_H
