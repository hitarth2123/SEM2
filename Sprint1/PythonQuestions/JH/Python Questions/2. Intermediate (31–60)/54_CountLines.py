with open('file.txt', 'w') as file:
    for i in range(20):
        file.write(f"This is line {i+1}\n")


with open('file.txt', 'r') as file:
    lines = file.readlines()
    print(len(lines))
    file.close()
