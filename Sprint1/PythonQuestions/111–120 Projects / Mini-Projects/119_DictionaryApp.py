import requests

def get_definition(word):
    api_url = f"https://api.dictionaryapi.dev/api/v2/entries/en/{word}"
    response = requests.get(api_url)
    if response.status_code == 200:
        data = response.json()
        definition = data[0]['meanings'][0]['definitions'][0]['definition']
        return definition
    else:
        return "Word not found"


print("Welcome to the Dictionary App!")
    
word = input("Enter a word to look up (or 'q' to quit): ")
if word.lower() == 'q': quit();
definition = get_definition(word)
print(f"{word}: {definition}")



