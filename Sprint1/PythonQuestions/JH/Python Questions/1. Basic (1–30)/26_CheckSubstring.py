def check_substring(string, substring):
    if substring in string:
        return True
    else:
        return False

string = input("\nEnter a string: ")
substring = input("\nEnter a substring: ")
print(f"\n{substring} is present in {string} :",check_substring(string, substring))
