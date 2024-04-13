class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function reverseList(head: ListNode | null): ListNode | null {
  let p: ListNode | null = null;
  while (head) {
    [head.next, head, p] = [p, head.next, head];
  }
  return p;
}

//time O(n)
//space O(1)
