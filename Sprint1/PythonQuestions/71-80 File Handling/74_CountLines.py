with open('file.txt', 'r') as file:
    lines = file.readlines()
    print(len(lines))
    file.close()
