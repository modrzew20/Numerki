import math
import numpy as np
import matplotlib.pyplot as plt


def horner(factors, x, number_factors):
    result = factors[0]
    for i in range(1, number_factors):
        result = result * x + factors[i]
    return result


def funkcja(which, x):
    if which == 1: return 2 * math.cos(x + 1)
    if which == 2: return horner([1, 5, 3], x, 3)
    if which == 3: return 2 * math.cos(horner([1, 5, 3], x, 3) + 1)
    if which == 4: return pow(2, horner([1, 5, 3], x, 3) - 12)
    if which == 5: return pow(2, x) - 12


def wezel_czebyszewa(k, a, b, n):
    return 0.5 * (a + b) + 0.5 * (b - a) * math.cos(((2 * k) * math.pi) / (2 * n))


def wielomiany_czebyszewa(k, x):
    if k == 0: return 1
    if k == 1:
        return x
    else:
        return 2 * x * wielomiany_czebyszewa(k - 1, x) - wielomiany_czebyszewa(k - 2, x)


def wielomiany_czebyszewa2(k, x):
    if k == 0: return np.poly1d([1])
    if k == 1:
        return np.poly1d([1, 0])
    else:
        return np.poly1d([2, 0]) * wielomiany_czebyszewa2(k - 1, x) - wielomiany_czebyszewa2(k - 2, x)


def uklad_rownan(a, b, k, which):
    a_array = []
    wiersz = []
    for i in range(k):
        for j in range(k):
            wiersz.append(wielomiany_czebyszewa(j, wezel_czebyszewa(i, a, b, k)))
        a_array.append(wiersz)
        wiersz = []

    b_array = []
    for i in range(k):
        b_array.append(funkcja(which, wezel_czebyszewa(i, a, b, k)))
    x_array = np.linalg.solve(a_array, b_array)
    t_array = []
    for i in range(k):
        t_array.append(wielomiany_czebyszewa2(i, wezel_czebyszewa(i, a, b, k)))
    wielomian = np.poly1d([0])
    for i in range(len(t_array)):
        wielomian += t_array[i] * x_array[i]
    return wielomian


def graph(wielomian, a, b, which):
    axisX = np.arange(a, b, 0.01)
    axisY = []
    axisY2 = []
    for x in range(len(axisX)):
        axisY.append(wielomian(axisX[x]))
        axisY2.append(funkcja(which, axisX[x]))
    plt.plot(axisX, axisY, label="aproksymowana")
    plt.plot(axisX, axisY2, label="oryginalna")
    plt.legend()
    print(wielomian)
    print("Błąd końcowy: " + str(blad(axisY, axisY2)))
    plt.show()


def blad(axisY, axisY2):
    sum = 0
    for i in range(len(axisY)):
        sum += abs(axisY[i] - axisY2[i])
    return sum / len(axisY)


if __name__ == '__main__':

    while True:
        print("""Wybierz funkcje:
        1. 2cos(x + 1)
        2. x^2 + 5x + 3
        3. 2 * cos(x^2 + 5x + 1)
        4. 2^(x^2 + 5x -9)
        5. 2^x - 12
        """)
        which = int(input())
        print("1. Dobierz stopień automatycznie\n"
              "2. Wpisz stopień")
        stop = int(input())

        print("Podaj przedział:")
        a = int(input("Od: "))
        b = int(input("Do: "))
        if stop == 2:
            k = int(input("Podaj stopień: "))
            graph(uklad_rownan(a, b, k+1, which), a, b, which)

        else:
            k = float(input("Podaj błąd: "))
            bl = 0
            i = 1
            X = np.arange(a, b, 0.01)
            while True:
                wielomian = uklad_rownan(a, b, i, which)
                i += 1
                Y = []
                Y2 = []
                for x in range(len(X)):
                    Y.append(wielomian(X[x]))
                    Y2.append(funkcja(which, X[x]))
                bl = blad(Y, Y2)
                if k > bl:
                    break
            graph(uklad_rownan(a, b, i, which), a, b, which)

        cont = input("Czy chcesz kontyunować: (N)")
        if cont == "N": break
