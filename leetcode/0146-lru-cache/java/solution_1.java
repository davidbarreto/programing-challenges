class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private NodeList usage;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.usage = new NodeList();
    }
    
    public int get(int key) {

        //System.out.println(String.format("get: %d. Cache = %s", key, cache));
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            updateUsage(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {

        //System.out.println(String.format("put: %d, %d. Cache = %s", key, value, cache));
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateUsage(node);
        } else {

            if (cache.size() == capacity) {
                evict();
            }
            Node node = usage.add(key, value);
            cache.put(key, node);
        }
    }

    private void updateUsage(Node node) {
        usage.remove(node);
        usage.add(node);
    }

    private void evict() {
        Node lru = usage.head;
        usage.remove(lru);
        cache.remove(lru.key);
    }
}

class Node {
    public Node next;
    public Node prev;
    public int key;
    public int val;

    Node(Node prev, Node next, int key, int val) {
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.val = val;
    }

    public String toString() {
        return "{key="+key+",value="+val+"}";
    }
}

class NodeList {
    public Node head;
    public Node tail;

    public Node add(int key, int value) {
        Node node = new Node(tail, null, key, value);
        return add(node);
    }

    public Node add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return node;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
        return node;
    }

    public void remove(Node node) {

        //System.out.println(String.format("head=%s, tail=%s", head, tail));
        if (node == head) {
            head = node.next;
        } else if (node == tail) {
            tail = tail.prev;
        } else {
            //System.out.println(String.format("remove from usage: prev=%s, node=%s, next=%s", node.prev, node, node.next));
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Node curr = head;
        while(curr != null) {
            sb.append(curr.toString());
            sb.append("->");
            curr = curr.next;
        }
        sb.append("}");
        return sb.toString();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */