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

function sumNumbers(root: TreeNode | null): number {
  let res = 0;
  const traverse = (node: TreeNode | null, prefix: number): void => {
    if (!node) {
      return;
    }

    if (!node.left && !node.right) {
      res += prefix * 10 + node.val;
      return;
    }

    traverse(node.left, prefix * 10 + node.val);
    traverse(node.right, prefix * 10 + node.val);
  };
  traverse(root, 0);
  return res;
}
