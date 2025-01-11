file_path = input("Enter the file path: ")

with open(file_path, 'r') as file:
    data = file.read()
    lines = data.split('\n')
    words = data.split()
    characters = sum(len(word) for word in words)
    unique_words = set(words)
    longest_line = max(lines, key=len)
    shortest_line = min(lines, key=len)

    print(f"Total characters: {characters}")
    print(f"Total lines: {len(lines)}")
    print(f"Total words: {len(words)}")
    print(f"Unique words: {len(unique_words)}")
    print(f"Longest line: {len(longest_line)} characters")
    print(f"Shortest line: {len(shortest_line)} characters")
    print(f"Average word length: {sum(len(word) for word in words) / len(words)}")
    print(f"Average line length: {sum(len(line) for line in lines) / len(lines)}")



