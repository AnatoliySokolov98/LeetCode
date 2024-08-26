class _Node {
  val: number;
  children: _Node[];
  constructor(val?: number) {
    this.val = val === undefined ? 0 : val;
    this.children = [];
  }
}

function postorder(root: _Node | null): number[] {
  const post: number[] = [];
  const stack: _Node[] = [];
  if (root) {
    stack.push(root);
  }
  while (stack.length) {
    const node = stack.pop()!;
    post.push(node.val);
    for (const child of node.children) {
      stack.push(child);
    }
  }
  post.reverse();
  return post;
}
