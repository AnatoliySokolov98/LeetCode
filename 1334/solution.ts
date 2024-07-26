function findTheCity(
  n: number,
  edges: number[][],
  distanceThreshold: number
): number {
  const dist: number[][] = Array.from({ length: n }, () =>
    Array(n).fill(Number.POSITIVE_INFINITY)
  );

  for (let i = 0; i < n; i++) {
    dist[i][i] = 0;
  }

  for (let [x, y, d] of edges) {
    dist[x][y] = d;
    dist[y][x] = d;
  }

  for (let k = 0; k < n; k++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (dist[i][k] + dist[k][j] < dist[i][j]) {
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }

  let res = [0, n];
  for (let i = 0; i < n; i++) {
    let reachableCities = 0;
    for (let j = 0; j < n; j++) {
      if (i !== j && dist[i][j] <= distanceThreshold) {
        reachableCities++;
      }
    }
    if (reachableCities <= res[1]) {
      res = [i, reachableCities];
    }
  }

  return res[0];
}
