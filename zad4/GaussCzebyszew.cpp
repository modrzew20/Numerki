#define _USE_MATH_DEFINES
#include <math.h>
#include "GaussCzebyszew.h"


double GaussCzebyszew::intergrate(int numberOfNodes, Model &f)
{
    double result = 0;
    double Ai;
    double node;

    for(int i = 0; i<=numberOfNodes; i++)
    {
        Ai = M_PI / (numberOfNodes + 1);
        node = cos( ((2 * i + 1) * M_PI) / (2 * numberOfNodes + 2) );
        result = result + Ai * f.calculate(node);
    }

    return result;
}