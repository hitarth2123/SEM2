
def find_and_replace(file_name, old_word, new_word):
    with open(file_name, 'r') as file:
        file_data = file.read()
    
    file_data = file_data.replace(old_word, new_word)
    
    with open(file_name, 'w') as file:
        file.write(file_data)
        
        

with open('python_data.txt', 'w') as file:
    python_topics = ['variables', 'data types', 'functions', 'loops', 'conditional statements', 'lists', 'tuples', 'dictionaries', 'sets', 'modules', 'classes', 'objects', 'inheritance', 'polymorphism', 'encapsulation', 'abstraction']
    for topic in python_topics:
            file.write(f'This is a sentence about {topic} in Python.\n')
    file.write('Python is a great programming language.\n')


file_name = 'python_data.txt'
old_word = input("\nEnter the word to replace: ")
new_word = input("\nEnter the new word: ")
find_and_replace(file_name, old_word, new_word)

print("\nFile updated successfully!")



