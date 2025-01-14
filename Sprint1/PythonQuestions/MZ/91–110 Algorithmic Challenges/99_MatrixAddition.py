rows_matrix1 = int(input("Enter number of rows for matrix 1: "))
cols_matrix1 = int(input("Enter number of columns for matrix 1: "))
matrix1 = []
for i in range(rows_matrix1):
    row = []
    for j in range(cols_matrix1):
        element = int(input(f"Enter element at position ({i},{j}) for matrix 1: "))
        row.append(element)
    matrix1.append(row)

rows_matrix2 = int(input("Enter number of rows for matrix 2: "))
cols_matrix2 = int(input("Enter number of columns for matrix 2: "))
matrix2 = []
for i in range(rows_matrix2):
    row = []
    for j in range(cols_matrix2):
        element = int(input(f"Enter element at position ({i},{j}) for matrix 2: "))
        row.append(element)
    matrix2.append(row)

if len(matrix1) != len(matrix2) or len(matrix1[0]) != len(matrix2[0]):
    print("Matrices must have the same dimensions for addition.")
else:
    result = []
    for i in range(len(matrix1)):
        row = []
        for j in range(len(matrix1[0])):
            row.append(matrix1[i][j] + matrix2[i][j])
        result.append(row)
    print("The sum of the two matrices is:")
    for row in result:
        print(row)
