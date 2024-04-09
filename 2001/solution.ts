function interchangeableRectangles(rectangles: number[][]): number {
  const counts = new Map<number, number>();
  let res = 0;
  for (const [width, height] of rectangles) {
    if (!counts.has(width / height)) {
      counts.set(width / height, 0);
    }
    counts.set(width / height, counts.get(width / height)! + 1);
  }

  for (const value of counts.values()) {
    res += (value * (value - 1)) / 2;
  }

  return res;
}
