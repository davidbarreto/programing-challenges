from random import randint
from random import choices

def main(totalGenerated, minMatrixSize, maxMatrixSize, probabilityOfOnes):

    print(totalGenerated)
    for _ in range(totalGenerated):
        matrixSize = randint(minMatrixSize, maxMatrixSize)
        
        matrix = generateMatrix(matrixSize, probabilityOfOnes)
        maxPath = buildMaxPath(matrixSize, matrix)
        x1, y1, x2, y2 = extractStartAndLastPosition(maxPath)

        print(matrixSize)
        printMatrix(matrix)
        print(x1, y1)
        print(x2, y2)

def generateMatrix(matrixSize, probabilityOfOnes):
    
    matrix = []
    population = [0, 1]
    probabilities = [1-probabilityOfOnes, probabilityOfOnes]

    for _ in range(matrixSize):
        row = []
        for _ in range(matrixSize):
            row.append(choices(population, probabilities)[0])
        matrix.append(row)

    return matrix

def buildMaxPath(matrixSize, matrix):

    visited = {}
    paths = []
    for i in range(matrixSize):
        for j in range(matrixSize):
            path = []
            dfs(matrix, matrixSize, path, visited, i, j)
            #print(f'Path for {i} {j} = {path}')
            #visited = {}
            paths.append(path)

    return max(paths, key=len)
    
def dfs(matrix, matrixSize, path, visited, x, y):
    
    if not isValid(matrixSize, x, y):
        return
    
    if matrix[x][y] == 1:
        return

    pair = (x, y)
    if pair in visited:
        return
    
    visited[pair] = True
    path.append(pair)

    maxNeighborPath = []
    for i, j in neighbors(x, y):
        neighborPath = []
        dfs(matrix, matrixSize, neighborPath, visited, i, j)

        if len(neighborPath) > len(maxNeighborPath):
            maxNeighborPath = neighborPath

    path = path.extend(maxNeighborPath)

def extractStartAndLastPosition(path):
    return (*path[0], *path[-1])

def printMatrix(matrix):
    for i in matrix:
        print(' '.join(map(str, i)))

def generateKey(a, b):
    return str(a) + ";" + str(b)

def isValid(n, a, b):
    return (a >= 0 and b >= 0 and a < n and b < n)

def neighbors(a, b):
    return [(a+1, b), (a, b+1), (a-1, b), (a, b-1)]

main(3, 300, 500, 0.6)