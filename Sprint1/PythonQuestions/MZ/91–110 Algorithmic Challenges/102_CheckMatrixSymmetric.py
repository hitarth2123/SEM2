def is_symmetric(matrix):
    if len(matrix) != len(matrix[0]):
        return False
    
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] != matrix[j][i]:
                return False
    
    return True

n = int(input("Enter the size of the square matrix: "))
matrix = []
for i in range(n):
    row = list(map(int, input(f"Enter row {i + 1} (space-separated): ").split()))
    matrix.append(row)

if is_symmetric(matrix):
    print("The matrix is symmetric.")
else:
    print("The matrix is not symmetric.")


