type HashNode<T = number> = {
  value: T;
  next?: HashNode<T>;
};

class MyHashSet {
  private head?: HashNode;

  constructor() {
    this.head = undefined;
  }

  add(key: number): void {
    const node: HashNode = { value: key };
    if (!this.head) {
      this.head = node;
      return;
    }
    if (this.contains(key)) {
      return;
    }
    node.next = this.head;
    this.head = node;
  }

  remove(key: number): void {
    if (!this.head) {
      return;
    }
    if (this.head.value === key) {
      this.head = this.head.next;
      return;
    }
    let curr = this.head;
    while (curr?.next) {
      if (curr.next.value === key) {
        curr.next = curr.next.next;
        break;
      }
      curr = curr.next;
    }
  }

  contains(key: number): boolean {
    let curr = this.head;
    while (curr) {
      if (curr.value === key) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }
}
