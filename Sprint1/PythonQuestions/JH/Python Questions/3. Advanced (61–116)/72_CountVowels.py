def count_vowels(s, idx=0):
    vowels = "aeiouAEIOU"
    if idx == len(s):
        return 0
    return (1 if s[idx] in vowels else 0) + count_vowels(s, idx + 1)

string = input("Enter a string: ")
print("Number of vowels:", count_vowels(string))
