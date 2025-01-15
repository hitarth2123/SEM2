with open('data.csv', 'w') as file:
    file.write('Name, Age, City\n')
    for i in range(20):
        file.write(f'Name {i}, Age {i}, City {i}\n')

with open('data.csv', 'r') as file:
    for row in file:
        print(row.strip().split(','))





