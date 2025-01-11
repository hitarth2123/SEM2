sentence = input("Please enter a sentence: ")
words = sentence.split()
longest_word = max(words, key=len)
print("The longest word is:", longest_word)


