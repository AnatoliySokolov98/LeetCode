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

function addOneRow(
  root: TreeNode | null,
  val: number,
  depth: number
): TreeNode | null {
  if (depth == 1) {
    return new TreeNode(val, root, null);
  }
  traverse(root, val, depth, 1);
  return root;
}

function traverse(
  node: TreeNode | null,
  val: number,
  depth: number,
  level: number
): void {
  if (!node) {
    return;
  }
  if (level == depth - 1) {
    const left = node.left;
    const right = node.right;
    node.left = new TreeNode(val, left, null);
    node.right = new TreeNode(val, null, right);
  } else {
    traverse(node.left, val, depth, level + 1);
    traverse(node.right, val, depth, level + 1);
  }
}
