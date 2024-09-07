class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

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

function isSubPath(head: ListNode | null, root: TreeNode | null): boolean {
  return traverse(root, head);
}

function traverse(node: TreeNode | null, listNode: ListNode | null): boolean {
  if (!node || node.val != listNode!.val) {
    return false;
  }
  return (
    dfs(node, listNode) ||
    traverse(node.left, listNode) ||
    traverse(node.right, listNode)
  );
}

function dfs(node: TreeNode | null, listNode: ListNode | null): boolean {
  if (!node || node.val != listNode!.val) {
    return false;
  }
  if (!listNode!.next) {
    return true;
  }
  return dfs(node.left, listNode!.next) || dfs(node.right, listNode!.next);
}
