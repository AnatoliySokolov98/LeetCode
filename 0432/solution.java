import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Node {
    int freq;
    Set<String> strings;
    Node prev, next;

    // Constructor for Node, initializing frequency and linked list pointers
    public Node(int freq, Node prev, Node next) {
        this.freq = freq;
        this.strings = new HashSet<>();
        this.prev = prev;
        this.next = next;
    }
}

class AllOne {

    private Node head, tail;
    private HashMap<String, Node> strings;

    public AllOne() {
        // Sentinel nodes: head is for minimum frequency, tail is for maximum frequency
        head = new Node(Integer.MIN_VALUE, null, null);
        tail = new Node(Integer.MAX_VALUE, null, null);
        head.next = tail;
        tail.prev = head;
        strings = new HashMap<>(); // HashMap to map keys to their corresponding nodes
    }

    public void inc(String key) {
        // Case: Key is not in the hash map (i.e., it's a new key)
        if (!strings.containsKey(key)) {
            // No node with frequency 1 exists right after the head node
            if (head.next.freq != 1) {
                // Create a new node with frequency 1 and insert it after head
                Node newNode = new Node(1, head, head.next);
                head.next.prev = newNode;
                head.next = newNode;
            }
            // Add the new key to the node with frequency 1
            head.next.strings.add(key);
            // Map the key to this new node
            strings.put(key, head.next);
        } else {
            // Case: Key exists in the map, so we increment its frequency
            Node node = strings.get(key);
            // Remove the key from its current frequency node
            node.strings.remove(key);
            int nextFreq = node.freq + 1;

            // Check if the next node has the incremented frequency
            if (node.next.freq != nextFreq) {
                // No node exists with the new incremented frequency, so create one
                Node newNode = new Node(nextFreq, node, node.next);
                node.next.prev = newNode;
                node.next = newNode;
            }
            // Add the key to the node with the incremented frequency
            node.next.strings.add(key);
            // Update the map to point to the new frequency node
            strings.put(key, node.next);

            // If the current node has no more keys, remove it from the linked list
            if (node.strings.isEmpty()) {
                removeNode(node);
            }
        }
    }

    public void dec(String key) {
        Node node = strings.get(key);
        // Remove the key from its current frequency node
        node.strings.remove(key);

        // Case: If the frequency is 1, we remove the key entirely
        if (node.freq == 1) {
            strings.remove(key); // Remove the key from the map
        } else {
            int prevFreq = node.freq - 1;

            // Check if the previous node has the decremented frequency
            if (node.prev.freq != prevFreq) {
                // No node exists with the decremented frequency, so create one
                Node newNode = new Node(prevFreq, node.prev, node);
                node.prev.next = newNode;
                node.prev = newNode;
            }
            // Add the key to the node with the decremented frequency
            node.prev.strings.add(key);
            // Update the map to point to the new frequency node
            strings.put(key, node.prev);
        }

        // If the current node has no more keys, remove it from the linked list
        if (node.strings.isEmpty()) {
            removeNode(node);
        }
    }

    public String getMaxKey() {
        // Case: The list is empty (head is directly connected to tail)
        if (tail.prev == head) {
            return ""; // Return an empty string if no keys are present
        }
        // Return any key from the set of the maximum frequency node
        Iterator<String> iterator = tail.prev.strings.iterator();
        return iterator.next();
    }

    public String getMinKey() {
        // Case: The list is empty (head is directly connected to tail)
        if (tail.prev == head) {
            return ""; // Return an empty string if no keys are present
        }
        // Return any key from the set of the minimum frequency node
        Iterator<String> iterator = head.next.strings.iterator();
        return iterator.next();
    }

    // Helper method to remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

// time O(1)
// space O(strings)