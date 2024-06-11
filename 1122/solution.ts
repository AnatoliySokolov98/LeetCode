function relativeSortArray(arr1: number[], arr2: number[]): number[] {
  const counts = new Map<number, number>();
  for (const num of arr1) {
    counts.set(num, (counts.get(num) || 0) + 1);
  }

  const res = new Array(arr1.length).fill(0);
  let i = 0;

  for (const num of arr2) {
    if (counts.has(num)) {
      const count = counts.get(num)!;
      for (let j = 0; j < count; j++) {
        res[i++] = num;
      }
      counts.delete(num);
    }
  }

  const extra: Array<number> = [];
  for (const num of arr1) {
    if (counts.has(num)) {
      extra.push(num);
    }
  }

  extra.sort((a, b) => a - b);
  for (const num of extra) {
    res[i++] = num;
  }
  return res;
}
