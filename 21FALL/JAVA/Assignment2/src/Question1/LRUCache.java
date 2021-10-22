package Question1;

import java.util.HashMap;

class LRUCache {
    int capacity = 0;
    HashMap<Integer, Node> map;
    int size = 0;
    Node head;
    Node tail;
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node (){}
        Node(int k, int v){
            key = k;
            val = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            return node.val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(size < capacity){
                Node latest = tail.pre;
                Node newNode = new Node(key, value);
                insert(latest, newNode, tail);
                size++;
            }
            else{
                Node oldest = head.next;
                delete(oldest);
                Node latest = tail.pre;
                Node newNode = new Node(key, value);
                insert(latest, newNode, tail);
            }
        }
        else{
            Node p = map.get(key);
            delete(p);
            Node latest = tail.pre;
            Node newNode = new Node(key, value);
            insert(latest, newNode, tail);
            map.put(key, newNode);
            size++;


        }

    }

    private void insert(Node i, Node a, Node j){
        i.next = a;
        a.pre = i;
        j.pre = a;
        a.next = j;
    }

    private void delete(Node i){
        Node pre = i.pre;
        Node next = i.next;
        pre.next = next;
        next.pre = pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */