//
// Created by Mateusz on 11.05.2021.
//

#include "Trygonometryczna.h"
#include "cmath"


Trygonometryczna::Trygonometryczna()
{
}

Trygonometryczna::~Trygonometryczna()
{
}

double Trygonometryczna::calculate(double x)
{
    return 2*cos(x+1);
}

std::string Trygonometryczna::getName()
{
    return "2cos(x + 1)";
}