function numOfMinutes(
  n: number,
  headID: number,
  manager: number[],
  informTime: number[]
): number {
  const graph = new Map<number, Array<number>>();
  for (let i = 0; i < manager.length; i++) {
    const parent = manager[i];
    if (parent == -1) {
      continue;
    }
    graph.set(parent, graph.get(parent) || []);
    graph.get(parent)!.push(i);
  }
  const bfs: Array<[number, number]> = [];
  bfs.push([headID, 0]);

  let res = 0;
  while (bfs.length) {
    const [node, time] = bfs.pop() as [number, number];
    res = Math.max(res, time);
    if (graph.has(node)) {
      for (const child of graph.get(node)!) {
        bfs.push([child, time + informTime[node]]);
      }
    }
  }
  return res;
}
