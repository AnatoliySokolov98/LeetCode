function getDirections(
  root: TreeNode | null,
  startValue: number,
  destValue: number
): string {
  let startPath: string = "";
  let endPath: string = "";
  let path: string[] = [];

  function traverse(
    node: TreeNode | null,
    startValue: number,
    destValue: number
  ): boolean {
    if (node === null) {
      return false;
    }

    if (node.val === startValue) {
      startPath = path.join("");
    }

    if (node.val === destValue) {
      endPath = path.join("");
    }

    path.push("L");
    if (traverse(node.left, startValue, destValue)) {
      return true;
    }
    path.pop();

    path.push("R");
    if (traverse(node.right, startValue, destValue)) {
      return true;
    }
    path.pop();

    return false;
  }

  traverse(root, startValue, destValue);

  let i = 0;
  while (
    i < startPath.length &&
    i < endPath.length &&
    startPath[i] === endPath[i]
  ) {
    i++;
  }

  let stepsUp = startPath.length - i;
  let result = "U".repeat(stepsUp) + endPath.substring(i);
  return result;
}
