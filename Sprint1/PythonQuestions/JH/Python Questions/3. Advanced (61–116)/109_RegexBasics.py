import re

text = "Contact us at support@example.com or sales@mywebsite.org."

emails = re.findall(r'[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}', text)
print("Email addresses found:", emails)
