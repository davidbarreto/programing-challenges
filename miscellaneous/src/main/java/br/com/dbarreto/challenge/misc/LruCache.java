package br.com.dbarreto.challenge.misc;

import br.com.dbarreto.challenge.misc.util.DoubleLinkNode;
import br.com.dbarreto.challenge.misc.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

    private final int capacity;
    private DoubleLinkNode<Pair<K, V>> latest;
    private DoubleLinkNode<Pair<K, V>> tail;
    private final Map<K, DoubleLinkNode<Pair<K, V>>> cache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = HashMap.newHashMap(capacity);
        this.latest = null;
        this.tail = null;
    }

    public V get(K key) {

        DoubleLinkNode<Pair<K, V>> node = cache.get(key);
        if (node == null) {
            return null;
        }

        updateUsage(key);
        return node.value.second();
    }

    public void put(K key, V value) {

        if (!cache.containsKey(key) && cache.size() == capacity) {
            evict();
        }

        DoubleLinkNode<Pair<K, V>> node = cache.getOrDefault(key, new DoubleLinkNode<>());
        node.value = new Pair<>(key, value);

        cache.put(key, node);
        updateUsage(key);
    }

    private void updateUsage(K key) {
        DoubleLinkNode<Pair<K,V>> node = cache.get(key);

        // Fist one in the list
        if (latest == null) {
            latest = node;
            tail = node;
            return;
        }

        // Already most recent
        if (node == latest) {
            return;
        }

        if (node == tail) {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = latest;
        node.next.prev = node;
        node.prev = null;
        latest = node;
    }

    private void evict() {
        cache.remove(tail.value.first());
        tail = tail.prev;
    }
}
