class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function createBinaryTree(descriptions: number[][]): TreeNode | null {
  const graph = new Map<number, TreeNode>();
  const children = new Set<number>();
  for (const [parent, child, isLeft] of descriptions) {
    if (!graph.has(parent)) {
      graph.set(parent, new TreeNode(parent));
    }
    if (!graph.has(child)) {
      graph.set(child, new TreeNode(child));
    }
    children.add(child);
    if (isLeft) {
      graph.get(parent)!.left = graph.get(child)!;
    } else {
      graph.get(parent)!.right = graph.get(child)!;
    }
  }
  for (const key of graph.keys()) {
    if (!children.has(key)) {
      return graph.get(key)!;
    }
  }
  return null;
}
