def generate_permutations(input_list):
    if len(input_list) == 1:
        return [input_list]
    result = []
    for i in range(len(input_list)):
        current = input_list[i]
        rest = input_list[:i] + input_list[i+1:]
        for p in generate_permutations(rest):
            result.append([current] + p)
    return result

input_list = list(map(int, input("Enter the list of distinct elements separated by spaces: ").split()))
print("Permutations of the list: ", generate_permutations(input_list))

