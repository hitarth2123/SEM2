class ContactBook:
    def __init__(self, filename):
        self.filename = filename
        self.contacts = self.load_contacts()

    def load_contacts(self):
        try:
            with open(self.filename, 'r') as file:
                return eval(file.read())
        except FileNotFoundError:
            return []

    def save_contacts(self):
        with open(self.filename, 'w') as file:
            file.write(str(self.contacts))

    def add_contact(self, name, number, email):
        self.contacts.append({
            'name': name,
            'number': number,
            'email': email
        })
        self.save_contacts()

    def search_contact(self, name):
        for contact in self.contacts:
            if contact['name'] == name:
                return contact
        return None


contact_book = ContactBook('contacts.txt')
while True:
    print("1. Add Contact")
    print("2. Search Contact")
    print("3. Exit")
    choice = input("Enter your choice: ")
    if choice == '1':
        name = input("Enter name: ")
        number = input("Enter number: ")
        email = input("Enter email: ")
        contact_book.add_contact(name, number, email)
    elif choice == '2':
        name = input("Enter name to search: ")
        contact = contact_book.search_contact(name)
        if contact:
            print("Name:", contact['name'])
            print("Number:", contact['number'])
            print("Email:", contact['email'])
        else:
            print("Contact not found")
    elif choice == '3':
        break
    else:
        print("Invalid choice")



