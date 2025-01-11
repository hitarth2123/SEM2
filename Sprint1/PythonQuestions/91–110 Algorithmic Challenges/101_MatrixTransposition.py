def get_user_input():
    rows = int(input("Enter the number of rows: "))
    cols = int(input("Enter the number of columns: "))
    matrix = []
    for i in range(rows):
        row = []
        for j in range(cols):
            val = int(input(f"Enter element [{i+1}][{j+1}]: "))
            row.append(val)
        matrix.append(row)
    return matrix

def transpose_matrix(matrix):
    transposed = [[matrix[j][i] for j in range(len(matrix))] for i in range(len(matrix[0]))]
    return transposed


matrix = get_user_input()
print("Original Matrix:")
for row in matrix:
        print(row)
transposed = transpose_matrix(matrix)
print("Transposed Matrix:")
for row in transposed:
        print(row)




