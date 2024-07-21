function buildMatrix(
  k: number,
  rowConditions: number[][],
  colConditions: number[][]
): number[][] {
  // Initialize graphs and indegree arrays for rows and columns
  const rowGraph: Map<number, Set<number>> = new Map();
  const colGraph: Map<number, Set<number>> = new Map();
  const rowIndegrees: number[] = new Array(k).fill(0);
  const colIndegrees: number[] = new Array(k).fill(0);

  for (let i = 1; i <= k; i++) {
    rowGraph.set(i, new Set());
    colGraph.set(i, new Set());
  }

  // Fill in the graphs and indegree arrays based on conditions
  for (const [x, y] of rowConditions) {
    if (!rowGraph.get(x)!.has(y)) {
      rowGraph.get(x)!.add(y);
      rowIndegrees[y - 1]++;
    }
  }

  for (const [x, y] of colConditions) {
    if (!colGraph.get(x)!.has(y)) {
      colGraph.get(x)!.add(y);
      colIndegrees[y - 1]++;
    }
  }

  // Perform topological sort for rows
  const rowOrder = topologicalSort(k, rowGraph, rowIndegrees);
  if (rowOrder.length !== k) {
    return [];
  }

  // Perform topological sort for columns
  const colOrder = topologicalSort(k, colGraph, colIndegrees);
  if (colOrder.length !== k) {
    return [];
  }

  // Construct the matrix based on row and column orders
  const res: number[][] = Array.from({ length: k }, () => new Array(k).fill(0));
  const colLocs: Map<number, number> = new Map();

  for (let i = 0; i < colOrder.length; i++) {
    colLocs.set(colOrder[i], i);
  }

  for (let i = 0; i < rowOrder.length; i++) {
    res[i][colLocs.get(rowOrder[i])!] = rowOrder[i];
  }

  return res;
}

function topologicalSort(
  k: number,
  graph: Map<number, Set<number>>,
  indegrees: number[]
): number[] {
  const order: number[] = [];
  const bfs: number[] = [];

  for (let i = 0; i < k; i++) {
    if (indegrees[i] === 0) {
      bfs.push(i + 1);
    }
  }

  while (bfs.length > 0) {
    const node = bfs.shift()!;
    order.push(node);
    for (const child of graph.get(node)!) {
      indegrees[child - 1]--;
      if (indegrees[child - 1] === 0) {
        bfs.push(child);
      }
    }
  }

  return order;
}
