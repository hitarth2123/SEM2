list1 = input("Enter the first list of elements (separated by spaces): ")
list2 = input("Enter the second list of elements (separated by spaces): ")
set1 = set(list1.split())
set2 = set(list2.split())
print("Union:", set1.union(set2))
print("Intersection:", set1.intersection(set2))
print("Difference (set1 - set2):", set1.difference(set2))
print("Difference (set2 - set1):", set2.difference(set1))


