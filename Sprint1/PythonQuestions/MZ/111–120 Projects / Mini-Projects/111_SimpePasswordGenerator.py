import random
import string

def generate_password(length):
    characters = string.ascii_letters + string.digits + string.punctuation
    return ''.join(random.choice(characters) for i in range(length))


length = int(input("Enter the length of the password: "))
password = generate_password(length)
print("Generated Password : ", password)




