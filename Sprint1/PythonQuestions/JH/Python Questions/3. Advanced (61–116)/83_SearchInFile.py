substring = input("Enter the substring to search for: ")
file_name = "83Question.txt"
with open(file_name, 'w') as file:
    python_topics = ['variables', 'data types', 'functions', 'loops', 'conditional statements', 'lists', 'tuples', 'dictionaries', 'sets', 'modules', 'classes', 'objects', 'inheritance', 'polymorphism', 'encapsulation', 'abstraction']
    for topic in python_topics:
        for _ in range(1):
            file.write(f'This is a sentence about {topic} in Python.\n')
    for _ in range(1):
        file.write('Python is a great programming language.\n')
try:
    with open(file_name, "r") as file:
        lines = file.readlines()
        for i, line in enumerate(lines, start=1):
            if substring in line:
                print(f"Substring found on line {i}: {line.strip()}")
except FileNotFoundError:
    print(f"The file '{file_name}' was not found.")
except Exception as e:
    print(f"An error occurred: {e}")
