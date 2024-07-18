function countPairs(root: TreeNode | null, distance: number): number {
  const leaves = new Set<number>();
  const graph = new Map<number, number[]>();
  let uuid = 1;
  root!.val = 0;
  graph.set(0, []);

  const traverse = (node: TreeNode | null) => {
    if (!node) return;

    if (node.left) {
      node.left.val = uuid++;
      graph.set(node.left.val, []);
      graph.get(node.val)!.push(node.left.val);
      graph.get(node.left.val)!.push(node.val);
      traverse(node.left);
    }

    if (node.right) {
      node.right.val = uuid++;
      graph.set(node.right.val, []);
      graph.get(node.val)!.push(node.right.val);
      graph.get(node.right.val)!.push(node.val);
      traverse(node.right);
    }

    if (!node.left && !node.right) {
      leaves.add(node.val);
    }
  };

  traverse(root);

  let res = 0;
  for (const node of leaves) {
    const visited = new Set<number>();
    const bfs: [number, number][] = [[node, 0]];
    visited.add(node);

    while (bfs.length) {
      const [curr, dist] = bfs.shift()!;
      if (dist < distance) {
        for (const neighbor of graph.get(curr)!) {
          if (!visited.has(neighbor)) {
            visited.add(neighbor);
            if (leaves.has(neighbor)) {
              res++;
            }
            bfs.push([neighbor, dist + 1]);
          }
        }
      }
    }
  }
  return res / 2;
}
