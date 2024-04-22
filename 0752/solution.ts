const combinations = (choice: string): string[] => {
  const res: string[] = [];
  for (let i = 0; i < choice.length; i++) {
    const num = Number(choice[i]);
    const small = (num + 1) % 10;
    const big = num == 0 ? 9 : num - 1;
    res.push(choice.substring(0, i) + String(small) + choice.substring(i + 1));
    res.push(choice.substring(0, i) + String(big) + choice.substring(i + 1));
  }
  return res;
};

function openLock(deadends: string[], target: string): number {
  if (target === "0000") return 0;
  const visited = new Set<string>(deadends);
  const bfs: [string, number][] = [["0000", 0]];
  if (visited.has("0000")) {
    return -1;
  }
  while (bfs.length) {
    const [choice, moves] = bfs.shift()!;
    if (choice === target) {
      return moves;
    }
    const children = combinations(choice);
    for (let child of children) {
      if (!visited.has(child)) {
        visited.add(child);
        bfs.push([child, moves + 1]);
      }
    }
  }
  return -1;
}
