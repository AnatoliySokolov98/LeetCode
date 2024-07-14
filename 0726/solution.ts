function countOfAtoms(formula: string): string {
  let stack: Array<Map<string, number>> = [new Map()];
  let i = 0;

  while (i < formula.length) {
    if (formula[i] === "(") {
      stack.push(new Map());
      i += 1;
    } else if (formula[i] === ")") {
      i += 1;
      let start = i;
      while (i < formula.length && isDigit(formula[i])) {
        i += 1;
      }
      let val = parseInt(formula.slice(start, i) || "1");
      let curr = stack.pop();
      curr!.forEach((value, key) => {
        stack[stack.length - 1].set(
          key,
          (stack[stack.length - 1].get(key) || 0) + value * val
        );
      });
    } else {
      let start = i;
      i += 1;
      while (i < formula.length && isLowerCase(formula[i])) {
        i += 1;
      }
      let element = formula.slice(start, i);
      start = i;
      while (i < formula.length && isDigit(formula[i])) {
        i += 1;
      }
      let val = parseInt(formula.slice(start, i) || "1");
      stack[stack.length - 1].set(
        element,
        (stack[stack.length - 1].get(element) || 0) + val
      );
    }
  }

  let result = "";
  let finalMap = stack.pop();
  let keys = Array.from(finalMap!.keys()).sort();

  for (let key of keys) {
    result += key;
    if (finalMap!.get(key)! > 1) {
      result += finalMap!.get(key)!.toString();
    }
  }

  return result;
}

function isDigit(char: string): boolean {
  return char.charCodeAt(0) >= 48 && char.charCodeAt(0) <= 57;
}

function isLowerCase(char: string): boolean {
  return char.charCodeAt(0) >= 97 && char.charCodeAt(0) <= 122;
}
