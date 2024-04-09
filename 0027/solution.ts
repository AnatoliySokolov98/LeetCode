function removeElement(nums: number[], val: number): number {
  let write_to = 0;
  for (let num of nums) {
    if (num !== val) {
      nums[write_to++] = num;
    }
  }
  return write_to;
}
