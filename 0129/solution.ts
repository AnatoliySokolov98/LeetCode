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
  const traverse = (node: TreeNode | null, prefix: number): number => {
    if (!node) {
      return 0;
    }

    if (!node.left && !node.right) {
      return prefix * 10 + node.val;
    }

    return (
      traverse(node.left, prefix * 10 + node.val) +
      traverse(node.right, prefix * 10 + node.val)
    );
  };
  return traverse(root, 0);
}
