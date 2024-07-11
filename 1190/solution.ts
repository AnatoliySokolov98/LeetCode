function reverseParentheses(s: string): string {
  const parens = new Map<number, number>();
  const stack: Array<number> = [];
  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) == "(") {
      stack.push(i);
    } else if (s.charAt(i) == ")") {
      const j = stack.pop()!;
      parens.set(i, j);
      parens.set(j, i);
    }
  }
  let direction = 1;
  let i = 0;
  const res: Array<string> = [];
  while (i >= 0 && i < s.length) {
    if (parens.has(i)) {
      direction *= -1;
      i = parens.get(i)! + direction;
    } else {
      res.push(s[i]);
      i += direction;
    }
  }
  return res.join("");
}
