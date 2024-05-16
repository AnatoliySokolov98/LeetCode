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

function evaluateTree(root: TreeNode | null): boolean {
  if (root!.val == 1) return true;
  if (root!.val == 0) return false;
  const left = evaluateTree(root!.left);
  const right = evaluateTree(root!.right);
  return root!.val == 2 ? left || right : left && right;
}
