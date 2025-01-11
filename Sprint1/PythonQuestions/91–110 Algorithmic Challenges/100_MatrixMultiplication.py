rows1 = int(input("Enter the number of rows for the first matrix: "))
cols1 = int(input("Enter the number of columns for the first matrix: "))
rows2 = int(input("Enter the number of rows for the second matrix: "))
cols2 = int(input("Enter the number of columns for the second matrix: "))

if cols1 != rows2:
    print("The matrices cannot be multiplied.")
   

matrix1 = []
for i in range(rows1):
    row = []
    for j in range(cols1):
        row.append(int(input(f"Enter element [{i+1}][{j+1}] of the first matrix: ")))
    matrix1.append(row)

matrix2 = []
for i in range(rows2):
    row = []
    for j in range(cols2):
        row.append(int(input(f"Enter element [{i+1}][{j+1}] of the second matrix: ")))
    matrix2.append(row)

result = [[0 for _ in range(cols2)] for _ in range(rows1)]
for i in range(rows1):
    for j in range(cols2):
        for k in range(cols1):
            result[i][j] += matrix1[i][k] * matrix2[k][j]

print("The result of the matrix multiplication is:")
for row in result:
        print(row)





