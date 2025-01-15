with open('source.txt', 'w') as file:
    file.write('pythonlearning')



with open('source.txt', 'r') as source:
    with open('destination.txt', 'w') as destination:
        destination.write(source.read())
