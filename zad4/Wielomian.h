#ifndef TEST_WIELOMIAN_H
#define TEST_WIELOMIAN_H

#include "Model.h"

class Wielomian : public Model
{

public:

    Wielomian();

    virtual ~Wielomian();

    double calculate(double x) override;

    std::string getName() override;

    static double horner(double* factors, double x, double numberOfFactors);

};


#endif //TEST_WIELOMIAN_H
