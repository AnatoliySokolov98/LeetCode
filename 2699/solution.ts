function modifiedGraphEdges(
  n: number,
  edges: number[][],
  source: number,
  destination: number,
  target: number
): number[][] {
  const graph = new Map<number, Map<number, number>>();
  const MAX = 2_000_000_000;
  for (const edge of edges) {
    const [x, y, d] = edge;
    if (d !== -1) {
      if (!graph.has(x)) graph.set(x, new Map());
      if (!graph.has(y)) graph.set(y, new Map());
      graph.get(x)?.set(y, d);
      graph.get(y)?.set(x, d);
    }
  }

  let currDistance = dijkstra(graph, source, destination);
  if (currDistance < target) {
    return [];
  }

  for (const edge of edges) {
    const [x, y, d] = edge;
    if (d !== -1) {
      continue;
    }
    if (currDistance === target) {
      edge[2] = MAX;
      continue;
    }

    edge[2] = 1;
    if (!graph.has(x)) graph.set(x, new Map());
    if (!graph.has(y)) graph.set(y, new Map());
    graph.get(x)?.set(y, 1);
    graph.get(y)?.set(x, 1);
    currDistance = dijkstra(graph, source, destination);
    if (currDistance <= target) {
      edge[2] += target - currDistance;
      currDistance = target;
    }
  }

  return currDistance === target ? edges : [];
}

function dijkstra(
  graph: Map<number, Map<number, number>>,
  source: number,
  destination: number
): number {
  const MAX = 2_000_000_000;
  const pq: [number, number][] = [];
  pq.push([source, 0]);
  const visited = new Set<number>();

  while (pq.length > 0) {
    pq.sort((a, b) => a[1] - b[1]);
    const [node, distance] = pq.shift()!;
    if (visited.has(node)) {
      continue;
    }
    visited.add(node);
    if (node === destination) {
      return distance;
    }

    const neighbors = graph.get(node) || new Map<number, number>();
    for (const [nextNode, weight] of neighbors.entries()) {
      if (!visited.has(nextNode)) {
        pq.push([nextNode, distance + weight]);
      }
    }
  }

  return MAX;
}
