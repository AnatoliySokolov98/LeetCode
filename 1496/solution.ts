function isPathCrossing(path: string): boolean {
  const visited = new Set<number>();
  let x = 0;
  let y = 0;
  visited.add(x + y * 10000);
  for (let i = 0; i < path.length; i++) {
    if (path.charAt(i) == "N") {
      x--;
    } else if (path.charAt(i) == "S") {
      x++;
    } else if (path.charAt(i) == "E") {
      y++;
    } else {
      y--;
    }

    if (visited.has(x + y * 10000)) {
      return true;
    }
    visited.add(x + y * 10000);
  }
  return false;
}
