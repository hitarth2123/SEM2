
import json

def create_json_file(file_path):
    data = {
        "name": "John",
        "age": 30,
        "city": "New York"
    }
    with open(file_path, 'w') as file:
        json.dump(data, file, indent=4)

def update_json_file(file_path, key, new_value):
    with open(file_path, 'r+') as file:
        data = json.load(file)
        data[key] = new_value
        file.seek(0)
        json.dump(data, file, indent=4)
        file.truncate()




file_path = 'example.json'
create_json_file(file_path)
update_json_file(file_path, 'age', 31)


with open(file_path, 'r') as file:
    data = json.load(file)
    print("\nUser Output:")
    for key, value in data.items():
        print(f"{key}: {value}")




