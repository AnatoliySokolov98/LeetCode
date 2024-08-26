import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> post = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.add(root);
        }
        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();
            post.add(curr.val);
            for (Node child : curr.children) {
                stack.add(child);
            }
        }
        Collections.reverse(post);
        return post;
    }
}

// time O(n)
// space O(1000)