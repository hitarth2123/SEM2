import random

def generate_password(length):
    characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+"
    password = ""
    for i in range(length):
        password += characters[random.randint(0, len(characters) - 1)]
    return password

length = int(input("Enter the length of the password: "))
password = generate_password(length)
print("\nGenerated Password : ", password)
