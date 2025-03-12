package AmazonInterview.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DLList {
        Node head, tail;

        public DLList() {
            head = new Node(-1, -1); // Dummy head
            tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        public void addStart(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeLast() {
            if (tail.prev == head) return null; // No actual node
            Node last = tail.prev;
            removeNode(last);
            return last;
        }
    }

    int capacity;
    int size;
    DLList list;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.list = new DLList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        list.removeNode(node);
        list.addStart(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.removeNode(node);
            node.val = value;
            list.addStart(node);
        } else {
            if (size == capacity) {
                Node last = list.removeLast();
                if (last != null) {
                    map.remove(last.key);
                    size--;
                }
            }
            Node newNode = new Node(key, value);
            list.addStart(newNode);
            map.put(key, newNode);
            size++;
        }
    }
}
