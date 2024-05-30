function countTriplets(arr: number[]): number {
  const counts = new Map<number, [number, number]>();
  let xor = 0;
  let res = 0;
  counts.set(0, [1, 0]);
  for (let i = 0; i < arr.length; i++) {
    xor ^= arr[i];
    if (counts.has(xor)) {
      let [count, indexTotal] = counts.get(xor)!;
      res += i * count - indexTotal;
      indexTotal += i + 1;
      count++;
      counts.set(xor, [count, indexTotal]);
    } else {
      counts.set(xor, [1, i + 1]);
    }
  }
  return res;
}
