string = input("\nEnter a string: ").lower()
vowels = 'aeiou'
vowel_count = sum(1 for char in string if char in vowels)
print(f"\nNumber of vowels: {vowel_count}")