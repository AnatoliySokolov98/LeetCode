class KthLargest {
  vals: number[];
  K: number;
  constructor(k: number, nums: number[]) {
    this.K = k;
    this.vals = nums.slice();
    this.vals.sort((a, b) => a - b);
    this.vals.slice(-k);
  }

  add(val: number): number {
    this.vals.push(val);
    this.vals.sort((a, b) => a - b);
    if (this.vals.length > this.K) {
      this.vals.shift();
    }
    return this.vals[0];
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */
