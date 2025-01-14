def shortest_path(grid):
    rows, cols = len(grid), len(grid[0])
    directions = [(0, 1), (1, 0)]  
    queue = [(0, 0, 0)]  
    visited = {(0, 0)}

    while queue:
        row, col, dist = queue.pop(0)
        if row == rows - 1 and col == cols - 1:
            return dist

        for dr, dc in directions:
            r, c = row + dr, col + dc
            if 0 <= r < rows and 0 <= c < cols and (r, c) not in visited:
                queue.append((r, c, dist + 1))
                visited.add((r, c))

    return -1 

rows = int(input("Enter the number of rows: "))
cols = int(input("Enter the number of columns: "))

grid = []
for i in range(rows):
    row = input(f"Enter row {i+1} values separated by space: ")
    grid.append([int(x) for x in row.split()])

print("Grid:")
for row in grid:
    print(row)

print("Shortest path:", shortest_path(grid))




