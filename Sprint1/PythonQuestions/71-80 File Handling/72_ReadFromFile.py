file = open("output.txt", "w") 
file.write("Some rough data")
file.close()

file = open("output.txt", "r") 
content = file.read()
print(content)
file.close()



