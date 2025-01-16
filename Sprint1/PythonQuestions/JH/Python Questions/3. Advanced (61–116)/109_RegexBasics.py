import re

text = input("Enter the text: ")
emails = re.findall(r'[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}', text)
if emails:
    print("Email addresses found:", emails)
else:
    print("No email addresses found")
