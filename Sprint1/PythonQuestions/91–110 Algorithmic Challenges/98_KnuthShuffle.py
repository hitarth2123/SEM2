import random

def knuth_shuffle(lst):
    n = len(lst)
    for i in range(n-1, 0, -1):
        j = random.randint(0, i)
        lst[i], lst[j] = lst[j], lst[i]
    return lst

def get_user_input():
    user_input = input("Enter a list of elements (space-separated): ")
    lst = user_input.split()
    return lst


lst = get_user_input()
print("Original List:", lst)
knuth_shuffle(lst)
print("Shuffled List:", lst)



