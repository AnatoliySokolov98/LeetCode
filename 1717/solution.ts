function maximumGain(s: string, x: number, y: number): number {
  let res = 0;
  let stack: Array<string> = [];
  const goodVal = x > y ? "ab" : "ba";
  const small = Math.min(x, y);
  const big = Math.max(x, y);

  for (const c of s) {
    if (c > "b") {
      res += calculateRemainingStack(stack, small);
      stack = [];
    } else if (
      stack.length &&
      c == goodVal.charAt(1) &&
      stack[stack.length - 1] == goodVal.charAt(0)
    ) {
      stack.pop();
      res += big;
    } else {
      stack.push(c);
    }
  }

  if (stack.length) {
    res += calculateRemainingStack(stack, small);
  }
  return res;
}

const calculateRemainingStack = (stack: Array<string>, val: number): number => {
  let ays = 0;
  let bees = 0;
  for (const c of stack) {
    if (c == "a") {
      ays++;
    } else {
      bees++;
    }
  }
  return Math.min(ays, bees) * val;
};
