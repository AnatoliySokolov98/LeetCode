function trap(height: number[]): number {
  let H = height.length;
  let res = 0;
  let leftMax = 0;
  const rightMax: Array<number> = new Array(H).fill(0);
  for (let i = H - 2; i >= 0; i--) {
    rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
  }

  for (let i = 1; i < H; i++) {
    leftMax = Math.max(leftMax, height[i - 1]);
    const contribution = Math.min(leftMax, rightMax[i]);
    res += Math.max(0, contribution - height[i]);
  }
  return res;
}
