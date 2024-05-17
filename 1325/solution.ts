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

function removeLeafNodes(
  root: TreeNode | null,
  target: number
): TreeNode | null {
  if (root == null) return null;
  root.left = removeLeafNodes(root.left, target);
  root.right = removeLeafNodes(root.right, target);
  if (root.val == target && root.left == null && root.right == null)
    return null;
  return root;
}
