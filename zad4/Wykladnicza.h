#ifndef TEST_WYKLADNICZA_H
#define TEST_WYKLADNICZA_H

#include "Model.h"

class Wykladnicza : public Model
{

public:

    Wykladnicza();

    virtual ~Wykladnicza();

    double calculate(double x) override;

    std::string getName() override;
};


#endif //TEST_WYKLADNICZA_H
