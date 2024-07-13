function survivedRobotsHealths(
  positions: number[],
  healths: number[],
  directions: string
): number[] {
  const n = positions.length;
  const robots: [number, number, string, number][] = [];
  for (let i = 0; i < n; i++) {
    robots.push([positions[i], healths[i], directions[i], i]);
  }
  robots.sort((a, b) => a[0] - b[0]);

  const stack: [number, string, number][] = [];
  for (const robot of robots) {
    let [_, health, direction, index] = robot;
    if (direction === "R") {
      stack.push([health, direction, index]);
    } else {
      while (
        stack.length > 0 &&
        stack[stack.length - 1][1] === "R" &&
        health > 0
      ) {
        const lastRobot = stack[stack.length - 1];
        if (health > lastRobot[0]) {
          health -= 1;
          stack.pop();
        } else if (health < lastRobot[0]) {
          stack[stack.length - 1][0] -= 1;
          health = 0;
        } else {
          stack.pop();
          health = 0;
        }
      }
      if (health > 0) {
        stack.push([health, direction, index]);
      }
    }
  }

  stack.sort((a, b) => a[2] - b[2]);

  return stack.map((robot) => robot[0]);
}
