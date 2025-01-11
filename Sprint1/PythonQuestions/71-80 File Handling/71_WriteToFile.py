with open("output.txt", "w+") as file:
    user_input = input("Please enter a string: ")
    file.write(user_input)
    file.close()

print("Output written to output.txt. File contents:")

with open("output.txt", "r") as file:
    print(file.read())   
    file.close()




