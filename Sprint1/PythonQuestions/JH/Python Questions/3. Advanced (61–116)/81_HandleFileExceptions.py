file_name = input("Enter the file name: ")

try:
    with open(file_name, "r") as file:
        print("File contents:")
        print(file.read())
except FileNotFoundError:
    print(f"The file '{file_name}' was not found.")
except Exception as e:
    print(f"An error occurred: {e}")
