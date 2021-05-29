#ifndef TEST_TRYGONOMETRYCZNA_H
#define TEST_TRYGONOMETRYCZNA_H

#include "Model.h"

class Trygonometryczna : public Model
{

public:

    Trygonometryczna();

    virtual ~Trygonometryczna();

    double calculate(double x) override;

    std::string getName() override;
};


#endif //TEST_TRYGONOMETRYCZNA_H
