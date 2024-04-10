class RandomizedSet {
  locs: Map<number, number>;
  nums: Array<number>;
  constructor() {
    this.locs = new Map();
    this.nums = [];
  }

  insert(val: number): boolean {
    if (this.locs.has(val)) {
      return false;
    }
    this.locs.set(val, this.nums.length);
    this.nums.push(val);
    return true;
  }

  remove(val: number): boolean {
    if (!this.locs.has(val)) {
      return false;
    }
    const lastNum = this.nums[this.nums.length - 1];
    const removeLoc = this.locs.get(val);
    this.locs.set(lastNum, removeLoc!);
    this.locs.delete(val);
    this.nums[removeLoc!] = lastNum;
    this.nums.pop();
    return true;
  }

  getRandom(): number {
    const randomIndex = Math.floor(Math.random() * this.nums.length);
    return this.nums[randomIndex];
  }
}
