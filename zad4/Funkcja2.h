#ifndef TEST_FUNKCJA2_H
#define TEST_FUNKCJA2_H

#include "Model.h"

class Funkcja2 : public Model
{

public:

    Funkcja2();

    virtual ~Funkcja2();

    double calculate(double x) override;

    std::string getName() override;

};


#endif //TEST_FUNKCJA2_H
