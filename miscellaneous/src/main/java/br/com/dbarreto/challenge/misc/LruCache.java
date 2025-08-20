package br.com.dbarreto.challenge.misc;

import br.com.dbarreto.challenge.misc.util.DoubleLinkNode;
import br.com.dbarreto.challenge.misc.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a LRU (least recently used) cache
 * This cache has a specific capacity, and whenever
 * this capacity is reached, the cache should remove the
 * key that is the least recently used.
 *
 * Public API:
 * get(key)
 * put(key, value)
 *
 * Requirements:
 * 1. put method should add a mapping to the cache. If cache is full
 * (already reached its capacity) it should remove the least recently used key
 * before adding the new mapping.
 * 2. put method can update the value of a key, and update the usage of this element
 * i.e. this element was used pretty recently and should not be removed now, even it was created
 * originally long time ago.
 * 3. When updated a existing value through put method, it should not increase the size of cache (because in fact,
 * this key is already there)
 * 4. get method returns the value associated to a key. If the key is not present, returns null
 * 5. get method also update the usage of this key
 * 6. get and put must be O(1)
 */

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
