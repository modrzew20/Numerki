#ifndef TEST_GAUSSCZEBYSZEW_H
#define TEST_GAUSSCZEBYSZEW_H

#include "Model.h"

class GaussCzebyszew
{
public:

    static double intergrate(int numberOfNodes, Model &f);
};


#endif //TEST_GAUSSCZEBYSZEW_H
