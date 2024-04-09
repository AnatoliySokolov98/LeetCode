function leastBricks(wall: number[][]): number {
  const counts = new Map<number, number>();
  for (let row of wall) {
    let total = 0;
    for (let i = 0; i < row.length - 1; i++) {
      total += row[i];
      if (!counts.has(total)) {
        counts.set(total, 0);
      }
      counts.set(total, counts.get(total)! + 1);
    }
  }

  let res = 0;
  for (let val of counts.values()) {
    res = Math.max(res, val);
  }
  return wall.length - res;
}
