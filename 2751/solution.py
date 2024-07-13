class Solution:
    def survivedRobotsHealths(
        self, positions: list[int], healths: list[int], directions: str
    ) -> list[int]:
        robots = sorted(
            [
                (positions[i], healths[i], directions[i], i)
                for i in range(len(positions))
            ]
        )
        stack = []

        for _, health, direction, index in robots:
            if direction == "R":
                stack.append([health, direction, index])
            else:
                while stack and stack[-1][1] == "R" and health:
                    last_robot = stack[-1]
                    if health > last_robot[0]:
                        health -= 1
                        stack.pop()
                    elif health < last_robot[0]:
                        stack[-1][0] -= 1
                        health = 0
                    else:
                        stack.pop()
                        health = 0

                if health:
                    stack.append([health, direction, index])

        stack.sort(key=lambda x: x[2])
        return [robot[0] for robot in stack]
