class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function insertGreatestCommonDivisors(head: ListNode | null): ListNode | null {
  const dummy = new ListNode();
  let curr = dummy;
  let prev: ListNode | null = null;
  while (head) {
    if (prev) {
      curr.next = new ListNode(gcd(prev.val, head.val));
      curr = curr.next;
    }
    prev = head;
    curr.next = head;
    head = head.next;
    curr = curr.next;
    curr.next = null;
  }
  return dummy.next;
}

function gcd(a: number, b: number) {
  while (b) {
    [a, b] = [b, a % b];
  }
  return a;
}
