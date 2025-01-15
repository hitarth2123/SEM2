import json

file_path = "data.json"

with open(file_path, 'r') as file:
    data = json.load(file)

data['key'] = 'new_value'

with open(file_path, 'w') as file:
    json.dump(data, file, indent=4)

print("JSON file updated successfully!")
