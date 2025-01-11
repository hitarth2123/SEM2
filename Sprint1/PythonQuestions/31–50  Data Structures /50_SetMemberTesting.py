names = {"Alice", "Bob", "Charlie", "David"}
name = input("Enter a name: ")
if name in names:
    print(f"{name} is in the set.")
else:
    print(f"{name} is not in the set.")