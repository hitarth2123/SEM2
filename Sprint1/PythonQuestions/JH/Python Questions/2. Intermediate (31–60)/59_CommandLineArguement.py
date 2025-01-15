import sys
print("Command-line arguments:")
for arg in sys.argv:
    print(arg)
    print(arg[:2])
    print(arg[2:])
