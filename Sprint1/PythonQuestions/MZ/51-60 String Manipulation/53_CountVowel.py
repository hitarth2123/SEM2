vowels = "aeiou"
count = 0
s = input("Enter a string: ")
for char in s:
    if char.lower() in vowels:
        count += 1
print("Number of vowels in the string: ", count)


