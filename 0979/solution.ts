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

function distributeCoins(root: TreeNode | null): number {
  return traverse(root)[0];
}

function traverse(node: TreeNode | null) {
  if (node == null) {
    return [0, 0];
  }
  const [leftMoves, leftCoins] = traverse(node.left);
  const [rightMoves, rightCoins] = traverse(node.right);
  const currMoves = Math.abs(leftCoins) + Math.abs(rightCoins);
  const totalMoves = leftMoves + rightMoves + currMoves;
  const currCoins = leftCoins + rightCoins + node.val - 1;
  return [totalMoves, currCoins];
}
