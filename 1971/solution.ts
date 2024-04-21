function validPath(
  n: number,
  edges: number[][],
  source: number,
  destination: number
): boolean {
  if (source == destination) {
    return true;
  }
  const graph = new Map<number, Array<number>>();
  for (const [x, y] of edges) {
    graph.set(x, graph.get(x) ?? []);
    graph.set(y, graph.get(y) ?? []);
    graph.get(x)!.push(y);
    graph.get(y)!.push(x);
  }

  const bfs = [source];
  const visited = new Set<number>([source]);
  while (bfs.length) {
    const node = bfs.pop();
    if (node === destination) {
      return true;
    }
    if (!graph.get(node!)) {
      continue;
    }
    for (const child of graph.get(node!)!) {
      if (visited.has(child)) {
        continue;
      }
      bfs.push(child);
      visited.add(child);
    }
  }
  return false;
}
