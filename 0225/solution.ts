class MyStack {
  first: number[];
  second: number[];
  constructor() {
    this.first = [];
    this.second = [];
  }

  push(x: number): void {
    this.first.push(x);
  }

  pop(): number {
    while (this.first.length > 1) {
      this.second.push(this.first.shift()!);
    }
    const res = this.first.pop();
    while (this.second.length) {
      this.first.push(this.second.shift()!);
    }
    return res!;
  }

  top(): number {
    while (this.first.length > 1) {
      this.second.push(this.first.shift()!);
    }
    const res = this.first.pop();
    this.second.push(res!);
    while (this.second.length) {
      this.first.push(this.second.shift()!);
    }
    return res!;
  }

  empty(): boolean {
    return this.first.length === 0;
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
