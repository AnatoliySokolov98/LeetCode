function robotSim(commands: number[], obstacles: number[][]): number {
  const obstacleSet = new Set<number>();
  for (const obstacle of obstacles) {
    obstacleSet.add(obstacle[0] + obstacle[1] * 40000);
  }

  const dirs = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let res = 0;
  let x = 0,
    y = 0;
  let dir = 0;

  for (const command of commands) {
    if (command === -1) {
      dir = (dir + 1) % 4;
    } else if (command === -2) {
      dir = (dir + 3) % 4;
    } else {
      const [dx, dy] = dirs[dir];
      for (let unused = 0; unused < command; unused++) {
        const newX = x + dx;
        const newY = y + dy;
        if (!obstacleSet.has(newX + newY * 40000)) {
          x = newX;
          y = newY;
          res = Math.max(res, x * x + y * y);
        } else {
          break;
        }
      }
    }
  }

  return res;
}
