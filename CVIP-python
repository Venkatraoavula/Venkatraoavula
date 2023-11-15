import string
import random

def generate_password(length, uppercase=True, lowercase=True, numbers=True, symbols=True):
    characters = ""
    if uppercase:
        characters += string.ascii_uppercase
    if lowercase:
        characters += string.ascii_lowercase
    if numbers:
        characters += string.digits
    if symbols:
        characters += string.punctuation

    if not characters:
        print("Error: No character types selected.")
        return

    password = ''.join(random.choice(characters) for _ in range(length))
    return password

def main():
    print("Random Password Generator")

    length = int(input("Enter password length: "))
    include_uppercase = input("Include uppercase letters? (y/n): ").lower() == 'y'
    include_lowercase = input("Include lowercase letters? (y/n): ").lower() == 'y'
    include_numbers = input("Include numbers? (y/n): ").lower() == 'y'
    include_symbols = input("Include symbols? (y/n): ").lower() == 'y'

    password = generate_password(length, include_uppercase, include_lowercase, include_numbers, include_symbols)

    if password:
        print("Generated Password:", password)
    else:
        print("No password generated. Please select at least one character type.")

if _name_ == "_main_":
    main()
