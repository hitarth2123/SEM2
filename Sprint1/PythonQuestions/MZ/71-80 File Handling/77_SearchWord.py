filename = input("Enter the filename: ")
word = input("Enter the word to search: ")

try:
    with open(filename, 'r') as file:
        for num, line in enumerate(file, 1):
            if word in line:
                print(f"The word '{word}' appears in line {num}.")
except FileNotFoundError:
    print(f"The file '{filename}' was not found.")

