function maxProbability(
  n: number,
  edges: number[][],
  succProb: number[],
  start_node: number,
  end_node: number
): number {
  const maxQ = new MaxPriorityQueue({
    compare: (a, b) => b[0] - a[0],
  });

  const paths: Map<number, [number, number][]> = new Map();
  for (let i = 0; i < edges.length; i++) {
    const [start, end] = edges[i];
    if (!paths.get(start)) {
      paths.set(start, []);
    }
    if (!paths.get(end)) {
      paths.set(end, []);
    }
    paths.get(start)!.push([succProb[i], end]);
    paths.get(end)!.push([succProb[i], start]);
  }
  const visited: Set<number> = new Set();
  maxQ.enqueue([1, start_node]);
  while (maxQ.size()) {
    const [dist, node] = maxQ.dequeue();
    console.log(dist, node);
    if (visited.has(node)) {
      continue;
    }

    if (node === end_node) {
      return dist;
    }
    visited.add(node);
    if (!paths.get(node)) {
      continue;
    }

    for (const [dist2, child] of paths.get(node)!) {
      if (!visited.has(child)) {
        maxQ.enqueue([dist * dist2, child]);
      }
    }
  }

  return 0;
}
