function findTheWinner(n: number, k: number): number {
  const circle: number[] = [];
  for (let i = 1; i <= n; i++) {
    circle.push(i);
  }
  while (circle.length > 1) {
    for (let i = 0; i < k - 1; i++) {
      circle.push(circle.shift()!);
    }
    circle.shift();
  }
  return circle.shift()!;
}
