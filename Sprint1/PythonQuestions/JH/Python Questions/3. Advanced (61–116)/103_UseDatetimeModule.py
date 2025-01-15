from datetime import datetime

now = datetime.now()

formatted = now.strftime("%Y-%m-%d %H:%M:%S")
print(f"Current date and time: {formatted}")
