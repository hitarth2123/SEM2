my_dict = {"a": 1, "b": 2, "c": 3}
print("Original Dictionary: ", my_dict)
inverted_dict = {v: k for k, v in my_dict.items()}
print("Inverted Dictionary: ", inverted_dict)
