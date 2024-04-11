import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x) {
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }
        first.offer(x);
        while (!second.isEmpty()) {
            first.offer(second.poll());
        }
    }

    public int pop() {
        return first.poll();
    }

    public int top() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
