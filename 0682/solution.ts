function calPoints(operations: string[]): number {
  const res: number[] = [];
  for (const op of operations) {
    switch (op) {
      case "+":
        res.push(res[res.length - 1] + res[res.length - 2]);
        break;
      case "D":
        res.push(res[res.length - 1] * 2);
        break;
      case "C":
        res.pop();
        break;
      default:
        res.push(parseInt(op));
    }
  }

  return res.reduce((acc, el) => acc + el, 0);
}
