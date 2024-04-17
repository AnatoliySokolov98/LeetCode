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

function smallestFromLeaf(root: TreeNode | null): string {
  return traverse(root!, "");
}

function traverse(node: TreeNode, curr: string): string {
  const newWord: string =
    String.fromCharCode("a".charCodeAt(0) + node.val) + curr;
  if (!node.left && !node.right) {
    return newWord;
  }

  if (!node.left) {
    return traverse(node.right!, newWord);
  }

  if (!node.right) {
    return traverse(node.left, newWord);
  }

  const left = traverse(node.left, newWord);
  const right = traverse(node.right, newWord);
  return left < right ? left : right;
}
