with open("hell.txt", "w+") as file:
    user_input = input("\nPlease enter a string: ")
    file.write(user_input)
    file.close()

print("\nOutput written to hell.txt file contents:")

with open("hell.txt", "r") as file:
    print(file.read())   
    file.close()




