function sumOfDistancesInTree(n: number, edges: number[][]): number[] {
  if (n == 1) {
    return [0];
  }
  const distances = new Array<number>(n).fill(0);
  const counts = new Array<number>(n).fill(1);
  const tree = new Map<number, Array<number>>();
  for (const [x, y] of edges) {
    tree.set(x, tree.get(x) || new Array<number>());
    tree.set(y, tree.get(y) || new Array<number>());
    tree.get(x)!.push(y);
    tree.get(y)!.push(x);
  }
  const getCounts = (node: number, parent: number): number => {
    let dist = 0;
    for (const child of tree.get(node)!) {
      if (child != parent) {
        dist += getCounts(child, node) + counts[child];
        counts[node] += counts[child];
      }
    }
    return dist;
  };

  const getDistances = (node: number, parent: number): void => {
    for (const child of tree.get(node)!) {
      if (child != parent) {
        distances[child] =
          distances[node] - counts[child] + (n - counts[child]);
        getDistances(child, node);
      }
    }
  };

  distances[0] = getCounts(0, -1);
  getDistances(0, -1);
  return distances;
}
