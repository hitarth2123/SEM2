try:
    with open('source.txt', 'r') as source:
        with open('destination.txt', 'w') as destination:
            destination.write(source.read())
except FileNotFoundError:
    print("Source file does not exist.")
