#ifndef TEST_MODEL_H
#define TEST_MODEL_H

#include "string"

class Model
{
    public:

    Model();

    virtual ~Model();

    virtual double calculate(double x) = 0;

    virtual std::string getName() = 0;
};


#endif //TEST_MODEL_H
