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

function delNodes(
  root: TreeNode | null,
  to_delete: number[]
): Array<TreeNode | null> {
  const badNodes = new Set(to_delete);
  const res: Array<TreeNode> = [];

  const traverse = (
    node: TreeNode | null,
    hasParent: boolean
  ): TreeNode | null => {
    if (!node) {
      return null;
    }
    if (!badNodes.has(node.val)) {
      if (!hasParent) {
        res.push(node);
      }
      node.left = traverse(node.left, true);
      node.right = traverse(node.right, true);
    } else {
      traverse(node.left, false);
      traverse(node.right, false);
      return null;
    }
    return node;
  };

  traverse(root, false);
  return res;
}
