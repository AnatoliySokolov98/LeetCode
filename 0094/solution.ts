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

function inorderTraversal(root: TreeNode | null): number[] {
  const res: number[] = [];
  const traverse = (node: TreeNode | null): void => {
    if (!node) return;

    traverse(node.left);
    res.push(node.val);
    traverse(node.right);
  };
  traverse(root);
  return res;
}
