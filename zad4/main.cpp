#include <iostream>
#include "Funkcja1.h"
#include "NewtonCotes.h"
#include "GaussCzebyszew.h"
#include "Wielomian.h"
#include "Trygonometryczna.h"
#include "Wykladnicza.h"
#include "Funkcja2.h"
#include <iomanip>

using namespace std;

int main()
{
    cout << "Witaj w programie!" << endl;

    Wielomian wielomian;
    Trygonometryczna trygonometryczna;
    Wykladnicza wykladnicza;
    Funkcja1 funkcja1;
    Funkcja2 funkcja2;

    Model *funtions[] = {&wielomian, &trygonometryczna, &wykladnicza, &funkcja1, &funkcja2};

    int choosenNumber;
    cout << "Wybierz funkcje:" <<endl;
    for(int i=0; i<5; i++)
    {
        cout << i << ". " << funtions[i]->getName() << endl;
    }
    cin >> choosenNumber;

    cout << "Podaj dokladnosc:" <<endl;
    double epsilon;
    cin >> epsilon;

    cout << std::setprecision(10);
    cout << "Newton-Cotes: " <<  NewtonCotes::intergrate(epsilon, *funtions[choosenNumber]) << endl;
    cout << "Gauss-Czebyszew 2 : " << GaussCzebyszew::intergrate(2, *funtions[choosenNumber]) <<endl;
    cout << "Gauss-Czebyszew 3 : " << GaussCzebyszew::intergrate(3, *funtions[choosenNumber]) <<endl;
    cout << "Gauss-Czebyszew 4 : " << GaussCzebyszew::intergrate(4, *funtions[choosenNumber]) <<endl;
    cout << "Gauss-Czebyszew 5 : " << GaussCzebyszew::intergrate(5, *funtions[choosenNumber]) <<endl;

    return 0;
}