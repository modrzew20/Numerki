#include "Funkcja1.h"
#include "Wielomian.h"
#include "cmath"

Funkcja1::Funkcja1()
{
}

Funkcja1::~Funkcja1()
{
}

double Funkcja1::calculate(double x)
{
    double factors[] = {1, 5, 3}; // x^2 + 5x + 3
    return 2*cos(Wielomian::horner(factors, x, 3)+1);
}

std::string Funkcja1::getName()
{
    return "2 * cos((x^2 + 5x + 3)+1)";
}