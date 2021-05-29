
#include "cmath"
#include "Wykladnicza.h"
#include <iostream>

Wykladnicza::Wykladnicza()
{
}

Wykladnicza::~Wykladnicza()
{
}

double Wykladnicza::calculate(double x)
{
    return pow(2, x) - 12;
}

std::string Wykladnicza::getName()
{
    return "2^x - 12";
}