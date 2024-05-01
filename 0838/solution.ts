function pushDominoes(dominoes: string): string {
  let stack: Array<number> = [];
  const res = dominoes.split("");
  let rightLoc = -1;
  for (let i = 0; i < dominoes.length; i++) {
    const curr = dominoes[i];
    if (curr == ".") {
      stack.push(i);
    } else if (curr == "R") {
      if (rightLoc != -1) {
        while (stack.length) {
          const last = stack.pop()!;
          res[last] = "R";
        }
      } else {
        stack = [];
      }
      rightLoc = i;
    } else {
      while (stack.length) {
        const last = stack.pop()!;
        if (rightLoc == -1 || last - rightLoc > i - last) {
          res[last] = "L";
        } else if (last - rightLoc < i - last) {
          res[last] = "R";
        }
      }
      rightLoc = -1;
    }
  }
  while (rightLoc != -1 && stack.length) {
    const loc = stack.pop()!;
    res[loc] = "R";
  }
  return res.join("");
}
