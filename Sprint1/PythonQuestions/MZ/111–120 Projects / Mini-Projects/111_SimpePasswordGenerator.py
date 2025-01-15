import random

def generate_password(length):
    characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+"
    return ''.join(random.choice(characters) for i in range(length))


length = int(input("Enter the length of the password: "))
password = generate_password(length)
print("Generated Password : ", password)



