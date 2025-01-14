with open('input.txt', 'r') as file:
    lines = file.readlines()
    file.close()
with open('output.txt', 'w') as file:
    for line in lines:
        if line.strip():
            file.write(line)
    file.close()
with open('output.txt', 'r') as file:
    print(file.read())
    file.close()
