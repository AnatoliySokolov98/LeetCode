class NumArray {
  private prefixSums: number[];
  constructor(nums: number[]) {
    this.prefixSums = [];
    let curr = 0;
    for (let num of nums) {
      curr += num;
      this.prefixSums.push(curr);
    }
  }

  sumRange(left: number, right: number): number {
    if (left === 0) {
      return this.prefixSums[right];
    } else {
      return this.prefixSums[right] - this.prefixSums[left - 1];
    }
  }
}
