
#include "Funkcja2.h"
#include "Wielomian.h"
#include "cmath"


Funkcja2::Funkcja2()
{
}

Funkcja2::~Funkcja2()
{
}

double Funkcja2::calculate(double x)
{
    double factors[] = {1, 5, 3}; // x^2 + 5x + 3
    return pow(2, Wielomian::horner(factors, x, 3)) - 12;
}

std::string Funkcja2::getName()
{
    return "2^(x^2 + 5x + 3) - 12";
}