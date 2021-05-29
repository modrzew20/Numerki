#ifndef TEST_FUNKCJA1_H
#define TEST_FUNKCJA1_H

#include "Model.h"

class Funkcja1 : public Model
{

public:

    Funkcja1();

    virtual ~Funkcja1();

    double calculate(double x) override;

    std::string getName() override;
};


#endif //TEST_FUNKCJA1_H
