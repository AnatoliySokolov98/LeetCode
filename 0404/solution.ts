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

function sumOfLeftLeaves(node: TreeNode | null, isLeft = false): number {
  if (!node) {
    return 0;
  }

  if (!node.left && !node.right && isLeft) {
    return node.val;
  }

  return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
}
