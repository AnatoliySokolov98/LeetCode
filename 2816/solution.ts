class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function doubleIt(head: ListNode | null): ListNode | null {
  head = reverseList(head);
  let cin = 0;
  let curr = head;
  while (curr != null) {
    const total = (curr.val * 2 + cin) % 10;
    cin = Math.floor((curr.val * 2 + cin) / 10);
    curr.val = total;
    curr = curr.next;
  }
  head = reverseList(head);
  if (cin != 0) {
    head = new ListNode(cin, head);
  }
  return head;
}

function reverseList(head: ListNode | null): ListNode | null {
  let curr = head;
  let prev = null;
  while (curr != null) {
    const next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  return prev;
}
