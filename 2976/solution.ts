function minimumCost(
  source: string,
  target: string,
  original: string[],
  changed: string[],
  cost: number[]
): number {
  const T = target.length;
  const O = original.length;
  const graph: number[][] = Array.from({ length: 26 }, () =>
    Array(26).fill(Infinity)
  );

  for (let i = 0; i < O; i++) {
    const x = original[i].charCodeAt(0) - "a".charCodeAt(0);
    const y = changed[i].charCodeAt(0) - "a".charCodeAt(0);
    graph[x][y] = Math.min(graph[x][y], cost[i]);
  }

  for (let i = 0; i < 26; i++) {
    graph[i][i] = 0;
  }

  for (let k = 0; k < 26; k++) {
    for (let i = 0; i < 26; i++) {
      for (let j = 0; j < 26; j++) {
        if (graph[i][k] !== Infinity && graph[k][j] !== Infinity) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }
  }

  let res = 0;
  for (let i = 0; i < T; i++) {
    const x = source.charCodeAt(i) - "a".charCodeAt(0);
    const y = target.charCodeAt(i) - "a".charCodeAt(0);
    if (graph[x][y] === Infinity) {
      return -1;
    }
    res += graph[x][y];
  }

  return res;
}
