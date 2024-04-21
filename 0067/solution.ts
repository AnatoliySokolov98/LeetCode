function addBinary(a: string, b: string): string {
  let cin = 0;
  let res: Array<string> = [];
  let i = a.length - 1;
  let j = b.length - 1;
  while (i >= 0 || j >= 0) {
    const top = i >= 0 ? parseInt(a[i--]) : 0;
    const bot = j >= 0 ? parseInt(b[j--]) : 0;
    const total = (top + bot + cin) % 2;
    cin = Math.floor((top + bot + cin) / 2);
    res.push(total.toString());
  }
  if (cin) {
    res.push("1");
  }
  res.reverse();
  i = 0;
  while (i < res.length && res[i] == "0") {
    i++;
  }

  return i < res.length ? res.slice(i).join("") : "0";
}
