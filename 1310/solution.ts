function xorQueries(arr: number[], queries: number[][]): number[] {
  const xors = Array(arr.length).fill(0);
  let total = 0;
  for (let i = 0; i < arr.length; i++) {
    total ^= arr[i];
    xors[i] = total;
  }
  const res = Array(queries.length).fill(0);
  for (let i = 0; i < queries.length; i++) {
    const x = queries[i][0];
    const y = queries[i][1];
    res[i] = xors[y] ^ (x == 0 ? 0 : xors[x - 1]);
  }
  return res;
}
