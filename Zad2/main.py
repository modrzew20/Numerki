import pandas as pd
import copy

from numpy import double


def checkMatrix(matrix):
    for i in range(len(matrix)):
        if matrix[i][i] == 0:
            print("matrix A has zeros on its main diagonal.")
            return False
    return True

def multi_matrix(firstmatrix, secondmatrix):
    resultmatrix = [[0] * (len(firstmatrix[0])) for i in range(len(firstmatrix))]
    for i in range(len(firstmatrix)):
        for j in range(len(firstmatrix[0])):
            for k in range(len(secondmatrix)):
                resultmatrix[i][j] += firstmatrix[i][k] * secondmatrix[k][j]
    return resultmatrix


filee = pd.read_csv("C:\\Users\\kot\\PycharmProjects\\pythonProject\\wspolczyniki", header=None)
file = filee.values.tolist()

for row in range(len(file)):
    for column in range(len(file[0])):
        file[row][column] = double(file[row][column])

print(file)
matrixA = [[0] * (len(file[0]) - 1) for i in range(len(file))]
for row in range(len(file)):
    for column in range(len(file[0]) - 1):
        matrixA[row][column] = file[row][column]

if checkMatrix(matrixA):
    matrixB = [0] * len(file)
    for row in range(len(file)):
        matrixB[row] = file[row][len(file[0]) - 1]

    matrixN = [[0] * (len(file[0]) - 1) for i in range(len(file))]
    for i in range(len(matrixN)):
        matrixN[i][i] = 1 / matrixA[i][i]

    matrixLU = copy.copy(matrixA)
    for i in range(len(matrixLU)):
        matrixLU[i][i] = 0

    matrixM = multi_matrix(matrixN, matrixLU)
    for row in range(len(matrixM)):
        for column in range(len(matrixM[0])):
            matrixM[row][column] = -1 * matrixM[row][column]

    previousresultx = [1] * len(file)
    resultx = [0] * len(file)
    iteration = 10
    precision = 0.001
    way = False

    #way
    #false - difference between result and previous result
    #true - iteration

    while (abs(resultx[0] - previousresultx[0])) > precision and not way or iteration != 0 and way:
        iteration -= 1
        for i in range(len(resultx)):
            previousresultx[i] = resultx[i]
        for i in range(len(resultx)):
            resultx[i] = matrixN[i][i] * matrixB[i]
            for j in range(len(resultx)):
                resultx[i] += matrixM[i][j] * previousresultx[j]
    print(resultx)