list1 = input("\nEnter the first list of elements (separated by spaces): ")
list2 = input("\nEnter the second list of elements (separated by spaces): ")
set1 = set(list1.split())
set2 = set(list2.split())
print("\nUnion:", set1.union(set2))
print("\nIntersection:", set1.intersection(set2))
print("\nDifference (set1 - set2):", set1.difference(set2))
print("\nDifference (set2 - set1):", set2.difference(set1))


