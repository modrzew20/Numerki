//
// Created by Mateusz on 11.05.2021.
//

#include "Wielomian.h"

Wielomian::Wielomian()
{
}

Wielomian::~Wielomian()
{
}

double Wielomian::calculate(double x)
{
    double factors[] = {1, 5, 3};
    return horner(factors, x, 3);
}

std::string Wielomian::getName()
{
    return "x^2 + 5x + 3";
}

double Wielomian::horner(double* factors, double x, double numberOfFactors)
{
    double result = factors[0];
    for(int i=1; i<numberOfFactors; i++)
    {
        result = result * x + factors[i];
    }
    return result;
}