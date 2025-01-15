import sys

# List comprehension
list_comp = [x**2 for x in range(1000000)]
print("List comprehension size:", sys.getsizeof(list_comp))

# Generator expression
gen_expr = (x**2 for x in range(1000000))
print("Generator expression size:", sys.getsizeof(gen_expr))
