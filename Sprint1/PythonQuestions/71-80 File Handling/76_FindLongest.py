with open('file.txt', 'r') as file:
    lines = file.readlines()
    longest_line = max(lines, key=len)
    print(longest_line.strip())

