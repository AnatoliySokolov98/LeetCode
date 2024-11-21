class Solution:
    def countUnguarded(
        self, m: int, n: int, guards: list[list[int]], walls: list[list[int]]
    ) -> int:
        # Initialize the grid
        matrix = [[0] * n for _ in range(m)]

        # Mark guards as 2 and walls as 3
        for guard in guards:
            matrix[guard[0]][guard[1]] = 2
        for wall in walls:
            matrix[wall[0]][wall[1]] = 3

        # Process rows for guard coverage
        for r in range(m):
            state = 0
            # Left to right
            for c in range(n):
                if matrix[r][c] == 2:  # Guard
                    state = 1
                elif matrix[r][c] == 3:  # Wall
                    state = 0
                else:  # Empty cell
                    matrix[r][c] |= state
            state = 0
            # Right to left
            for c in range(n - 1, -1, -1):
                if matrix[r][c] == 2:  # Guard
                    state = 1
                elif matrix[r][c] == 3:  # Wall
                    state = 0
                else:  # Empty cell
                    matrix[r][c] |= state

        # Process columns for guard coverage
        for c in range(n):
            state = 0
            # Top to bottom
            for r in range(m):
                if matrix[r][c] == 2:  # Guard
                    state = 1
                elif matrix[r][c] == 3:  # Wall
                    state = 0
                else:  # Empty cell
                    matrix[r][c] |= state
            state = 0
            # Bottom to top
            for r in range(m - 1, -1, -1):
                if matrix[r][c] == 2:  # Guard
                    state = 1
                elif matrix[r][c] == 3:  # Wall
                    state = 0
                else:  # Empty cell
                    matrix[r][c] |= state

        # Count unguarded cells
        res = 0
        for r in range(m):
            for c in range(n):
                if matrix[r][c] == 0:  # Empty and unguarded
                    res += 1

        return res
