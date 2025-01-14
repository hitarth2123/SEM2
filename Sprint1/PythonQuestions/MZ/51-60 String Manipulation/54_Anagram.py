def check_anagram(str1, str2):
    str1 = str1.replace(" ", "").lower()
    str2 = str2.replace(" ", "").lower()
    return sorted(str1) == sorted(str2)

str1 = input("Enter the first string: ")
str2 = input("Enter the second string: ")
if check_anagram(str1, str2):
    print("The strings are anagrams.")
else:
    print("The strings are not anagrams.")

