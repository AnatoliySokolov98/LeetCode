function findMinHeightTrees(n: number, edges: number[][]): number[] {
  let level: Array<number> = [];
  if (n == 1) {
    return [0];
  }
  const indegrees = new Array(n).fill(0);
  const graph = new Map<number, Array<number>>();
  for (const [x, y] of edges) {
    indegrees[x]++;
    indegrees[y]++;
    graph.set(x, graph.get(x) || []);
    graph.set(y, graph.get(y) || []);
    graph.get(x)!.push(y);
    graph.get(y)!.push(x);
  }

  for (let i = 0; i < indegrees.length; i++) {
    if (indegrees[i] == 1) {
      level.push(i);
    }
  }

  while (true) {
    const nextLevel: Array<number> = [];
    for (const node of level) {
      for (const child of graph.get(node)!) {
        indegrees[child]--;
        if (indegrees[child] == 1) {
          nextLevel.push(child);
        }
      }
    }
    if (!nextLevel.length) {
      return level;
    }
    level = nextLevel;
  }
}
