text = input("Enter some text to append to the file: ")
with open('output.txt', 'a') as file:
    file.write(text + "\n")
file.close()
with open('output.txt', 'r') as file:
    print(file.read())
file.close()

