class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function isPalindrome(head: ListNode | null): boolean {
  let slow = head,
    fast = head;
  while (fast!.next && fast!.next.next) {
    fast = fast!.next.next;
    slow = slow!.next;
  }
  let new_head = slow!.next;
  slow!.next = null;

  slow = null;
  while (new_head) {
    fast = new_head.next;
    new_head.next = slow;
    slow = new_head;
    new_head = fast;
  }

  while (slow && head) {
    if (slow.val !== head.val) {
      return false;
    }
    slow = slow.next;
    head = head.next;
  }
  return true;
}
