cmake_minimum_required(VERSION 3.16)

#Ustawiono dodatkowo flagi debug generujące informację dla debuggera
set(CMAKE_BUILD_TYPE Debug)

#Ustaw nazwę projektu i język na C++
enable_language(CXX)
PROJECT(MetodyNumeryczne)

add_executable(MetodyNumeryczne
        main.cpp
        Funkcja1.cpp
        Funkcja2.cpp
        Trygonometryczna.cpp
        Wykladnicza.cpp
        Wielomian.cpp
        Model.cpp
        GaussCzebyszew.cpp
        NewtonCotes.cpp

        Funkcja1.h
        Funkcja2.h
        Trygonometryczna.h
        Wykladnicza.h
        Wielomian.h
        Model.h
        GaussCzebyszew.h
        NewtonCotes.h
        )

set (-Wall -Wpedantic -Wextra -Werror)