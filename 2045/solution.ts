function secondMinimum(
  n: number,
  edges: number[][],
  time: number,
  change: number
): number {
  const graph: number[][] = Array.from({ length: n + 1 }, () => []);
  for (const [u, v] of edges) {
    graph[u].push(v);
    graph[v].push(u);
  }

  const dist: number[][] = Array.from({ length: n + 1 }, () => [
    Infinity,
    Infinity,
  ]);
  dist[1][1] = 0;

  const queue: [number, number][] = [[1, 0]];

  while (queue.length > 0) {
    const [node, currentTime] = queue.shift()!;
    let nextTime = currentTime + time;
    const cycle = Math.floor(currentTime / change);

    if (cycle % 2 === 1) {
      const waitTime = change - (currentTime % change);
      nextTime += waitTime;
    }

    for (const neighbor of graph[node]) {
      if (dist[neighbor][0] === Infinity) {
        dist[neighbor][0] = nextTime;
        queue.push([neighbor, nextTime]);
      } else if (
        dist[neighbor][0] < nextTime &&
        dist[neighbor][1] === Infinity
      ) {
        dist[neighbor][1] = nextTime;
        queue.push([neighbor, nextTime]);
      }
    }
  }

  return dist[n][1];
}
