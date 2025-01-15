def add_matrices(mat1, mat2):
    result = [[mat1[i][j] + mat2[i][j]  for j in range(len(mat1[0]))] for i in range(len(mat1))]
    return result

rows_mat1 = int(input("\nEnter the number of rows for matrix 1: "))
cols_mat1 = int(input("\nEnter the number of columns for matrix 1: "))
mat1 = [[int(input(f"\nEnter element for row {i+1}, column {j+1} of matrix 1: ")) for j in range(cols_mat1)] for i in range(rows_mat1)]
rows_mat2 = int(input("\nEnter the number of rows for matrix 2: "))
cols_mat2 = int(input("\nEnter the number of columns for matrix 2: "))
mat2 = [[int(input(f"\nEnter element for row {i+1}, column {j+1} of matrix 2: ")) for j in range(cols_mat2)] for i in range(rows_mat2)]
print("\nMatrix 1:")
for row in mat1:
    print(row)
print("\nMatrix 2:")
for row in mat2:
    print(row)

result = add_matrices(mat1, mat2)
print("\nResult Matrix :")
for row in result:
    print(row)

