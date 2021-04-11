import copy


def checkMatrix(file):
    if len(file) < len(file[0]) - 1:
        return False
    matrixA = [[0] * (len(file[0]) - 1) for i in range(len(file))]
    for i in range(len(file)):
        if file[i][i] == 0:
            return False
    for row in range(len(file)):
        for column in range(len(file[0]) - 1):
            matrixA[row][column] = file[row][column]
    return matrixA


def change(file):
    for i in range(len(file)):
        if file[i][i] == 0:
            j = 0
            while (j < len(file)):
                if file[j][i] != 0:
                    m = file[i]
                    file[i] = file[j]
                    file[j] = m
                    j = len(file)
                j += 1
    return file


def check_convergence(matrix):
    sum = 0
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            sum += abs(matrix[i][j])
        sum = sum - abs(matrix[i][i])
        if matrix[i][i] < sum:
            print(sum)
            return False
        sum=0
    return True


def multi_matrix(firstmatrix, secondmatrix):
    resultmatrix = [[0] * (len(firstmatrix[0])) for i in range(len(firstmatrix))]
    for i in range(len(firstmatrix)):
        for j in range(len(firstmatrix[0])):
            for k in range(len(secondmatrix)):
                resultmatrix[i][j] += firstmatrix[i][k] * secondmatrix[k][j]
    return resultmatrix


def count(digit, way, file, matrixA):
    matrixB = [0] * len(file)
    for row in range(len(file)):
        matrixB[row] = file[row][len(file[0]) - 1]

    matrixN = [[0] * (len(file[0]) - 1) for i in range(len(file))]
    for i in range(len(matrixN)):
        matrixN[i][i] = 1 / matrixA[i][i]

    matrixLU = copy.deepcopy(matrixA)
    for i in range(len(matrixLU)):
        matrixLU[i][i] = 0

    matrixM = multi_matrix(matrixN, matrixLU)
    for row in range(len(matrixM)):
        for column in range(len(matrixM[0])):
            matrixM[row][column] = -1 * matrixM[row][column]
    previousresultx = [1] * len(file)
    resultx = [0] * len(file)

    # way
    # false - difference between result and previous result
    # true - iteration
    iteration = 0
    filewrite = open("./results.csv", "a")

    filewrite.write("\nNOWA\n")

    while (abs(sum(resultx) - sum(previousresultx)) / len(previousresultx)) > digit and not way or digit != 0 and way:
        iteration += 1
        if way:
            digit -= 1
        filewrite.write("\n" + str(iteration) + ",")

        for i in range(len(resultx)):
            previousresultx[i] = resultx[i]

        for i in range(len(resultx)):
            resultx[i] = matrixN[i][i] * matrixB[i]
            for j in range(len(resultx)):
                resultx[i] += matrixM[i][j] * previousresultx[j]
        for i in range(len(resultx)):
            if i == len(resultx):
                filewrite.write(str(resultx[i]) + "\n")
            else:
                filewrite.write(str(resultx[i]) + ",")

    filewrite.close()
    return resultx, iteration
