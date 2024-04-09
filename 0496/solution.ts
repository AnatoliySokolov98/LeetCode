function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
  const nextGreater = new Array(nums2.length).fill(-1);
  const numsMap: Map<number, number> = new Map();
  const stack: [number, number][] = [];
  for (let i = 0; i < nums2.length; i++) {
    numsMap.set(nums2[i], i);
    while (stack.length && nums2[i] > stack[stack.length - 1][0]) {
      nextGreater[stack[stack.length - 1][1]] = nums2[i];
      stack.pop();
    }
    stack.push([nums2[i], i]);
  }
  const res: number[] = [];
  for (let i = 0; i < nums1.length; i++) {
    res.push(nextGreater[numsMap.get(nums1[i])!]);
  }

  return res;
}
