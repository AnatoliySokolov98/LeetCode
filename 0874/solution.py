class Solution:
    def robotSim(self, commands: list[int], obstacles: list[list[int]]) -> int:
        obstacle_set = {(x, y) for x, y in obstacles}
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        max_distance = 0
        x, y = 0, 0
        direction_index = 0

        for command in commands:
            if command == -2:
                direction_index = (direction_index - 1) % 4
            elif command == -1:
                direction_index = (direction_index + 1) % 4
            else:
                dx, dy = directions[direction_index]
                for _ in range(command):
                    if (x + dx, y + dy) not in obstacle_set:
                        x += dx
                        y += dy
                        max_distance = max(max_distance, x * x + y * y)
                    else:
                        break

        return max_distance
