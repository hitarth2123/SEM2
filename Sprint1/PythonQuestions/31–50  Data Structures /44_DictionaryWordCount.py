user_string = input("Please enter a string: ")
print("Input String: ", user_string)
words = user_string.split()
word_count_dict = {}
for word in words:
    if word in word_count_dict:
        word_count_dict[word] += 1
    else:
        word_count_dict[word] = 1
print("Word Count Dictionary: ", word_count_dict)



