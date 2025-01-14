s = input("Enter a string: ")
frequency = {}
for char in s:
    if char in frequency:
        frequency[char] += 1
    else:
        frequency[char] = 1
print("Character Frequency:")
for char, count in frequency.items():
    print(f"{char}: {count}")




