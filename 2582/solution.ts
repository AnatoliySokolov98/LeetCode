function passThePillow(n: number, time: number): number {
  const cycles = Math.floor(time / (n - 1));
  const remainder = time % (n - 1);
  return cycles % 2 == 0 ? 1 + remainder : n - remainder;
}
