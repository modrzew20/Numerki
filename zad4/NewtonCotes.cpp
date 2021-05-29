//
// Created by Mateusz on 11.05.2021.
//

#include "NewtonCotes.h"
#include "cmath"


double NewtonCotes::intergrate(double epsilon, Model &f)
{
    double result = 0;
    double previousResult;

    // ------------------- od 0 do 1 ------------------- //
    double start = 0;
    double end = 0.5;
    do
    {
        previousResult = result;
        result = result + simpson(f, epsilon, start, end);
        start = end;
        end = (1 + end) / 2;
    }
    while(fabs(result - previousResult) > epsilon);

    // ------------------- od 0 do 1 ------------------- //
    start = -0.5;
    end = 0.0;
    do
    {
        previousResult = result;
        result = result + simpson(f, epsilon, start, end);
        end = start;
        start = (start - 1) / 2;
    }
    while(fabs(result - previousResult) > epsilon);

    return result;
}

double NewtonCotes::simpson(Model &f, double epsilon, double start, double end)
{
    double result = 0;
    double previousResult;
    int n = 2;

    do
    {
        previousResult = result;

        double lengthOfSection = (end - start)/n;
        result = VOFMBW(f.calculate(start), start) + VOFMBW(f.calculate(end), start);
        for(int i=1; i<=n-1; i++)
        {
            if(i%2 == 0)
            {
                result = result + 4 * VOFMBW(
                                f.calculate(start + i * lengthOfSection),
                                start + i * lengthOfSection);
            }
            else
            {
                result = result + 2 * VOFMBW(
                                f.calculate(start + i * lengthOfSection),
                                start + i * lengthOfSection);
            }
        }
        result = lengthOfSection * result/3;

        n = n * 2;
    }
    while (epsilon < fabs(result - previousResult));

    return result;
}

double NewtonCotes::VOFMBW(double valueOfF, double x) // value Of F(x) Multiplied By Weight
{
    return valueOfF * (1 / sqrt(1 - (x * x)));
}