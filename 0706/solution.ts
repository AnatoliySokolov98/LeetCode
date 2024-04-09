type LinkedListNode = {
  next: LinkedListNode | null;
  key: number;
  value: number;
};

class MyHashMap {
  buckets: Array<LinkedListNode | null>;
  bucketsNumber = 10;

  constructor() {
    this.buckets = new Array(this.bucketsNumber).fill(null);
  }

  put(key: number, value: number): void {
    const bucketIndex = this.getBucketIndex(key);
    const bucket = this.buckets[bucketIndex];

    // Check if the key already exists and update its value in case it does.
    let node: LinkedListNode | null = bucket;
    while (node) {
      if (node.key === key) {
        node.value = value;
        return;
      }
      node = node.next;
    }

    // Otherwise just append the value to the beginning of the list.
    this.buckets[bucketIndex] = { next: bucket, key, value };
  }

  get(key: number): number {
    const bucketIndex = this.getBucketIndex(key);
    const bucket = this.buckets[bucketIndex];

    let node: LinkedListNode | null = bucket;
    while (node) {
      if (node.key === key) {
        return node.value;
      }
      node = node.next;
    }

    return -1;
  }

  remove(key: number): void {
    const bucketIndex = this.getBucketIndex(key);
    const bucket = this.buckets[bucketIndex];

    if (!bucket) {
      return;
    }

    if (bucket.key === key) {
      this.buckets[bucketIndex] = bucket.next;
    } else {
      let node: LinkedListNode | null = bucket.next;
      let prev: LinkedListNode = bucket;
      while (node) {
        if (node.key === key) {
          prev.next = node.next;
          return;
        }
        prev = prev.next!;
        node = node.next;
      }
    }
  }

  getBucketIndex = (key: number): number => {
    return key % this.bucketsNumber;
  };
}
