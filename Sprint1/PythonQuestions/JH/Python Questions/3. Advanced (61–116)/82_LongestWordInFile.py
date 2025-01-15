file_name = "82Question.txt"
with open(file_name, 'w') as file:
    python_topics = ['variables', 'data types', 'functions', 'loops', 'conditional statements', 'lists', 'tuples', 'dictionaries', 'sets', 'modules', 'classes', 'objects', 'inheritance', 'polymorphism', 'encapsulation', 'abstraction']
    for topic in python_topics:
        for _ in range(200 // len(python_topics)):
            file.write(f'This is a sentence about {topic} in Python.\n')
    for _ in range(20):
        file.write('Python is a great programming language.\n')

try:
    with open(file_name, "r") as file:
        words = file.read().split()
        longest_word = max(words, key=len)
        print(f"The longest word is '{longest_word}' with length {len(longest_word)}.")
except FileNotFoundError:
    print(f"The file '{file_name}' was not found.")
except Exception as e:
    print(f"An error occurred: {e}")
