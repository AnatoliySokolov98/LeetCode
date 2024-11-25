from collections import deque


class Solution:
    def slidingPuzzle(self, board: list[list[int]]) -> int:
        # Convert board into a string for easier manipulation
        start = "".join(str(num) for row in board for num in row)
        target = "123450"

        # Define the possible moves based on zero's index
        moves = {0: [1, 3], 1: [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}

        # BFS initialization
        queue = deque([start])
        visited = set([start])
        steps = 0

        while queue:
            for _ in range(len(queue)):
                current = queue.popleft()

                # If we reach the target state, return the number of steps
                if current == target:
                    return steps

                # Find the position of '0' (empty space)
                zero_index = current.index("0")

                # Generate new states by swapping '0' with its possible moves
                for move in moves[zero_index]:
                    new_state = list(current)
                    new_state[zero_index], new_state[move] = (
                        new_state[move],
                        new_state[zero_index],
                    )
                    new_state_str = "".join(new_state)

                    # Add new state to queue if not visited
                    if new_state_str not in visited:
                        visited.add(new_state_str)
                        queue.append(new_state_str)

            # Increment step count after processing all nodes at the current level
            steps += 1

        # If we exhaust the queue without finding the target state, return -1
        return -1
