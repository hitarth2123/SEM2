def longest_common_subsequence(seq1, seq2):
    m = [[0] * (1 + len(seq2)) for i in range(1 + len(seq1))]
    for x in range(1, 1 + len(seq1)):
        for y in range(1, 1 + len(seq2)):
            if seq1[x - 1] == seq2[y - 1]:
                m[x][y] = m[x - 1][y - 1] + 1
            else:
                m[x][y] = max(m[x - 1][y], m[x][y - 1])
    lcs = []
    x, y = len(seq1), len(seq2)
    while x > 0 and y > 0:
        if seq1[x - 1] == seq2[y - 1]:
            lcs.append(seq1[x - 1])
            x -= 1
            y -= 1
        elif m[x - 1][y] > m[x][y - 1]:
            x -= 1
        else:
            y -= 1
    return ''.join(reversed(lcs))

seq1 = input("Enter the first sequence: ")
seq2 = input("Enter the second sequence: ")
result = longest_common_subsequence(seq1, seq2)
print("Longest common subsequence:", result)

